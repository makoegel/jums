package jums.server

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import doobie.util.transactor.Transactor
import eu.timepit.refined.auto._
import jums.server.application.Config
import jums.server.infrastructure.https4.Assets
import jums.server.infrastructure.doobie.{DoobieMigration, DoobieUtils}
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext

object Server extends IOApp {

  private def router(tx: Transactor[IO]) =
    Router(
      "/" -> Service.root,
      "/api" -> Service.api(tx),
      Assets.prefix -> Assets.service[IO](ExecutionContext.Implicits.global)
    ).orNotFound

  def run(args: List[String]): IO[ExitCode] =
    for {
      conf <- Config.load[IO]
      _ <- DoobieMigration.run[IO](conf.db)
      c <- DoobieUtils
        .transactor[IO](conf.db)
        .use(r =>
          blazeBuilder(conf.http, r).serve.compile.drain.as(ExitCode.Success))
    } yield c

  def blazeBuilder(httpConfig: Config.Http,
                   tx: Transactor[IO]): BlazeServerBuilder[IO] =
    BlazeServerBuilder[IO]
      .bindHttp(httpConfig.port, httpConfig.host)
      .withHttpApp(router(tx))
}

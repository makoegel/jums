package jums.server.infrastructure.https4

import cats.effect.{ContextShift, Effect}
import jums.server.BuildInfo
import org.http4s.HttpRoutes
import org.http4s.server.staticcontent.{WebjarService, webjarService}

import scala.concurrent.ExecutionContext

object Assets {
  def service[F[_]: Effect: ContextShift](
      executionContext: ExecutionContext): HttpRoutes[F] =
    webjarService[F](WebjarService.Config(executionContext))

  val prefix: String =
    s"/${BuildInfo.assetsRoot}"
}

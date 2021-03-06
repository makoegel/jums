package jums.server

import java.util.UUID

import cats.effect.IO
import doobie.util.transactor.Transactor
import io.circe.syntax._
import org.http4s.circe._
import org.http4s.dsl.io._
import org.http4s.headers._
import org.http4s.{HttpRoutes, MediaType}

import scala.util.Try

object Service {
  val root: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root =>
      Ok(Html.index).map(_.withContentType(`Content-Type`(MediaType.text.html)))
  }

  object UUIDVar {
    def unapply(arg: String): Option[UUID] = Try(UUID.fromString(arg)).toOption
  }

  def api(tx: Transactor[IO]): HttpRoutes[IO] =
    HttpRoutes.of[IO] {
      //case GET -> Root / "jums" / UUIDVar(id) =>
      /* DbGraffelService.findById(GraffelId(id)).transact(tx).flatMap {
          case Some(entity) => Ok(entity.asJson)
          case None         => NotFound()
        }*/
      //IO(response => Ok())

      /*case GET -> Root / "jums" :? LatQueryParamMatcher(lat) +& LonQueryParamMatcher(
            lon) =>
        val length: Length = refineMV[LengthRange](50)
        DbGraffelService
          .findNearPosition(Position(lat, lon), Radius(length, kilometer))
          .transact(tx)
          .flatMap(l =>
            Ok(l.map(t => TagView(t._1.name, t._2.position)).asJson))*/

      /*case request @ PUT -> Root / "graffel" =>
        request.decodeJson[(String, Position)].flatMap {
          case (name, position) =>
            DbGraffelService
              .create(name, position)
              .transact(tx)
              .flatMap(_ => Ok())
        }*/

      case GET -> Root / "version" => Ok(BuildInfo.version.asJson)
    }
}

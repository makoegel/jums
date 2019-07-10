package jums.server.infrastructure.doobie.service

import cats.effect.Sync
import cats.implicits._
import jums.server.domain.model.{FachId, Klasse, KlasseId}
import jums.server.domain.repository.KlasseRepository
import jums.server.domain.util.UUIDUtil

class KlasseService[F[_]](klasseRepository: KlasseRepository[F],
                          UUIDUtil: UUIDUtil[F]) {

  def create(id: KlasseId, stufe: String)(implicit F: Sync[F]): F[Unit] =
    for {
      gOpt <- klasseRepository.findById(id)
      _ <- gOpt match {
        case Some(g) => g.pure[F]
        case None    => createKlasse(stufe)
      }
    } yield ()

  def findById(klasseId: KlasseId): F[Option[Klasse]] =
    klasseRepository.findById(klasseId)

  private def createKlasse(stufe: String)(implicit F: Sync[F]): F[Klasse] =
    for {
      id <- UUIDUtil.uuid
      fachId <- UUIDUtil.uuid
      klasse = Klasse(KlasseId(id), FachId(fachId), stufe)
      _ <- klasseRepository.create(klasse)
    } yield klasse

}

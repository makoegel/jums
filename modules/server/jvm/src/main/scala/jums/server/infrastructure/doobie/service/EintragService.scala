package jums.server.infrastructure.doobie.service

import cats.effect.Sync
import cats.implicits._
import jums.server.domain.model.{Eintrag, EintragId}
import jums.server.domain.repository.EintragRepository
import jums.server.domain.util.UUIDUtil

class EintragService[F[_]](eintragRepository: EintragRepository[F],
                           UUIDUtil: UUIDUtil[F]) {

  def create(id: EintragId,
             kind: String,
             klasse: Int,
             fach: String,
             datum: String,
             testart: Int,
             note: Int)(implicit F: Sync[F]): F[Unit] =
    for {
      gOpt <- eintragRepository.findById(id)
      _ <- gOpt match {
        case Some(g) => g.pure[F]
        case None    => createEintrag(kind, klasse, fach, datum, testart, note)
      }
    } yield ()

  def findById(eintragId: EintragId): F[Option[Eintrag]] =
    eintragRepository.findById(eintragId)

  private def createEintrag(kind: String,
                            klasse: Int,
                            fach: String,
                            datum: String,
                            testart: Int,
                            note: Int)(implicit F: Sync[F]): F[Eintrag] =
    for {
      id <- UUIDUtil.uuid
      eintrag = Eintrag(EintragId(id), kind, klasse, fach, datum, testart, note)
      _ <- eintragRepository.create(eintrag)
    } yield eintrag

}

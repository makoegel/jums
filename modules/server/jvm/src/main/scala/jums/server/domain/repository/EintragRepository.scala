package jums.server.domain.repository

import jums.server.domain.model.{Eintrag, EintragId}

trait EintragRepository[F[_]] {
  def findById(id: EintragId): F[Option[Eintrag]]
  def create(eintrag: Eintrag): F[Int]
}

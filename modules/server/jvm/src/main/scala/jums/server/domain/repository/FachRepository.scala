package jums.server.domain.repository

import jums.server.domain.model.{Fach, FachId}

trait FachRepository[F[_]] {
  def findById(id: FachId): F[Option[Fach]]
  def create(fach: Fach): F[Int]
}

package jums.server.domain.repository

import jums.server.domain.model.{Kategorie, KategorieId, Kind, KindId}

trait KindRepository[F[_]] {
  def findById(id: KindId): F[Option[Kind]]
  def create(kind: Kind): F[Int]
}

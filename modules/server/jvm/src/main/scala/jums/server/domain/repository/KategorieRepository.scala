package jums.server.domain.repository

import jums.server.domain.model.{Kategorie, KategorieId}

trait KategorieRepository[F[_]] {
  def findById(id: KategorieId): F[Option[Kategorie]]
  def create(kategorie: Kategorie): F[Int]
}

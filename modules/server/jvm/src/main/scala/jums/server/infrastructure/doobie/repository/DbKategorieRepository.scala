package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Kategorie, KategorieId}
import jums.server.domain.repository.KategorieRepository
import jums.server.infrastructure.doobie.statements.KategorieStatements

object DbKategorieRepository extends KategorieRepository[ConnectionIO] {
  override def findById(id: KategorieId): ConnectionIO[Option[Kategorie]] =
    KategorieStatements.findById(id).option
  override def create(kategorie: Kategorie): ConnectionIO[Int] =
    KategorieStatements.create(kategorie).run
}

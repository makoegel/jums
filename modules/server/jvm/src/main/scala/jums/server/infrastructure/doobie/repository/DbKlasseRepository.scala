package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Klasse, KlasseId}
import jums.server.domain.repository.KlasseRepository
import jums.server.infrastructure.doobie.statements.KlasseStatements

object DbKlasseRepository extends KlasseRepository[ConnectionIO] {
  override def findById(id: KlasseId): ConnectionIO[Option[Klasse]] =
    KlasseStatements.findById(id).option
  override def create(klasse: Klasse): ConnectionIO[Int] =
    KlasseStatements.create(klasse).run
}

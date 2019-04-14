package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Noten, NoteId}
import jums.server.domain.repository.NotenRepository
import jums.server.infrastructure.doobie.statements.NotenStatements

object DbNotenRepository extends NotenRepository[ConnectionIO] {
  override def findById(id: NoteId): ConnectionIO[Option[Noten]] =
    NotenStatements.findById(id).option
  override def create(Noten: Noten): ConnectionIO[Int] =
    NotenStatements.create(Noten).run
}

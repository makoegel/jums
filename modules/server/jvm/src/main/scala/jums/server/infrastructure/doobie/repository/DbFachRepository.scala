package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Fach, FachId}
import jums.server.domain.repository.FachRepository
import jums.server.infrastructure.doobie.statements.FachStatements

object DbFachRepository extends FachRepository[ConnectionIO] {
  override def findById(id: FachId): ConnectionIO[Option[Fach]] =
    FachStatements.findById(id).option
  override def create(fach: Fach): ConnectionIO[Int] =
    FachStatements.create(fach).run
}

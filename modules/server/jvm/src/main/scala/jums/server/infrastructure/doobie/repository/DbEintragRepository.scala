package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Eintrag, EintragId}
import jums.server.domain.repository.EintragRepository
import jums.server.infrastructure.doobie.statements.EintragStatements

object DbEintragRepository extends EintragRepository[ConnectionIO] {
  override def findById(id: EintragId): ConnectionIO[Option[Eintrag]] =
    EintragStatements.findById(id).option
  override def create(eintrag: Eintrag): ConnectionIO[Int] =
    EintragStatements.create(eintrag).run
}

package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Kind, KindId}
import jums.server.domain.repository.KindRepository
import jums.server.infrastructure.doobie.statements.KindStatements

object DbKindRepository extends KindRepository[ConnectionIO] {
  override def findById(id: KindId): ConnectionIO[Option[Kind]] =
    KindStatements.findById(id).option
  override def create(kind: Kind): ConnectionIO[Int] =
    KindStatements.create(kind).run
}

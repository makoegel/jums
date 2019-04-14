package jums.server.infrastructure.doobie.repository

import doobie.free.connection.ConnectionIO
import jums.server.domain.model.{Testart, TestartId}
import jums.server.domain.repository.TestartRepository
import jums.server.infrastructure.doobie.statements.TestartStatements

object DbTestartRepository extends TestartRepository[ConnectionIO] {
  override def findById(id: TestartId): ConnectionIO[Option[Testart]] =
    TestartStatements.findById(id).option
  override def create(Testart: Testart): ConnectionIO[Int] =
    TestartStatements.create(Testart).run
}

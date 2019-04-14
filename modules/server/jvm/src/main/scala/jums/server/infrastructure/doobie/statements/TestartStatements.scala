package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Testart, TestartId}
import jums.server.infrastructure.doobie.DoobieInstances

object TestartStatements extends DoobieInstances {

  def create(testart: Testart): Update0 =
    sql"""
      INSERT INTO FACH (id, bezeichnung)
      VALUES (${testart.id},
      ${testart.value},
    """.update

  def findById(id: TestartId): Query0[Testart] =
    sql"""
       SELECT id,bezeichnung
       FROM FACH WHERE id = $id
      """.query

}

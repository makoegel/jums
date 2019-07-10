package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model._
import jums.server.infrastructure.doobie.DoobieInstances

object FachStatements extends DoobieInstances {

  def create(fach: Fach): Update0 =
    sql"""
      INSERT INTO FACH (id, bezeichnung)
      VALUES (${fach.id},
      ${fach.bezeichnung},
    """.update

  def findById(id: FachId): Query0[Fach] =
    sql"""
       SELECT id,bezeichnung
       FROM FACH WHERE id = $id
      """.query

}

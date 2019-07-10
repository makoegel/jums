package jums.server.infrastructure.doobie.statements

import doobie.implicits._
import doobie.{Query0, Update0}
import jums.server.domain.model._
import jums.server.infrastructure.doobie.DoobieInstances

object KlasseStatements extends DoobieInstances {

  def create(klasse: Klasse): Update0 =
    sql"""
      INSERT INTO KLASSE (id, fachid, stufe)
      VALUES (${klasse.id},
      ${klasse.fachId},
      ${klasse.stufe}
    """.update

  def findById(id: KlasseId): Query0[Klasse] =
    sql"""
       SELECT id, fachId, stufe
       FROM KLASSE WHERE id = $id
      """.query
}

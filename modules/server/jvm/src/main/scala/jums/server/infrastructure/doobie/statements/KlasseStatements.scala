package jums.server.infrastructure.doobie.statements

/*CREATE TABLE KLASSE (
    ID UUID PRIMARY KEY,
    FACHID UUID,
    STUFE BigDecimal
);*/

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Kind, KindId, Klasse, KlasseId}
import jums.server.infrastructure.doobie.DoobieInstances

object KlasseStatements extends DoobieInstances {

  def create(klasse: Klasse): Update0 =
    sql"""
      INSERT INTO Klasse (id, fachid, stufe)
      VALUES (${klasse.id},
      ${klasse.fachId},
      ${klasse.stufe}
    """.update

  def findById(id: KlasseId): Query0[Klasse] =
    sql"""
       SELECT id, fachId, stufe
       FROM Klasse WHERE id = $id
      """.query
}

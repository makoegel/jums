package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Kategorie, KategorieId}
import jums.server.infrastructure.doobie.DoobieInstances

object KategorieStatements extends DoobieInstances {

  def create(kategorie: Kategorie): Update0 =
    sql"""
      INSERT INTO KATEGORIE (id, fachid, bezeichnung)
      VALUES (${kategorie.id},
      ${kategorie.fachId},
      ${kategorie.value}
    """.update

  def findById(id: KategorieId): Query0[Kategorie] =
    sql"""
       SELECT id,fachid, bezeichnung
       FROM KATEGORIE WHERE id = $id
      """.query
}

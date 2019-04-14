package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Eintrag, EintragId}
import jums.server.infrastructure.doobie.DoobieInstances

object EintragStatements extends DoobieInstances {
  def create(eintrag: Eintrag): Update0 =
    sql"""
      INSERT INTO EINTRAG (id, kindid, klasseid, fachid, kategorieid, testartid, noteid)
      VALUES (${eintrag.id},
      ${eintrag.kindId},
      ${eintrag.klasseId},
      ${eintrag.fachId},
      ${eintrag.kategorieId},
      ${eintrag.testartId},
      ${eintrag.noteId})
    """.update

  def findById(id: EintragId): Query0[Eintrag] =
    sql"""
       SELECT id, kindid, klasseid, fachid,kategorieid, testartid, noteid 
       FROM eintrag WHERE id = $id
      """.query

}

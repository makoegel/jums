package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Kind, KindId, Klasse, KlasseId, NoteId, Noten}
import jums.server.infrastructure.doobie.DoobieInstances

object NotenStatements extends DoobieInstances {

  def create(noten: Noten): Update0 =
    sql"""
      INSERT INTO NOTEN (id, fachid, name)
      VALUES (${noten.id},
      ${noten.value}
    """.update

  def findById(id: NoteId): Query0[Noten] =
    sql"""
       SELECT id, name
       FROM NOTEN WHERE id = $id
      """.query
}

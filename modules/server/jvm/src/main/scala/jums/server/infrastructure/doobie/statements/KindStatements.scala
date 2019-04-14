package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Kind, KindId}
import jums.server.infrastructure.doobie.DoobieInstances

object KindStatements extends DoobieInstances {

  def create(kind: Kind): Update0 =
    sql"""
      INSERT INTO KIND (id, vorname, gebdatum)
      VALUES (${kind.id},
      ${kind.vorname},
      ${kind.gebDatum}
    """.update

  def findById(id: KindId): Query0[Kind] =
    sql"""
       SELECT id, vorname, gebDatum
       FROM KIND WHERE id = $id
      """.query
}

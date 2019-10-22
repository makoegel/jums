package jums.server.infrastructure.doobie.statements

import doobie._
import doobie.implicits._
import jums.server.domain.model.{Eintrag, EintragId}
import jums.server.infrastructure.doobie.DoobieInstances

object EintragStatements extends DoobieInstances {
  def create(eintrag: Eintrag): Update0 = {
    val klasse = BigDecimal(eintrag.klasse)
    val testart = BigDecimal(eintrag.testart)
    val note = BigDecimal(eintrag.note)
    sql"""
      INSERT INTO EINTRAG (id, kind, klasse, fach, datum, testart, note)
      VALUES (${eintrag.id},
      ${eintrag.kind},
      ${klasse},
      ${eintrag.fach},
      ${eintrag.datum},
      ${testart},
      ${note})
    """.update
  }

  def findById(id: EintragId): Query0[Eintrag] =
    sql"""
       SELECT id, kind, klasse, fach, datum, testart, note
       FROM eintrag WHERE id = $id
      """.query

}

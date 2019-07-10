package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{NoteId, Noten}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class NotenStatementsTest extends FunSuite {
  test("create") {
    check(NotenStatements.create(sampleOf[Noten]))
  }

  test("findById") {
    check(NotenStatements.findById(sampleOf[NoteId]))
  }

}

package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Fach, FachId}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class FachStatementsTest extends FunSuite {
  test("create") {
    check(FachStatements.create(sampleOf[Fach]))
  }

  test("findById") {
    check(FachStatements.findById(sampleOf[FachId]))
  }

}

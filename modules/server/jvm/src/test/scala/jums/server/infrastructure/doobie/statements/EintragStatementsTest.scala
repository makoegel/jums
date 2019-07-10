package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Eintrag, EintragId}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class EintragStatementsTest extends FunSuite {
  test("create") {
    check(EintragStatements.create(sampleOf[Eintrag]))
  }

  test("findById") {
    check(EintragStatements.findById(sampleOf[EintragId]))
  }

}

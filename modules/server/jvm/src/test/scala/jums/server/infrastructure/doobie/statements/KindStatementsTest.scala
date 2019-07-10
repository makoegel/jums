package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Kind, KindId}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class KindStatementsTest extends FunSuite {
  test("create") {
    check(KindStatements.create(sampleOf[Kind]))
  }

  test("findById") {
    check(KindStatements.findById(sampleOf[KindId]))
  }

}

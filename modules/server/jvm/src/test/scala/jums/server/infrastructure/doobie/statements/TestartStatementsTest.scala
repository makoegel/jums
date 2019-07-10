package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Testart, TestartId}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class TestartStatementsTest extends FunSuite {
  test("create") {
    check(TestartStatements.create(sampleOf[Testart]))
  }

  test("findById") {
    check(TestartStatements.findById(sampleOf[TestartId]))
  }

}

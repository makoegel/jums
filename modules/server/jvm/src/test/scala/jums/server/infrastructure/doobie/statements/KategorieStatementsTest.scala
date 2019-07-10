package jums.server.infrastructure.doobie.statements

import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Kategorie, KategorieId}
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.FunSuite

class KategorieStatementsTest extends FunSuite {
  test("create") {
    check(KategorieStatements.create(sampleOf[Kategorie]))
  }

  test("findById") {
    check(KategorieStatements.findById(sampleOf[KategorieId]))
  }

}

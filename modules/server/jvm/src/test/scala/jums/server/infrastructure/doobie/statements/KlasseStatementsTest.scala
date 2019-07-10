package jums.server.infrastructure.doobie.statements

import org.scalatest.FunSuite
import jums.server.infrastructure.doobie.DbSpecification._
import jums.server.ArbitraryInstances._
import jums.server.domain.model.{Klasse, KlasseId}

class KlasseStatementsTest extends FunSuite {
  test("create") {
    check(KlasseStatements.create(sampleOf[Klasse]))
  }

  test("findById") {
    check(KlasseStatements.findById(sampleOf[KlasseId]))
  }

}

package jums.server.infrastructure.doobie.repository

import jums.server.ArbitraryInstances._
import jums.server.domain.model.Eintrag
import jums.server.infrastructure.doobie.DbSpecification._
import org.scalatest.{FunSuite, Matchers}

class DbEintragRepositoryTest extends FunSuite with Matchers {
  test("findById") {
    val t = sampleOf[Eintrag]

    val eintrag = for {
      _ <- DbEintragRepository.create(t)
      s <- DbEintragRepository.findById(t.id)
    } yield s

    val result = runQuery(eintrag).unsafeRunSync()

    result should be(defined)
    result.map(_.id) should contain(t.id)
    result.map(_.kind) should contain(t.kind)
    result.map(_.klasse) should contain(t.klasse)
    result.map(_.fach) should contain(t.fach)
    result.map(_.datum) should contain(t.datum)
    result.map(_.testart) should contain(t.testart)
    result.map(_.note) should contain(t.note)
  }

}

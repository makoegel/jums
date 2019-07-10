package jums.server.infrastructure.doobie.repository

import jums.server.domain.model.Testart
import org.scalatest.{FunSuite, Matchers}
import jums.server.ArbitraryInstances._
import jums.server.infrastructure.doobie.DbSpecification._

class DbTestartRepositoryTest extends FunSuite with Matchers {
  test("create and findById") {
    val t = sampleOf[Testart]

    val testart = for {
      _ <- DbTestartRepository.create(t)
      s <- DbTestartRepository.findById(t.id)
    } yield s

    val result = runQuery(testart).unsafeRunSync()

    result should be(defined)
    result.map(_.id) should contain(t.id)
    result.map(_.value) should contain(t.value)
  }

}

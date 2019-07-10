package jums.server

import jums.server.domain.model.{Testart, TestartId}
import org.scalacheck.Arbitrary
import org.scalacheck.derive.MkArbitrary

import scala.annotation.tailrec

object ArbitraryInstances {

  implicit lazy val testartIdArbitrary: Arbitrary[TestartId] =
    MkArbitrary[TestartId].arbitrary

  implicit lazy val testartArbitrary: Arbitrary[Testart] =
    MkArbitrary[Testart].arbitrary

  @tailrec
  def sampleOf[T](implicit ev: Arbitrary[T]): T =
    ev.arbitrary.sample match {
      case Some(t) => t
      case None    => sampleOf[T]
    }

}

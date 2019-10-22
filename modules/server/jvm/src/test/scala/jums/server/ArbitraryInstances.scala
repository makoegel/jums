package jums.server

import java.time.{LocalDate, Month, Year}

import jums.server.domain.model._
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.derive.MkArbitrary

import scala.annotation.tailrec

object ArbitraryInstances {

  implicit lazy val localDateArbitrary: Arbitrary[LocalDate] =
    Arbitrary {
      for {
        year <- Gen.chooseNum(1, 9999)
        month <- Gen.chooseNum(1, 12)
        maxDaysInMonth = Month.of(month).length(Year.of(year).isLeap)
        day <- Gen.chooseNum(1, maxDaysInMonth)
      } yield LocalDate.of(year, month, day)
    }

  implicit lazy val eintragIdArbitrary: Arbitrary[EintragId] =
    MkArbitrary[EintragId].arbitrary

  implicit lazy val eintragArbitrary: Arbitrary[Eintrag] =
    MkArbitrary[Eintrag].arbitrary


  @tailrec
  def sampleOf[T](implicit ev: Arbitrary[T]): T =
    ev.arbitrary.sample match {
      case Some(t) => t
      case None    => sampleOf[T]
    }

}

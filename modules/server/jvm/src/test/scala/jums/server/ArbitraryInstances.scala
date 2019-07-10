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

  implicit lazy val fachIdArbitrary: Arbitrary[FachId] =
    MkArbitrary[FachId].arbitrary

  implicit lazy val fachArbitrary: Arbitrary[Fach] =
    MkArbitrary[Fach].arbitrary

  implicit lazy val kategorieIdArbitrary: Arbitrary[KategorieId] =
    MkArbitrary[KategorieId].arbitrary

  implicit lazy val kategorieNameArbitrary: Arbitrary[KategorieName] =
    MkArbitrary[KategorieName].arbitrary

  implicit lazy val kategorieArbitrary: Arbitrary[Kategorie] =
    MkArbitrary[Kategorie].arbitrary

  implicit lazy val kindIdArbitrary: Arbitrary[KindId] =
    MkArbitrary[KindId].arbitrary

  implicit lazy val kindArbitrary: Arbitrary[Kind] =
    MkArbitrary[Kind].arbitrary

  implicit lazy val klasseIdArbitrary: Arbitrary[KlasseId] =
    MkArbitrary[KlasseId].arbitrary

  implicit lazy val klasseArbitrary: Arbitrary[Klasse] =
    MkArbitrary[Klasse].arbitrary

  implicit lazy val noteIdArbitrary: Arbitrary[NoteId] =
    MkArbitrary[NoteId].arbitrary

  implicit lazy val notenArbitrary: Arbitrary[Noten] =
    MkArbitrary[Noten].arbitrary

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

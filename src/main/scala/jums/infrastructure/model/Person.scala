package jums.infrastructure.model

import java.time.LocalDate
import java.util.UUID

case class Person (id: UUID, name: String, vorname: String, GebDatum: LocalDate)

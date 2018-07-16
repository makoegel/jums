package jums.infrastructure.model

import java.time.LocalDate
import java.util.UUID

case class Test (id: UUID, name: String, vorname: String, fach: String, beschreibung: String, datum: LocalDate, note: Int)
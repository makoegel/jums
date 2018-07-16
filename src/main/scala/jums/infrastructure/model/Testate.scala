package jums.infrastructure.model

import java.time.LocalDate
import java.util.UUID

case class Testate (id: UUID, personId: UUID, fachId: UUID, beschreibung: String, datum: LocalDate, note: Int)
package jums.server.domain.model

import java.util.UUID

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

final case class NoteId(uuid: UUID)

object NoteId {
  implicit val decoder: Decoder[NoteId] = deriveDecoder
  implicit val encoder: Encoder[NoteId] = deriveEncoder
}

package jums.server.domain.model

import java.util.UUID

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

final case class FachId(uuid: UUID)

object FachId {
  implicit val decoder: Decoder[FachId] = deriveDecoder
  implicit val encoder: Encoder[FachId] = deriveEncoder
}

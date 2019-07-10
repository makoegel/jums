package jums.server.domain.model

import java.util.UUID

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class EintragId(uuid: UUID)

object EintragId {
  implicit val decoder: Decoder[EintragId] = deriveDecoder
  implicit val encoder: Encoder[EintragId] = deriveEncoder
}

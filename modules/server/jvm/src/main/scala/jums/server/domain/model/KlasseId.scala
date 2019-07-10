package jums.server.domain.model

import java.util.UUID

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

final case class KlasseId(uuid: UUID)

object KlasseId {
  implicit val decoder: Decoder[KlasseId] = deriveDecoder
  implicit val encoder: Encoder[KlasseId] = deriveEncoder
}

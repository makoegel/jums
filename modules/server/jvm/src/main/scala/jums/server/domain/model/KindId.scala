package jums.server.domain.model

import java.util.UUID

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class KindId(uuid: UUID)

object KindId {
  implicit val decoder: Decoder[KindId] = deriveDecoder
  implicit val encoder: Encoder[KindId] = deriveEncoder
}

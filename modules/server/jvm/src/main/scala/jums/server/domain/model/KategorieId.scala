package jums.server.domain.model

import java.util.UUID

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class KategorieId(uuid: UUID)

object KategorieId {
  implicit val decoder: Decoder[KategorieId] = deriveDecoder
  implicit val encoder: Encoder[KategorieId] = deriveEncoder
}

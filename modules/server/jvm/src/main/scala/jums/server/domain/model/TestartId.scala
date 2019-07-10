package jums.server.domain.model

import java.util.UUID

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class TestartId(uuid: UUID)

object TestartId {
  implicit val decoder: Decoder[TestartId] = deriveDecoder
  implicit val encoder: Encoder[TestartId] = deriveEncoder
}

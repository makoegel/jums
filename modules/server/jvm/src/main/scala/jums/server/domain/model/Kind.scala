package jums.server.domain.model

import java.time.LocalDate

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Kind(id: KindId, vorname: String, gebDatum: LocalDate)

object Kind {
  implicit val kindDecoder: Decoder[Kind] =
    deriveDecoder

  implicit val kindEncoder: Encoder[Kind] =
    deriveEncoder
}

package jums.server.domain.model

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

final case class Eintrag(id: EintragId,
                         kind: String,
                         klasse: Int,
                         fach: String,
                         datum: String,
                         testart: Int,
                         note: Int)

object Eintrag {
  implicit val eintragDecoder: Decoder[Eintrag] =
    deriveDecoder

  implicit val eintragEncoder: Encoder[Eintrag] =
    deriveEncoder
}
package jums.server.domain.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class Fach(id: FachId, bezeichnung: String)

final case class Klasse(id: KlasseId, fachId: FachId, stufe: String)

final case class KategorieName(value: String)
final case class Testart(id: TestartId, value: String)

final case class Kategorie(id: KategorieId,
                           fachId: FachId,
                           value: KategorieName)

final case class Note(value: Int)
final case class Noten(id: NoteId, value: Int)

final case class Eintrag(id: EintragId,
                         kindId: KindId,
                         klasseId: KlasseId,
                         fachId: FachId,
                         kategorieId: KategorieId,
                         testartId: TestartId,
                         noteId: NoteId)

object Fach {
  implicit val fachDecoder: Decoder[Fach] =
    deriveDecoder

  implicit val fachEncoder: Encoder[Fach] =
    deriveEncoder
}

object Klasse {
  implicit val klasseDecoder: Decoder[Klasse] =
    deriveDecoder

  implicit val klasseEncoder: Encoder[Klasse] =
    deriveEncoder
}

object Kategorie {
  implicit val kategorieDecoder: Decoder[Kategorie] =
    deriveDecoder

  implicit val kategorieEncoder: Encoder[Kategorie] =
    deriveEncoder
}

object KategorieName {
  implicit val kategorieNameDecoder: Decoder[KategorieName] =
    deriveDecoder

  implicit val kategorieNameEncoder: Encoder[KategorieName] =
    deriveEncoder
}

object Testart {
  implicit val testartDecoder: Decoder[Testart] =
    deriveDecoder

  implicit val testartEncoder: Encoder[Testart] =
    deriveEncoder
}

object Note {
  implicit val noteDecoder: Decoder[Note] =
    deriveDecoder

  implicit val noteEncoder: Encoder[Note] =
    deriveEncoder
}

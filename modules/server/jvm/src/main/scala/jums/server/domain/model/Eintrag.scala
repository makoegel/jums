package jums.server.domain.model

final case class Fach(id: FachId, value: String)

final case class Klasse(id: KlasseId, fachId: FachId)

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

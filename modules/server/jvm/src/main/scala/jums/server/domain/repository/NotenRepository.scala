package jums.server.domain.repository

import jums.server.domain.model.{Noten, NoteId}

trait NotenRepository[F[_]] {
  def findById(id: NoteId): F[Option[Noten]]
  def create(noten: Noten): F[Int]
}

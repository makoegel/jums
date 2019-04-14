package jums.server.domain.repository

import jums.server.domain.model.{Klasse, KlasseId}

trait KlasseRepository[F[_]] {
  def findById(id: KlasseId): F[Option[Klasse]]
  def create(klasse: Klasse): F[Int]
}

package jums.server.domain.repository

import jums.server.domain.model.{Testart, TestartId}

trait TestartRepository[F[_]] {
  def findById(id: TestartId): F[Option[Testart]]
  def create(testart: Testart): F[Int]
}

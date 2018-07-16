package jums.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.UUID

import jums.infrastructure.model.Test

import scala.io.Source

object ImportData {

  def main(args: Array[String]): Unit = {

    val fileName = "/home/marion/Dokumente/Schule/Noten_2017_2018.csv"
    val input = Source.fromFile(fileName)

    for (line <- input.getLines().drop(1)) {
      val splitLine: Array[String] = line.split(";")
      val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")
      val test: Test = Test(UUID.randomUUID(),
                            splitLine(0),
                            splitLine(1),
                            splitLine(2),
                            splitLine(3),
                            LocalDate.parse(splitLine(4), formatter),
                            Integer.parseInt(splitLine(5)))
      println(test)
    }

  }

}

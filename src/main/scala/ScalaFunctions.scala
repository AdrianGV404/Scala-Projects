package main
import scala.io.Source
import java.io.FileNotFoundException
import java.io.IOException

object ScalaFunctions extends App {
  /**
   * Counts the number of occurrences of each word in a list of texts or a single text.
   *
   * @param texts The list of texts or a single text to analyze.
   * @return A map where each word is a key, and its value is the number of occurrences.
   */
  def wordCount(texts: Either[List[String], String]): Map[String, Int] = {
    texts match {
      case Left(list) =>
        list
          .flatMap(_.toLowerCase.split("\\W+"))
          .groupMapReduce(identity)(_ => 1)(_ + _)
      case Right(text) =>
        text
          .toLowerCase.split("\\W+")
          .groupMapReduce(identity)(_ => 1)(_ + _)
    }
  }

  /**
   * Counts the total number of words in a list of texts or a single text.
   *
   * @param texts The list of texts or a single text to analyze.
   * @return The total number of words in the list or text.
   */
  def countWords(texts: Either[List[String], String]): Int = {
    texts match {
      case Left(list) => list.flatMap(_.split("\\W+")).length
      case Right(text) => text.split("\\W+").length
    }
  }

/**
   * Reads the content of the specified file and returns it as a string.
   *
   * @param filePath The path to the file to be read.
   * @return The content of the file as a string.
   */
  def readText(filePath: String): String = {
    try {
      val source = Source.fromFile(filePath, "UTF-8")
      try {
        source.mkString
      } finally {
        source.close()
      }
    } catch {
      case e: FileNotFoundException =>
        s"Error: File not found - $filePath"
      case e: IOException =>
        s"Error reading file - $e.getMessage"
    }
  }
}
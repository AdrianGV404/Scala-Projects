package main

object MacroWorkSpace extends App {
  // WordCount function (counts the number of occurrences of each word in a list of texts)
  def wordCount(texts: List[String]): Map[String, Int] = {
    texts
      .flatMap(_.toLowerCase.split("\\W+"))
      .groupMapReduce(identity)(_ => 1)(_ + _)
  }

  // CountWords function (counts the total number of words in a list of texts)
  def countWords(texts: List[String]): Int = {
    texts.flatMap(_.split("\\W+")).length
  }
}

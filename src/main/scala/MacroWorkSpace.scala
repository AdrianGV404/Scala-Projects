package main

object MacroWorkSpace extends App {
  // WordCount function (counts the number of occurrences of each word in a text)
  def wordCount(text: String): Map[String, Int] = {
    text
      .toLowerCase
      .split("\\W+")
      .groupMapReduce(identity)(_ => 1)(_ + _)
  }

  // CountWords function (counts the total number of words in a text)
  def countWords(text: String): Int = {
    text.split("\\W+").length
  }
}
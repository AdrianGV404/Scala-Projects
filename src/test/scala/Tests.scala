package test

import main.MacroWorkSpace
import munit.FunSuite

class Tests extends FunSuite {
  // String text to be read
  val sampleText: String =
    "This is an example text. It contains some words, and we want to count the occurrences of each word."

  // Print word count and total word count
  val counts: Map[String, Int] = MacroWorkSpace.wordCount(sampleText)
  val totalWords: Int = MacroWorkSpace.countWords(sampleText)

  test("word count test") {
    println("Word Count:")
    counts.foreach { case (word, count) =>
      println(s"$word: $count")
    }

    println(s"\nTotal Words: $totalWords")
    // Add your assertions here based on the expected results
  }
}
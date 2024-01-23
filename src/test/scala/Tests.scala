package test

import main.MacroWorkSpace
import munit.FunSuite

class Tests extends FunSuite {
  // List of strings to be read
  val sampleTexts: List[String] = List(
    "This is an example text.",
    "It contains some words,",
    "and we want to count the occurrences of each word.",
    "is to, of"
  )

  // Get word count and total word count
  val wordCount: Map[String, Int] = MacroWorkSpace.wordCount(sampleTexts)
  val countWords: Int = MacroWorkSpace.countWords(sampleTexts)

  test("word count test") {
    // Assert that the word count for specific words is as expected
    assertEquals(wordCount.getOrElse("this", 1), 1)
    assertEquals(wordCount.getOrElse("example", 1), 1)
    assertEquals(wordCount.getOrElse("to", 2), 2)
    assertEquals(wordCount.getOrElse("of", 2), 2)

    // Assert that the total word count is as expected
    assertEquals(countWords, 22)
  }
}

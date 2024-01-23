file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
### file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:31: error: end of file expected but } found
}
^

occurred in the presentation compiler.

action parameters:
uri: file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
text:
```scala
package example

object MacroWorkSpace extends App {

  // String texto del que se va a leer
  val texto = "Este es un ejemplo de texto. En este texto, vamos a contar el número de palabras y el número de ocurrencias de cada palabra."

  // WordCount (cuenta el número de ocurrencias de cada palabra en un texto)
  val wordCount: Map[String, Int] = contarPalabras(texto)
  println("Word Count:")
  wordCount.foreach { case (palabra, count) => println(s"$palabra: $count") }

  // CountWords (cuenta el número de palabras totales en un texto)
  val totalWords: Int = contarPalabrasTotales(texto)
  println(s"\nTotal Words: $totalWords")

  // Función para contar el número de ocurrencias de cada palabra en un texto
  def contarPalabras(texto: String): Map[String, Int] = {
    val palabras = texto.split("\\s+").map(_.toLowerCase)
    palabras.groupBy(identity).mapValues(_.length)
  }

  // Función para contar el número total de palabras en un texto
  def contarPalabrasTotales(texto: String): Int = {
    val palabras = texto.split("\\s+")
    palabras.length
  }
}

//Un patrón (que sea facil)
}

```



#### Error stacktrace:

```
scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.ScalametaParser.syntaxErrorExpected(ScalametaParser.scala:421)
	scala.meta.internal.parsers.ScalametaParser.expect(ScalametaParser.scala:423)
	scala.meta.internal.parsers.ScalametaParser.accept(ScalametaParser.scala:427)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:63)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:54)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:132)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:29)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:36)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:374)
```
#### Short summary: 

file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:31: error: end of file expected but } found
}
^
file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
### file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:6: error: unclosed string literal
  val texto = "Este es un ejemplo de texto. En este texto, 
              ^

occurred in the presentation compiler.

action parameters:
uri: file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
text:
```scala
package example

object MacroWorkSpace extends App {

  // String texto del que se va a leer
  val texto = "Este es un ejemplo de texto. En este texto, 
  vamos a contar el número de palabras y el número de ocurrencias de cada palabra."

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

//Un patrón (que sea facil)
}

```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.LegacyScanner.getStringLit(LegacyScanner.scala:553)
	scala.meta.internal.tokenizers.LegacyScanner.fetchDoubleQuote$1(LegacyScanner.scala:372)
	scala.meta.internal.tokenizers.LegacyScanner.fetchToken(LegacyScanner.scala:376)
	scala.meta.internal.tokenizers.LegacyScanner.nextToken(LegacyScanner.scala:211)
	scala.meta.internal.tokenizers.LegacyScanner.foreach(LegacyScanner.scala:1011)
	scala.meta.internal.tokenizers.ScalametaTokenizer.uncachedTokenize(ScalametaTokenizer.scala:24)
	scala.meta.internal.tokenizers.ScalametaTokenizer.$anonfun$tokenize$1(ScalametaTokenizer.scala:17)
	scala.collection.concurrent.TrieMap.getOrElseUpdate(TrieMap.scala:962)
	scala.meta.internal.tokenizers.ScalametaTokenizer.tokenize(ScalametaTokenizer.scala:17)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$anon$2.apply(ScalametaTokenizer.scala:332)
	scala.meta.tokenizers.Api$XtensionTokenizeDialectInput.tokenize(Api.scala:25)
	scala.meta.tokenizers.Api$XtensionTokenizeInputLike.tokenize(Api.scala:14)
	scala.meta.internal.parsers.ScannerTokens$.apply(ScannerTokens.scala:914)
	scala.meta.internal.parsers.ScalametaParser.<init>(ScalametaParser.scala:33)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:35)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:374)
```
#### Short summary: 

file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:6: error: unclosed string literal
  val texto = "Este es un ejemplo de texto. En este texto, 
              ^
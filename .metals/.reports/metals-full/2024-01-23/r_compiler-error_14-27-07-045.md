file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
### file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:4: error: unclosed comment
/*WordCount
^

occurred in the presentation compiler.

action parameters:
uri: file:///C:/URV/Progra/RepositorioGitHub/Scala-Projects/src/main/scala/example/MacroWorkSpace.scala
text:
```scala
package example

object MacroWorkSpace extends App {
/*WordCount
cuenta el número de ocurrencias de cada palabra en un texto, mientras que CountWords
cuenta el número de palabras totales en un texto
//WordCount

//CountWords

//Un patrón (que sea facil)
}

```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.Reporter.incompleteInputError(Reporter.scala:27)
	scala.meta.internal.tokenizers.Reporter.incompleteInputError$(Reporter.scala:26)
	scala.meta.internal.tokenizers.Reporter$$anon$1.incompleteInputError(Reporter.scala:33)
	scala.meta.internal.tokenizers.Reporter.incompleteInputError(Reporter.scala:29)
	scala.meta.internal.tokenizers.Reporter.incompleteInputError$(Reporter.scala:29)
	scala.meta.internal.tokenizers.Reporter$$anon$1.incompleteInputError(Reporter.scala:33)
	scala.meta.internal.tokenizers.LegacyScanner.skipNestedComments(LegacyScanner.scala:52)
	scala.meta.internal.tokenizers.LegacyScanner.skipToCommentEnd(LegacyScanner.scala:71)
	scala.meta.internal.tokenizers.LegacyScanner.fetchToken(LegacyScanner.scala:313)
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

file%3A%2F%2F%2FC%3A%2FURV%2FProgra%2FRepositorioGitHub%2FScala-Projects%2Fsrc%2Fmain%2Fscala%2Fexample%2FMacroWorkSpace.scala:4: error: unclosed comment
/*WordCount
^
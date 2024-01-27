package test.scala

import main.scala.ScalaFunctions
import main.scala.Singleton
import scala.composite
import munit.FunSuite
import main.java.{Controller, Invoker, Action, Metric}
import main.java.reflection.{ActionProxy,DynamicProxy}
import main.java.policy.{UniformGroup, RoundRobinImproved, RoundRobin, GreedyGroup, BigGroup}
import main.java.operations.{Adder, CountWords, Factorial, Multiplier, WordCount}
import main.java.mapReduce.{Reduce, TextReader}
import main.java.interfaces.{DistributionPolicy, InterfaceAction, InterfaceInvoker, Observer}
import main.java.exceptions.InsufficientMemoryException
import main.java.decorator.{ActionResult, InvokerCacheDecorator, InvokerChronometerDecorator}

class Tests extends FunSuite {

  test("word count test") {
    // List of strings to be read
    val sampleTexts: List[String] = List(
      "This is an example text.",
      "It contains some words,",
      "and we want to count the occurrences of each word.",
      "is to, of"
    )

    // Get word count and total word count
    val wordCount: Map[String, Int] = ScalaFunctions.wordCount(Left(sampleTexts))
    val countWords: Int = ScalaFunctions.countWords(Left(sampleTexts))

    // Assert that the word count for specific words is as expected
    assertEquals(wordCount.getOrElse("this", 1), 1)
    assertEquals(wordCount.getOrElse("example", 1), 1)
    assertEquals(wordCount.getOrElse("to", 2), 2)
    assertEquals(wordCount.getOrElse("of", 2), 2)

    // Assert that the total word count is as expected
    assertEquals(countWords, 22)
  }

  test("read text test") {
    // Create a temporary file with some content for testing
    val filePath = "file.txt"

    val fileContent = ScalaFunctions.readText(filePath)
    println(s"File Content:\n$fileContent")

    val wordCount: Map[String, Int] = ScalaFunctions.wordCount(Right(fileContent))
    val countWords: Int = ScalaFunctions.countWords(Right(fileContent))

    // Assert that the word count for specific words is as expected
    assertEquals(wordCount.getOrElse("this", 1), 1)
    assertEquals(wordCount.getOrElse("example", 1), 1)
    assertEquals(wordCount.getOrElse("to", 2), 2)
    assertEquals(wordCount.getOrElse("of", 2), 2)

    // Assert that the total word count is as expected
   assertEquals(countWords, 22)
  }

    test("read temporal") {
    // Create a temporary file with some content for testing
    val tempFilePath = "temporal.txt"
    val tempFileContent = "This is a test one this is a test."

    // Write content to the temporary file
    java.nio.file.Files.write(
      java.nio.file.Paths.get(tempFilePath),
      tempFileContent.getBytes(java.nio.charset.StandardCharsets.UTF_8)
    )

    // Read content from the temporary file using readText function
    val fileContent = ScalaFunctions.readText(tempFilePath)
    println(s"File Content:\n$fileContent")

    val wordCount: Map[String, Int] = ScalaFunctions.wordCount(Right(fileContent))
    val countWords: Int = ScalaFunctions.countWords(Right(fileContent))
    // Assert that the content read from the file is the same as expected
    assertEquals(fileContent, tempFileContent)    
    assertEquals(wordCount.getOrElse("this", 2), 2)
    assertEquals(wordCount.getOrElse("is", 2), 2)
    assertEquals(wordCount.getOrElse("a", 2), 2)
    assertEquals(wordCount.getOrElse("test", 2), 2)
    assertEquals(wordCount.getOrElse("one", 1), 1)
    
    // Assert that the total word count is as expected
    assertEquals(countWords, 9)
  }

  test("Singleton is the only instance") {
    // Verify that the ID of the default instance is as expected
    assertEquals(Singleton.getId, "SingletonId")

    // Create a new instance of Singleton with a custom ID using the create method
    val customSingletonId = "CustomSingletonId"
    val mySingleton = Singleton.create(customSingletonId)

    // Verify that the ID of the new instance is the custom ID
    assertEquals(mySingleton.getId, customSingletonId)
    // Verify that the ID of the default instance is the new one
    assertEquals(Singleton.getId, customSingletonId)
  }

    test("Java Functions Working") {
    val controller: Controller = Controller.getInstance()
    controller.setPolicy(new RoundRobinImproved());
    val controllerId: Int = controller.getId()
    println(s"Controller ID: $controllerId")

    val invoker = new Invoker(1024, "Invoker1") 
    controller.addInvoker(invoker)

    val invoker2 = new Invoker(1024, "Invoker2") 
    controller.addInvoker(invoker2)

    val list: List[Int] = List(1, 2, 3, 4, 5)
    val values: Array[Int] = list.toArray //"casting" to avoid type problem

    val add1: Adder = new Adder("add1", 2000, {values});
    val add2: Adder = new Adder("add2", 2000, {values});

        
    controller.addAction(add1)
    controller.addAction(add2);

    // Distribuir acciones (puedes personalizar esto según tu lógica)
    assert(true,controller.distributeActions())

    assertEquals(1,invoker.getActions().size());
    assertEquals(1,invoker2.getActions().size());

    // Ejecutar acciones asignadas
    controller.executeAssignedActions()
    assertEquals(0,invoker.getActions().size());
    assertEquals(0,invoker2.getActions().size());

    // Imprimir métricas
    assertEquals(2,controller.getMetrics().size())
    controller.printMetrics()
  }

  test("Composite Menu Test"){
    val Menu: composite.MenuCategory=new  composite.MenuCategory("Root");
    val appetizersCategory: composite.MenuCategory = new composite.MenuCategory("Appetizers")
    val mainCourses: composite.MenuCategory = new composite.MenuCategory("Main Courses")
    Menu.addChild(appetizersCategory)
    Menu.addChild(mainCourses)
    val salad: composite.SingleItem = new composite.SingleItem("Caesar Salad", 8.99)
    appetizersCategory.addChild(salad)
    val pasta: composite.MenuCategory = new composite.MenuCategory("Pasta")  
    mainCourses.addChild(pasta)
    val spaghetti: composite.SingleItem = new composite.SingleItem("Spaghetti Bolognese", 12.99)
    pasta.addChild(spaghetti)
    val soup: composite.SingleItem = new composite.SingleItem("Tomato Soup", 0.04)
    appetizersCategory.addChild(soup);

    assertEquals(12.99,mainCourses.getPrice);
    assertEquals(9.03,appetizersCategory.getPrice);

  }
}

package main.scala

import main.java.{Controller, Invoker, Action, Metric}
import main.java.reflection.{ActionProxy, DynamicProxy}
import main.java.policy.{
  UniformGroup,
  RoundRobinImproved,
  RoundRobin,
  GreedyGroup,
  BigGroup
}
import main.java.operations.{
  Adder,
  CountWords,
  Factorial,
  Multiplier,
  WordCount
}
import main.java.mapReduce.{Reduce, TextReader}
import main.java.interfaces.{
  DistributionPolicy,
  InterfaceAction,
  InterfaceInvoker,
  Observer
}
import main.java.exceptions.InsufficientMemoryException
import main.java.decorator.{
  ActionResult,
  InvokerCacheDecorator,
  InvokerChronometerDecorator
}

object JavaFunctions {
  def main(args: Array[String]): Unit = {
    val controller: Controller = Controller.getInstance()
    controller.setPolicy(new RoundRobinImproved());
    val controllerId: Int = controller.getId()
    println(s"Controller ID: $controllerId")

    val invoker = new Invoker(1024, "Invoker1")
    controller.addInvoker(invoker)
    val invoker2 = new Invoker(1024, "Invoker2")
    controller.addInvoker(invoker2)

    val list: List[Int] = List(1, 2, 3, 4, 5)
    val values: Array[Int] = list.toArray // "casting" to avoid type problem
    val add1: Adder = new Adder("add1", 200, { values });
    val add2: Adder = new Adder("add2", 200, { values });

    for (i <- 1 to 6) {
      val mltp: Multiplier = new Multiplier(s"mltp$i", 200, { values })
      controller.addAction(mltp)
    }

    controller.addAction(add1)
    controller.addAction(add2)

    // Distribuir acciones (puedes personalizar esto según tu lógica)
    controller.distributeActions()

    // Ejecutar acciones asignadas
    controller.executeAssignedActions()

    // Imprimir métricas
    controller.printMetrics()
  }
}

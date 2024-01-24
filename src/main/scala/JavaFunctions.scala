package main.scala

import main.java.{Controller, Invoker, Action, Metric, reflection, policy, operations, mapReduce, interfaces, exceptions, decorator}

object JavaFunctions {
  def main(args: Array[String]): Unit = {
    // Crear una instancia del controlador
    val controller: Controller = Controller.getInstance()

    // Hacer llamadas a métodos de la instancia del controlador
    val controllerId: Int = controller.getId()
    println(s"Controller ID: $controllerId")
    
    // Agregar invocadores, acciones, etc. según sea necesario
    val invoker = new Invoker(1024, "Invoker1") // Ejemplo, ajusta según tu lógica
    controller.addInvoker(invoker)

    val action = new Action("Action1", 512) // Ejemplo, ajusta según tu lógica
    controller.addAction(action)

    // Distribuir acciones (puedes personalizar esto según tu lógica)
    controller.distributeActions()

    // Ejecutar acciones asignadas
    controller.executeAssignedActions()

    // Imprimir métricas
    controller.printMetrics()
  }
}
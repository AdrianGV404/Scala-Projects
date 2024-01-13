package example

class Tests extends munit.FunSuite {
  // Create an instance of the controller (SINGLETON)
  val controller = SimpleController

  // Configure the controller's policy
  controller.setPolicy(new RoundRobin())

  // Create some actions
  val adderAction = new Adder()
  val multiplierAction = new Multiplier()
  val factorialAction = new Factorial()

  // Add actions to the controller
  controller.addAction(adderAction)
  controller.addAction(multiplierAction)
  controller.addAction(factorialAction)

  // Create some invokers
  val invoker1 = new SimpleInvoker("Invoker1", 1024.0f)
  val invoker2 = new SimpleInvoker("Invoker2", 2048.0f)

  // Add invokers to the controller
  controller.addInvoker(invoker1)
  controller.addInvoker(invoker2)

  // Distribute actions according to the controller's policy
  controller.distributeActions()

  // Execute actions assigned to the controller (without threads)
  controller.executeActions()

  // Execute actions assigned to the controller (with threads)
  // controller.executeActionsWithThreads()
}

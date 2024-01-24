package scala.composite

object RunMenu extends scala.App {
  val Menu: MenuCategory = new MenuCategory("Root")
  val appetizersCategory: MenuCategory = new MenuCategory("Appetizers")
  val mainCourses: MenuCategory = new MenuCategory("Main Courses")
  val dessert: MenuCategory = new MenuCategory("Desserts")
  
  val salad: SingleItem = new SingleItem("Caesar Salad", 8.99)
  val soup: SingleItem = new SingleItem("Tomato Soup", 5.99)
  val pasta: MenuCategory = new MenuCategory("Pasta")  
  val spaghetti: SingleItem = new SingleItem("Spaghetti Bolognese", 12.99)
  val meat: MenuCategory = new MenuCategory("Meat")
  val sausages: SingleItem = new SingleItem("Red Sausages", 6.99)
  val steak: SingleItem = new SingleItem("Grilled Steak", 18.99)
  val cake: SingleItem = new SingleItem("Chocolate Cake", 6.99)
  
  Menu.addChild(appetizersCategory)
  Menu.addChild(mainCourses)
  mainCourses.addChild(pasta)
  mainCourses.addChild(meat)
  Menu.addChild(dessert)
  
  appetizersCategory.addChild(salad)
  appetizersCategory.addChild(soup)
  
  meat.addChild(steak)
  meat.addChild(sausages)
  pasta.addChild(spaghetti)
  
  dessert.addChild(cake)
  
  println("-------------")

  println("Root Category Price: $" + Menu.getPrice)
  println("Appetizers Category Price: $" + appetizersCategory.getPrice)
  println("Main Courses Category Price: $" + mainCourses.getPrice)
  println("Pasta Category Price: $" + pasta.getPrice)
  println("Meat Category Price: $" + meat.getPrice)
  println("Desserts Category Price: $" + dessert.getPrice)
}

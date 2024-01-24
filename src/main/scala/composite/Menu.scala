package scala.composite

import scala.collection.mutable.ListBuffer

trait MenuItem {
  def getName: String
  def getPrice: Double
}

class SingleItem(val name: String, val price: Double) extends MenuItem {
  def getName: String = name
  def getPrice: Double = price
}

class MenuCategory(val name: String) extends MenuItem {
  private var items: ListBuffer[MenuItem] = ListBuffer()

  def addChild(item: MenuItem): Unit = {
    items += item
  }

  def removeChild(item: MenuItem): Unit = {
    items -= item
  }

  def getName: String = name

  def getPrice: Double = {
    items.map(_.getPrice).sum
  }
}
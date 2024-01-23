package main

object Singleton extends App {
  // Controller ID
  private var _id: String = "SingletonId"

  // Function to get the current ID
  def getId: String = {
    if (_id == null) {
      _id = "SingletonId"
    }
    _id
  }

  // Constructor that allows setting the ID
  def create(newId: String): Singleton.type = {
    _id = newId
    this
  }
}
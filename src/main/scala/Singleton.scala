package main

/**
 * Singleton object representing a controller with an ID.
 * This object is designed as a singleton, ensuring that there is only one instance of the controller in the application.
 */
object Singleton extends App {
  // Controller ID
  private var _id: String = "SingletonId"

  /**
   * Gets the current ID of the Singleton.
   * If the ID is not initialized, it is set to the default value "SingletonId" before being returned.
   *
   * @return The current ID of the Singleton.
   */
  def getId: String = {
    if (_id == null) {
      _id = "SingletonId"
    }
    _id
  }

  /**
   * Creates a new instance of the Singleton with a custom ID.
   * This method allows setting a custom ID for the Singleton instance.
   *
   * @param newId The custom ID to set for the Singleton.
   * @return The Singleton instance with the custom ID.
   */
  def create(newId: String): Singleton.type = {
    _id = newId
    this
  }
}

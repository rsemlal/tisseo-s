package net.rsemlal.tisseos.services.boilerplate

/**
 * Helper pour les exceptions.
 */
object ExceptionHelper {

}

/**
 * Helper d'une exception.
 */
trait ExceptionHelper[T <: Throwable] {
  /**
   * Factory method.
   * @param message Message.
   * @param innerException Exception imbriquée.
   */
  def apply(message: String, innerException: Throwable): T

  /**
   * Factory method.
   * @param message Message.
   */
  final def apply(message: String): T =
    ExceptionHelper.this.apply(message, null)

  /**
   * Factory method.
   * @param innerException Exception imbriquée.
   */
  final def apply(innerException: Throwable): T =
    ExceptionHelper.this.apply(s"Cause: $innerException", innerException)

  /**
   * Factory method.
   */
  final def apply(): T =
    ExceptionHelper.this.apply("Unkown cause", null)
}
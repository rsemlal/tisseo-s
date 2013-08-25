package net.rsemlal.tisseos.data.places

object PlaceCategory {
  /**
   * Route.
   */
  case object Road extends PlaceCategory("Roads", "road")
  /**
   * Addresse.
   */
  case object Address extends PlaceCategory("Address", "address")
  /**
   * Place publique.
   */
  case object PublicPlace extends PlaceCategory("PublicPlace", "publicplace") // TODO Aucun exemple de ça
  /**
   * Ville.
   */
  case object City extends PlaceCategory("Cities", "city")
  /**
   * Arrêt.
   */
  case object StopPlace extends PlaceCategory("Stops", "stop")
}

/**
 * Catégorie d'un endroit répertorié.
 * @param category Nom de la catégorie.
 * @param className Nom de la classe.
 */
sealed class PlaceCategory private (val category: String, val className: String) {
  override def equals(obj: Any) = obj match {
    case other: PlaceCategory => this.category == other.category &&
      this.className == other.className
    case _ => false
  }
}
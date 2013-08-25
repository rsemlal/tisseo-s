package net.rsemlal.tisseos.data.places

object PlaceCategory {
  case object Road extends PlaceCategory("Roads", "road")
  case object Address extends PlaceCategory("Address", "address")
  case object PublicPlace extends PlaceCategory("PublicPlace", "publicplace") // TODO Aucun exemple de ça
  case object City extends PlaceCategory("Cities", "city")
  case object StopPlace extends PlaceCategory("Stops", "stop")
}

/**
 * Catégorie d'un endroit répertorié.
 * @param category Nom de la catégorie.
 * @param className Nom de la classe.
 */
sealed class PlaceCategory private(val category: String, val className: String) {
  override def equals(obj: Any) = obj match {
    case other: PlaceCategory => this.category == other.category &&
      this.className == other.className
    case _ => false
  }
}
package net.rsemlal.tisseos.data.places

import scala.collection.mutable.ListBuffer
// FIXME Les objects sont initializés de façon lazy donc les from* risque de ne pas fonctionner dans certains cas.
object PlaceCategory {
  private val _values = ListBuffer.empty[PlaceCategory]
  private val clazzName = classOf[PlaceCategory].getCanonicalName

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

  /**
   * Retourne un [[PlaceCategory]] depuis le nom de categorie.
   * @param category Nom de la catégorie.
   * @return [[PlaceCategory]] correspondant.
   * @throws NoSuchElementException Si aucun [[PlaceCategory]] ne correspond à la recherche.
   */
  @throws[NoSuchElementException]
  def fromCategory(category: String) = {
    val filter = _values.filter(_.category == category)
    filter.headOption.getOrElse {
      throw new NoSuchElementException {
        s"There is no element of type $clazzName with the category $category"
      }
    }
  }

  /**
   * Retourne un [[PlaceCategory]] depuis le nom de la classe.
   * @param category Nom de la catégorie.
   * @return [[PlaceCategory]] correspondant.
   * @throws NoSuchElementException Si aucun [[PlaceCategory]] ne correspond à la recherche.
   */
  @throws[NoSuchElementException]
  def fromClassName(className: String) = {
    val filter = _values.filter(_.className == className)
    filter.headOption.getOrElse {
      throw new NoSuchElementException {
        s"There is no element of type $clazzName with the class name $className"
      }
    }
  }
}

/**
 * Catégorie d'un endroit répertorié.
 * @param category Nom de la catégorie.
 * @param className Nom de la classe.
 */
sealed class PlaceCategory private (val category: String, val className: String) {

  PlaceCategory._values.synchronized {
    PlaceCategory._values.+=(this)
  }

  override def equals(obj: Any) = obj match {
    case other: PlaceCategory => this.category == other.category &&
      this.className == other.className
    case _ => false
  }
}
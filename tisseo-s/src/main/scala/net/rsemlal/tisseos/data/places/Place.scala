package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

object Place {

  def apply(label: String, key: String, placeCategory: PlaceCategory) = placeCategory match {
    case PlaceCategory.Address => Address(label, key)
    case PlaceCategory.City => City(label, key)
    case PlaceCategory.PublicPlace => PublicPlace(label, key)
    case PlaceCategory.Road => Road(label, key)
    case PlaceCategory.StopPlace => StopPlace(label, key)
    case _ => Address(label, key) // FIXME Ce cas ne doit pas se présenter
  }

  def unapply(obj: Place) =
    Some((obj.label, obj.key, obj.placeCategory))
}

/**
 * Endroit répertorié.
 */
trait Place {
  /**
   * Nom complet de l'endroit.
   */
  val label: String

  /**
   * Clé de la place.
   */
  val key: String

  /**
   * Catégorie de la place.
   */
  val placeCategory: PlaceCategory

  def withPos(_pos: GeoLoc): Place with PosAttribute{}

  override def equals(obj: Any) = obj match {
    case other: Place => this.label == other.label &&
      this.key == other.label &&
      this.placeCategory == this.placeCategory
    case _ => false
  }
}
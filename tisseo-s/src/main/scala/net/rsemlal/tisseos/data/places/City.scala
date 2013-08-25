package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Ville.
 * @param label Nom complet.
 * @param key Clé.
 */
case class City(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.City

  override def withPos(_pos: GeoLoc) = new City(label, key) with PosAttribute {
    override val pos = _pos
  }
}
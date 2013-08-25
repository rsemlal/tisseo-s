package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Addresse.
 * @param label Nom complet.
 * @param key Clé.
 */
case class Address(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.Address

  override def withPos(_pos: GeoLoc) = new Address(label, key) with PosAttribute {
    override val pos = _pos
  }
}
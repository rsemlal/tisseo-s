package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.objects.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Place publique.
 * @param label Nom complet.
 * @param key Clé.
 */
case class PublicPlace(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.PublicPlace

  override def withPos(_pos: GeoLoc) = new PublicPlace(label, key) with PosAttribute {
    override val pos = _pos
  }
}
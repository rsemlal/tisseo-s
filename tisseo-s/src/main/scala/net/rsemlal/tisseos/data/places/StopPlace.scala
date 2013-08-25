package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

/**
 * Arrêt.
 * @param label Nom complet.
 * @param key Clé.
 */
case class StopPlace(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.StopPlace

  override def withPos(_pos: GeoLoc) = new StopPlace(label, key) with PosAttribute {
    override val pos = _pos
  }
}
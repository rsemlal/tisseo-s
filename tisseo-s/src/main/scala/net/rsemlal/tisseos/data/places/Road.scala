package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

case class Road(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.Road

  override def withPos(_pos: GeoLoc) = new Road(label, key) with PosAttribute {
    override val pos = _pos
  }
}
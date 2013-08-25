package net.rsemlal.tisseos.data.places

import net.rsemlal.tisseos.data.additionnals.GeoLoc
import net.rsemlal.tisseos.data.attributes.PosAttribute

case class Address(label: String, key: String) extends Place {
  override val placeCategory = PlaceCategory.Address

  override def withPos(_pos: GeoLoc) = new Address(label, key) with PosAttribute {
    override val pos = _pos
  }
}
package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.additionnals.GeoLoc

trait PosAttribute {
  /**
   * Position.
   */
  val pos: GeoLoc
}
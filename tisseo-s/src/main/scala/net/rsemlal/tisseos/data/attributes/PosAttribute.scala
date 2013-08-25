package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.objects.GeoLoc

trait PosAttribute {
  /**
   * Position.
   */
  val pos: GeoLoc
}
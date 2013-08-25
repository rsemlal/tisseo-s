package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.Line
import net.rsemlal.tisseos.data.TransportMode

trait TransportModeAttribute {
  this: Line =>
  val transportMode: TransportMode
}
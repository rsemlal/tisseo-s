package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.StopArea
import net.rsemlal.tisseos.data.Line

trait TerminusAttribute {
  this: Line =>
  val terminus: (StopArea, StopArea)
}
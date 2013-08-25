package net.rsemlal.tisseos.data.attributes;

import net.rsemlal.tisseos.data.Line
import net.rsemlal.tisseos.data.StopArea

trait LinesAttribute {
  this: StopArea =>
  /**
   * Liste des lignes.
   */
  val lines: Set[Line]
}
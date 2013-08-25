package net.rsemlal.tisseos.data.attributes;

import net.rsemlal.tisseos.data.Line

trait LinesAttribute {
  /**
   * Liste des lignes.
   */
  val lines: Set[Line]
}
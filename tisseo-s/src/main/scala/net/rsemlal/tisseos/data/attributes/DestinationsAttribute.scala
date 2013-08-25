package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.additionnals.Destination

trait DestinationsAttribute {
  /**
   * Ensemble de destinations.
   */
  val destinations: Set[Destination]
}
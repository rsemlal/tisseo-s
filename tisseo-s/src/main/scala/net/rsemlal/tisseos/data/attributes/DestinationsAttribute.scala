package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.objects.Destination

trait DestinationsAttribute {
  /**
   * Ensemble de destinations.
   */
  val destinations: Set[Destination]
}
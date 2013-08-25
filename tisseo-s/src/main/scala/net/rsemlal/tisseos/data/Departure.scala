package net.rsemlal.tisseos.data

import org.joda.time.DateTime
import net.rsemlal.tisseos.data.objects.Destination
import net.rsemlal.tisseos.data.attributes.DestinationsAttribute

/**
 * Horraire de départ.
 * @param dateTime Heure de départ.
 * @param realTime [[Boolean.True]] si et seulement si c'est un horraire temps réel.
 * @param destinations Destinations du départ.
 */
case class Departure(
  dateTime: DateTime,
  realTime: Boolean,
  destinations: Set[Destination])
  extends DestinationsAttribute
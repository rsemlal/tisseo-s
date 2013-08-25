package net.rsemlal.tisseos.data.objects

import net.rsemlal.tisseos.data.Line
import net.rsemlal.tisseos.data.StopArea

/**
 * Destination d'une ligne.
 * @param line Ligne en question.
 * @param stopArea Direction de la ligne (terminus de destination).
 */
case class Destination(line: Line, stopArea: StopArea)
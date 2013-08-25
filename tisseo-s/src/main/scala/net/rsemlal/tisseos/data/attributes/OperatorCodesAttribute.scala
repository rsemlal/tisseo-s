package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.objects.OperatorCode
import net.rsemlal.tisseos.data.Stop

trait OperatorCodesAttribute {
  this: Stop =>
  /**
   * Ensemble de codes opérateur.
   */
  val operatorCodes: Set[OperatorCode]
}
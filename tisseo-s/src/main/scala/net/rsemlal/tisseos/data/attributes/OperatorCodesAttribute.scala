package net.rsemlal.tisseos.data.attributes

import net.rsemlal.tisseos.data.additionnals.OperatorCode

trait OperatorCodesAttribute {
  /**
   * Ensemble de codes opérateur.
   */
  val operatorCodes: Set[OperatorCode]
}
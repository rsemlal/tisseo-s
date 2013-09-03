package net.rsemlal.tisseos.services.implementations.tisseoapiconf

import net.rsemlal.tisseos.services.api.TisseoAPIConfiguration

/**
 * Implémentation déléguée de [[TisseoAPIConfiguration]].
 */
abstract class WrappedTisseoAPIConfiguration
  extends TisseoAPIConfiguration {

  /**
   * implémentation interne.
   */
  protected val stub: TisseoAPIConfiguration

  final lazy val url = {
    stub.url
  }

  final lazy val key = {
    stub.key
  }
}
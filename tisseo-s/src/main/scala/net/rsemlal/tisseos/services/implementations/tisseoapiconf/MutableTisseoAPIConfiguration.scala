package net.rsemlal.tisseos.services.implementations.tisseoapiconf

import java.net.URL

import net.rsemlal.tisseos.services.api.TisseoAPIConfiguration

/**
 * Implémentation mutable de [[TisseoAPIConfiguration]].
 */
class MutableTisseoAPIConfiguration
  extends TisseoAPIConfiguration {
  var url: URL = _
  var key: String = _
}
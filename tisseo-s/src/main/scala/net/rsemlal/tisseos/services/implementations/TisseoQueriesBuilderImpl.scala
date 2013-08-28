package net.rsemlal.tisseos.services.implementations

import net.rsemlal.tisseos.queries.TisseoQuery.ResultFormat.Value
import net.rsemlal.tisseos.queries.TisseoQuery
import net.rsemlal.tisseos.services.api.TisseoQueriesBuilder
import net.rsemlal.tisseos.services.api.TisseoAPIConfiguration
import net.rsemlal.tisseos.queries.LinesListQuery
import net.rsemlal.tisseos.queries.StopAreasListQuery
import net.rsemlal.tisseos.queries.StopPointsListQuery
import net.rsemlal.tisseos.queries.DepartureBoardQuery

class TisseoQueriesBuilderImpl(val tisseoApiConfiguration: TisseoAPIConfiguration) extends TisseoQueriesBuilder {

  override def buildGenericQuery(
    serviceName: String,
    format: TisseoQuery.ResultFormat.Value) = {
    TisseoQuery(serviceName, tisseoApiConfiguration.key, format)
  }

  override def buildLinesListQuery(
    format: TisseoQuery.ResultFormat.Value) = {
    LinesListQuery(tisseoApiConfiguration.key, format)
  }

  override def buildStopAreasListQuery(
    format: TisseoQuery.ResultFormat.Value) = {
    StopAreasListQuery(tisseoApiConfiguration.key, format)
  }

  override def buildStopPointsListQuery(
    format: TisseoQuery.ResultFormat.Value) = {
    StopPointsListQuery(tisseoApiConfiguration.key, format)
  }

  override def buildDepartureBoardQuery(
    format: TisseoQuery.ResultFormat.Value) = {
    DepartureBoardQuery(tisseoApiConfiguration.key, format)
  }
}
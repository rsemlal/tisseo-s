package net.rsemlal.tisseos.services.api

import net.rsemlal.tisseos.queries.DepartureBoardQuery
import net.rsemlal.tisseos.queries.LinesListQuery
import net.rsemlal.tisseos.queries.StopAreasListQuery
import net.rsemlal.tisseos.queries.StopPointsListQuery
import net.rsemlal.tisseos.queries.TisseoQuery

trait TisseoQueriesBuilder {
  /**
   * Construit une requête générique.
   * @param serviceName Nom du service.
   * @param format Format de résultat.
   * @return Requête.
   */
  def buildGenericQuery(serviceName: String, format: TisseoQuery.ResultFormat.Value = TisseoQuery.ResultFormat.Default): TisseoQuery

  /**
   * Construit une requête linesList.
   * @param format Format de résultat.
   * @return Requête.
   */
  def buildLinesListQuery(format: TisseoQuery.ResultFormat.Value = TisseoQuery.ResultFormat.Default): LinesListQuery

  /**
   * Construit une requête stopAreasList.
   * @param format Format de résultat.
   * @return Requête.
   */
  def buildStopAreasListQuery(format: TisseoQuery.ResultFormat.Value = TisseoQuery.ResultFormat.Default): StopAreasListQuery

  /**
   * Construit une requête stopPointsList.
   * @param format Format de résultat.
   * @return Requête.
   */
  def buildStopPointsListQuery(format: TisseoQuery.ResultFormat.Value = TisseoQuery.ResultFormat.Default): StopPointsListQuery

  /**
   * Construit une requête departueBoard.
   * @param format Format de résultat.
   * @return Requête.
   */
  def buildDepartureBoardQuery(format: TisseoQuery.ResultFormat.Value = TisseoQuery.ResultFormat.Default): DepartureBoardQuery
}
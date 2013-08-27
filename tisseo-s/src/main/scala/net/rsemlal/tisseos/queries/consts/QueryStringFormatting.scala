package net.rsemlal.tisseos.queries.consts

import net.rsemlal.tisseos.data.objects.Coords

object QueryStringFormatting {
  private val bboxRegex = """\s*(\d+\.*\d*)\s*,\s*(\d+\.*\d*)\s*,\s*(\d+\.*\d*)\s*,\s*(\d+\.*\d*)\s*""".r

  def booleanToQueryString(v: Boolean) = v match {
    case false => QueryFalse
    case true => QueryTrue
  }

  def queryStringToBoolean(v: String) = v match {
    case QueryFalse => Some(false)
    case QueryTrue => Some(true)
    case _ => None
  }

  def bboxToQueryString(value: Bbox) = {
    s"${value._1.x},${value._1.y},${value._2.x},${value._2.y}"
  }

  def queryStringToBbox(value: String) = value match {
    case bboxRegex(s_x_1, s_y_1, s_x_2, s_y_2) =>
      Some(Coords(s_x_1.toDouble, s_y_1.toDouble) -> Coords(s_x_2.toDouble, s_y_2.toDouble))
    case _ => None
  }
}
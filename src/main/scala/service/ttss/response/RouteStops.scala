package com.github.novitzkee
package service.ttss.response

import zio.json.{DeriveJsonDecoder, JsonDecoder}

case class RouteStops(route: RouteInfo,
                      stops: List[StopIdentifier])

object RouteStops:
  given jsonDecoder: JsonDecoder[RouteStops] = DeriveJsonDecoder.gen[RouteStops]
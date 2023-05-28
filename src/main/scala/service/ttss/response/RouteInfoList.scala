package com.github.novitzkee
package service.ttss.response

import zio.json.{DeriveJsonDecoder, JsonDecoder}

case class RouteInfoList(routes: List[RouteInfo])

object RouteInfoList:
  given jsonDecoder: JsonDecoder[RouteInfoList] = DeriveJsonDecoder.gen[RouteInfoList]



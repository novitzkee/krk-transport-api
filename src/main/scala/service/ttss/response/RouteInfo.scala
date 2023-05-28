package com.github.novitzkee
package service.ttss.response

import utils.JSONDecoders.emptyListIfMissing

import zio.json.{DeriveJsonDecoder, JsonDecoder}

case class RouteInfo(authority: String,
                     directions: List[String],
                     id: String,
                     name: String)

object RouteInfo:
  given jsonDecoder: JsonDecoder[RouteInfo] = DeriveJsonDecoder.gen[RouteInfo]

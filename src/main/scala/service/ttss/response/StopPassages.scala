package com.github.novitzkee
package service.ttss.response

import utils.JSONDecoders.instantFromEpochMillis

import zio.json.{DeriveJsonDecoder, JsonDecoder}

import java.time.Instant

case class StopPassages(actual: List[PassageInfo],
                        firstPassageTime: Instant,
                        lastPassageTime: Instant,
                        old: List[PassageInfo],
                        routes: List[RouteInfo],
                        stopName: String,
                        stopShortName: String)

object StopPassages:
  given jsonDecoder: JsonDecoder[StopPassages] = DeriveJsonDecoder.gen[StopPassages]
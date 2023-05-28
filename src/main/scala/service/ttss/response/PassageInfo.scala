package com.github.novitzkee
package service.ttss.response

import utils.JSONDecoders.durationFromSeconds

import zio.json.{DeriveJsonDecoder, JsonDecoder}

import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalTime}
import java.util.Locale

case class PassageInfo(actualRelativeTime: Duration,
                       actualTime: Option[LocalTime],
                       direction: String,
                       passageid: String,
                       patternText: String,
                       plannedTime: LocalTime,
                       routeId: String,
                       status: PassageStatus,
                       tripId: String,
                       vehicleId: Option[String])

object PassageInfo:
  given jsonDecoder: JsonDecoder[PassageInfo] = DeriveJsonDecoder.gen[PassageInfo]

package com.github.novitzkee
package service.ttss.request

import java.time.temporal.TemporalUnit
import java.time.{Duration, Instant, ZoneId, ZoneOffset}
import java.util.Locale

case class TimeRange(start: Instant, end: Instant):

  private val zoneId = ZoneId.of("Europe/Warsaw")

  def durationInMinutes: Long = Duration.between(start, end).toMinutes

object TimeRange:

  def relativeToNow(durationAhead: Duration): TimeRange =
    relativeToNow(Duration.ZERO, durationAhead)

  def relativeToNow(durationBehind: Duration = Duration.ZERO, durationAhead: Duration): TimeRange =
    val start = Instant.now().minusMillis(durationBehind.toMillis)
    val end = Instant.now().plusMillis(durationAhead.toMillis)
    TimeRange(start, end)

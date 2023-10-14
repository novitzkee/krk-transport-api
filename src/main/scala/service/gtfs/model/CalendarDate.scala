package com.github.novitzkee
package service.gtfs.model

import java.time.Instant
import java.util.Date

case class CalendarDate(serviceId: Long,
                        date: Date,
                        exceptionType: String)

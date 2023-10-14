package com.github.novitzkee
package service.gtfs.model

import java.time.DayOfWeek
import java.util.Date

case class CalendarEntry(serviceId: Long,
                         dayOfWeek: DayOfWeek,
                         startDate: Date,
                         endDate: Date)
package com.github.novitzkee
package service.gtfs.persistance
import service.gtfs.model.{Agency, CalendarDate, CalendarEntry, Route, Shape, Stop, StopTime, Trip}

import com.github.novitzkee.service.gtfs.file.GTFSCsvProvider
import zio.{Task, ZIO}

class InMemoryGTFS(private val csvProvider: GTFSCsvProvider) extends GTFS:

  override def agencies: Task[List[Agency]] = ???

  override def calendarDates: Task[List[CalendarDate]] = ???

  override def calendarEntries: Task[List[CalendarEntry]] = ???

  override def routes: Task[List[Route]] = ???

  override def shapes: Task[List[Shape]] = ???

  override def stops: Task[List[Stop]] = ???

  override def stopTimes: Task[List[StopTime]] = ???

  override def trips: Task[List[Trip]] = ???


package com.github.novitzkee
package service.gtfs.persistance

import service.gtfs.model.{Agency, CalendarDate, CalendarEntry, Route, Shape, Stop, StopTime, Trip}

import io.getquill.*
import io.getquill.jdbczio.Quill
import zio.{Task, ZIO}

import java.sql.SQLException
import javax.sql.DataSource

class SqliteGTFS(quill: Quill.Sqlite[SnakeCase]) extends GTFS:

  import quill.*

  override def agencies: Task[List[Agency]] = run(query[Agency])

  override def calendarDates: Task[List[CalendarDate]] = ???

  override def calendarEntries: Task[List[CalendarEntry]] = ???

  override def routes: Task[List[Route]] = ???

  override def shapes: Task[List[Shape]] = ???

  override def stops: Task[List[Stop]] = ???

  override def stopTimes: Task[List[StopTime]] = ???

  override def trips: Task[List[Trip]] = ???

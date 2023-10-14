package com.github.novitzkee
package service.gtfs.persistance

import service.gtfs.model.{Agency, CalendarDate, CalendarEntry, Route, Shape, Stop, StopTime, Trip}

import zio.Task

trait GTFS:

  def agencies: Task[List[Agency]]

  def calendarDates: Task[List[CalendarDate]]

  def calendarEntries: Task[List[CalendarEntry]]

  def routes: Task[List[Route]]

  def shapes: Task[List[Shape]]

  def stops: Task[List[Stop]]

  def stopTimes: Task[List[StopTime]]

  def trips: Task[List[Trip]]

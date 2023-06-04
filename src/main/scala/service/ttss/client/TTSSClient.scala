package com.github.novitzkee
package service.ttss.client

import service.ttss.request.TimeRange
import service.ttss.response.{RouteInfoList, RouteStops, StopPassages}
import utils.jsonDecode

import zio.http.*
import zio.json.JsonDecoder
import zio.{Chunk, IO, ZIO}

abstract class TTSSClient:

  protected lazy val ServiceURL: URL

  private val RouteInfoPath = ~~ / "routeInfo"

  private val PassageInfoPath = ~~ / "passageInfo"

  def fetchRoutes(): ZIO[Client, Throwable, RouteInfoList] =
    fetch(RouteInfoPath / "route")

  def fetchRouteStops(routeId: String): ZIO[Client, Throwable, RouteStops] =
    fetch(RouteInfoPath / "routeStops",
      ("routeId", routeId))

  def fetchStopPassages(stopNumber: String, timeRange: TimeRange): ZIO[Client, Throwable, StopPassages] =
    fetch(PassageInfoPath / "stopPassages" / "stop",
      ("mode", "departure"),
      ("stop", stopNumber),
      ("startTime", timeRange.start.toEpochMilli.toString),
      ("timeFrame", timeRange.durationInMinutes.toString)
    )

  private def fetch[R](relativePath: Path, formFields: (String, String)*)
                      (using JsonDecoder[R]): ZIO[Client, Throwable, R] =
    val form = Form(formFields.map(FormField.simpleField.tupled): _*)
    val request = Request.post(Body.fromURLEncodedForm(form), ServiceURL ++ URL(relativePath))
    fetch(request)
  
  private def fetch[R](request: Request)(using JsonDecoder[R]): ZIO[Client, Throwable, R] =
    for
      response <- Client.request(request)
      body <- response.body.asString
      response <- ZIO.jsonDecode[R](body)
    yield response

package com.github.novitzkee
package service.ttss.client

import service.ttss.exception.HttpResponseException
import service.ttss.request.TimeRange
import service.ttss.response.{RouteInfoList, RouteStops, StopPassages}
import utils.{filterOrFailWith, jsonDecode}

import zio.http.*
import zio.json.JsonDecoder
import zio.{Task, ZIO}

abstract class TTSSClient(private val client: Client):

  protected lazy val serviceURL: URL

  private val routeInfoPath = ~~ / "routeInfo"

  private val passageInfoPath = ~~ / "passageInfo"

  def fetchRoutes(): ZIO[Client, Throwable, RouteInfoList] =
    fetch(routeInfoPath / "route")

  def fetchRouteStops(routeId: String): Task[RouteStops] =
    fetch(routeInfoPath / "routeStops",
      ("routeId", routeId))

  def fetchStopPassages(stopNumber: String, timeRange: TimeRange): Task[StopPassages] =
    fetch(passageInfoPath / "stopPassages" / "stop",
      ("mode", "departure"),
      ("stop", stopNumber),
      ("startTime", timeRange.start.toEpochMilli.toString),
      ("timeFrame", timeRange.durationInMinutes.toString)
    )

  private def fetch[R](relativePath: Path, formFields: (String, String)*)(using JsonDecoder[R]): Task[R] =
    val form = Form(formFields.map(FormField.simpleField.tupled): _*)
    val request = Request.post(Body.fromURLEncodedForm(form), serviceURL ++ URL(relativePath))
    fetch(request)

  private def fetch[R](request: Request)(using JsonDecoder[R]): Task[R] =
    for
      response <- client.request(request)
        .filterOrFailWith(_.status.isSuccess)(HttpResponseException.invalidStatus)
      body <- response.body.asString
      response <- ZIO.jsonDecode[R](body)
    yield response

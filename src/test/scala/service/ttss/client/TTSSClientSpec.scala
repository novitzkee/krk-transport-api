package com.github.novitzkee
package service.ttss.client

import service.ttss.request.TimeRange
import service.ttss.response.RouteInfoList

import zio.http.ZClient
import zio.test.Assertion.{hasSize, isGreaterThan, isNull}
import zio.test.{Spec, TestAspect, ZIOSpecDefault, assert}
import zio.{ZIO, ZLayer}

import java.time.Duration

// This test is a bit flaky, it won't pass if there are no passages for stop at the time (e.g. night hours).
abstract class TTSSClientSpec extends ZIOSpecDefault:

  val SuiteLabel: String

  val ClientInstance: TTSSClient

  // This test should be broken down into separate test for each api endpoint but state would be needed from previous test.
  // It would require tests to run sequentially, and to data to be passed between them - not sure how to do this.

  def spec: Spec[Any, Throwable] = suite(SuiteLabel)(
    test("Should fetch data from service") {
      for
        client <- ZIO.service[TTSSClient]
        routeInfo <- client.fetchRoutes()
        _ <- ZIO.logInfo(routeInfo.toString)
        routeStops <- client.fetchRouteStops(routeInfo.routes.head.id)
        _ <- ZIO.logInfo(routeStops.toString)
        stopPassages <- client.fetchStopPassages(
          routeStops.stops.head.number,
          TimeRange.relativeToNow(Duration.ofMinutes(10), Duration.ofHours(1)))
        _ <- ZIO.logInfo(stopPassages.toString)
      yield
        assert(routeInfo)(!isNull) &&
          assert(routeInfo.routes)(!isNull && hasSize(isGreaterThan(1))) &&
          assert(routeStops)(!isNull) &&
          assert(routeStops.stops)(!isNull && hasSize(isGreaterThan(1))) &&
          assert(stopPassages)(!isNull) &&
          assert(stopPassages.actual)(!isNull && hasSize(isGreaterThan(1)))
    }
  ).provideShared(ZClient.default, ZLayer.succeed(ClientInstance))


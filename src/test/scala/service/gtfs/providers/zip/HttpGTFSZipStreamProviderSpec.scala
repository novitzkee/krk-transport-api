package com.github.novitzkee
package service.gtfs.providers.zip

import service.ttss.client.TTSSClient
import service.ttss.request.TimeRange
import utils.Zip

import zio.http.{Client, ZClient}
import zio.test.Assertion.hasSameElements
import zio.test.{Spec, ZIOSpecDefault, assert}
import zio.{Scope, URLayer, ZIO}

import java.time.Duration
import scala.util.Try

abstract class HttpGTFSZipStreamProviderSpec[TestedProvider <: HttpGTFSZipStreamProvider] extends ZIOSpecDefault:

  val suiteLabel: String

  val testedClientLayer: URLayer[Client, TestedProvider]

  private lazy val expectedFilenames: List[String] = List(
    "agency.txt",
    "calendar.txt",
    "calendar_dates.txt",
    "routes.txt",
    "shapes.txt",
    "stop_times.txt",
    "stops.txt",
    "trips.txt")

  def spec: Spec[Any, Throwable] = suite(suiteLabel)(
    test(suiteLabel) {
      for
        provider <- ZIO.service[HttpGTFSZipStreamProvider]
        zipStream <- provider.stream.toInputStream
        filenames <- ZIO.attemptBlocking(Zip.getFilenames(zipStream))
      yield
        assert(filenames)(hasSameElements(expectedFilenames))
    }
  ).provideShared(Scope.default, ZClient.default, testedClientLayer)


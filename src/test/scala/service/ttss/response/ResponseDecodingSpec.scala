package com.github.novitzkee
package service.ttss.response

import service.ttss.response.ResponseData.{RoutesDecoded, RoutesJSON}
import service.ttss.response.{ResponseData, RouteInfo, RouteInfoList}

import zio.json.JsonDecoder
import zio.test.Assertion.{equalTo, isRight}
import zio.test.{Assertion, Spec, ZIOSpecDefault, assert, suite, test}

import java.nio.file.Path
import scala.io.Source

object ResponseDecodingSpec extends ZIOSpecDefault:

  def spec: Spec[Any, Nothing] = suite("Response JSON decoding test suite")(
    test("Should decode route info json") {
      assertDecoded(ResponseData.RoutesJSON, ResponseData.RoutesDecoded)
    },
    test("Should decode route stops json") {
      assertDecoded(ResponseData.RouteStopsJSON, ResponseData.RouteStopsDecoded)
    },
    test("Should decode stop passages json") {
      assertDecoded(ResponseData.StopPassagesJSON, ResponseData.StopPassagesDecoded)
    }
  )

  private def assertDecoded[T](jsonFilePath: String, expectedDecoded: T)(using JsonDecoder[T]) =
    val jsonFile = readFile(jsonFilePath)
    val actualDecoded = JsonDecoder[T].decodeJson(jsonFile)
    assert(actualDecoded)(isRight(equalTo(expectedDecoded)))

  private def readFile(path: String) =
    Source.fromResource(path)
      .getLines()
      .mkString("\n");

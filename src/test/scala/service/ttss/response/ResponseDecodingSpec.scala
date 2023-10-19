package com.github.novitzkee
package service.ttss.response

import service.ttss.response.ResponseData.{routesDecoded, routesJSON}
import service.ttss.response.{ResponseData, RouteInfo, RouteInfoList}

import org.junit.runner.RunWith
import zio.json.JsonDecoder
import zio.test.Assertion.{equalTo, isRight}
import zio.test.junit.ZTestJUnitRunner
import zio.test.{Assertion, Spec, ZIOSpecDefault, assert, suite, test}

import java.nio.file.Path
import scala.io.Source

@RunWith(classOf[ZTestJUnitRunner])
class ResponseDecodingSpec extends ZIOSpecDefault:

  def spec: Spec[Any, Nothing] = suite("Response JSON decoding test suite")(
    test("Should decode route info json") {
      assertDecoded(ResponseData.routesJSON, ResponseData.routesDecoded)
    },
    test("Should decode route stops json") {
      assertDecoded(ResponseData.routeStopsJSON, ResponseData.routeStopsDecoded)
    },
    test("Should decode stop passages json") {
      assertDecoded(ResponseData.stopPassagesJSON, ResponseData.stopPassagesDecoded)
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

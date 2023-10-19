package com.github.novitzkee
package utils

import org.junit.runner.RunWith
import zio.test.Assertion.*
import zio.test.junit.ZTestJUnitRunner
import zio.test.{Spec, ZIOSpecDefault, assert}

import scala.util.Using

@RunWith(classOf[ZTestJUnitRunner])
class ZipSpec extends ZIOSpecDefault:

  private val testFile = "zip/archive.zip"

  def spec: Spec[Any, Throwable] = suite("Files unzipping spec") {
    test("Should retrieve filenames from zip") {
      val filenames = Using.resource(getZipResourceStream()) {
        fileStream => Zip.getFilenames(fileStream)
      }

      assert(filenames)(hasSameElements(List("A.txt", "B.txt", "folder/C.txt")))
    }

    test("Should unzip files with content") {
      val unzipResult = Using.resource(getZipResourceStream()) {
        fileStream => Zip.unzipFiles(fileStream)
      }.view
        .mapValues(String(_))
        .toMap

      assert(unzipResult)(!isNull)
      assert(unzipResult.keySet)(hasSameElements(List("A.txt", "B.txt", "folder/C.txt")))
      assert(unzipResult.get("A.txt"))(isSome(equalTo("File A")))
      assert(unzipResult.get("B.txt"))(isSome(equalTo("File B")))
      assert(unzipResult.get("folder/C.txt"))(isSome(equalTo("File C")))
    }
  }

  private def getZipResourceStream() =
    Thread.currentThread()
      .getContextClassLoader
      .getResourceAsStream(testFile)

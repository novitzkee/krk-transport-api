package com.github.novitzkee
package utils

import java.io.InputStream
import java.util.zip.ZipInputStream
import scala.util.Using


object Zip:

  def unzipFiles(stream: InputStream): Map[String, Array[Byte]] =
    Using.resource(new ZipInputStream(stream)) {
      zipStream =>
        LazyList.continually(zipStream.getNextEntry)
          .takeWhile(_ != null)
          .filter(!_.isDirectory)
          .map(entry => (entry.getName, zipStream.readAllBytes()))
          .toMap
    }

  def getFilenames(stream: InputStream): List[String] =
    Using.resource(new ZipInputStream(stream)) {
      zipStream =>
        LazyList.continually(zipStream.getNextEntry)
          .takeWhile(_ != null)
          .filter(!_.isDirectory)
          .map(_.getName)
          .toList
    }

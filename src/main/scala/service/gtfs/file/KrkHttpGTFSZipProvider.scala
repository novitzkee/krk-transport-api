package com.github.novitzkee
package service.gtfs.file

import service.gtfs.file.GTFSZipProvider

import zio.http.*
import zio.stream.Stream

class KrkHttpGTFSZipProvider(private val client: Client) extends GTFSZipProvider:

  private val busZipPath = ~~ / "GTFS_KRK_A.zip"

  private val tramZipPath = ~~ / "GTFS_KRK_T.zip"

  private val krkGTFSWebsiteUrl = URL.root.absolute("gtfs.ztp.krakow.pl")

  override def busGTFSZip: Stream[Throwable, Byte] = getZipFileStream(busZipPath)

  override def tramGTFSZip: Stream[Throwable, Byte] = getZipFileStream(tramZipPath)

  private def getZipFileStream(filePath: Path): Stream[Throwable, Byte] =
    val request = Request.get(krkGTFSWebsiteUrl ++ URL(filePath))
    val response = client.request(request)
    request.body.asStream

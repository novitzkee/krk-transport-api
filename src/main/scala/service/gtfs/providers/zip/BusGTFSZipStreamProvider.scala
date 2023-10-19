package com.github.novitzkee
package service.gtfs.providers.zip

import zio.http.{!!, Client, URL}
import zio.{URLayer, ZLayer}

case class BusGTFSZipStreamProvider(client: Client)
  extends HttpGTFSZipStreamProvider(BusGTFSZipStreamProvider.fileURL, client)

object BusGTFSZipStreamProvider:

  private val fileURL = URL(!! / "GTFS_KRK_A.zip").absolute("gtfs.ztp.krakow.pl")

  val live: URLayer[Client, BusGTFSZipStreamProvider] = ZLayer.derive[BusGTFSZipStreamProvider]

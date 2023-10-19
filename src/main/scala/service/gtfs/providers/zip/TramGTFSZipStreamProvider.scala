package com.github.novitzkee
package service.gtfs.providers.zip

import zio.http.{!!, Client, URL}
import zio.{URLayer, ZLayer}

case class TramGTFSZipStreamProvider(client: Client)
  extends HttpGTFSZipStreamProvider(TramGTFSZipStreamProvider.fileURL, client)

object TramGTFSZipStreamProvider:

  private val fileURL = URL(!! / "GTFS_KRK_T.zip").absolute("gtfs.ztp.krakow.pl")

  val live: URLayer[Client, TramGTFSZipStreamProvider] = ZLayer.derive[TramGTFSZipStreamProvider]

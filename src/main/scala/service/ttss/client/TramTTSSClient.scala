package com.github.novitzkee
package service.ttss.client

import zio.{URLayer, ZLayer}
import zio.http.{!!, Client, Path, URL}

case class TramTTSSClient(client: Client) extends TTSSClient(client):

  override protected lazy val serviceURL: URL =
    URL(!! / "internetservice" / "services")
      .absolute("www.ttss.krakow.pl")

object TramTTSSClient:
  
  val live: URLayer[Client, TramTTSSClient] = ZLayer.derive[TramTTSSClient]


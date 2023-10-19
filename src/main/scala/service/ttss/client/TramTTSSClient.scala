package com.github.novitzkee
package service.ttss.client

import zio.http.{!!, Client, Path, URL}
import zio.{URLayer, ZLayer}

case class TramTTSSClient(client: Client) extends TTSSClient(TramTTSSClient.host, client)

object TramTTSSClient:

  private val host = "www.ttss.krakow.pl"

  val live: URLayer[Client, TramTTSSClient] = ZLayer.derive[TramTTSSClient]


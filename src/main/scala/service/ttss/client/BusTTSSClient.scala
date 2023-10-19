package com.github.novitzkee
package service.ttss.client

import zio.{URLayer, ZLayer}
import zio.http.{!!, Client, Path, URL}

case class BusTTSSClient(client: Client) extends TTSSClient(BusTTSSClient.host, client)

object BusTTSSClient:

  private val host = "ttss.mpk.krakow.pl"

  val live: URLayer[Client, BusTTSSClient] = ZLayer.derive[BusTTSSClient]

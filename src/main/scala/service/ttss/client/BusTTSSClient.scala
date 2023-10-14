package com.github.novitzkee
package service.ttss.client

import zio.{URLayer, ZLayer}
import zio.http.{!!, Client, Path, URL}

case class BusTTSSClient(client: Client) extends TTSSClient(client):

  override protected lazy val serviceURL: URL =
    URL(!! / "internetservice" / "services")
      .absolute("ttss.mpk.krakow.pl")

object BusTTSSClient:

  val live: URLayer[Client, BusTTSSClient] = ZLayer.derive[BusTTSSClient]

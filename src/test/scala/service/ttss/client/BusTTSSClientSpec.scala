package com.github.novitzkee
package service.ttss.client
import zio.URLayer
import zio.http.Client

object BusTTSSClientSpec extends TTSSClientSpec[BusTTSSClient]:

  override val suiteLabel: String = "Bus web service client spec"

  override val testedClientLayer: URLayer[Client, BusTTSSClient] = BusTTSSClient.live

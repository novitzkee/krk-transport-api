package com.github.novitzkee
package service.ttss.client
import zio.URLayer
import zio.http.Client

object TramTTSSClientSpec extends TTSSClientSpec[TramTTSSClient]:

  override val suiteLabel: String = "Tram web service client spec"

  override val testedClientLayer: URLayer[Client, TramTTSSClient] = TramTTSSClient.live

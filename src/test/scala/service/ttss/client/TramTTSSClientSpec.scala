package com.github.novitzkee
package service.ttss.client
import org.junit.runner.RunWith
import zio.URLayer
import zio.http.Client
import zio.test.junit.ZTestJUnitRunner

@RunWith(classOf[ZTestJUnitRunner])
class TramTTSSClientSpec extends TTSSClientSpec[TramTTSSClient]:

  override val suiteLabel: String = "Tram web service client spec"

  override val testedClientLayer: URLayer[Client, TramTTSSClient] = TramTTSSClient.live

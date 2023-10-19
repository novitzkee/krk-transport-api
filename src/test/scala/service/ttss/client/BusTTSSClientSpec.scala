package com.github.novitzkee
package service.ttss.client
import org.junit.runner.RunWith
import zio.URLayer
import zio.http.Client
import zio.test.junit.ZTestJUnitRunner

@RunWith(classOf[ZTestJUnitRunner])
class BusTTSSClientSpec extends TTSSClientSpec[BusTTSSClient]:

  override val suiteLabel: String = "Bus web service client spec"

  override val testedClientLayer: URLayer[Client, BusTTSSClient] = BusTTSSClient.live

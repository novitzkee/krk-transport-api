package com.github.novitzkee
package service.gtfs.providers.zip

import org.junit.runner.RunWith
import zio.URLayer
import zio.http.Client
import zio.test.junit.ZTestJUnitRunner

@RunWith(classOf[ZTestJUnitRunner])
class TramGTFSZipStreamProviderSpec extends HttpGTFSZipStreamProviderSpec[BusGTFSZipStreamProvider]:

  override val suiteLabel: String = "Should fetch bus GTFS zip with content"

  override val testedClientLayer: URLayer[Client, BusGTFSZipStreamProvider] = BusGTFSZipStreamProvider.live

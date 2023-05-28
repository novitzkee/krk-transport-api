package com.github.novitzkee
package service.ttss.client

import zio.http.{!!, Path, URL}

class TramTTSSClient extends TTSSClient:

  override protected lazy val ServiceURL: URL =
    URL(!! / "internetservice" / "services")
      .absolute("www.ttss.krakow.pl")


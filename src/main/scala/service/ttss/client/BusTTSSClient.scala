package com.github.novitzkee
package service.ttss.client

import zio.http.{!!, Path, URL}

class BusTTSSClient extends TTSSClient:

  override protected lazy val ServiceURL: URL =
    URL(!! / "internetservice" / "services")
      .absolute("ttss.mpk.krakow.pl")

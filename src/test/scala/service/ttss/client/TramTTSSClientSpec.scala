package com.github.novitzkee
package service.ttss.client

object TramTTSSClientSpec extends TTSSClientSpec:

  override val SuiteLabel: String = "Tram web service client spec"

  override val ClientInstance: TTSSClient = TramTTSSClient()

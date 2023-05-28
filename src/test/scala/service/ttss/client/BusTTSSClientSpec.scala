package com.github.novitzkee
package service.ttss.client

object BusTTSSClientSpec extends TTSSClientSpec:

  override val SuiteLabel: String = "Bus web service client spec"

  override val ClientInstance: TTSSClient = BusTTSSClient()

package com.github.novitzkee
package service.ttss.exception

import zio.http.Status

case class HttpResponseException(message: String) extends Exception(message)

object HttpResponseException:
  def invalidStatus(expectedStatus: Status, actualStatus: Status): HttpResponseException =
    HttpResponseException(s"Expected status: ${expectedStatus.code}, but it was: ${actualStatus.code} - $actualStatus")

package com.github.novitzkee
package service.ttss.exception

import zio.http.{Response, Status}

case class HttpResponseException(message: String) extends Exception(message)

object HttpResponseException:
  def invalidStatus(response: Response): HttpResponseException =
    HttpResponseException(s"Invalid http status received: ${response.status} in response: $response")

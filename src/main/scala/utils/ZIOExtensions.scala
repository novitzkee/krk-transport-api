package com.github.novitzkee
package utils

import zio.json.{DecoderOps, JsonDecoder}
import zio.{Trace, ZIO}

case class JSONDecodingException(private val message: String) extends Exception(message)

extension (zio: ZIO.type)
  def jsonDecode[A](json: String)(using JsonDecoder[A]): ZIO[Any, Throwable, A] =
    json.fromJson[A]
      .fold(s => ZIO.fail(JSONDecodingException(s)), ZIO.from(_))

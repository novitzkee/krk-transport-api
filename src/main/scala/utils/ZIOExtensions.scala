package com.github.novitzkee
package utils

import zio.json.{DecoderOps, JsonDecoder}
import zio.{Trace, ZIO}

case class JSONDecodingException(private val message: String) extends Exception(message)

extension (zio: ZIO.type)
  def jsonDecode[A](json: String)(using JsonDecoder[A]): ZIO[Any, Throwable, A] =
    json.fromJson[A]
      .fold(s => ZIO.fail(JSONDecodingException(s)), ZIO.from(_))

extension [R, E, A](zio: ZIO[R, E, A])
  // Not sure why this method is not part of ZIO api.
  def filterOrFailWith[E1 >: E](p: A => Boolean)(t: A => E1): ZIO[R, E1, A] =
    zio.filterOrElseWith(p)(a => ZIO.fail(t(a)))


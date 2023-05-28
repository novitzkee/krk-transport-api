package com.github.novitzkee
package utils

import zio.json.internal.RetractReader
import zio.json.{JsonDecoder, JsonError}

import java.time.{Duration, Instant}

object JSONDecoders:

  given instantFromEpochMillis: JsonDecoder[Instant] =
    JsonDecoder.long.map(Instant.ofEpochMilli)

  given durationFromSeconds: JsonDecoder[Duration] =
    JsonDecoder.long.map(Duration.ofSeconds)

  given emptyListIfMissing[T](using JsonDecoder[List[T]]): JsonDecoder[List[T]] =
    withMissingFallback(List.empty)

  private def withMissingFallback[T](fallback: => T)(using JsonDecoder[T]): JsonDecoder[T] = new JsonDecoder[T]:
    override def unsafeDecodeMissing(trace: List[JsonError]): T =
      fallback

    override def unsafeDecode(trace: List[JsonError], in: RetractReader): T =
      JsonDecoder[T].unsafeDecode(trace, in)

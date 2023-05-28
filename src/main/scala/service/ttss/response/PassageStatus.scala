package com.github.novitzkee
package service.ttss.response

import zio.json.{DeriveJsonDecoder, JsonDecoder}

enum PassageStatus:
  case DEPARTED, STOPPING, PREDICTED, PLANNED

object PassageStatus:

  private def parse(value: String): PassageStatus =
    values.find(_.toString() == value)
      .getOrElse(throw new IllegalArgumentException(s"Could not parse passage status with value: $value"))

  given jsonDecoder: JsonDecoder[PassageStatus] = JsonDecoder[String].map(parse)


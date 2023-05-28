package com.github.novitzkee
package service.ttss.response

import zio.json.{DeriveJsonDecoder, JsonDecoder}

case class StopIdentifier(id: String,
                          name: String,
                          number: String)

object StopIdentifier:
 given jsonDecoder: JsonDecoder[StopIdentifier] = DeriveJsonDecoder.gen[StopIdentifier]

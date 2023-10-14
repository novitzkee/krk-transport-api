package com.github.novitzkee
package service.gtfs.model

import com.github.tototoshi.csv.CSVReader
import io.getquill.MappedEncoding
import zio.schema.DeriveSchema

case class Agency(id: Long,
                  name: String,
                  url: String,
                  timezone: String,
                  lang: String,
                  phone: String)


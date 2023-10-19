package com.github.novitzkee
package service.gtfs.providers.zip

import exception.HttpResponseException
import utils.filterOrFailWith

import zio.http.*
import zio.stream.{Stream, ZStream}
import zio.{Task, ZIO}

class HttpGTFSZipStreamProvider(private val fileURL: URL, private val client: Client) extends GTFSZipStreamProvider:

  override def stream: Stream[Throwable, Byte] =
    val bodyStreamZIO = client.request(Request.get(fileURL))
      .filterOrFailWith(_.status.isSuccess)(HttpResponseException.invalidStatus)
      .map(_.body.asStream)

    ZStream.unwrap(bodyStreamZIO)

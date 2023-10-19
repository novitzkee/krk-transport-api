package com.github.novitzkee
package service.gtfs.providers.zip

import zio.stream.Stream

trait GTFSZipStreamProvider:

  def stream: Stream[Throwable, Byte]



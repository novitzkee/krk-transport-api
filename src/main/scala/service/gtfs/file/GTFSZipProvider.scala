package com.github.novitzkee
package service.gtfs.file

import zio.http.Client
import zio.stream.Stream

trait GTFSZipProvider:

  def busGTFSZip: Stream[Throwable, Byte]

  def tramGTFSZip: Stream[Throwable, Byte]

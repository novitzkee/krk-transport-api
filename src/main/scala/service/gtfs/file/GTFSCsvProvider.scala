package com.github.novitzkee
package service.gtfs.file

import zio.stream.Stream

trait GTFSCsvProvider:

  def busGTFSCsv: Stream[Throwable, String]

  def tramGTFSCsv: Stream[Throwable, String]

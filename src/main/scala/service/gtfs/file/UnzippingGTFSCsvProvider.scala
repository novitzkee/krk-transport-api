package com.github.novitzkee
package service.gtfs.file

import service.gtfs.file.GTFSCsvProvider

import zio.stream.Stream

class UnzippingGTFSCsvProvider extends GTFSCsvProvider:

  override def busGTFSCsv: Stream[Throwable, String] = ???

  override def tramGTFSCsv: Stream[Throwable, String] = ???
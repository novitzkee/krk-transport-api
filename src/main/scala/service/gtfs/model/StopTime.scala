package com.github.novitzkee
package service.gtfs.model

import java.time.Instant

case class StopTime(blockId: Long,
                    tripId: Long,
                    serviceId: Long,
                    routeId: Long,
                    stopNumber: Long,
                    stopSubNumber: Long,
                    stopSequence: Int,
                    stopTime: Instant)

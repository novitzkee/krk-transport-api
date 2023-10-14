package com.github.novitzkee
package service.gtfs.model

case class Trip(blockId: Long,
                tripId: Long,
                serviceId: Long,
                routeId: Long,
                shapeId: Long,
                tripHeadsign: String)

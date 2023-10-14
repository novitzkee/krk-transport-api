package com.github.novitzkee
package service.gtfs.model

case class Route(id: Long,
                 agencyId: Long,
                 routeShortName: String,
                 routeType: Int,
                 latitude: Float,
                 longitude: Float)

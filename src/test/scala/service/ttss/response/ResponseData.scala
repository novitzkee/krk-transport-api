package com.github.novitzkee
package service.ttss.response

import java.time.{Duration, Instant, LocalTime}

object ResponseData:

  private val JsonDirectory = "json"

  val RoutesJSON: String = s"$JsonDirectory/routes.json"

  val RoutesDecoded: RouteInfoList =
    RouteInfoList(
      routes = List(
        RouteInfo(
          authority = "MPK",
          directions = List("Salwator", "Wańkowicza"),
          id = "8059228650286874655",
          name = "1"
        ),
        RouteInfo(
          authority = "MPK",
          directions = List("Cmentarz Rakowicki", "Salwator"),
          id = "8059228650286875578",
          name = "2"
        ),
        RouteInfo(
          authority = "MPK",
          directions = List(),
          id = "8059228650286874679",
          name = "3"
        )
      )
    )

  val RouteStopsJSON: String = s"$JsonDirectory/routeStops.json"

  val RouteStopsDecoded: RouteStops =
    RouteStops(
      route = RouteInfo(
        authority = "MPK",
        directions = List("Salwator", "Wańkowicza"),
        id = "8059228650286874655",
        name = "1"
      ),
      stops = List(
        StopIdentifier(
          id = "8059230041856278841",
          name = "Bieńczycka",
          number = "867"
        ),
        StopIdentifier(
          id = "8059230041856278820",
          name = "Borsucza",
          number = "612"
        ),
        StopIdentifier(
          id = "8059230041856278821",
          name = "Brożka (nż)",
          number = "613"
        )
      )
    )

  val StopPassagesJSON: String = s"$JsonDirectory/stopPassages.json"

  val StopPassagesDecoded: StopPassages =
    StopPassages(
      actual = List(
        PassageInfo(
          actualRelativeTime = Duration.ofSeconds(-27),
          actualTime = Some(LocalTime.of(22, 12)),
          direction = "Borek Fałęcki",
          passageid = "-1188950300377882262",
          patternText = "8",
          plannedTime = LocalTime.of(22, 12),
          routeId = "8059228650286875431",
          status = PassageStatus.STOPPING,
          tripId = "8059232507167812611",
          vehicleId = Option("-1188950295904324328")
        ),
        PassageInfo(
          actualRelativeTime = Duration.ofSeconds(93),
          actualTime = Some(LocalTime.of(22, 14)),
          direction = "Bronowice",
          passageid = "-1188950300377888389",
          patternText = "13",
          plannedTime = LocalTime.of(22, 12),
          routeId = "8059228650286875432",
          status = PassageStatus.PREDICTED,
          tripId = "8059232507169721358",
          vehicleId = Option("-1188950295904324362")
        )
      ),
      firstPassageTime = Instant.ofEpochMilli(1684698147000L),
      lastPassageTime = Instant.ofEpochMilli(1684704600000L),
      old = List(
        PassageInfo(
          actualRelativeTime = Duration.ofSeconds(-267),
          actualTime = None,
          direction = "Salwator",
          passageid = "-1188950300377891227",
          patternText = "1",
          plannedTime = LocalTime.of(22, 7),
          routeId = "8059228650286874655",
          status = PassageStatus.DEPARTED,
          tripId = "8059232507168181262",
          vehicleId = Option("-1188950295904330973")
        )
      ),
      routes = List(
        RouteInfo(
          authority = "MPK",
          directions = List("Salwator", "Wańkowicza"),
          id = "8059228650286874655",
          name = "1"
        )
      ),
      stopName = "Filharmonia",
      stopShortName = "322"
    )

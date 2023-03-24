package com.github.aveek22

import java.time.Instant

case class TemptationEvent(
                            domainUserId: String,
                            temptationTrackingId: String,
                            meteringCount: String,
                            contentBlocker: String,
                            brand: String,
                            networkUserId: String,
                            lastUpdatedTimestamp: String
                          )

object TemptationEvent{

}

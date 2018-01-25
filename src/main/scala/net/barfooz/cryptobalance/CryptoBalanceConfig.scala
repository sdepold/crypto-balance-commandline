package net.barfooz.cryptobalance

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

object CryptoBalanceConfig {
  private val config: Config = ConfigFactory.load

  val bitstampConfig = CryptoBalanceConfigSpec(
    config.getString("bitstamp.username"),
    config.getString("bitstamp.key"),
    config.getString("bitstamp.secret"),
    config.getString("bitstamp.baseUrl"),
  )
}

case class CryptoBalanceConfigSpec(username: String = "", key: String, secret: String, hostname: String) {}
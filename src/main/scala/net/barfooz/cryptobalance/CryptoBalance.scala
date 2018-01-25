package net.barfooz.cryptobalance

import net.barfooz.cryptobalance.service.BitstampService

object CryptoBalance extends App {
  val bitstampService = new BitstampService
  val accountBalance = bitstampService.getAccountBalance

  println(accountBalance)
}

package net.barfooz.cryptobalance.service

import net.barfooz.cryptobalance.client.BitstampClient
import net.barfooz.cryptobalance.dao.{BitstampUserTransaction, TransactionType}
import net.barfooz.cryptobalance.{AccountBalance, CryptoBalanceConfig}

class BitstampService {
  def getAccountBalance = {
    val bitstampClient = new BitstampClient(CryptoBalanceConfig.bitstampConfig)
    val bitstampAccountBalance = bitstampClient.getAccountBalance
    val userTransactions = bitstampClient.getUserTransactions
    val accountBalance = new AccountBalance()

    accountBalance.update("bch", bitstampAccountBalance.bch_balance)
    accountBalance.update("btc", bitstampAccountBalance.btc_balance)
    accountBalance.update("eth", bitstampAccountBalance.eth_balance)
    accountBalance.update("eur", bitstampAccountBalance.eur_balance)
    accountBalance.update("ltc", bitstampAccountBalance.ltc_balance)
    accountBalance.update("usd", bitstampAccountBalance.usd_balance)
    accountBalance.update("xrp", bitstampAccountBalance.xrp_balance)

    accountBalance
  }
}

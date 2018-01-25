package net.barfooz.cryptobalance.dao

object TransactionType extends Enumeration {
  type TransactionType = Value
  val DEPOSIT, WITHDRAWAL, TRADE, RIPPLE_WITHDRAWAL, RIPPLE_DEPOSIT, SUB_ACCOUNT_TRANSFER = Value
}

case class BitstampUserTransaction(
                                    fee: BigDecimal = 0,
                                    usd: BigDecimal = 0,
                                    btc_usd: Option[BigDecimal] = Some(0),
                                    btc: Option[BigDecimal] = Some(0),
                                    ltc: Option[BigDecimal] = Some(0),
                                    xrp: Option[BigDecimal] = Some(0),
                                    `type`: String,
                                    id: Integer,
                                    eur: BigDecimal = 0
                                  ) {
  def transactionType = `type` match {
    case "None" | "2" => TransactionType.TRADE
    case "0" => TransactionType.DEPOSIT
    case "1" => TransactionType.WITHDRAWAL
    case "3" => TransactionType.RIPPLE_WITHDRAWAL
    case "4" => TransactionType.RIPPLE_DEPOSIT
    case "14" => TransactionType.SUB_ACCOUNT_TRANSFER
    case _ => {
      println(s"Unknown transaction type: ${`type`}")
      TransactionType.TRADE
    }
  }
}

case class BitstampAccountBalance(
                                   bch_available: BigDecimal,
                                   bch_balance: BigDecimal,
                                   bch_reserved: BigDecimal,
                                   btc_available: BigDecimal,
                                   btc_balance: BigDecimal,
                                   btc_reserved: BigDecimal,
                                   eth_available: BigDecimal,
                                   eth_balance: BigDecimal,
                                   eth_reserved: BigDecimal,
                                   eur_available: BigDecimal,
                                   eur_balance: BigDecimal,
                                   eur_reserved: BigDecimal,
                                   ltc_available: BigDecimal,
                                   ltc_balance: BigDecimal,
                                   ltc_reserved: BigDecimal,
                                   usd_available: BigDecimal,
                                   usd_balance: BigDecimal,
                                   usd_reserved: BigDecimal,
                                   xrp_available: BigDecimal,
                                   xrp_balance: BigDecimal,
                                   xrp_reserved: BigDecimal
                                 )

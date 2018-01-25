package net.barfooz.cryptobalance

class AccountBalance(
  var bch: BigDecimal = 0,
  var btc: BigDecimal = 0,
  var doge: BigDecimal = 0,
  var eth: BigDecimal = 0,
  var eur: BigDecimal = 0,
  var lsk: BigDecimal = 0,
  var ltc: BigDecimal = 0,
  var usd: BigDecimal = 0,
  var xlm: BigDecimal = 0,
  var xrp: BigDecimal = 0,
) {
  def update(currency: String, value: BigDecimal) = currency match {
    case "bch" => this.bch += value
    case "btc" => this.btc += value
    case "doge" => this.doge += value
    case "eth" => this.eth += value
    case "eur" => this.eur += value
    case "lsk" => this.lsk += value
    case "ltc" => this.ltc += value
    case "xlm" => this.xlm += value
    case "xrp" => this.xrp += value
    case _ => this
  }

  override def toString: String =
    s"""
       USD: $usd
       EUR: $eur
       BTC: $btc
       LTC: $ltc
       XRP: $xrp
       XLM: $xlm
       LSK: $lsk
       dog: $doge
    """.stripMargin
}

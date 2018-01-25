package net.barfooz.cryptobalance.client

import com.roundeights.hasher.Algo
import io.circe
import net.barfooz.cryptobalance.CryptoBalanceConfigSpec
import net.barfooz.cryptobalance.dao.{BitstampAccountBalance, BitstampUserTransaction}
import org.json4s.JArray
import org.json4s.JsonAST.JObject
import io.circe.parser.decode
import io.circe.generic.auto._
import io.circe.syntax._

import scalaj.http.{Http, HttpOptions}

class BitstampClient(cryptoBalanceConfigSpec: CryptoBalanceConfigSpec) {
  private def generateNonce = System.currentTimeMillis.toString
  private def generateSignature(nonce: String) = {
    val message = s"$nonce${cryptoBalanceConfigSpec.username}${cryptoBalanceConfigSpec.key}"
    val result = Algo.hmac(cryptoBalanceConfigSpec.secret).sha256(message)

    result.hash.toUpperCase
  }

  private def params = {
    val nonce = generateNonce

    s"sort=asc&key=${cryptoBalanceConfigSpec.key}&nonce=$nonce&signature=${generateSignature(nonce)}"
  }

  def getUserTransactions = {
     val url = s"${cryptoBalanceConfigSpec.hostname}/api/v2/user_transactions/"
     val json = Http(url).postData(params).option(HttpOptions.readTimeout(10000)).asString

     val decoded = decode[List[BitstampUserTransaction]](json.body)

     decoded match {
       case Left(failure) => {
         println("Invalid JSON :(")
         List.empty
       }
       case Right(result) => result
     }
  }

  def getAccountBalance = {
    val url = s"${cryptoBalanceConfigSpec.hostname}/api/v2/balance/"
    val json = Http(url).postData(params).option(HttpOptions.readTimeout(10000)).asString

    val decoded = decode[BitstampAccountBalance](json.body)

    decoded match {
      case Left(failure) => {
        println("Invalid JSON :(")
        new BitstampAccountBalance(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
      }
      case Right(result) => result
    }
  }
}

package quanter.securities

import quanter.OptionRight._
import quanter.OptionStyle._
import quanter.SecurityType
import quanter.SecurityType.SecurityType

/**
  * 证券类，
  */
class Security(private val _symbol : String) {
  /**
    * 证券类型
    */
  var securityType : SecurityType = SecurityType.Base
  /**
    * 证券代码，包含交易所代码
    */
  var symbol = _symbol

//  def optionRight : OptionRight = Put
//  def optionStyle : OptionStyle = American
}

object Security{
  val EMPTY =  new String("");
  private def generate : String = null

//  def createOption() = generate
//  def createBase() = generate
//  def createCfd(symbol : String, market : String) = generate

  /**
    * 创建一个期货
    * @param symbol
    * @return
    */
  def createFuture(symbol: String) : Security = {
    new Security(symbol) {
      securityType = SecurityType.Future
    }
  }
  /**
    * 创建一个股票
    * @param symbol
    * @return
    */
  def createEquity(symbol: String): Security = {
    new Security(symbol) {
      securityType = SecurityType.Equity
    }
  }

}

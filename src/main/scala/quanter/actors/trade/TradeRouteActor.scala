package quanter.actors.trade

import akka.actor.{Actor, ActorRef, Props}
import quanter.rest.Transaction

import scala.collection.mutable

/**
  * 1、初始化交易接口
  * 2、处理订单
  */
class TradeRouteActor extends Actor {
  var traders = new mutable.HashMap[Int, ActorRef]()
  override def receive: Receive = {
    case tran: Transaction => _handleOrder(tran)
  }

  /**
    * 初始化指定的交易接口
 *
    * @param id
    */
  private def _init(id: Int): Unit = {
    val trader = null
    val ref = context.actorOf(TradeActor.props(trader))

    traders += (id -> ref)
  }

  /**
    * 将订单发送给合适的交易通道
 *
    * @param tran
    */
  private def _handleOrder(tran: Transaction): Unit = {
    for(order <- tran.orders) {
      // TODO: 将订单保存到数据库

      traders.get(order.tradeId).get ! order
    }
  }
}

object TradeRouteActor {
  def props(): Props = {
    Props(classOf[TradeRouteActor])
  }

  val path = "tradeManager"
}

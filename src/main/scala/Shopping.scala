import scala.collection.immutable.{Map => IMap}



object Shopping {




  val data = IMap("Apple" ->  60, "Orange" -> 25)


  /**
    * checkout
    * @param items
    * @return
    */
  def checkout(items: List[String]):  Float={

    var total:Float = 0
    var atotal:Float = 0
    var ototal:Float = 0



      val applePrice = data.get("Apple").get
      val orangePrice = data.get("Orange").get


    // Apple price Offers
      if(items.contains("Apple")) {
         val apples = items.groupBy(identity).mapValues(_.size).get("Apple").get
        if(apples > 1){
          atotal = applePrice * apples / 2
        } else {
          atotal = applePrice
        }
        atotal /=100
      }

    // Orange Price Offers
      if(items.contains("Orange")) {
        val oranges = items.groupBy(identity).mapValues(_.size).get("Orange").get
         if(oranges >= 3 ){

           ototal = (oranges - (oranges /3)) * orangePrice
         }else{
           ototal = oranges * orangePrice
         }
        ototal/=100
      }

    total = atotal + ototal
    print("\nApple(s) Cost "+atotal)
    print("\nOranges(s) Cost "+ototal)
    print("\nSub Total "+total)


    return total
  }





  /**
    * Main Function
    * @param args
    */
  def main(args: Array[String]): Unit = {
      val shop = List("Orange","Orange","Orange","Apple","Apple","Orange","Orange","Orange")
      val total =  shop.map(item => {
        data.get(item).get
      }).sum.toFloat

    print("Total £"+total/100)

    val ototal = checkout(shop)



  }


}

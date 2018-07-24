import scala.collection.immutable.{Map => IMap}



object Shopping {




  val data = IMap("Apple" ->  60, "Orange" -> 25)


  /**
    * checkout
    * @param item
    * @param qty
    * @return
    */
  def checkout(items: List[String]):  Float={
   return items.map( item => {
        data.get(item).get
    }).sum.toFloat / 100

  }


  def main(args: Array[String]): Unit = {
      val shop = List("Apple","Apple","Orange","Apple")
      val total = checkout(shop);
    print("Total £"+total);
  }


}

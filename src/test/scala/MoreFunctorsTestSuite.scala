import MoreFunctors._
import cats.implicits._
import minitest._

object MoreFunctorsTestSuite extends SimpleTestSuite {
  test("printable boolean") {

    val r = showOrderConstra.show(Order(1, List("order 1", "order 2")))

    println(r)

    assertEquals(showOrderConstra.show(Order(1, List("order 1", "order 2"))), "1: [order 1, order 2]")
  }

}

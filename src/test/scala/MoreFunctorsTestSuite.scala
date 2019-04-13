import MoreFunctors.Box
import cats.implicits._
import minitest._

object MoreFunctorsTestSuite extends SimpleTestSuite {
  test("printable boolean") {
    assertEquals(MoreFunctors.format(true), "boolean:true")
  }

  test("printable double") {
    assertEquals(MoreFunctors.format(11.0), "double:11.0")
  }

  test("printable box") {
    assertEquals(MoreFunctors.format(Box("A")), "string:A")
  }
}

package notes

import MonadExample._
import cats._
import cats.implicits._
import cats.data._
import minitest._
//import notes.MonadExample._

object MonadExampleTestSuite extends SimpleTestSuite {
//  test("sumSquare") {
//    val listA: Option[Int] = Option(1)
//    val listB: Option[Int] = Option(2)
//    val r = MonadExample.sumSquare(listA, listB)
//
//    assertEquals(r, Option(5))
//
//  }
//
//  test("flatMap") {
//    val tree: Tree[String] = Branch(
//      Leaf("left"),
//      Leaf("right"),
//    )
//
//    val tree2: Tree[String] = Branch(
//      Leaf("left"),
//      Leaf("right"),
//    )
//
//    val result = tree.flatMap(v => Leaf(v + "---"))
//
//    assert(result.toString == "Branch(Leaf(left---),Leaf(right---))")
//  }
//
//  test("flatMap Int") {
//    val tree: Tree[Int] = Branch(
//      Leaf(1),
//      Leaf(200),
//    )
//
//    val branch: Tree[Int] = Branch(Leaf(4), Leaf(5))
//
//    val result2 = for {
//      v1 <- tree
//      v2 <- branch
//    } yield v1 + v2
//
//
//    println(s"result2 = $result2")
//
//    val result = tree.flatMap(v => Leaf(v * 2))
//
//    assertEquals(result.toString, "Branch(Leaf(2),Leaf(400))")
//  }
//
//  test("sumSquare Int") {
//    val input1 = List(3, 4, 5)
//    val input2 = List(1, 2)
//
//    val result = sumSquare(input1, input2)
//
//    assertEquals(result, List(10, 13, 17, 20, 26, 29))
//  }
//
//  test("sumSquare tree") {
//    val input1 = Tree.leaf(1)
//    val input2 = Tree.branch(Tree.leaf(2), Tree.leaf(3))
//
//    val result = sumSquare(input1, input2)
//
//    assert(result == Branch(Leaf(5),Leaf(10)))
//  }
//
//  test("either for") {
//    assertEquals(r4, "error occurred".asLeft)
//  }
//
//  test("countPositive Right") {
//    val input1 = List(1, 3, 5)
//    assertEquals(countPositive(input1), 3.asRight[String])
//  }
//
//  test("countPositive Left") {
//    val input1 = List(1, -3, 5)
//    assertEquals(countPositive(input1), 2.asRight[String])
//  }
//
//  test("toInt") {
//    val input1 = "1"
//    assertEquals(toInt(input1), 2)
//  }
//
//  test("toInt failure") {
//    val input1 = "a1"
//    val result = Either.catchNonFatal(toInt(input1))
//    //Either.fromTry(scala.util.Try("dfkjdfkj".toInt))
//    //Either.fromOption[String, Int](None, "This did  not work")
//
//// val theresult1 =     -1.asRight[String].ensure("Must be non-negative!")(_ > 0)
//
////    val result2 = Left("java.lang.NumberFormatException: For input string: \"a1\"")
////    assertEquals(result, Left("java.lang.NumberFormatException: For input string: \"a1\""), result2)
////
////
////    println(result, result2)
////    // Left(java.lang.NumberFormatException: For input string: "a1")
////    // Left(java.lang.NumberFormatException: For input string: "a1")
//
//  }

}

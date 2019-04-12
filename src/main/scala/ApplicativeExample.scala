import cats._
import cats.implicits._
import cats.data._

import scala.annotation.tailrec

object ApplicativeExample {

  /*
trait Semigroupal[F[_]] {
  def product[A, B](fa: F[A], fb: F[B] ): F[(A, B)]
}
   */

  val x = Semigroupal[Option].product(
    Option(1),
    Option(2)
  )

  val y = Semigroupal[Option].product(
    Option(1),
    Option(" two ")
  )

  val z = Semigroupal[Option].product(
    Option.empty[Int],
    Option(" two ")
  )

  case class Ns(a: Int, b: Int, c: Int)

  val a = Semigroupal.tuple3(Some(1), Option(null), Some("two"))
  val map2 = Semigroupal.map2(1.some, none[Int])(_ + _)

  (11.some, 2.some, 0.some).tupled
  val anNs = (11.some, 2.some, 0.some).mapN(Ns.apply)

  def f(a: Int, b: Int, c: Int): Int = {
    a + b + c
  }

  val anNs2 = (11.some, 2.some, 0.some).mapN(f)
}

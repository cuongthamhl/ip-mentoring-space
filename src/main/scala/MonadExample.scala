package notes

import cats._
import cats.implicits._
import cats.data._
import scala.annotation.tailrec

object MonadExample {

  sealed trait Tree[A] {}

  final case class Leaf[A](data: A) extends Tree[A]

  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree {
    def leaf[A](i: A): Tree[A] = Leaf(i)
    def branch[A](v1: Tree[A], v2: Tree[A]): Tree[A] = Branch(v1, v2)

  }

  val tree1: Tree[String] = Branch(
    Leaf("left"),
    Leaf("right"),
  )

  implicit val functorForTree: Functor[Tree] = new Functor[Tree] {
    def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(data)   => Leaf(f(data))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }

  implicit val monadForTree: Monad[Tree] = new Monad[Tree] {
    override def pure[A](x: A): Tree[A] = Leaf(x)

    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] =
      fa match {
        case Leaf(x)      => f(x)
        case Branch(l, r) => Branch(flatMap(l)(f), flatMap(r)(f))

      }

    //    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = {
    //      flatMap(f(a))({
    //        case Left(r) => tailRecM(r)(f)
    //        case Right(r) => pure(r)
    //      })
    //    }

    def tailRecM[A, B](arg: A)(func: A => Tree[Either[A, B]]): Tree[B] = {
      @tailrec
      def loop(
          open: List[Tree[Either[A, B]]],
          closed: List[Option[Tree[B]]]
      ): List[Tree[B]] =
        open match {
          case Branch(l, r) :: next =>
            loop(l :: r :: next, None :: closed)

          case Leaf(Left(value)) :: next =>
            loop(func(value) :: next, closed)

          case Leaf(Right(value)) :: next =>
            loop(next, Some(pure(value)) :: closed)

          case Nil =>
            closed.foldLeft(Nil: List[Tree[B]]) { (acc, maybeTree) =>
              maybeTree.map(_ :: acc).getOrElse {
                val left :: right :: tail = acc
                Branch(left, right) :: tail
              }
            }
        }

      loop(List(func(arg)), Nil).head
    }
  }

  val optionInt: Option[Int] = 1.pure[Option]
  val listInt: List[Int] = 1.pure[List]
  val treeInt: Tree[Int] = 1.pure[Tree]

  println("treeInt = ")
  println(treeInt)

  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] = {
    for {
      v1 <- a
      v2 <- b
    } yield v1 * v1 + v2 * v2
  }

//  "error..."
  val left = "error occurred".asLeft[Int]
  val right = 1.asRight[String]

  val r4 = for {
    v1 <- left
    v2 <- right
  } yield v1 + v2

  val q = Right(0)
  val r = 0.asRight[String]

  def countPositive(n: List[Int]) = n.foldLeft(0.asRight[String]) { (acc, num) =>
    if (num > 0) {
      acc.map(_ + 1)
    } else {
      acc
    }
  }

  def toInt(i: String): Int = {
      i.toInt * 2
  }

}

import cats._
import cats.implicits._

object MoreFunctors {

  // F[A] => (A => B) => F[B]     map on Covariant Functor === Functor
  // F[B] => (A => B) => F[A]     contramap on Contravariant Functor

  trait Printable[A] {
    self =>
    // A => String
    def format(value: A): String

    def contramap[B](f: B => A): Printable[B] = new Printable[B] {
      def format(value: B):String = self.format(f(value))

    }
  }
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  implicit val printableBoolean: Printable[Boolean] = new Printable[Boolean] {
    def format(value: Boolean): String = s"boolean:${value.toString}"
  }

  implicit val printableDouble: Printable[Double] = new Printable[Double] {
    def format(value: Double): String = s"double:${value.toString}"
  }

  implicit val printableString: Printable[String] = new Printable[String] {
    def format(value: String): String = s"string:${value}"
  }

  implicit def printableBox[A](implicit p: Printable[A]): Printable[Box[A]] = p.contramap[Box[A]](b => b.value)

  implicit def printableList[A](implicit p: Printable[A]): Printable[List[A]] = p.contramap[List[A]](b => b.head)

  final case class Box[A](value: A)

//  implicit def printableBox[A](implicit p: Printable[A]): Printable[Box[A]] = {
//    new Printable[Box[A]] {
//      def format(value: Box[A]): String = p.format(value.value)
//    }
//  }

}

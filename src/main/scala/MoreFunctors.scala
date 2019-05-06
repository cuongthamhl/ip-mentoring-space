import cats._
import cats.implicits._

object MoreFunctors {

  val showString = Show[String]
  val showASymbol =
    Contravariant[Show].contramap(showString)((s: Symbol) => s"'${s.name}")
  val aSymboleShown = showASymbol.show('Ticket)

  implicit val monoidSymbol: Monoid[Symbol] = Monoid[String].imap(s => Symbol(s))(_.name)

  val symbolE: Symbol = Monoid[Symbol].empty
  val combinationSymbol = 'k |+| 'a

  case class Order(id: Int, orderItems: List[String])

//  val showOrder: Show[Order] = Show[Order]
  val showOrderConstra : Show[Order]=
    Contravariant[Show].contramap(showString) { o: Order =>
      s"${o.id}: [${o.orderItems.mkString(", ")}]"
    }



  // F[A] => (A => B) => F[B]     map on Covariant Functor === Functor
  // F[B] => (A => B) => F[A]     contramap on Contravariant Functor
  // def imap[B](dec: A => B, enc: B => A): Codec[B]
  /*
    trait Invariant[F[_]] {
     def imap[A, B](fa: F[A])(f: A => B)(g: B => A): F[B]
   */

//  sealed trait Codec[A] {
//    def decode[B](input: B): A
//    def encode[B](input: A): B
//    def imap[B](dec: A => B, enc: B => A): Codec[B] = {
//      val self = this
//      new Codec[B] {
//        def decode[A](s: A): B = dec(self.decode(s))
//        def encode[A](i: B): A = self.encode(enc(i))
//      }
//    }
//  }

//  implicit val strCodec: Codec[String] = new Codec[String] {
//    def decode[String](value: String): String = value
//    def encode[String](value: String): String = value
//  }
//
//
//  implicit val intCodec: Codec[Int] = new Codec[Int] {
//    def decode[A](input: A): Int = input.toInt
//    def encode[A](input: Int): String = input.toString
//  }

//  implicit val intCodec: Codec[Int] = stringCodec.imap(_.toInt, _.toString)

//  implicit val doubleCodec: Codec[Double] =
//    stringCodec.imap(_.toDouble, _.toString)

//    new Codec[Int] {
//    def decode(input: String): Int = input.toInt
//    def encode(input: Int): String = input.toString
//  }

//  trait Printable[A] {
//    self =>
//    // A => String
//    def format(value: A): String
//
//    def contramap[B](f: B => A): Printable[B] = new Printable[B] {
//      def format(value: B): String = self.format(f(value))
//
//    }
//  }
//  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
//
//  implicit val printableBoolean: Printable[Boolean] = new Printable[Boolean] {
//    def format(value: Boolean): String = s"boolean:${value.toString}"
//  }
//
//  implicit val printableDouble: Printable[Double] = new Printable[Double] {
//    def format(value: Double): String = s"double:${value.toString}"
//  }
//
//  implicit val printableString: Printable[String] = new Printable[String] {
//    def format(value: String): String = s"string:${value}"
//  }
//
//  implicit def printableBox[A](implicit p: Printable[A]): Printable[Box[A]] =
//    p.contramap[Box[A]](b => b.value)
//
//  implicit def printableList[A](implicit p: Printable[A]): Printable[List[A]] =
//    p.contramap[List[A]](b => b.head)
//
//  final case class Box[A](value: A)
//
//  implicit def boxCodec[A](implicit codecA: Codec[A]): Codec[Box[A]] =
//    codecA.imap(
//      Box(_),
//      _.value
//    )
//  implicit def printableBox[A](implicit p: Printable[A]): Printable[Box[A]] = {
//    new Printable[Box[A]] {
//      def format(value: Box[A]): String = p.format(value.value)
//    }
//  }

}

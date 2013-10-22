/**
 * Defines a Fraction data structure that achieves 100% decimal precision by storing
 * integers as numerator and denominator and providing basic mathematical operations.
 *
 * You can create a fraction with the :/ operator. For example:
 *
 * {{{
 * (5 :/ 7) * 5
 * }}}
 */
trait Fractions {

  implicit def int2Fract( i: Int ): Fraction = Fraction( i, 1 )

  def gcd( a: Int, b: Int ): Int = if ( b == 0 ) a else gcd( b, a % b )

  case class Fraction( private val n: Int, private val d: Int ) {
    val toBigD: BigDecimal = BigDecimal( n ) / BigDecimal( d )
    val toDouble: Double = n.toDouble / d.toDouble
    val isDefined: Boolean = d != 0
    override def toString = n + " / " + d

    def reduce: Fraction = {
      val k = gcd( n, d )
      Fraction( ( n / k ), ( d / k ) )
    }

    def *( that: Fraction ): Fraction = Fraction( n * that.n, d * that.d )
    def :/( that: Fraction ) = this * Fraction( that.d, that.n )
    def +( that: Fraction ): Fraction = Fraction( n * that.d + that.n * d, d * that.d )
    def -( that: Fraction ): Fraction = this + ( -1 * that )

    def ==( that: Fraction ): Boolean = ( n * that.d ) == ( that.n * d )
    def !=( that: Fraction ): Boolean = !( this == that )
    def >( that: Fraction ): Boolean = ( n * that.d ) > ( that.n * d )
    def <( that: Fraction ): Boolean = ( n * that.d ) < ( that.n * d )
    def >=( that: Fraction ): Boolean = !( this < that )
    def <=( that: Fraction ): Boolean = !( this > that )
  }
}

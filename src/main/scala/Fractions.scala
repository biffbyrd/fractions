/**
 * Defines a Fraction data structure that achieves 100% decimal precision by storing integers as
 * numerators and denominators. It provides basic mathematical operations, comparisons, and pattern
 * matching.
 *
 * You can create a fraction with the :/ operator. For example:
 *
 * {{{
 * (5 :/ 7) * 5
 * }}}
 */
trait Fractions {

  implicit def int2Fract( i: Int ): Fraction = Fraction( i, 1 )

  private def gcd( a: Int, b: Int ): Int = if ( b == 0 ) a else gcd( b, a % b )

  case class Fraction( val n: Int, val d: Int ) {
    val toBigD: BigDecimal = BigDecimal( n ) / BigDecimal( d )
    val toDouble: Double = n.toDouble / d.toDouble
    val isDefined: Boolean = d != 0
    override def toString = n + " / " + d

    def reduce: Fraction = {
      val k = gcd( n, d )
      Fraction( ( n / k ), ( d / k ) )
    }

    def *( that: Fraction ): Fraction = Fraction( n * that.n, d * that.d ).reduce
    def :/( that: Fraction ) = this * Fraction( that.d, that.n ).reduce
    def +( that: Fraction ): Fraction = Fraction( n * that.d + that.n * d, d * that.d ).reduce
    def -( that: Fraction ): Fraction = this + ( -1 * that ).reduce

    def ==( that: Fraction ): Boolean = ( n * that.d ) == ( that.n * d )
    def !=( that: Fraction ): Boolean = !( this == that )
    def >( that: Fraction ): Boolean = ( n * that.d ) > ( that.n * d )
    def <( that: Fraction ): Boolean = ( n * that.d ) < ( that.n * d )
    def >=( that: Fraction ): Boolean = !( this < that )
    def <=( that: Fraction ): Boolean = !( this > that )
  }

  object :/ {
    def unapply( f: Fraction ) = Some( ( f.n, f.d ) )
  }
}

trait Fractions {

  implicit def int2Fract( i: Int ): Fraction = Fraction( i, 1 )

  private def gcd( a: Int, b: Int ): Int = if ( b == 0 ) a else gcd( b, a % b )

  case class Fraction( val n: Int, val d: Int ) extends Ordered[ Fraction ] {
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

    def compare( that: Fraction ): Int = ( n * that.d ) - ( that.n * d )
    def ==( that: Fraction ): Boolean = this.compare( that ) == 0
    def !=( that: Fraction ): Boolean = this.compare( that ) != 0
  }

  object :/ {
    def unapply( f: Fraction ) = Some( ( f.n, f.d ) )
  }
}

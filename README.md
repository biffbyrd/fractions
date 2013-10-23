# Fractions

Defines a Fraction data structure that achieves 100% decimal precision by storing integers for numerator and denominator and providing basic mathematical operations.

Example usage:
```scala
$ sbt console
...
scala> object fractions extends Fractions
defined module fractions

scala> import fractions._
import fractions._

scala> (7 :/ 5) * (3 :/ 13) + 12
res1: fractions.Fraction = 801 / 65

scala> val x = 5 :/ 7
x: fractions.Fraction = 5 / 7

scala> val y = (3 :/ 21)
y: fractions.Fraction = 1 / 7

scala> y < x
res2: Boolean = true

scala> y match { case 1 :/ 7 => println("yes!") }
yes!
```

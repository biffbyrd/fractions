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

scala> val x = 5 :/ 7
x: fractions.Fraction = 5 / 7

scala> val y = (7 :/ 5) * (3 :/ 13)
y: fractions.Fraction = 21 / 65

scala> val y = (21 :/ 3)
y: fractions.Fraction = 21 / 3

scala> y.reduce
res2: fractions.Fraction = 7 / 1

scala> x < y
res3: Boolean = true
```

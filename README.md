# Fractions

Defines a Fraction data structure that achieves 100% decimal precision by storing integers for numerator and denominator. It provides basic mathematical operations, comparisons, and pattern matching. It also exteds Ordered[Fraction], which allows for sorting.

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

scala> 3 :/ 7 > 7 :/ 17
res3: Boolean = true

scala> y match { case 1 :/ 7 => println("yes!") }
yes!

scala> val fs =  (3 :/ 4) :: (2 :/ 3) :: (1 :/ 2) :: Nil
fs: List[fractions.Fraction] = List(3 / 4, 2 / 3, 1 / 2)

scala> fs.sorted
res4: List[fractions.Fraction] = List(1 / 2, 2 / 3, 3 / 4)
```

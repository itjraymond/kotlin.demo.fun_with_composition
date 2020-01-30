package ca.jent.composition

import java.time.Instant
import java.time.Instant.*

/**
 * Function composition demo.
 *
 * In my own words, function composition involves 3 functions: 2 as input
 * and one as output.  I believe it is important to understand that function
 * composition is a definition artifact and not an execution one.  In other
 * word, when we execute a composed function, the execution of the code has
 * no idea that it has been composed from two other functions but instead
 * only see a single function as if it was defined on its own.
 * This is different than function application.
 *
 * see all usage in the main method below.
 */

/**
 * Let's call this function, the first input function
 * A simple integer addition
 */
fun add(a: Int, b: Int) = a + b

/**
 * Let's call this function, the second input function
 * Double the value.
 */
fun doubleIt(i: Int) = i * 2

/**
 * Let's call this function, the third (output) function.
 * Notice the type of the returned value is a function type:  (Int,Int) -> Int
 * Doubling an addition operation.
 */
fun addAndDbouleIt(a: Int, b: Int): (Int, Int) -> Int = { a, b ->
    doubleIt(add(a,b))
}

/**
 * We can also use curried functions instead.
 */
fun addAndDoubleItCurried(a: Int): (Int) -> (Int) -> Int = { a -> { b ->
    doubleIt(add(a,b))
}}

/**
 * Usage
 */
fun main() {
    // This is not function composition but function application
    // Notice that we did not create an output function but instead
    // we simply applied the output of one function as input to
    // a second function
    val value1 = doubleIt(add(3,7))

    // This is function composition: we simply use the addAsString
    // just like any other function.  In other word, addAsString
    // is a function that has been composed from add and intToString
    val value2 = addAndDbouleIt(3, 7)

    // Another way of using function composition with curried function.
    val value3 = addAndDoubleItCurried(3)(7)


}
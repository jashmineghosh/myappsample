
import io.StdIn._

object recurse {
 
 def main(args: Array[String]): Unit = {
   
   
   def sum (n:Int):Int = {
   //  println(s"doing something")
    if (n<1) 0
    else       {    
    val input = readInt()
    input + sum(n-1)
    }
  }
   def sumUntilQuit ():Int = {
         val input = readLine.toLowerCase.trim
    if (input == "quit") 0
    else       {    
        input.toInt + sumUntilQuit
    }
      
  }
   
   def sumAndCount ():(Int,Int) = {
     //println(s"something")
         val input = readLine.toLowerCase.trim
    if (input == "quit") (0,0)
   else       {    
      val (sum,count) = sumAndCount()
       (input.toInt + sum, count+1) 
              }
         }
 val (s,c) = sumAndCount()
 println(s/c.toDouble)
 
 def mulAndCount ():(Int,Int) = {
     //println(s"something")
         val input = readLine.toLowerCase.trim
    if (input == "quit") (1,0)
   else       {    
      val (prod,count) = mulAndCount()
       (input.toInt * prod, count+1) 
              }
         }
 
//abstract def for all above def 
 def anyAndCount (base:Int, op:(Int,Int)=>Int):(Int,Int) = {
     //println(s"something")
         val input = readLine.toLowerCase.trim
    if (input == "quit") (base,0)
   else       {    
      val (any,count) = anyAndCount(base,op)
       (op(input.toInt,any), count+1) 
              }
         }
 def fact(i:Int):Int = i match
 { case 0 => 1
 case _ => i*fact(i-1)
 }
 
 println(fact(5))
 
 
 def countdown (n:Int):Unit = if (n<=0) 0 else  {
      println(n)
      countdown(n-1)
 }
//writing countdown with match 
 def countdown1 (n:Int):Unit = n match {
   case 0 => 0
   case _ => println(n)
   countdown(n-1)
 }
 
 io.StdIn.readInt match {
   case 1=> println("its 1")
   case 2 =>println( "its 2")
   case n => println("something "+n)
 }
 
 def fizzbuzz (i:Int):Unit = {
  if (i<=100) 
  { (i%3,i%5) match{
    case (0,0) => println("fizzbuzz")
    case (0,_) => println("fizz")
    case (_,0) => println("buzz")
    case _ => println(i)
  } ;fizzbuzz(i+1)
  }}
 fizzbuzz(1)
 
import io.StdIn._
 def readingInt:Int = {
   try {
     readInt
   }
   catch {
     case e:NumberFormatException => 
       println("enter another value")
     readingInt
   }
 }
 val i = readingInt
 println(i)
 
 
 }
  }

import io.StdIn._
object loops {
  def main(args: Array[String]): Unit = {
    var i =0
    while (i<10){
      println(i)
      i+= 1
    }
    def readInts :List[Int]= { // example of while loop
      var input = readLine
      var lst = List[Int]()
      while(input != "quit") {
        lst =  input.toInt :: lst
       input = readLine
    }
    lst.reverse
    }
    
   println(readInts) 
  
   
  /* def printMenu: Unit = {
    println("""
    1: enter grade
    2: enter assignment
    3: quit
    """)
   }
   var input1 = 0  
   var testGrade = List[Int]()
   do {
   printMenu
   input1 = readInt
   input1 match {
     case 1 => println("enter a grade")
   //  testGrade:: = readInt1
       
     case _ => println("what")
   }
    }
  while (input1 !=3)*/
    
  //example polynomial 3*x^2 + 2*x^1 -5
   def evalPoly(coefficient:Array[Int],x:Double):Double = {
     var sum = 0.0
     var pow = 1.0
     for (c<- coefficient.reverse){ ///we can also use range capability here  for (c<- coefficient.length -1 to 0 by -1)
           sum += c*pow   // sum+ = coefficient(c)*pow
     pow = pow * x  // or pow *= x
   }
   sum
   }
   
    def evalPoly1(coefficient:Array[Int],x:Double):Double = {
     var sum = 0.0
          for (i<- coefficient.indices){ 
           sum += coefficient(i)*math.pow(x, coefficient.length-1-i)   
      
   }
   sum
   }
    
    def evalPoly2(coefficient:Array[Int],x:Double):Double = {
     
          (for (i<- coefficient.indices) yield { 
           coefficient(i)*math.pow(x, coefficient.length-1-i)   
      
   }).sum
   }
  println(evalPoly(Array(3,2,-5),2))
  println(evalPoly1(Array(3,2,-5),2))
  println(evalPoly2(Array(3,2,-5),2))
  /* yield in for loop gives us back some value hence for is no more than just statement also an expression
   * for (i <- i to 10) yield i
   * for (i <- i to 10 ; if i%2==0) yield i -- here we are using if guard
   * for(i <- i to 10; j<- i to j) yield (i,j) -- this is wroking with multiple generators
   * val Array(a,b,c) = "1,2,3".split(",").map(_.toInt) &&&& for((1,n2) <- tuples) yield n2 -- example of pattern matching
   
   * */
  
  } 
  
}
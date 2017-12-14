



object prg1 {
  def main(args: Array[String]){

  def classAvg(assign:Double*)(grade:Double*):Double = { //example of currying
      .4*grade.sum/grade.length + assign.sum/assign.length
      }
  classAvg(30.0,20,10)(50.0,60)
    def add (x:Int):Int=>Int = y=> x+y // syntax for currying
    add(5)(6)
    //alternate syntax is below
     def add2 (x:Int)(y:Int):Int =  x+y
     val plus = add2(5)_
     plus(6)
    add2{4}{5}
     add2(5)(7)
     
   /* example of currying where i want to pass a code block as argument
    * add2{
     | println("hi")
     | 4}{
     | println("u")
     | 6}  
    */
   /* example of call by name
    * def thrice (x: =>Int):Int =  x*x*x , the syntax x: => is for call by name, fill is an interesting example of call by name when we use it with math.random, as it gets so many random numbers each time it is called
    * var a = 0
    *  thrice{a += 1; a} , this returns 6, the func thrice is called 3 times, hence a gets bigger, first its 1, then 2 , then 3 , result is 1*2*3
    *   
    */
  }
  }
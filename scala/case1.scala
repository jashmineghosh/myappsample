
import io.StdIn._

object case1 {
  def main(args: Array[String]): Unit = {
    case class Student(name:String , grade:List[Int], assign:Array[Int])
    
    case class point3d(x:Double, y:Double)
    
    def distance(a:point3d,b:point3d) = {
    val  d1 = a.x-b.x
    val d2 = a.y+b.y
    println(d1,d2)
      math.sqrt(d1*d1+d2*d2)
     
    }
    
    def classAvg(s:Student):Double = {
      .4*s.grade.sum/s.grade.length + s.assign.sum/s.assign.length
    }
    
   //val stu = Student("jas",List(90,70),Array(50,60)) 
    //classAvg(stu)
    // or i could condense the statements above as -> classAvg(Student("jas",List(90,70),Array(50,60)) )
    // using copy in case class-  stu.copy(name = "jas1"); stu.copy(grade = 10::stu.grade);val p1 = point3d(1,2);p1.copy(x= p1.x-1)
    //pattern matching in case class---for (point3d(a,b) <- p1) yield (a*a+b*b)
    //make case class mutable by prefixing var to the variable
    
    def evalQuad(a:Double=0, b:Double, c:Double,x:Double=2):Double = {   //example of default and named arguments
      a*x*x +b*x + c
    }
    
   val c1 = List (1,2,3)
   val c2 = "a b c".split(" ")
    c1.zip(c2).map(t=> t._2*t._1)//here i have the overhead of creating another collection and running a map on that new collection with names like t._1...
    (c1,c2).zipped
      (c1,c2).zipped.map((cnt,str) => str*cnt)  //more efficient i have not created new collections
   
  }
}
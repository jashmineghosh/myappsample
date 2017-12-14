

object array_list {
  def main(args: Array[String]): Unit = {
    def repeat(arr:Array[Int],v:Int,i:Int):Unit= {
    if (arr.length>i){
      arr(i) = v
      repeat(arr,v,i+1)

    }
    }
    def operateArray(arr:Array[Int],i:Int,f:(Int,Int)=>Int):Int= {
    if (arr.length-1>i){
      f(arr(i),operateArray(arr,i+1,f))

    }
    else arr(i)
    }

  import io.StdIn._
  def inputlst(n:Int):List[Int] = {
    if (n<1) Nil
    else
      readInt :: inputlst(n-1)
      }

  def operateList(lst:List[Int],base:Int,f:(Int,Int)=>Int):Int= {
    if (lst == Nil) base
    else f(lst.head,operateList(lst.tail,base,f))

           }

   def operateListmatch(lst:List[Int],base:Int,f:(Int,Int)=>Int):Int=
     lst match {
     case Nil => base
     case h :: t => f(h, operateListmatch(t,base,f))
     }
  /// fills up list with random numbers
   def fillList(n:Int,v:Double):List[Double]= {
    if (n<1) Nil
    else v:: fillList(n-1,v)
  }

  /*collection methods on array/list like drop,splitAt,take,sropRight,takeRight,last,slice,init

  boolean collection methods on array/list like contains,startsWith, endsWith, isEmpty,nonEmpty,indexOf,
  lastIndexOf, indexOf(1,5)--here we saying to look for item 1 after position/index 5
  other collection methods diff(a.diff(Array(1,2.3))),distinct,mkString,patch(2,Nil,3)--so it starts with position 2 and ends after 3 position
  reverse,toList,toArray,zip,zipWithIndex, sum, min, product,max,length

  * higher order function-> map,filter,dropWhile(_<6)--drops everything before where 6 occurs, count, filterNot, exists,forall, indexWhere(it takes function)
  *partition-- it divides the array based on the predicate, like 2 arrays with even and odd
  * takeWhile(predicate)--it gives back everything from the beginning till it satisfies the predicate
  * reduce,a.foldLeft(0)(_+_)--so foldRight/Left is like fill which is also currying function, left and right is for direction from where it starts taking elements
  *some iterator methods--> a.combinations(3).foreach(a=> println(a.mkString(",")))
  * a.inits.foreach(a=> println(a.mkString(","))) -- keeps returning an array while leaving the last element in array
  * sliding--leaving the first element, there is an overlap of other elements; permutations;tails--just like inits except it rip off element from start
  *  string is also collection, hence some operation like str.count(c=> "aeio".contains(c))--counts the times vowel appear in string
  *  str.split(" "),
  *  (Array(10,5,2).indices).foreach(println)
  *  (1 to 100 by 10).foreach(println) ;
  *  scala> (100 to 1 by -10).foreach(println)
100
90
80
multi dimentional array->  Array.fill(2,3)(0) {2 arrays with 3 elements each}
 Array.tabulate(2,3)((i,j)=> i*j) gives  res28: Array[Array[Int]] = Array(Array(0, 0, 0), Array(0, 1, 2))**/
/*option type example
  *  */
  val lst = List(1,2,3,4,5,6)
  lst.find(_>3).map(_*2)
  lst.find(_>6)
  lst.find(_>6).getOrElse(0)// instead of returning none as result i return 0
  lst.find(_>6) match {
    case Some(n) => n*5
    case None => 0
  }
  /* variable length argument example**/
  def average(n:Double*):Double = if( n.length>0) return n.sum/n.length else 0 //to pass a val which is list as argumrnt, use average(lst:_*)
  def averageList(n:List[Double]):Double = if( n.length>0) return n.sum/n.length else 0 // this will take list as argument, like  averageList(List(2.0,3,4))

  val troa = Array(Array(1,2,3),Array(4,5,6)) //to get 5 type troa(1)(1)
  val filla = Array.fill(2,1)(1) // creates 2 arrays with 1 element containing value 1
  val taba = Array.tabulate(2,3)((x,y)=>x+y) // res is Array[Array[Int]] = Array(Array(0, 1, 2), Array(1, 2, 3)), accessed as taba(0)(1)

  def fact (n:Int):Int = {if (n<2) 1 else n*fact(n-1)}
  //types of error syntax errors, run time and logical

  }

}

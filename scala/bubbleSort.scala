import sun.security.util.Length
import scala.annotation.tailrec


object bubbleSort {
  def main(args: Array[String]): Unit = {
 
   def bubblesort(a:Array[Double]):Unit = {
     for (i <- 0 until a.length-1){
       for (j <- 0 until a.length-1-i){
         if(a(j) > a(j+1)){
           val tmp = a(j)
           a(j) = a(j+1)
           a(j+1) = tmp
       }
         }
     }
     
   }
    case class Student (lname:String, fname:String, avg:Double)
  def bubblesortStu(a:Array[Student], gt:(Student,Student) => Boolean):Unit = {
     for (i <- 0 until a.length-1){
       for (j <- 0 until a.length-1-i){
         if(gt(a(j), a(j+1))){
           val tmp = a(j)
           a(j) = a(j+1)
           a(j+1) = tmp
       }
         }
     }
     
   }  
   //val studs = Array(Student("bin", "al", 90), Student("app", "din", 80))
    //bubblesortStu(studs, _.lname < _.lname)
    //studs -- will give the sorted answer
    
    val arr = Array.fill(10)(math.random())
    bubblesort(arr)
    val arr1 = arr.mkString(",")
    println(arr1)
    
    def selectionsort(a:Array[Double]):Unit = {
     for (i <- 0 until a.length-1){
       var min = i
       for (j <- i+1 until a.length){
         if(a(min) > a(j)) min = j
       }  
         val tmp = a(i)
           a(i) = a(min)
           a(min) = tmp
       
        
     }
     
   }
   val arrS = Array.fill(10)(math.random())
    selectionsort(arrS)
    val arrS1 = arrS.mkString(",")
    println(arrS1) 
    
   def insertionsort(a:Array[Double]):Unit = {
     for (i <- 1 until a.length){
       var j = i-1
       val tmp = a(i)
       while (j <=0 && tmp < a(j)){
         a(j+1) = a(j)
         j -= 1
       }  
         a(j+1) = tmp
       
        
     }
     
   } 
   
    val arrI = Array.fill(10)(math.random())
    selectionsort(arrI)
    val arrI1 = arrI.mkString(",")
    println(arrI1)
    
    // in order to test an array is sorted or not , the forall returns a boolean
    val a1 = Array(5,6,4,0)
    a1.zip(a1.tail).forall(t => t._1 <= t._2)
  
    //below code to work with insertion sort on List
   def insertionSortList(lst:List[Double]):List[Double] = {
      def insert(x:Double, sorted:List[Double]):List[Double] = sorted match {
        case Nil => x::Nil
        case h::t => if(x<h) x::sorted else h::insert(x,t)
            
      }
     def helper (sorted:List[Double], unsorted:List[Double]) : List[Double] = unsorted match {
       case Nil => sorted
       case h::t => helper(insert(h,sorted), t)
     }
    
     helper(Nil,lst) 
    }
   
    def bucketSort(a:Array[Double]):Unit = {
      val min = a.min
      val max = a.max
      val buckets = Array.fill(a.length)(List[Double]())
      for (x<- a){
        val b = ((x-min)*(buckets.length-1)/(max-min)).toInt //converted to Int as we are inserting into List
        buckets(b)::= x
      }
      var i = 0
      for(bucket<- buckets; x <- bucket){
       
        a(i)= x
       i +=1
      }
      insertionsort(a)
    }
    //an alternate way to write bucketsort algorithm
    def bucketSort1(a:Array[Double]):Unit = {
      val min = a.min
      val max = a.max
      val buckets = Array.fill(a.length)(List[Double]())
      for (x<- a){
        def insert(x:Double, sorted:List[Double]):List[Double] = sorted match {
        case Nil => x::Nil
        case h::t => if(x<h) x::sorted else h::insert(x,t)
            
      }
        }
        var i = 0
      for(bucket<- buckets; x <- bucket){
       
        a(i)= x
       i +=1
      }
      }
    
    //performance of various sort methods
    def timeFunc(sortFunc:Array[Double]=>Unit, a:Array[Double]):Double = {
      val copy= a.map(x=>x)
      val start = System.nanoTime()
      sortFunc(copy)
      val end = System.nanoTime()
      (end-start)/1e9
     
    }
    val arr2 = Array.fill(1000)(math.random)
     println("bubblesort " +timeFunc(bubblesort,arr2))
       println("bucketsort1 " +timeFunc(bucketSort1,arr2))
       println("selectionsort " +timeFunc(selectionsort,arr2))
  //tower of hanoi
       //val pegs = Array((1 to args(0).toInt).toList, Nil , Nil)
  //for(x <- pegs) println(x)
     val pegs = Array((1 to 5).toList, Nil , Nil)
      def moveOneDisk(from:Int, to:Int):Unit = {
      require(pegs(to).isEmpty || pegs(to).head > pegs(from).head)
        pegs(to)::= pegs(from).head
       pegs(from) = pegs(from).tail 
    }
     def moveDisks(from:Int, to:Int,n:Int):Unit = {
       if(n==1) moveOneDisk(from, to)
       else{
         val other = 3-from-to // 3here, as pegs are totally 3 in count
         moveDisks(from, other, n-1)
         moveOneDisk(from,to)
         moveDisks(other, to, n-1)
       }
     }
     for(x <- pegs) println(x) // before func call
     println()
   moveDisks(0,1, pegs(0).length) // after func call
  
 for(x <- pegs) println(x)
 
 //merge sort
// def merge(l1:List[Double], l2:List[Double]):List[Double]= (l1,l2) match
// { 
//   case (Nil, _) =>l2
//   case (_,Nil) => l1
//   case (h1::t1, h2::t2) => 
//     if(h1 < h2) h1::merge(t1,l2)
//     else h2::merge(l1,t2)
// }
// def mergeSort(lst:List[Double]):List[Double] = lst match
// {
//   case Nil=> lst  
//   case h::Nil => lst
//   case _ => 
//     val (l1,l2) = lst.splitAt(lst.length/2)
//   merge(mergeSort(l1),mergeSort(l2))
// }
// //mergeSort(List.fill(10)(math.random)).foreach(println)
 
 //merge sort with tail recursion
 @tailrec
 def merge(l1:List[Double], l2:List[Double],lst:List[Double]):List[Double]= (l1,l2) match
 { 
   case (Nil, _) =>lst.reverse:::l2
   case (_,Nil) => lst.reverse:::l1
   case (h1::t1, h2::t2) => 
     if(h1 < h2) merge(t1,l2,h1::lst)
     else merge(l1,t2,h2::lst)
 }
 def mergeSort(lst:List[Double]):List[Double] = lst match
 {
   case Nil=> lst  
   case h::Nil => lst
   case _ => 
     val (l1,l2) = lst.splitAt(lst.length/2)
   merge(mergeSort(l1),mergeSort(l2),Nil)
 }
 //mergeSort(List.fill(10)(math.random)).foreach(println)
 //quick sort
 def quicksort(lst:List[Double]):List[Double]=  lst match {
 
   case Nil => lst
   case h::Nil => lst
   case pivot::t =>
     val (less,greater) = t.partition(_<pivot)
     quicksort(less) ::: pivot::quicksort(greater)
     }
  quicksort(List.fill(10)(math.random)).foreach(println)
  }
}
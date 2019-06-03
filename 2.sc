import scala.collection.mutable

def lastStoneWeight(stones: Array[Int]): Int = {


  val pq: mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty[Int]
  stones.map( pq.enqueue(_))

  //println(pq.mkString(" ") + "\n")

  while (pq.size > 2) {
    val y = pq.dequeue()
    println("y is " + y)

    val x = pq.dequeue()
    println("x is " + x)

    if ( x != y ) {
      pq.enqueue(y - x)
    }

  }

  if (pq.size == 1) {
    pq.dequeue()
  } else {
    0
  }
}

def rotatedDigits(N: Int): Int = {
  // make a list from 1 to N
  // run rotate on each, and add them up
  val myList = List.range(1, N+1)
  myList.filter { num =>
    val str = num.toString

    // println(str)

    val onlyContains018 = str.forall( chara => chara == '1' ||
      chara == '8' ||
      chara == '0')

    // println(onlyContains018)

    str.forall( chara => chara != '3' &&
      chara != '4' &&
      chara != '7')  && !onlyContains018
  }.size
}

//val t: Array[Int] = Array(2, 7, 4, 1, 8, 1)

//println(lastStoneWeight(t))
rotatedDigits(10)
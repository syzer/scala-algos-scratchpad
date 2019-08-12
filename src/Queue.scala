// Useages
// Class approach
class MyQueue(maxSize: Int) {
  private var queueBox: Array[Any] = new Array[Any](maxSize)
  private var front: Int = 0
  private var rear: Int = -1
  private var numOfItems: Int = 0

  def insert(data: Any): Unit = {
    if (rear == maxSize - 1) {
      rear = -1
    }
    rear += 1
    queueBox(rear) = data
    numOfItems += 1
  }

  def remove(): Any = {
    val tempData: Any = queueBox(front)
    front += 1
    if (front == maxSize) {
      front = 0
    }
    numOfItems -= 1
    tempData
  }

  def peekFront(): Any = {
    queueBox(front)
  }

  def peekSecond(): Any = {
    queueBox(front + 1)
  }

  def isEmpty(): Boolean = {
    numOfItems == 0
  }

  def isFull(): Boolean = {
    numOfItems == maxSize
  }
}

object QueueApp {
  def main(args: Array[String]): Unit = {

    val myQueue = new MyQueue(10)
    myQueue.insert(1)
    myQueue.insert(2)
    myQueue.insert(3)

    while (!myQueue.isEmpty()) {
      println(myQueue.remove())
    }

    val myQueue2 = new MyQueue(10)
    myQueue2.insert(1)
    myQueue2.insert(2)
    myQueue2.insert(3)
    println("6.2 excercise:", myQueue2.peekSecond())
  }
}

case class FQueue(out: List[Int], in: List[Int]) {
  def check(): Boolean = (out, in) match {
    case (Nil, x :: xs) => false
    case _ => true
  }

  require(check, "Didn’t satisfy invariant")
}

// case class that represent real world
object FunctQueueApp {
  def main(args: Array[String]): Unit = {
    val myQueue = insert(15, insert(10, insert(5,
      FQueue(Nil, Nil))))
    println(remove(myQueue))
  }

  def insert(data: Int, queue: FQueue): FQueue = {
    val newIn = data :: queue.in
    queue.out match {
      case Nil => FQueue(newIn.reverse, Nil)
      case _ => queue.copy(in = newIn)
    }
  }

  def remove(queue: FQueue): (Int, FQueue) = {
    queue.out match {
      case Nil => throw new
          IllegalArgumentException("Queue is empty!")
      case x :: Nil => (x, queue.copy(out =
        queue.in.reverse, Nil))
      case y :: ys => (y, queue.copy(out = ys))
    }
  }
}

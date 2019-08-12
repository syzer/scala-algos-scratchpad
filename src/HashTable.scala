// when not enough space to accomodate value
// hash value => put as key
// O(1) time for search, insert, delete
// O(n) worst case! ex: fucked up hash algo that gives `42` as hash for all cases
// hash needs to be colision free and fast
// ex: take reminder value(tohash) % no of elems in hash table

// ex: lookups (like FS, dicts, hash for passwords, search apps, dropbox)

trait HashTable[Key, Value] {
  def insert(myKey: Key, myValue: Value)

  def search(myKey: Key): Option[Value]

  def delete(myKey: Key): Option[Value]
}

// multiplication method: hash(key) = elems * ((key * const) % 1)
class HashTableMutableImpl[Key, Value](size: Int) extends HashTable[Key, Value] {
  private val myHashArray = Array.fill(size)(List[(Key,
    Value)]())

  def hashCode[Key](myKey: Key) = {
    val tempHashCode = myKey.## % size
    if (tempHashCode < 0) tempHashCode + size else
      tempHashCode
  }

  override def insert(myKey: Key, myValue: Value): Unit = {
    val myList = myHashArray(hashCode(myKey))
    myHashArray(hashCode(myKey)) = (
      myKey, myValue) +: myList.filter(x => x._1 != myKey)
  }

  override def search(myKey: Key): Option[Value] = {
    val myList = myHashArray(hashCode(myKey))
    myList.find(x => x._1 == myKey).map(y => y._2)
  }

  override def delete(myKey: Key): Option[Value] = {
    val myList = myHashArray(hashCode(myKey))
    myHashArray(hashCode(myKey)) = myList
      .filter(x => x._1 != myKey)
    myList
      .find(x => x._1 == myKey)
      .map(y => y._2)
  }
}

//object HashTableMutableApp {
//  def main(args: Array[String]): Unit = {
//    val myHashTable: HashTable[Int, String] =
//      new HashTableMutableImpl[Int, String](17)
//
//    myHashTable.insert(123456789, "Martin")
//    myHashTable.insert(987654321, "James")
//    myHashTable.insert(123454321, "Testa")
//    myHashTable.insert(432112345, "Chuck")
//    myHashTable.insert(776612345, "Noris")
//
//    println(s" Martin search, ${
//      myHashTable.search(123456789)
//    }")
//
//    println(s"James search, ${myHashTable.search(987654321)}")
//
//    println(s"Brian search, ${myHashTable.search(123454321)}")
//    println(s"Einstein search ${myHashTable.search(432112345)}")
//    println(s"Richie search, ${myHashTable.search(776612345)}")
//    println(s"Richie delete, ${myHashTable.delete(776612345)}")
//    println(s"Non-existing delete, ${
//      myHashTable.delete(886612345)
//    }")
//    println(s"Richie search, ${
//      myHashTable.search(776612345)
//    }")
//  }
//}

trait HashTable2[Key, Value] {
  def insert(myKey: Key, myValue: Value): HashTable2[Key, Value]

  def search(myKey: Key): Option[Value]

  def delete(myKey: Key): HashTable2[Key, Value]
}

// immutable version
// better concurency... vector uses Trie so it will remove some duplicates
protected class HashTableImmutableImpl[Key, Value](myHashVector: Vector[List[(Key, Value)]]) extends HashTable2[Key, Value] {
  private val size = myHashVector.size

  def hashCode[Key](myKey: Key) = {
    val tempHashCode = myKey.## % size
    if (tempHashCode < 0) tempHashCode + size else
      tempHashCode
  }

  override def insert(myKey: Key, myValue: Value) = {
    val insertionIndex = hashCode(myKey)
    val insertionList = myHashVector(insertionIndex)
    val newList = (myKey, myValue) +: insertionList
      .filter(_._1 != myKey)
    new HashTableImmutableImpl[Key, Value](myHashVector
      .updated(insertionIndex, newList))
  }

  override def search(myKey: Key): Option[Value] = {
    val myList = myHashVector(hashCode(myKey))
    myList.find(x => x._1 == myKey).map(y => y._2)
  }

  override def delete(myKey: Key) = {
    val deletionIndex = hashCode(myKey)
    val deletionList = myHashVector(deletionIndex)
    val newList = deletionList.filter(_._1 != myKey)
    new HashTableImmutableImpl[Key, Value](myHashVector.updated(deletionIndex, newList))
  }
}

object HashTableImmutableImpl {
  def apply[Key, Value](size: Int) = {
    val myHashVector = Vector.fill(size)(List())
    new HashTableImmutableImpl[Key, Value](myHashVector)
  }
}

// better concurrency, slower on single core
object HashTableImmutableApp {
  def main2(args: Array[String]): Unit = {
    val myHashTable: HashTable2[Int, String] = HashTableImmutableImpl(17)
    val data = myHashTable.insert(123456789, "Martin")
      .insert(987654321, "James")
      .insert(123454321, "Brian")
      .insert(432112345, "Einstein")
      .insert(776612345, "Richie")

    println(s" Martin search, ${data.search(123456789)}")
    println(s"James search, ${data.search(987654321)}")
    println(s"Brian search, ${data.search(123454321)}")
    println(s"Einstein search ${data.search(432112345)}")
    println(s"Richie search, ${data.search(776612345)}")
    val removedRichie = data.delete(776612345)
    val nonExisting = data.delete(886612345)
    println(s"Richie search, ${removedRichie.search(776612345)}")
    println(s"Non-existing search, ${nonExisting.search(886612345)}")
    println(s"Richie search in original, ${data.search(776612345)}")
  }
}

HashTableImmutableApp.main2(Array("dadas"))

package collections

import kotlin.jvm.internal.Intrinsics

fun printCollection(list: Collection<String>) {
	for(i in list) {
		print("$i ")
	}
	println()
}

fun main() {
	val collection = listOf("one", "three", "four", "five", "two", "one")
	printCollection(collection)
	// list predefined functions
	println("find the element of: ${collection.indexOf("five")}")

	val sets = setOf("one", "three", "four", "five", "two", "one")
	printCollection((sets))

	// Maps
	val maps = mapOf("one" to 1, "two" to 2, "three" to 3)
	for ((k, v) in maps) {
		println("$k ==>  $v")
	}

	// construction from list
	val presizedSet = HashSet<Int>(2)
	presizedSet.add(3)
	presizedSet.add(4)
	println(presizedSet)

	// Copying the list
	val sourceList = mutableListOf(1, 2, 3, 4)
	val referenceList = sourceList
	val copyList = sourceList.toMutableList()
	val readList = sourceList.toList()
	sourceList.add(5)

	println("size:: source list:: ${sourceList.size}:: copy list:: ${copyList.size}::: readList::: ${readList.size}::: referece list:: ${referenceList.size}")


	// Filters & mappings
	println(sourceList.filter{it > 3})
	println(sourceList.map{ it * 3})

	//	loop through iterators
	val ite = sourceList.iterator()
	while(ite.hasNext()) {
		print("${ ite.next() } ")
	}

	// list iterator for both forward and backward
	val listIterators = sourceList.listIterator()
	println("forward")
	while(listIterators.hasNext()) {
		print("${listIterators.next()} ")
	}

	println("backwards")
	while(listIterators.hasPrevious()) {
		print("${listIterators.previous()} ")
	}
	println()

	// ranges
	for (i in 2 downTo  -1) print(i)
	// sequence - useful when there are sequnce of operations
	// which can reduce the no.of steps which are required.
	val seqElements = sourceList.asSequence()
	seqElements.map{ print(it)}
}

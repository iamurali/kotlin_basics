package classes

fun lambdaFunctions(items: List<Int>) {
	//	====> Value of the last expression is implicit return in lambda
	items.fold(0, {
		acc: Int, i: Int ->
		val result = acc + i
		println("acc: $acc, result: $result, I value: $i")
		result
	})
}

fun makeString(items: List<Int>) {
	val result = items.fold("Elements", {
		acc, i -> acc + " " + i
	})
	println(result)
}

// ===> Closures

fun closures() {
	var sum = 0
	val items = listOf(1, 2, 3, 4, -5, -4, -3)
	items.filter{ it > 0}.forEach{ sum += it }
	println("Items in the sum of +ve numbers::: $sum")
}

// anonymous functions

val stringPlus: (String, String) -> String = String::plus
val intPlus: Int.(Int) -> Int = Int::plus

fun main() {
	val items = listOf(1, 2, 3, 4, 5)
	lambdaFunctions(items)
	makeString(items)
	val result = items.fold(1, Int::times)
	println("Items:: $result")
	println(stringPlus("hai", "murali"))
	println(intPlus(1 , 3))
	closures()
}

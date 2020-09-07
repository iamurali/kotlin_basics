package classes

class FunctionVariaents {
	fun namedArguments(str: String, isBooleanParam: Boolean = true, ) {
		println("parameters:: $str, boolean: $isBooleanParam")
	}

	// function with lambda expressions
	fun funWithLambda(str: String, lam: () -> Unit ) {
		println("Function with lamda expression: $str")
		lam()
	}

	// variable no.of arguments
	fun <T> funcWithArgs(vararg args: T): List<T> {
		val result = ArrayList<T>()
		for (t in args) {
			result.add(t)
		}
		return result
	}
}

fun main() {
	// ===> Optional argument take default value and pass named arguments
	val obj = FunctionVariaents()
	obj.namedArguments("test")
	obj.namedArguments("test", false)
	obj.namedArguments(
		str = "testing params",
		isBooleanParam = true
	)

	obj.funWithLambda("test", { println("EOL") })
	val result1 = obj.funcWithArgs(1, 2, 3, 4)
	println(result1)

	val a = arrayOf(3, 4, 5)
	val result2 = obj.funcWithArgs(1, 2, *a, 4)
	println(result2)
}

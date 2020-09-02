package classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class IntArthemetics: BinaryOperator<Int>, IntBinaryOperator {
	PLUS {
		override fun apply(t: Int, u: Int): Int {
			return t + u
		}
	},
	TIMES {
		override fun apply(t: Int, u: Int): Int {
			return t * u
		}
	};

	override fun applyAsInt(left: Int, right: Int): Int {
		return apply(left, right)
	}
}

fun main() {
	val a = 10
	val b = 20
	println(IntArthemetics.values())
	for(f in IntArthemetics.values()) {
		println("Invoke function: $f ==> ${f.apply(a, b)}")
	}

	println(IntArthemetics.valueOf("PLUS"))
}

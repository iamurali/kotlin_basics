package controlflow

// when flow

fun  whenStatement(x: Int) {
	when (x) {
		1 -> println("x==1")
		2 -> println("x==2")
		else -> {
			println("x is neither 1 or 2")
		}
	}
}

fun whenConditionCombined(x: Int) {
	when(x) {
		0,1 -> println("x is either 0 or 1")
		else -> {
			println("x is other than ")
		}
	}
}

fun whenWithRange(x: Int) {
	when(x) {
		in 1..10 -> println("in the range of 1 to 10")
		!in 1..10 -> println("not in the range of 1 to 10")
	}
}


fun main(args: Array<String>) {
	whenStatement(1)
	whenStatement(3)
	whenConditionCombined(1)
	whenConditionCombined(3)
	whenWithRange(22)
	whenWithRange(2)
}

// Output::
// x==1
// x is neither 1 or 2
// x is either 0 or 1
// x is other than
// not in the range of 1 to 10in the range of 1 to 10



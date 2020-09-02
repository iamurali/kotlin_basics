package controlflow

fun breaks() {
	loop1@ for (i in 1..5) {
		loop2@ for (j in 1..5) {
			if (i > 3 ) {
				break@loop1
			}
			else if (j % 3 == 0 ) {
				break@loop2
			} else {
				println(j)
			}
		}
	}
}

fun returnStatements() {
	listOf(1, 2, 3, 4).forEach{
		if (it == 3)
			return;
		println(it)
	}
	println("this point is unreachable")
}

fun returnStatementWithLabel() {
	listOf(1, 2, 3, 4).forEach{
		if (it == 3)
			return@forEach;
		println(it)
	}
	println("this is reachable statement with label")
}

fun main() {
	breaks()	
	returnStatements()
	returnStatementWithLabel()
}

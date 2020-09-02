package classes

class A {
	class AInner {
		fun demo() {
			println("A inner class")
		}
	}
}

class B {
	class BInner {
		fun demo() {
			println("B inner class")
		}
	}
}

public typealias  AInner = A.AInner
public typealias  BInner = B.BInner

fun main() {
	AInner().demo()
	BInner().demo()
}

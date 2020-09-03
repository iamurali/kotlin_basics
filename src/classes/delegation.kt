package classes

interface DelegationB {
	fun printMessage()
	fun printer()
}

class DelegationBase(val i: Int) : DelegationB {
	override fun printMessage() {
		println("base class delegation:: $i")
	}

	override fun printer() {
		println("print override message $i")
	}
}

class DelegationDerivedClass(b: DelegationB): DelegationB by b {
	override fun printer() {
		println("derived class info")
	}
}


fun main() {
	val t = DelegationBase(10)
	DelegationDerivedClass(t).printMessage()
	DelegationDerivedClass(t).printer()
}

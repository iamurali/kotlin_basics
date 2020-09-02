package classes

import java.time.LocalDate
import java.util.*

// visibility settings in a class

open class Outer {
	private  val a = 1
	protected open val b = 2
	val c = 3

	protected  class Nested {
		public val e: Int = 5
	}
}


class Subclass : Outer() {
	// a is not visible
	// b is visible
	// c is visible as public by default

	override val b = 5

	fun present() {
		println(b)
		println(c)
	}
}

class IndependentKlass(oc : Outer) {
	// oc.a is not accessible
	// oc.b is not accessible as it's protected class and accessed by only class and its subclasses
	// c is visible as it's a public class
	val oc = oc;

	fun present() {
		println(oc.c)
	//	println(oc.b) // this will raise error
	}
}


// Extension of a class function

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
	val tmp = this[index1] // this corresponds to list
	this[index1] = this[index2]
	this[index2] = tmp
}

fun Any?.toString(): String {
	if (this == null) return ""
	return toString()
}


// Extensions as members
class Host(val hostName: String) {
	fun printHostName() {
		println(hostName)
	}
}

class Connection(val host: Host, val port: Int) {
	fun Host.printConnectionDetails() {
		printHostName()
		println("*****")
		println(port)
	}

	fun connect() {
		println("start")
		host.printConnectionDetails()
		println("end")
	}
}

// Extensions which are declared as open can be overriden in subclasses

open class Base { }
class Derieved: Base() { }

open class BaseCaller {
	open fun Base.printFunction() {
		println("Base extension in base caller")
	}

	open fun Derieved.printFunction() {
		println("Derieved extesion in base caller")
	}

	fun call(b: (Base)) {
		b.printFunction()
	}
}

class DerievedCaller: BaseCaller() {
	override fun Base.printFunction() {
		println("Base extension function in derieved caller")
	}

	override  fun Derieved.printFunction() {
		println("Derieved extension function in print function")
	}

}

// Data classes
data class User(val name: String, val dob: LocalDate)


// sealed classes
sealed class Expr
data class Const(val number: Int) : Expr()
data class Sum(val e1: Expr, val e2: Expr): Expr()
object  NotANumber : Expr()

fun main() {
	// visibility settings
	val oc = Outer()
	val obj = IndependentKlass(oc)
	obj.present()
	val sc = Subclass()
	sc.present()

	// Extension functions
	val list = mutableListOf(1, 3, 4, 2)
	list.swap(1, 3)
	println(list)

	// Extension as members
	Connection(Host("kotlin-demo"), 9000).connect()

	// Extension as open members
	BaseCaller().call(Base())   // "Base extension function in BaseCaller"
	DerievedCaller().call(Base())  // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
	DerievedCaller().call(Derieved())  // "Base extension function in DerivedCaller" - extension receiver is resolved statically
	val (name, dob) = User("murali", LocalDate.parse("1993-09-29"))
	println("Name: $name, dob: $dob ")
}

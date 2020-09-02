package classes

import javax.xml.crypto.Data

// Example of object which will be used as singleton in kotlin

object DataManager {
	var dataProviders = mutableListOf<String>()
	fun registerDataProvider(name: String) {
		dataProviders.add(name)
	}

	fun deregisterDataProvider(name: String) {
		dataProviders.remove(name)
		println("removed $name data provider")
	}

	fun allDataProviders() {
		for (provider in dataProviders) {
			println(provider)
		}
	}
}


fun main() {
	DataManager.registerDataProvider("Postgres")
	DataManager.registerDataProvider("MySql")
	DataManager.allDataProviders()
	DataManager.deregisterDataProvider("MySql")
	DataManager.allDataProviders()
}

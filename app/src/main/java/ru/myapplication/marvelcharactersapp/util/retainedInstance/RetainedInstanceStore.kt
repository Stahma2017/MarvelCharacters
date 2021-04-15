package ru.myapplication.marvelcharactersapp.util.retainedInstance

import ru.myapplication.marvelcharactersapp.util.retainedInstance.exeptions.InstanceNotFoundException

class RetainedInstanceStore<T> {
    private val instances = mutableMapOf<String, T>()

    fun isExist(key: String): Boolean = instances.containsKey(key)
    fun add(key: String, component: T) {
        instances[key] = component
    }
    fun get(key: String): T = instances[key] ?: throw InstanceNotFoundException()
    fun remove(key: String) {
        instances.remove(key)
    }
}
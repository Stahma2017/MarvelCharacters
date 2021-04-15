package ru.myapplication.marvelcharactersapp.util.retainedInstance

interface IHasRetainedInstance<T> {
    fun createRetainedInstance(): T
}
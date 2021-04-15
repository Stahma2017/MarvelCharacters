package ru.myapplication.marvelcharactersapp.navigation.coordinator

interface Coordinator {
    fun consumeEvent(event: CoordinatorEvent)
}
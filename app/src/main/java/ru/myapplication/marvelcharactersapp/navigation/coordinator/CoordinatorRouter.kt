package ru.myapplication.marvelcharactersapp.navigation.coordinator

interface CoordinatorRouter {
    fun sendEvent(event: CoordinatorEvent)
}
package ru.myapplication.marvelcharactersapp.navigation

import ru.myapplication.marvelcharactersapp.navigation.coordinator.CoordinatorRouter

interface ParentRouterProvider {
    fun getParentRouter(): CoordinatorRouter
}
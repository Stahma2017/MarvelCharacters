package ru.myapplication.marvelcharactersapp.navigation

import ru.terrakok.cicerone.Router

interface NavigationRouterProvider {
    fun getNavigationRouter(): Router
}
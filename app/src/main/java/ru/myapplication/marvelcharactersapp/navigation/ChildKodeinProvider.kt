package ru.myapplication.marvelcharactersapp.navigation

import org.kodein.di.Kodein

interface ChildKodeinProvider {
    fun getChildKodein(): Kodein
}
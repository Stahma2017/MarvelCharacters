package ru.myapplication.marvelcharactersapp.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import ru.myapplication.marvelcharactersapp.di.scopes.CustomActivityScope
import ru.myapplication.marvelcharactersapp.di.scopes.CustomFragmentScope
import ru.myapplication.marvelcharactersapp.navigation.coordinator.CoordinatorHolder
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

fun navigationDiModule() = Kodein.Module("navigationDiModule") {

    bind<Cicerone<Router>>() with scoped(CustomFragmentScope).singleton { Cicerone.create() }
    bind<Cicerone<Router>>() with scoped(CustomActivityScope).singleton { Cicerone.create() }
    bind<CoordinatorHolder>() with scoped(CustomFragmentScope).singleton { CoordinatorHolder() }
    bind<CoordinatorHolder>() with scoped(CustomActivityScope).singleton { CoordinatorHolder() }

}
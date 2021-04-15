package ru.myapplication.marvelcharactersapp.ui.root.di

import androidx.fragment.app.FragmentManager
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.*
import ru.myapplication.marvelcharactersapp.navigation.coordinator.Coordinator
import ru.myapplication.marvelcharactersapp.ui.root.RootCoordinator
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

fun rootContainerDiModule() = Kodein.Module("rootContainerDiModule") {
    bind<Coordinator>() with scoped(AndroidLifecycleScope.multiItem)
        .multiton { fragmentManager: FragmentManager ->
            RootCoordinator(instance<Cicerone<Router>>().router, instance(), fragmentManager)
        }

    bind<RootNavigator> with factory {  }

}
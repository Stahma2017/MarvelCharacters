package ru.myapplication.marvelcharactersapp.ui.root

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.myapplication.marvelcharactersapp.navigation.coordinator.Coordinator
import ru.myapplication.marvelcharactersapp.navigation.coordinator.CoordinatorEvent
import ru.terrakok.cicerone.Router
import java.lang.ref.WeakReference

class RootCoordinator : Coordinator {

    private val navigationRouter: Router
    private val contextWeak: WeakReference<Context>
    private val fragmentManagerWeak: WeakReference<FragmentManager>

    constructor(
        navigationRouter: Router,
        context: Context,
        fragmentManager: FragmentManager,
    ) {
        this.navigationRouter = navigationRouter
        this.contextWeak = WeakReference(context)
        this.fragmentManagerWeak = WeakReference(fragmentManager)
    }

    override fun consumeEvent(event: CoordinatorEvent) {
        TODO("Not yet implemented")
    }
}
package ru.myapplication.marvelcharactersapp.di

import android.app.Application
import org.kodein.di.Kodein
import ru.myapplication.marvelcharactersapp.util.retainedInstance.IHasRetainedInstance
import ru.myapplication.marvelcharactersapp.util.retainedInstance.RetainedInstanceManager

class KodeinInjectionManager {
    private val injectionManager = RetainedInstanceManager<Kodein>()

    fun init(app: Application) = injectionManager.init(app)
    fun bindKodein(owner: IHasRetainedInstance<Kodein>) = injectionManager.bindKodein(owner)

    companion object {
        val instance = KodeinInjectionManager()
    }

}
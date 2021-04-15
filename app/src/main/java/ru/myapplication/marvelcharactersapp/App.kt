package ru.myapplication.marvelcharactersapp

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import ru.myapplication.marvelcharactersapp.di.KodeinInjectionManager
import ru.myapplication.marvelcharactersapp.di.navigationDiModule
import ru.myapplication.marvelcharactersapp.di.scopes.CustomScopesManager

class App : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@App))
        import(navigationDiModule())
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        KodeinInjectionManager.instance.init(this)
        CustomScopesManager.init(this)
    }

    companion object {
        lateinit var appInstance: App
        private set
    }

}
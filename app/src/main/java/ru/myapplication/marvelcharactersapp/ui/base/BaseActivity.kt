package ru.myapplication.marvelcharactersapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import org.kodein.di.Kodein
import org.kodein.di.LateInitKodein
import org.kodein.di.LazyKodein
import ru.myapplication.marvelcharactersapp.App
import ru.myapplication.marvelcharactersapp.di.KodeinInjectionManager
import ru.myapplication.marvelcharactersapp.util.retainedInstance.IHasRetainedInstance
import ru.myapplication.marvelcharactersapp.util.retainedInstance.IdProvider
import java.util.*

abstract class BaseActivity<Binding : ViewBinding> : FragmentActivity(),
        IHasRetainedInstance<Kodein>, IdProvider {

    protected lateinit var binding: Binding
    protected val kodein = LateInitKodein()

    abstract fun provideViewBinding(inflater: LayoutInflater): Binding
    abstract fun prepareUi()
    abstract fun provideDiModule(): Kodein.Module

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        this.intent.putExtra(CONTAINER_UUID, savedInstanceState?.getString(CONTAINER_UUID) ?: UUID.randomUUID().toString())
        initDi()
        super.onCreate(savedInstanceState, persistentState)
        binding = provideViewBinding(layoutInflater)
        setContentView(binding.root)
        prepareUi()
    }

    private fun initDi() {
        kodein.baseKodein = KodeinInjectionManager.instance.bindKodein(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(CONTAINER_UUID, this.intent.getStringExtra(CONTAINER_UUID))
        super.onSaveInstanceState(outState)
    }

    final override fun createRetainedInstance(): Kodein = LazyKodein {
        Kodein {
            extend(App.appInstance.kodein)
            import(provideDiModule(), allowOverride = true)
        }
    }

    override fun getUuid(): String = this.intent.getStringExtra(CONTAINER_UUID)!!

    companion object {
        private val CONTAINER_UUID = "${BaseActivity::class.java.canonicalName}.CONTAINER_UUID"
    }


}
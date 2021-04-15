package ru.myapplication.marvelcharactersapp.ui.root

import android.view.LayoutInflater
import org.kodein.di.Kodein
import ru.myapplication.marvelcharactersapp.databinding.ViewRootFragmentContainerBinding
import ru.myapplication.marvelcharactersapp.ui.base.BaseActivity
import ru.myapplication.marvelcharactersapp.ui.root.di.rootContainerDiModule

class RootActivity : BaseActivity<ViewRootFragmentContainerBinding>() {

    override fun provideViewBinding(inflater: LayoutInflater): ViewRootFragmentContainerBinding  = ViewRootFragmentContainerBinding.inflate(inflater)
    override fun provideDiModule(): Kodein.Module = rootContainerDiModule()

    override fun prepareUi() { }

}
package ru.myapplication.marvelcharactersapp.di.scopes

import android.util.Log
import androidx.fragment.app.Fragment
import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.ScopeRegistry
import org.kodein.di.bindings.StandardScopeRegistry
import ru.myapplication.marvelcharactersapp.util.retainedInstance.IdProvider

object CustomFragmentScope : Scope<Fragment> {
    private val scopeRegistryMap: HashMap<String, StandardScopeRegistry> = hashMapOf()

    override fun getRegistry(context: Fragment): ScopeRegistry {
        val uuid = (context as? IdProvider)?.getUuid() ?: throw RuntimeException("Uuid must not be null")

        val fragmentScopeRegistry = scopeRegistryMap[uuid]

        return fragmentScopeRegistry as? ScopeRegistry ?: StandardScopeRegistry().also {
            scopeRegistryMap[uuid] = it
        }
    }

    fun clearScope(context: Fragment) {
        val uuid = (context as? IdProvider)?.getUuid() ?: return

        Log.d(CustomFragmentScope::class.java.simpleName, "Scope with key=$uuid clearing.")

        scopeRegistryMap[uuid]?.clear()
        scopeRegistryMap.remove(uuid)
    }
}
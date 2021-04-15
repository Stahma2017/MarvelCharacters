package ru.myapplication.marvelcharactersapp.di.scopes

import android.app.Application
import ru.myapplication.marvelcharactersapp.util.retainedInstance.helpers.ActivityLifecycleHelper

object CustomScopesManager {
    fun init(app: Application) = app.registerActivityLifecycleCallbacks(
            ActivityLifecycleHelper(
                    onActivityDestroyed = { activity -> CustomActivityScope.clearScope(activity) },
                    onFragmentDestroyed = { fragment -> CustomFragmentScope.clearScope(fragment) }

            )
    )
}
package ru.myapplication.marvelcharactersapp.util.retainedInstance.helpers

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class ActivityLifecycleHelper(
    private val onActivityDestroyed: ((activity: Activity) -> Unit)?,
    private val onFragmentDestroyed: ((fragment: Fragment) -> Unit)?
) : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(FragmentLifecycleHelper(onFragmentDestroyed), true)
    }

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityResumed(activity: Activity) = Unit

    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityDestroyed(activity: Activity) {
        if (activity.isFinishing) {
            onActivityDestroyed?.invoke(activity)
        }
    }

}
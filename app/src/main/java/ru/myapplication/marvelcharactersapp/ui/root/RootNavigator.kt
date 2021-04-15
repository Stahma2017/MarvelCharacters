package ru.myapplication.marvelcharactersapp.ui.root

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class RootNavigator(activity: FragmentActivity, @IdRes containerId: Int) : SupportAppNavigator(activity, containerId) {



    override fun activityBack() {
        activity.moveTaskToBack(true)
    }

    override fun fragmentForward(command: Forward) {

        super.fragmentForward(command)
    }

}
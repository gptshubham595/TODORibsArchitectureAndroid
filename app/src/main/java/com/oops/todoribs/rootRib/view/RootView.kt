package com.oops.todoribs.rootRib.view

import android.content.Context
import android.view.ViewGroup
import com.oops.todoribs.rootRib.presentor.RootPresenter

class RootView : ViewGroup, RootPresenter {
    constructor(context: Context) : super(context)

    override fun displayLoading() {
        // Show loading UI
    }

    override fun hideLoading() {
        // Hide loading UI
    }

    override fun showError(message: String) {
        // Show error message
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }
}

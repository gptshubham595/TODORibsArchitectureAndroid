package com.oops.todoribs.rootRib.presentor

interface RootPresenter {
    fun displayLoading()
    fun hideLoading()
    fun showError(message: String)
}

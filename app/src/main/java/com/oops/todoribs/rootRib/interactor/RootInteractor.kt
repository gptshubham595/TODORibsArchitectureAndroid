package com.oops.todoribs.rootRib.interactor

import com.oops.todoribs.rootRib.presentor.RootPresenter
import com.oops.todoribs.rootRib.router.RootRouter
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor

class RootInteractor(
    private val presenter: RootPresenter
) : Interactor<RootPresenter, RootRouter>() {
    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.displayLoading()

        // Simulate some logic, then hide loading and attach TaskListRIB
        presenter.hideLoading()
        router.attachTaskList()
    }
}

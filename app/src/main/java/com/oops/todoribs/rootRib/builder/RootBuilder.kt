package com.oops.todoribs.rootRib.builder

import com.oops.todoribs.rootRib.components.RootDependency

class RootBuilder(dependency: RootDependency) : Builder<RootDependency>(dependency) {
    fun build(): RootRouter {
        val interactor = RootInteractor()
        return RootRouter(interactor)
    }
}
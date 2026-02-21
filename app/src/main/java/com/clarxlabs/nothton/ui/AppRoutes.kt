package com.clarxlabs.nothton.ui

import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object RootGraph : AppRoutes

    @Serializable
    data object Home : AppRoutes
}

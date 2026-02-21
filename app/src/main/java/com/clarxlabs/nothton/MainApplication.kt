package com.clarxlabs.nothton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.clarxlabs.nothton.core.factories.HttpClientFactory
import com.clarxlabs.nothton.ui.AppRoutes
import com.clarxlabs.nothton.ui.theme.AppTheme
import io.ktor.client.HttpClient
import org.koin.compose.KoinApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

@Composable
fun MainApplication() {
    val appModule = module {
        singleOf(HttpClientFactory::create).bind<HttpClient>()
    }

    KoinApplication({ modules(appModule) }) {
        AppTheme {
            val navController = rememberNavController()

            NavHost(navController, AppRoutes.RootGraph) {
                navigation<AppRoutes.RootGraph>(startDestination = AppRoutes.Home) {
                    composable<AppRoutes.Home> {
                        Surface(modifier = Modifier.fillMaxSize()) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) { Text("hello!") }
                        }
                    }
                }
            }
        }
    }
}

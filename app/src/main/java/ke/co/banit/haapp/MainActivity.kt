package ke.co.banit.haapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.banit.haapp.ui.Screen
import ke.co.banit.haapp.ui.about.AboutScreen
import ke.co.banit.haapp.ui.channels.ChannelScreen
import ke.co.banit.haapp.ui.home.HomeScreen
import ke.co.banit.haapp.ui.theme.HaappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HaappTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        NavigationHost(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.News,
        Screen.Channels,
        Screen.About
    )
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar {
        val currentRoute = navController.currentDestination?.route
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (index == selectedItem) screen.selectedIcon
                        else screen.unSelectedIcon,
                        contentDescription = screen.label
                    )
                },
                label = { Text(screen.label) },
                alwaysShowLabel = false,
                selected = index == selectedItem,
                onClick = {
                    selectedItem = index
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.News.route) {
        composable(Screen.News.route) { HomeScreen() }
        composable(Screen.Channels.route) { ChannelScreen() }
        composable(Screen.About.route) { AboutScreen() }
    }
}
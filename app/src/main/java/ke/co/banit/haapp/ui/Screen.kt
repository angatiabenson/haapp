package ke.co.banit.haapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @Author: Angatia Benson
 * @Date: 6/3/2024
 * Copyright (c) 2024 BanIT
 */
sealed class Screen(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
) {
    data object News : Screen(
        route = "news",
        label = "News",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    )

    data object Channels : Screen(
        route = "channels",
        label = "Channels",
        selectedIcon = Icons.Filled.CheckCircle,
        unSelectedIcon = Icons.Outlined.CheckCircle
    )

    data object About : Screen(
        route = "about",
        label = "About",
        selectedIcon = Icons.Filled.Info,
        unSelectedIcon = Icons.Outlined.Info
    )
}
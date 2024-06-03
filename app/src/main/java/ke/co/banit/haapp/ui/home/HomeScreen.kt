package ke.co.banit.haapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ke.co.banit.haapp.R

/**
 * @Author: Angatia Benson
 * @Date: 6/3/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(12.dp)
            .fillMaxHeight()
    ) {
        TrendingSection()
        Spacer(modifier = Modifier.height(24.dp))
        NewsSection()
    }
}

@Composable
fun NewsSection() {
    Column {
        Text(
            text = "Latest News",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            val newsList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            items(newsList.size) { _ ->
                NewsItem(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun TrendingSection() {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Trending",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    Image(
        painter = painterResource(id = R.drawable.img_news),
        contentDescription = "Trending News",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(RoundedCornerShape(12.dp))
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "BBC News",
        style = MaterialTheme.typography.bodySmall
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Israeli war cabinet due to meet as Netanyahu 'strongly opposes' ending Gaza war",
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row {
        Text(
            text = "Kit Maher",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_time),
            contentDescription = "Time",
            modifier = Modifier
                .padding(start = 8.dp)
                .size(16.dp)
        )
        Text(
            text = "14 min ago",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun NewsItem(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_news),
                contentDescription = "News Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "BBC News",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Israeli war cabinet due to meet as Netanyahu 'strongly opposes' ending Gaza war",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = "Kit Maher",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = "Time",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(16.dp)
                    )
                    Text(
                        text = "14 min ago",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}

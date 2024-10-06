package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    val dataList = Data()  // Get the list of Category objects
    LazyColumn {
        items(dataList) { category ->  // Use 'items' to iterate over the list of Category
            SingleRow(category = category)  // Pass the Category object to SingleRow
        }
    }
}

@Composable
fun SingleRow(category: Category) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = "Dummy",
            modifier = Modifier
                .size(40.dp)
                .weight(.2f)

        )
        Column(modifier = Modifier.weight(.8f)) {
            Text(
                text = category.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = category.profile, fontWeight = FontWeight.Thin)
        }
    }
}


fun Data(): MutableList<Category> {
    val dataList = mutableListOf<Category>()
    for (i in 1..30) {
        if (i == 1) {
            dataList.add(Category(R.drawable.profile_icon, "Tushar Gupta", "Android Dev"))
        } else {
            if (i % 2 == 0) {
                dataList.add(Category(R.drawable.profile_icon, "Reshu Gupta", "Android Dev"))
            } else {
                dataList.add(Category(R.drawable.profile_icon, "Neha Gupta", "Android Dev"))
            }

        }
    }

    return dataList
}

data class Category(val image: Int, val name: String, val profile: String)
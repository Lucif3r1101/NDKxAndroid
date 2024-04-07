package com.rishav.ndkxandroid

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.content.ContextCompat.startActivity
import com.rishav.ndkxandroid.ui.theme.NDKxAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.sample_image)
        setContent {
            NDKxAndroidTheme {
                MainActivityContent(this)
                ProcessedOriginalImage(bitmap = originalBitmap)
            }
        }
    }
}

@Composable
fun ProcessedOriginalImage(bitmap: Bitmap) {
    val processedBitmap = bitmap.asImageBitmap()

    Image(
        bitmap = processedBitmap,
        contentDescription = "Processed Image",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun MainActivityContent(activity: Activity) {
    Column {
        Button(onClick = { navigateToProcessImageActivity(activity) }) {
            Text("Show Processed Image")
        }
    }
}


fun navigateToProcessImageActivity(activity: Activity) {
    // Start ProcessImageActivity
    val intent = Intent(activity, ProcessImageActivity::class.java)
    activity.startActivity(intent)
}


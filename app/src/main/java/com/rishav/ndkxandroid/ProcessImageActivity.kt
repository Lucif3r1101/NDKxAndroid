package com.rishav.ndkxandroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import com.rishav.ndkxandroid.ui.theme.NDKxAndroidTheme

class ProcessImageActivity : ComponentActivity() {

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.sample_image)
        val processedBitmap = processImage(originalBitmap)

        setContent {
            NDKxAndroidTheme {
                ProcessedImage(bitmap = processedBitmap)
            }
        }
    }

    private external fun processImage(bitmap: Bitmap): Bitmap
}

@Composable
fun ProcessedImage(bitmap: Bitmap) {
    val processedBitmap = bitmap.asImageBitmap()

    Image(
        bitmap = processedBitmap,
        contentDescription = "Processed Image",
        modifier = Modifier.fillMaxSize()
    )
}

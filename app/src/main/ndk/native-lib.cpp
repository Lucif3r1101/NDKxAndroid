#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>

#define LOG_TAG "NativeImageProcessing"
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__))

extern "C" {
JNIEXPORT jobject JNICALL
Java_com_rishav_ndkxandroid_ProcessImageActivity_processImage(JNIEnv *env, jobject instance, jobject bitmap) {
    AndroidBitmapInfo info;
    void *pixels;
    int ret;

    // Get bitmap info
    if ((ret = AndroidBitmap_getInfo(env, bitmap, &info)) < 0) {
        LOGE("AndroidBitmap_getInfo() failed, error=%d", ret);
        return NULL;
    }

    // Lock bitmap pixels
    if ((ret = AndroidBitmap_lockPixels(env, bitmap, &pixels)) < 0) {
        LOGE("AndroidBitmap_lockPixels() failed, error=%d", ret);
        return NULL;
    }

    // Invert colors (simple grayscale inversion)
    uint32_t *pixelPtr = (uint32_t *)pixels;
    for (int y = 0; y < info.height; y++) {
        for (int x = 0; x < info.width; x++) {
            uint32_t color = *pixelPtr;
            int alpha = (color >> 24) & 0xFF;
            int red = (color >> 16) & 0xFF;
            int green = (color >> 8) & 0xFF;
            int blue = color & 0xFF;
            int gray = (int)(0.3 * red + 0.59 * green + 0.11 * blue);
            *pixelPtr = (uint32_t)((alpha << 24) | (gray << 16) | (gray << 8) | gray);
            pixelPtr++;
        }
    }

    // Unlock bitmap pixels
    AndroidBitmap_unlockPixels(env, bitmap);

    return bitmap;
}
}

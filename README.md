# NDKxAndroid

NDKxAndroid is an Android application that demonstrates how to integrate native C/C++ code (NDK) with Kotlin/Java code in an Android app. It includes a sample image processing feature implemented using native code.

## Overview

NDKxAndroid is an Android application that showcases the integration of native C/C++ code with Kotlin/Java code to perform image processing tasks. The application provides a sample image processing feature that demonstrates the use of the Android NDK (Native Development Kit) to perform grayscale inversion on images.

### Native Development Kit (NDK)

The Android NDK is a toolset provided by Google for developing native Android applications using C and C++ programming languages. It allows developers to reuse existing native code libraries written in C/C++ or to optimize performance-critical parts of their Android applications.

### CMake

CMake is an open-source, cross-platform build system that is used to manage the build process of native code projects. In the case of NDKxAndroid, CMake is used to configure, build, and install the native C/C++ code into the Android application.

### Project Structure

- **native-lib.cpp**: Contains the native C++ code for image processing.
- **ProcessImageActivity.kt**: Activity responsible for processing images using native code.
- **MainActivity.kt**: Main launcher activity containing a button to navigate to the image processing activity.
- **CMakeLists.txt**: Configuration file for CMake to build the native code.
- **local.properties**: Configuration file specifying the SDK and NDK directories.

## Installation

To run this project locally, follow these steps:

1. Clone the repository:

`git clone https://github.com/Lucif3r1101/NDKxAndroid.git`


2. Open the project in Android Studio.

3. Build and run the project on an Android device or emulator.

## Dependencies

This project requires the following dependencies:

- Android Studio 4.0 or later
- Kotlin 1.4 or later
- Android SDK
- NDK (Native Development Kit)

## Usage

Once the project is running on your device or emulator, you can use the application to demonstrate native image processing. Follow the on-screen instructions to navigate through the app and process images.

## Contributing

Contributions to this project are welcome! If you find any issues or have suggestions for improvements, please [open an issue](https://github.com/Lucif3r1101/NDKxAndroid/issues) or [submit a pull request](https://github.com/Lucif3r1101/NDKxAndroid/pulls).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

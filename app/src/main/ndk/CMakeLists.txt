cmake_minimum_required(VERSION 3.10.2)

# Set the project name
project(NDKxAndroid)

# Set the path to your native source files
set(SRC_DIR src/main/ndk)

# Collect all source files in the specified directory
file(GLOB SRC_FILES "${SRC_DIR}/*.cpp")

# Add the native library target
add_library(native-lib SHARED ${SRC_FILES})


target_sources(native-lib
        PRIVATE
        native-lib.cpp
)

# Link native libraries
target_link_libraries(
        native-lib
        PRIVATE
        android
        log
        jnigraphics
        atomic
        camera2ndk  # Camera2 libraries
        mediandk    # Media libraries (for NdkImageReader)
)
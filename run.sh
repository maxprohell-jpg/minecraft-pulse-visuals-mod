#!/bin/bash

# Compiling the mod
echo "Compiling the mod..."
# Assume there's a build tool like Gradle or Maven
./gradlew build 

# Running the mod
echo "Running the mod..."
# Here we can assume a typical way to start the Minecraft server or client with mods
java -Xmx2G -cp "build/libs/*" com.mojang.minecraft.Main

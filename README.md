
![firstcomposelayoyt](https://github.com/user-attachments/assets/fddbcac3-1ee2-4936-aa9d-82c419f38924)


# Android Project with Docker and Jetpack Compose

This repository contains an Android project setup that integrates **Docker** for containerized builds and **Jetpack Compose** for building modern UI.

## Prerequisites

Before getting started, make sure you have the following installed:

- **Docker**: [Install Docker](https://docs.docker.com/get-docker/)
- **Android Studio** (Optional, for local testing): [Install Android Studio](https://developer.android.com/studio)

## Setting Up the Project

### Step 1: Clone the Repository
Clone this repository to your local machine.

Step 2: Build the Docker Image
Build the Docker image using the following command:

bash

docker build -t my-android-app .
This command will create a Docker image based on the Dockerfile in the root directory of the project.

Step 3: Run the Docker Container
After the build is complete, run the Docker container with:

bash

docker run -it my-firstcomposelayout-app
This will start the container, and your app will be built inside the Docker container.

Step 4: Run Android App (Debug Build)
To build and run the Android app inside the Docker container:

bash
x
./gradlew --no-daemon assembleDebug

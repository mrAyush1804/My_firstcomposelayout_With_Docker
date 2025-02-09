# 1️⃣ Base Image
FROM openjdk:17-jdk-slim

# 2️⃣ Install Required Packages
RUN apt-get update && apt-get install -y \
    curl unzip git && \
    rm -rf /var/lib/apt/lists/*

# 3️⃣ Define Environment Variables for SDK
ENV ANDROID_HOME=/opt/android-sdk
ENV PATH=${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${PATH}

# 4️⃣ Install Android SDK Command Line Tools
RUN mkdir -p $ANDROID_HOME/cmdline-tools \
    && curl -o sdk.zip https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip \
    && unzip sdk.zip -d $ANDROID_HOME/cmdline-tools/ \
    && mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest \
    && rm sdk.zip

# 5️⃣ Accept SDK Licenses and Install Build Tools
RUN yes | $ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --licenses \
    && $ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager \
        "platform-tools" \
        "platforms;android-34" \
        "build-tools;34.0.0"

# 6️⃣ Set Work Directory
WORKDIR /app

# 7️⃣ Copy Project Files
COPY . /app

# 8️⃣ Make Gradle Executable
RUN chmod +x gradlew

# 9️⃣ Set SDK Path in Local Properties
RUN echo "sdk.dir=$ANDROID_HOME" > local.properties

# 🔟 Build the Project
RUN ./gradlew --no-daemon assembleDebug

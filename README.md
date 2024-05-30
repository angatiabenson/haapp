<div>
   <center>
   <img src="app/src/main/res/drawable/app_logo.png" width="200" height="200">
   </center>
</div>

# Haapp

## Overview
Haapp is a modern news application built using the MVVM (Model-View-ViewModel) architecture. The app fetches news articles and sources from the NewsAPI.org and displays them in a user-friendly manner. The application is developed using Kotlin and Jetpack Compose for the UI, and Retrofit for network operations.

## Features
- **Home Page:** Displays the latest news from various sources.
- **News Source Page:** Lists different news sources.
- **MVVM Architecture:** Ensures a clean separation of concerns, making the app more maintainable and testable.
- **Jetpack Compose:** Utilizes the modern UI toolkit for building native Android UIs.

## Requirements
- Android Studio
- Minimum SDK: 21
- Kotlin
- NewsAPI.org API Key

## Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/angatiabenson/haapp
   ```

2. **Open the project in Android Studio:**
   - Open Android Studio.
   - Click on `File -> Open...` and navigate to the cloned project directory.

3. **Obtain NewsAPI.org API Key:**
   - Register at [NewsAPI.org](https://newsapi.org/register) to get your API key.

4. **Add API Key to the project:**
   - Create a file named `local.properties` in the root directory of your project.
   - Add the following line to `local.properties`:
     ```properties
     NEWS_API_KEY=your_api_key_here
     ```

5. **Build the project:**
   - Click on `Build -> Make Project` or press `Ctrl+F9` to build the project.

6. **Run the project:**
   - Click on `Run -> Run 'app'` or press `Shift+F10` to run the project on an emulator or a physical device.

## Architecture

### MVVM Structure

- **Model:** Handles the data operations. This includes fetching data from the NewsAPI.
- **ViewModel:** Acts as a bridge between the Model and the View. It fetches data from the Model and prepares it for the View.
- **View:** Displays the data. Built using Jetpack Compose.

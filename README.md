# UserListApp

## Description
This is an Android application built using **Kotlin** that fetches user data from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/) and displays it in a list using the **MVVM architecture**.

## Features
- Fetches user data from the JSONPlaceholder API.
- Displays users in a RecyclerView with their name, email, and phone number.
- Implements the MVVM architecture pattern for better separation of concerns.
- Handles click events on list items to show a Toast message with the selected user's name.
- Uses modern Android technologies such as Retrofit, Coroutines, LiveData/StateFlow, and RecyclerView.

## Technologies Used
- **Language**: Kotlin
- **Architecture**: MVVM
- **Networking**: Retrofit + Moshi (for JSON parsing)
- **Concurrency**: Kotlin Coroutines
- **UI Components**: RecyclerView, ConstraintLayout
- **Data Management**: ViewModel, Repository
- **State Management**: LiveData or StateFlow

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/UserListApp.git

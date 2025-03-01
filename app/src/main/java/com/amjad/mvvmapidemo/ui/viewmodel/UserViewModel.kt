package com.amjad.mvvmapidemo.ui.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amjad.mvvmapidemo.data.model.User
import com.amjad.mvvmapidemo.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                val fetchedUsers = repository.fetchUsers()
                _users.value = fetchedUsers
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
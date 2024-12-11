package com.eclipse.findz.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eclipse.findz.data.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel( private val firestore: FirebaseFirestore) : ViewModel(){

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    fun fetchUser(userId: String){
        viewModelScope.launch {
            firestore.collection("users").document(userId)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        val user = document.toObject(User::class.java)
                        _user.value = user
                    } else {
                        _user.value = null
                    }
                }
                .addOnFailureListener {
                    _user.value = null
                }
        }
    }
}

class UserViewModelFactory(private val firestore: FirebaseFirestore) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(firestore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
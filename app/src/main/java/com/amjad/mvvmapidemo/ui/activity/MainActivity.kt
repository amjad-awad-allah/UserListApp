package com.amjad.mvvmapidemo.ui.activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amjad.mvvmapidemo.R
import com.amjad.mvvmapidemo.data.model.User
import com.amjad.mvvmapidemo.data.repository.UserRepository
import com.amjad.mvvmapidemo.ui.adapter.UserAdapter
import com.amjad.mvvmapidemo.ui.viewmodel.UserViewModel
import com.amjad.mvvmapidemo.ui.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity(), UserAdapter.OnItemClickListener {

    private val viewModel: UserViewModel by viewModels { UserViewModelFactory(UserRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the users list from the ViewModel
        viewModel.users.observe(this, Observer { users ->
            recyclerView.adapter = UserAdapter(users, this) // Pass users and listener
        })
    }

    override fun onItemClick(user: User) {
        Toast.makeText(this, "Clicked: ${user.name}", Toast.LENGTH_SHORT).show()
    }
}
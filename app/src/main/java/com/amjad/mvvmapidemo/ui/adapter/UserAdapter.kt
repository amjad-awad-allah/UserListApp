package com.amjad.mvvmapidemo.ui.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amjad.mvvmapidemo.R
import com.amjad.mvvmapidemo.data.model.User

class UserAdapter(
    private val users: List<User>, // Users list passed to the adapter
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Define the click listener interface
    interface OnItemClickListener {
        fun onItemClick(user: User)
    }

    // ViewHolder class
    class UserViewHolder(
        itemView: View,
        private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)

        private lateinit var currentUser: User // Add this variable

        init {
            itemView.setOnClickListener(this) // Set the click listener
        }

        // Method to bind data to the ViewHolder
        fun bind(user: User) {
            currentUser = user // Store the current user
            nameTextView.text = user.name
            emailTextView.text = user.email
            phoneTextView.text = user.phone
        }

        override fun onClick(v: View?) {
            listener.onItemClick(currentUser) // Pass the current user directly
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view, onItemClickListener) // Pass the listener
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user) // Bind the user data to the ViewHolder
    }

    override fun getItemCount(): Int = users.size
}
package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.theme.Book
import com.example.myapplication.ui.theme.BookAdapter

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val bookList = listOf(
            Book("One Hundred Years of Solitude", "Gabriel García Márquez", R.drawable.solitude, 4.5f),
            Book("Terra Nostra", "Carlos Fuentes", R.drawable.nostra, 4.0f),
            Book("Angels & Demons", "Dan Brown", R.drawable.angels, 3.5f),
            Book("The Sword Thief", "Peter Lerangis", R.drawable.sword, 4.0f),
            Book("Bloodline", "James Rollins", R.drawable.blood, 4.0f),
            Book("The House Of The Spirits", "Isabel Allende", R.drawable.spirits, 4.0f),
            Book("The Hummingbird's Daughter", "Luis Alberto Urrea", R.drawable.humming, 4.0f)
        )

        val adapter = BookAdapter(bookList)
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter


        binding.toolbar.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.bell -> {
                    Toast.makeText(this, R.string.bell_c licked, Toast.LENGTH_SHORT).show()
                    true

                }
                else -> false
            }
        }
        binding.toolbar.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.reviews -> {
                    Toast.makeText(this, R.string.review_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.favorite -> {
                    Toast.makeText(this, R.string.favorite_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}

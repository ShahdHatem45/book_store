package com.example.myapplication.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class BookAdapter( val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageView = itemView.findViewById(R.id.book_image)
        val bookTitle: TextView = itemView.findViewById(R.id.book_title)
        val bookAuthor: TextView = itemView.findViewById(R.id.book_author)
        val bookRating: RatingBar = itemView.findViewById(R.id.book_rating)
        val wantToReadButton: Button = itemView.findViewById(R.id.want_to_read_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.bookTitle.text = book.title
        holder.bookAuthor.text = "by ${book.author}"
        holder.bookImage.setImageResource(book.imageResId)
        holder.bookRating.rating = book.rating

        holder.wantToReadButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${book.title} added to your list", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}

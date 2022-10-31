package com.example.wishlist_final_one

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishes: List<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onBtnClick
        // get the 3 text fields
        // change wishFetcher to hold 3 lists instead of just name
        // write function to insert into fetcher

        val nameET = findViewById<EditText>(R.id.name_text)
        val urlET = findViewById<EditText>(R.id.url_text)
        val priceET = findViewById<EditText>(R.id.price_text)
        val submitBtn = findViewById<Button>(R.id.submit_btn)


        submitBtn.setOnClickListener {
            // Enter new wish item into the wishlist
            WishFetcher.addWishes(nameET.text.toString(), urlET.text.toString(), priceET.text.toString())

            // Lookup the RecyclerView in activity layout
            val wishesRv = findViewById<RecyclerView>(R.id.wishesRv)

            // Fetch the list of emails
            wishes = WishFetcher.getWishes()

            // Create adapter passing in the list of emails
            val adapter = WishAdapter(wishes)

            // Attach the adapter to the RecyclerView to populate items
            wishesRv.adapter = adapter

            // Set layout manager to position the items
            wishesRv.layoutManager = LinearLayoutManager(this)

            nameET.text.clear()
            urlET.text.clear()
            priceET.text.clear()
            hideKeyboard()
        }

    }

    private fun hideKeyboard() {
        val view = this.currentFocus

        if (view != null) {
            val hideMe = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken, 0)
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
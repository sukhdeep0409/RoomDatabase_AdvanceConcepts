package com.example.roomdatabase_advanceconcepts

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.roomdatabase_advanceconcepts.data.Address
import com.example.roomdatabase_advanceconcepts.data.MyAdapter
import com.example.roomdatabase_advanceconcepts.data.MyViewModel
import com.example.roomdatabase_advanceconcepts.data.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { MyAdapter() }
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        val address = Address("Wall Street", 10)
        lifecycleScope.launch {
            val person = Person("John", "Doe", 25, address, getBitmap())

            myViewModel.insertPerson(person)
        }

        myViewModel.readPerson.observe(this, {
            adapter.setData(it)
        })
    }

    private suspend fun getBitmap(): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data("https://image.shutterstock.com/image-vector/kotlin-mobile-application-programming-language-260nw-1466263208.jpg")
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}
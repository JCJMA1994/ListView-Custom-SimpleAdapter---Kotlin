package com.example.listviewcustomsimpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val titleArray = arrayOf("Name", "Sex", "Age", "Location", "Email")
    private val descArray = arrayOf("Jerry", "Male", "43", "Singapore", "webmaster@dev2qa.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.simpleAdapterListView()
    }

    private fun simpleAdapterListView() {

        val dataListArray = ArrayList<HashMap<String, Any>>()
        val length = titleArray.size

        for (i in 0 until length){
            val item = HashMap<String, Any>()
            item["imageId"] = R.mipmap.ic_launcher
            item["title"] = titleArray[i]
            item["description"] = descArray[i]

            dataListArray.add(item)
        }
        val listViewExample = findViewById<ListView>(R.id.listViewExample)

        val simpleAdapter = SimpleAdapter(this, dataListArray, R.layout.activity_main,
            arrayOf("imageId","title", "description"), intArrayOf(R.id.userImage, R.id.userTitle,R.id.userDesc))
        listViewExample.adapter = simpleAdapter

        listViewExample.setOnItemClickListener {
                parent, _, position, _ ->
            Toast.makeText(this, "You chose " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
        }
    }

}
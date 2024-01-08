package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val index = it + 1
            items.add(
                ItemModel(
                    "Item $index",
                    resources.getIdentifier("thumb$index", "drawable", packageName)
                )
            )
        }

        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }
}
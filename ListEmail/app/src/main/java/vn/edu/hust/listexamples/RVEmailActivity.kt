package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RVEmailActivity : AppCompatActivity(), RVEmailItemAdapter.ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvemail)

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

        val adapter = RVEmailItemAdapter(items, this)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun ItemClick(position: Int) {
        Log.v("TAG", "Selected position: $position")
    }
}
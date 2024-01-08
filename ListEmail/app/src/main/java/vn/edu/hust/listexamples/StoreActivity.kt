package vn.edu.hust.listexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val items = arrayListOf<OneApp>()
        repeat(28) {
            val index = it + 1
            items.add(OneApp(
                "Item $index",
                resources.getIdentifier("thumb$index", "drawable", packageName)
            ))
        }

        val rows = arrayListOf<OneRow>()
        repeat(8) {
            val index = it + 1
            rows.add(OneRow(
                "Apps $index",
                items
            ))
        }

        val rvRow = findViewById<RecyclerView>(R.id.rvRow)

        val menuAdapter = RVStoreMenuAdapter(rows, this)
        val manager = LinearLayoutManager(this)

        rvRow.layoutManager = manager
        rvRow.adapter = menuAdapter
    }

}
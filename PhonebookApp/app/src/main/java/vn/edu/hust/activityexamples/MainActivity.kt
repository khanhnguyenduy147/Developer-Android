package vn.edu.hust.activityexamples

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.view.ActionMode

class MainActivity : AppCompatActivity() {
    val items = arrayListOf<String>()

    var actionMode: ActionMode? = null
    val actionModeCallback = object: ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.main_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1 = findViewById<EditText>(R.id.edit_param1)
        val edit2 = findViewById<EditText>(R.id.edit_param2)
        val textResult = findViewById<TextView>(R.id.text_result)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val result = it.data?.getDoubleExtra("result", 0.0)
                textResult.text = "$result"
            } else {
                textResult.text = "Canceled"
            }
        }

        findViewById<Button>(R.id.button_open).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("param1", edit1.text.toString())
            intent.putExtra("param2", edit2.text.toString())
            launcher.launch(intent)
        }

        findViewById<Button>(R.id.button_do_action).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND, Uri.parse("smsto:0987654321"))
            intent.type = "text/plain"
            intent.putExtra("sms_body", "Content")
            startActivity(intent)
        }

        val imageView = findViewById<ImageView>(R.id.imageView)

        imageView.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.inflate(R.menu.main_menu)
            popupMenu.setOnMenuItemClickListener {
                true
            }
            popupMenu.show()
        }

        repeat(50) {items.add("Item $it")}
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val selectedItem = items[(item.menuInfo as AdapterContextMenuInfo).position]
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }
}
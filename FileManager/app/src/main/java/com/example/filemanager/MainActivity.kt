package com.example.filemanager

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var emptyTextView: TextView
    private lateinit var currentDirectory: File
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                startActivity(intent)
            }
        }

        listView = findViewById(R.id.listView)
        emptyTextView = findViewById(R.id.emptyTextView)

        registerForContextMenu(listView)

        // Set the initial directory to external storage
        currentDirectory = Environment.getExternalStorageDirectory()

        // Kiểm tra xem có dữ liệu được khôi phục từ Bundle không
        if (savedInstanceState != null) {
            val savedPath = savedInstanceState.getString("currentDirectory")
            if (!savedPath.isNullOrBlank()) {
                currentDirectory = File(savedPath)
            }
        }

        loadFiles(currentDirectory)
    }

    private fun loadFiles(directory: File) {
        title = directory.path
        val files = directory.listFiles()
        val fileList = mutableListOf<String>()

        if (files != null) {
            for (file in files) {
                fileList.add(file.name)
            }
        }

        if (fileList.isEmpty()) {
            emptyTextView.visibility = View.VISIBLE
            listView.visibility = View.GONE
        } else {
            emptyTextView.visibility = View.GONE
            listView.visibility = View.VISIBLE
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fileList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFile = File(directory, fileList[position])
            if (selectedFile.isDirectory) {
                loadFiles(selectedFile)
            } else {
                // Handle file click, e.g., open file
            }
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val selectedFile = File(currentDirectory, adapter.getItem(info.position)!!)

        when (item.itemId) {
            R.id.renameItem -> showRenameDialog(selectedFile)
            R.id.deleteItem -> showDeleteDialog(selectedFile)
            // Add more context menu items as needed
        }

        return true
    }

    private fun showRenameDialog(file: File) {
        val input = EditText(this)
        input.setText(file.name)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Rename File/Folder")
            .setView(input)
            .setPositiveButton("OK") { _, _ ->
                val newName = input.text.toString()
                val newFile = File(file.parentFile, newName)

                if (file.renameTo(newFile)) {
                    loadFiles(currentDirectory)
                } else {
                    // Handle renaming failure
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun showDeleteDialog(file: File) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Delete File/Folder")
            .setMessage("Are you sure you want to delete ${file.name}?")
            .setPositiveButton("Yes") { _, _ ->
                if (file.deleteRecursively()) {
                    loadFiles(currentDirectory)
                } else {
                    // Handle deletion failure
                }
            }
            .setNegativeButton("No", null)
            .create()

        dialog.show()
    }
    // Ghi đè phương thức để xử lý nút "Back"
    override fun onBackPressed() {
        // Nếu đang ở root directory, đóng ứng dụng
        if (currentDirectory.path == Environment.getExternalStorageDirectory().path) {
            super.onBackPressed()
        } else {
            // Nếu không ở root directory, quay lại thư mục trước đó
            loadFiles(currentDirectory.parentFile)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        // Lưu trạng thái khi ứng dụng bị hủy (ví dụ: khi xoay màn hình)
        outState.putString("currentDirectory", currentDirectory.path)
        super.onSaveInstanceState(outState)
    }
}

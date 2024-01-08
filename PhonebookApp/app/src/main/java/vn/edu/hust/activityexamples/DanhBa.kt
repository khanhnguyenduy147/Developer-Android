package vn.edu.hust.activityexamples

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController


class DanhBa : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danh_ba)

        repeat(28) {
            val index = it + 1
            items.add(Person(
                index,
                "Khanh Nguyen Duy $index",
                resources.getIdentifier("ic_launcher_background", "drawable", packageName),
                "0965555555$index"
            ))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            val navController = navHostFragment?.findNavController()
            val bundle = Bundle()
            navController?.navigate(R.id.action_listFragment_to_addFragment, bundle)
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val items = arrayListOf<Person>()
    }


}
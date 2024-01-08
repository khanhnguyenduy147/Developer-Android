package vn.edu.hust.activityexamples

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class DanhBaDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danh_ba_detail)
        val name = findViewById<TextView>(R.id.name)
        val phone = findViewById<TextView>(R.id.phone)
        val email = findViewById<TextView>(R.id.email)

        try {
            val personInfo = intent.getParcelableExtra<Person>("Item")
            name.text = "${personInfo?.id.toString()}. ${personInfo?.name}"
            phone.text = "${personInfo?.phone}"
            email.text = "${personInfo?.email}"

        } catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }
    }
}
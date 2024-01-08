package com.example.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var checkbox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitButton = findViewById(R.id.submit);
        checkbox = findViewById(R.id.checkbox)

        submitButton.setOnClickListener(){
            var methodError = messageError();
            if(methodError == ""){
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, methodError , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun messageError(): String {
        var messageError = ""
        val firstName = findViewById<TextInputEditText>(R.id.first_name).text.toString().trim()
        val lastName = findViewById<TextInputEditText>(R.id.last_name).text.toString().trim()
        val address = findViewById<TextInputEditText>(R.id.address).text.toString().trim()
        val email = findViewById<TextInputEditText>(R.id.email).text.toString().trim()
        val isTermsChecked = findViewById<CheckBox>(R.id.checkbox).isChecked
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val isGenderSelected = genderGroup.checkedRadioButtonId != -1
        if(firstName.isEmpty()){
            messageError += "first name is empty, ";
        }
        if(lastName.isEmpty()){
            messageError += "last name is empty, ";
        }
        if(address.isEmpty()){
            messageError += "address is empty, ";
        }
        if(email.isEmpty()){
            messageError += "email is empty, ";
        }
        if(!isTermsChecked){
            messageError += "please check this box, ";
        }
        if(!isGenderSelected){
            messageError += "gener is not valid ";
        }
        return messageError;
    }

}
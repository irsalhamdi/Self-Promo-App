package com.irsalhamdi.selfpromoapp

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.Spinner
import android.widget.CheckBox
import android.widget.ArrayAdapter
import androidx.core.view.ViewCompat
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var contactNameEditText: TextInputEditText? = null
    var contactNumberEditText: TextInputEditText? = null
    var displayNameEditText: TextInputEditText? = null
    var startDateEditText: TextInputEditText? = null
    var jobTitleSpinner: Spinner? = null
    var immediateStartCheckBox: CheckBox? = null
    var juniorCheckBox: CheckBox? = null

    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setUpOnClick()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun MainActivity.getElementById() {
    contactNameEditText = findViewById(R.id.edit_text_contact_name)
    contactNumberEditText = findViewById(R.id.edit_text_contact_number)
    displayNameEditText = findViewById(R.id.edit_text_display_name)
    startDateEditText = findViewById(R.id.edit_text_start_date)
    jobTitleSpinner = findViewById(R.id.spinner_job_title)
    immediateStartCheckBox = findViewById(R.id.checkbox_immediate_start)
    juniorCheckBox = findViewById(R.id.checkbox_junior)
    button = findViewById(R.id.button_preview)
}

private fun MainActivity.setUpOnClick() {
    getElementById()

    val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("Android Developer", "Android Engineer"))
    jobTitleSpinner?.adapter = spinnerAdapter

    button?.setOnClickListener {
        
        val message = Message(
            contactNameEditText?.text.toString(),
            contactNumberEditText?.text.toString(),
            displayNameEditText?.text.toString(),
            startDateEditText?.text.toString(),
            jobTitleSpinner?.selectedItem.toString(),
            immediateStartCheckBox?.isChecked ?: false ,
            juniorCheckBox?.isChecked ?: false
        )

        val previewActivity = Intent(this, PreviewActivity::class.java)
        previewActivity.putExtra("Message", message)

        startActivity(previewActivity)
    }
}

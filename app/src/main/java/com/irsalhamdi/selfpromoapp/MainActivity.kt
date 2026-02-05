package com.irsalhamdi.selfpromoapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var displayNameEditText: TextInputEditText? = null
    private var startDateEditText: TextInputEditText? = null
    private var jobTitleSpinner: Spinner? = null
    private var immediateStartCheckBox: CheckBox? = null
    private var juniorCheckBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        displayNameEditText = findViewById(R.id.edit_text_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)
        immediateStartCheckBox = findViewById(R.id.checkbox_immediate_start)
        juniorCheckBox = findViewById(R.id.checkbox_junior)

        val button = findViewById<Button>(R.id.button_preview)
        button.setOnClickListener {
            val toastMessage = contactNameEditText!!.text.toString() + " " + contactNumberEditText!!.text.toString() + " " + displayNameEditText!!.text.toString()
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

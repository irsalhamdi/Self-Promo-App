package com.irsalhamdi.selfpromoapp

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private var messageText: String? = null
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview)

        displayMessage()
        setupButton()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messageText = """
            Hi ${message.contactName},
            
            My name is ${message.displayName} and I am ${message.getFullJobDescription()}.
            
            I have a portfolio of apps to demonstrate my technical skills that I can show on request.
            
            I am able to start a new position ${message.getAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thank you!
        """.trimIndent()

        findViewById<TextView>(R.id.text_view_message).text = messageText
    }

    private fun setupButton() {
        button = findViewById(R.id.send_message)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "smsto: ${message.contactNumber}".toUri()
                putExtra("sms_body", messageText)
            }
            startActivity(intent)
        }
    }
}

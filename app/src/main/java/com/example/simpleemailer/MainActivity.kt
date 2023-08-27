package com.example.simpleemailer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val sendButton: Button = findViewById(R.id.sendButton)
        val emailTo: String = findViewById<EditText>(R.id.emailAddrEditText).toString()
        val emailMsgText: String = findViewById<EditText>(R.id.emailTextEditText).toString()
        sendButton.setOnClickListener {
            Toast.makeText(this,"Sending message...",Toast.LENGTH_SHORT).show()
            val intentEmailer = Intent(Intent.ACTION_SENDTO)
            intentEmailer.data = Uri.parse("mailto: ${emailTo}")
            intentEmailer.putExtra(Intent.EXTRA_EMAIL, emailMsgText)
            intentEmailer.putExtra(Intent.EXTRA_SUBJECT, "test message from android app")
            startActivity(intentEmailer)
        }

    }
}
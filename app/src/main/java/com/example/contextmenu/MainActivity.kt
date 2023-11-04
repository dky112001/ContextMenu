package com.example.contextmenu

import android.annotation.SuppressLint
import   androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.myButton)
        val popupButton = findViewById<Button>(R.id.popupButton)

        popupButton.setOnClickListener {

        val popupMenu = PopupMenu(this,popupButton)
            popupMenu.menuInflater.inflate(R.menu.menu_list,popupMenu.menu)
            popupMenu.show()

        }

        registerForContextMenu(myButton)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu,menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.home -> {
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                return true

            }

            R.id.call -> {
                Toast.makeText(this, "call", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.setting -> {
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.sms -> {
                Toast.makeText(this, "sms", Toast.LENGTH_SHORT).show()
                return true
            }
        }
            return super.onContextItemSelected(item)
        }

}
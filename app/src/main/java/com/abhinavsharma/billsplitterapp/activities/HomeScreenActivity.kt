package com.abhinavsharma.billsplitterapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.abhinavsharma.billsplitterapp.R
import com.abhinavsharma.billsplitterapp.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private var binding : ActivityHomeScreenBinding? = null
    private var notificationDot : TextView? = null
    private var areNotificationAvailable : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolBarHomeScreenActivity)

        if(supportActionBar != null)
        {
            supportActionBar?.title = "Bill Splitter"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)

        val menuItem = menu?.findItem(R.id.notificationsActionBar)
        val actionView = menuItem?.actionView

        notificationDot = actionView?.findViewById<View>(R.id.bellBadge) as TextView
        setupBadge()

        actionView.setOnClickListener {
            onOptionsItemSelected(menuItem)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.notificationsActionBar -> {

            }
        }
        return true
    }

    private fun setupBadge(){
        if(areNotificationAvailable == true){
            notificationDot?.visibility = View.VISIBLE
        }
        else{
            notificationDot?.visibility = View.GONE
        }
    }
}
package com.followmanager.app.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.followmanager.app.R
import com.followmanager.app.adapters.FollowerAdapter
import com.followmanager.app.api.User
import com.followmanager.app.utils.Utils

class FollowersListActivity : AppCompatActivity() {

    private var usersList: Map<String, User> = mapOf<String,User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers_list)


        usersList = Utils.jsonToMap(intent.getStringExtra("jsonList"))?: usersList
        findViewById<TextView>(R.id.followers_list_title).text = (intent.getStringExtra("title"))

        loadFollowersRecyclerView()
    }


    fun loadFollowersRecyclerView(){
        val recycler = findViewById<RecyclerView>(R.id.followers_recycler)

        recycler.adapter = FollowerAdapter(Utils.mapToArray(usersList))
        recycler.layoutManager = LinearLayoutManager(this)
    }

    fun goBack(v: View?){
        //startActivity(Intent(applicationContext, Dashboard::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }

}
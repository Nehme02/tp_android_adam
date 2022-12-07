package com.example.whateveryouwantagency

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.whateveryouwantagency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsItemClicked {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pAdapter: ProjectListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        pAdapter = ProjectListAdapter(this)
        recyclerView.adapter = pAdapter


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    private fun fetchData() {
        val url="https://6371f432025414c63702192f.mockapi.io/projects"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener{
                val projectJsonArray = it.getJSONArray()
                val projectArray = ArrayList<Projects>()
                for(i in 0 until newjsonArray.length()){
                    val projectJsonObject = newsJsonArray.getJSONObject(i)
                    val project = Projects(
                        projectJsonObject.GetString("image"),
                        projectJsonObject.GetString("title"),
                        projectJsonObject.GetString("description"),
                        projectJsonObject.GetString("date")
                    )
                    projectArray.add(project)
                }

                pAdapter.updateProjects(projectArray)
            }
        )
    }
    override fun onitemClicked(item: Projects) {
        Toast.makeText(this, "clicked item is $item", Toast.LENGTH_LONG.show()
    }
}
package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var modelList : MutableList<Model> = mutableListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        modelDataPrepare()
        val modelAdapter = ModelAdapter(modelList, this@MainActivity)
       val rv =  findViewById<RecyclerView>(R.id.rv)
        rv.adapter =modelAdapter
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun modelDataPrepare() {
        modelList.add(Model("Title 1", "Small Description"))
        modelList.add(
            Model(
                "Title 2",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(
            Model(
                "Title 3",
                "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"
            )
        )
        modelList.add(
            Model(
                "Title 4",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(Model("Title 5", "Small Description"))
        modelList.add(Model("Title 6", "Small Description"))
        modelList.add(
            Model(
                "Title 7",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(
            Model(
                "Title 8",
                "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"
            )
        )
        modelList.add(
            Model(
                "Title 9",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(Model("Title 10", "Small Description"))
        modelList.add(Model("Title 11", "Small Description"))
        modelList.add(
            Model(
                "Title 12",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(
            Model(
                "Title 13",
                "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"
            )
        )
        modelList.add(
            Model(
                "Title 14",
                "Medium Description Medium Description Medium Description Medium Description"
            )
        )
        modelList.add(Model("Title 15", "Small Description"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
package com.ys.essential.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.ys.essential.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var binding: com.ys.essential.databinding.ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MainAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        Timber.d("call onCreate")

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        mainViewModel.getTestPrint()
        mainViewModel.testSavePreference()
        mainViewModel.testGetPreference()

        layoutManager = LinearLayoutManager(this)
        binding.appBarMain.layoutMain.rvMain.layoutManager = layoutManager
        adapter = MainAdapter()
        binding.appBarMain.layoutMain.rvMain.adapter = adapter
    }

    override fun onBackPressed() {
        Timber.d("call onBackPressed")
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                Timber.i("select camera menu")
            }
            R.id.nav_gallery -> {
                Timber.i("select gallery menu")
            }
            R.id.nav_slideshow -> {
                Timber.i("select slideshow menu")
            }
            R.id.nav_manage -> {
                Timber.i("select manage menu")
            }
            R.id.nav_share -> {
                Timber.i("select share menu")
            }
            R.id.nav_send -> {
                Timber.i("select send menu")
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

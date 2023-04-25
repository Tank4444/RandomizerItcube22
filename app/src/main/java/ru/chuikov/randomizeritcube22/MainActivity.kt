package ru.chuikov.randomizeritcube22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.chuikov.randomizeritcube22.databinding.ActivityMainBinding
import ru.chuikov.randomizeritcube22.fragment.history.HistoryFragment
import ru.chuikov.randomizeritcube22.fragment.random.RandomFragment
import ru.chuikov.randomizeritcube22.fragment.settings.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        replaceFragment(RandomFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.input_nav_bar -> replaceFragment(SettingFragment())
                R.id.random_nav_bar -> replaceFragment(RandomFragment())
                R.id.history_nav_bar -> replaceFragment(HistoryFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment)
        fragmentTransition.commit()
    }
}
package com.proway.projeto002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.projeto002.databinding.MainActivityBinding
import com.proway.projeto002.utils.replaceFragment
import com.proway.projeto002.view.RepoListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        settingInitialFrag()
    }

    private fun settingInitialFrag() {
        replaceFragment(fragment = RepoListFragment.newInstance())
    }
}
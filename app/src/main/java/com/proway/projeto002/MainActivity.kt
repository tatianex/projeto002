package com.proway.projeto002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.projeto002.view.RepoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, RepoListFragment.newInstance())
            .commitNow()
    }
}
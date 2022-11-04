package com.catnip.notepadku.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.catnip.notepadku.base.BaseActivity
import com.catnip.notepadku.base.GenericViewModelFactory
import com.catnip.notepadku.data.room.AppDatabase
import com.catnip.notepadku.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: MainViewModel by lazy {
        GenericViewModelFactory(MainViewModel()).create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.doSomeWork()
        lifecycleScope.launch {
            val notes = AppDatabase.getInstance(this@MainActivity).notesDao().getAllNotes()
            Toast.makeText(this@MainActivity, notes.size.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}
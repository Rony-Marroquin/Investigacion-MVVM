package edu.udb.sv.investigacionmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.udb.sv.investigacionmvvm.databinding.ActivityMainBinding
import edu.udb.sv.investigacionmvvm.viewmodel.MessageViewModel

import edu.udb.sv.investigacionmvvm.R

class MainActivity : AppCompatActivity() {

    //Data binding para vicular los datos entre la vista y el viewmodel

    private lateinit var binding: ActivityMainBinding
    private lateinit var messageViewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageViewModel = ViewModelProvider(this).get(MessageViewModel::class.java)

        messageViewModel.messageLiveData.observe(this, Observer {
            binding.messageTextView.text = it.message
        })
            //listener para que salga hola mundo cada vez que se aprete
        binding.getMessageButton.setOnClickListener {
            messageViewModel.getMessage()
        }
    }
}
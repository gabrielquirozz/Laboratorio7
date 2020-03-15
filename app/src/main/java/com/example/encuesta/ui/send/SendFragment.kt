package com.example.encuesta.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.encuesta.R
import com.example.encuesta.variable
import kotlinx.android.synthetic.main.fragment_send.*

class SendFragment : Fragment() {
    private val llamarvariable by lazy { ViewModelProviders.of(activity!!).get(variable::class.java)
    }

    private lateinit var sendViewModel: SendViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =ViewModelProviders.of(this).get(SendViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ponerrespuestas.text = llamarvariable.mutablerespuestas.toString()
        super.onViewCreated(view, savedInstanceState)
    }
}
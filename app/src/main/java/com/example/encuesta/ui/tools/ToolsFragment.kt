package com.example.encuesta.ui.tools

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.encuesta.R
import com.example.encuesta.variable
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_tools.*
import kotlinx.android.synthetic.main.fragment_tools.view.*

class ToolsFragment : Fragment() {
    private val llamarvariable by lazy {
        ViewModelProviders.of(activity!!).get(variable::class.java)
    }

    private var root: View? = null


    private lateinit var toolsViewModel: ToolsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        toolsViewModel =
            ViewModelProviders.of(this).get(ToolsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tools, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sumatoriaencuesta.text = llamarvariable.contadorencuestas.toString()

        ratingdado.text = llamarvariable.calificacionfinal.toString()
       // concatenarrespuestas.setOnClickListener{
            //Toast.makeText(activity, llamarvariable.mutablerespuestas.toString(), Toast.LENGTH_LONG).show()

        //}
        concatenarrespuestas.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_tools_to_nav_send))
        nuevaencuesta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_tools_to_nav_slideshow))


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menuencuestas, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item!!.itemId
        if (id == R.id.eliminarencuestas) {
            llamarvariable.calificacionfinal = "0"
            llamarvariable.contadorencuestas = 0
            Toast.makeText(activity,"ElIMINADO", Toast.LENGTH_LONG).show()

        }
        else if (id ==R.id.eliminarpreguntas){
            llamarvariable.mutablepreguntas.clear()
            Toast.makeText(activity,"ElIMINADO", Toast.LENGTH_LONG).show()


        }
        else{
            llamarvariable.mutablerespuestas.clear()
            Toast.makeText(activity,"ElIMINADO", Toast.LENGTH_LONG).show()

        }
            //findNavController().navigate((R.id.action_nav_gallery_to_nav_home))
            //val action = GalleryFragmentDirections.actionNavGalleryToNavHome(ingresadaagregada.text.toString())

        return super.onOptionsItemSelected(item)
    }




}
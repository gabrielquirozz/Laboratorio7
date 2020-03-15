package com.example.encuesta.ui.gallery

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.encuesta.R
import com.example.encuesta.ui.slideshow.SlideshowFragmentArgs
import com.example.encuesta.ui.slideshow.SlideshowFragmentDirections
import com.example.encuesta.variable
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private var root: View? = null
    private lateinit var galleryViewModel: GalleryViewModel
    private val llamarvariable by lazy {
        ViewModelProviders.of(activity!!).get(variable::class.java)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tipopreguntas = arrayOf("Texto", "Numero", "Rating")
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }



    override fun onCreate(savedInstanceState: Bundle?) {


        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menuguardar, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item!!.itemId
        if (id == R.id.guardar) {
            llamarvariable.mutablepreguntas.add(ingresadaagregada.text.toString())
            findNavController().navigate((R.id.action_nav_gallery_to_nav_home))
            //val action = GalleryFragmentDirections.actionNavGalleryToNavHome(ingresadaagregada.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }


}
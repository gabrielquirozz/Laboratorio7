package com.example.encuesta.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.encuesta.R
import com.example.encuesta.variable
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowFragment : Fragment() {


    private val llamarvariable by lazy {
        ViewModelProviders.of(activity!!).get(variable::class.java)
    }

    var estado = true
    var contador =0
    var contadorfinales =0
    var contadorrespuestas =1
    private var root: View? = null
    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        if (llamarvariable.mutablepreguntas.size == 0){
            preguntatoca.text = llamarvariable.mutablepreguntasfinales.get(contadorfinales)
            contadorfinales++
        }
        else{
            preguntatoca.text = llamarvariable.mutablepreguntas.get(contador)
            contador++

        }

            ratingBarcalificar.setVisibility(View.INVISIBLE)

        if (estado ==false){



        }







        cambiarpregunta.setOnClickListener{

            if (contador < llamarvariable.mutablepreguntas.size) {
                preguntatoca.text = llamarvariable.mutablepreguntas.get(contador)
                contador++
                llamarvariable.mutablerespuestas.add("Pregunta"+contadorrespuestas)
                llamarvariable.mutablerespuestas.add(respuestaescrita.text.toString())
                contadorrespuestas++
            }



            else if (contadorfinales <2){
                if (contadorfinales ==1){
                    ratingBarcalificar.setVisibility(View.VISIBLE)
                    respuestaescrita.setVisibility(View.INVISIBLE)
                    textView3.setVisibility(View.INVISIBLE)
                }
                preguntatoca.text = llamarvariable.mutablepreguntasfinales.get(contadorfinales)
                contadorfinales++
                llamarvariable.mutablerespuestas.add("Pregunta"+contadorrespuestas)
                llamarvariable.mutablerespuestas.add(respuestaescrita.text.toString())
                contadorrespuestas++


            }


            else{
                llamarvariable.contadorencuestas++
                llamarvariable.calificacionfinal = ((llamarvariable.calificacionfinal.toFloat()+ratingBarcalificar.rating) / llamarvariable.contadorencuestas).toString()


                findNavController().navigate(R.id.Respuestas)

            }
        }


         //   preguntatoca.text = (mutablepreguntas.get(0))



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item!!.itemId
        if (id == R.id.guardar){
         //   arguments?.let {
           //     val args = HomeFragmentArgs.fromBundle(it)
             //   args.preguntahome
               // llamarvariable.mutablepreguntas.add(args.preguntahome)
                //preguntatoca.text= args.preguntatoca
            //}

        }
        return super.onOptionsItemSelected(item)
    }



}
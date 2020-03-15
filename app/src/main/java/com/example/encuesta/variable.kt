package com.example.encuesta

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

class variable : ViewModel() {

    


    val mutablepreguntas = mutableListOf<String>()
    val mutablepreguntasfinales = mutableListOf<String>( "¿Tiene algún comentario o sugerencia?", "¿Qué le pareció nuestro servicio?")
    val mutablerespuestas = mutableListOf<String>()
    var calificacionfinal ="0"

    var contadorencuestas =0


}
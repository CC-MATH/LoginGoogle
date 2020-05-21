package mx.uv.musicaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.uv.musicaapp.R

class MiAdaptador (micontexto: Context) : BaseAdapter(){

    private val miContexto : Context

    private val listComidas = arrayListOf<String>(
        "Albóndigas", "Arroz frito", "Burrito", "Canelones"
    )

    private val listaCalorias = arrayListOf<String>(
        "202 kcal", "186 kcal", "163 kcal", "153 kcal"
    )

    init {
        miContexto = micontexto
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(miContexto)
        val rowMain = layoutInflater.inflate(R.layout.fila_lista_main, parent, false)
        val nombreComida = rowMain.findViewById<TextView>(R.id.nombre_comida)
        nombreComida.text = listComidas.get(position)

        val calorias = rowMain.findViewById<TextView>(R.id.nombre_calorias)
        val nombreCalorias = rowMain.findViewById<TextView>(R.id.nombre_calorias)

        return rowMain

        /*val cajita_texto = TextView(miContexto)
        cajita_texto.text = "Cajita de texto"
        return cajita_texto*/
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return listComidas.size
    }



}
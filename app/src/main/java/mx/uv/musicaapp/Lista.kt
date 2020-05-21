package mx.uv.musicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import mx.uv.musicaapp.adapters.MiAdaptador

class Lista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val cuenta_email = intent.getStringExtra("cuenta")
        val cuenta_id =  intent.getStringExtra("cuenta_id")

        val cuentaUsuario = findViewById<TextView>(R.id.cuenta_usuario)
        val lista = findViewById<ListView>(R.id.main_listview)


        cuentaUsuario.text = cuenta_email + ", " + cuenta_id

        lista.adapter = MiAdaptador(this)
        lista.setOnItemClickListener { parent, view, position, id ->
            milistaItemClicked(position)
        }
    }

    fun milistaItemClicked(position: Int){
        Toast.makeText(this,"Item $position Clicked!!", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Reproductor::class.java).apply{
            putExtra("posicion",position)
        }
        this.startActivity(intent)
    }
}

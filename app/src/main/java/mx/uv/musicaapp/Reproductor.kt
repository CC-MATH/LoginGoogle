package mx.uv.musicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Reproductor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor)

        val message = intent.getIntExtra("posicion",-1)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Esta es la actividad del item $message"

    }
}

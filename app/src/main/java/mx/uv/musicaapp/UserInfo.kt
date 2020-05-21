package mx.uv.musicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.w3c.dom.Text

class UserInfo : AppCompatActivity() {

    lateinit var mGoogleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val sign_out = findViewById<Button>(R.id.sign_out)
        val nombre = findViewById<TextView>(R.id.user_nombre)
        val email = findViewById<TextView>(R.id.user_email)
        val id = findViewById<TextView>(R.id.user_id)
        val photo = findViewById<ImageView>(R.id.user_photo)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val acc = GoogleSignIn.getLastSignedInAccount(this)
        if(acc != null){
            nombre.setText(acc.displayName.toString())
            email.setText(acc.email.toString())
            id.setText(acc.id)
            Glide.with(this).load(acc.photoUrl).into(photo )
        }


        sign_out.setOnClickListener{parent -> signOut()}
    }

    private fun signOut(){
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this, {
            Toast.makeText(this,"Ya no estás registrado!", Toast.LENGTH_SHORT).show()
                val i = Intent (this, Login::class.java)
                this.startActivity(i)
                finish()

        })
    }

}

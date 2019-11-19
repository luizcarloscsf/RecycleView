package cesar.devapps.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonConfirm = findViewById<Button>(R.id.button_confirm)
        val buttonCancel = findViewById<Button>(R.id.button_cancel)

        buttonConfirm.setOnClickListener {

            val intent = Intent(this, RecyclerViewActivity::class.java)
            val editLogin = findViewById<EditText>(R.id.edit_login)
            val loginValue = editLogin.text.toString()
            intent.putExtra("loginOk",loginValue)
            startActivity(intent)
        }

        buttonCancel.setOnClickListener {
            finish()
        }
    }
}

package cesar.devapps.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    val TAG = "log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_data)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_data)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(mutableListOf<User>())
        recyclerView.adapter = adapter
        val textLogin = findViewById<TextView>(R.id.login_data)
        textLogin.text = intent.getStringExtra("loginOk")
        val fabButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fabButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            builder.setTitle("Novo usuário")
            val dialogLayout = inflater.inflate(R.layout.edit_text, null)

            val editTextName = dialogLayout.findViewById<EditText>(R.id.editTextName)
            val editTextCPF = dialogLayout.findViewById<EditText>(R.id.editTextCPF)

            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") {
                dialogInterface, i ->
                val user = User(editTextName.text.toString(), editTextCPF.text.toString())
                adapter.addUser(user)
            }
        builder.show()
        Log.d(TAG, "Clicou no fab")
        }
    }
}

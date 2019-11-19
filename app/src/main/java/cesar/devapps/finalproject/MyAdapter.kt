package cesar.devapps.finalproject

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cesar.devapps.finalproject.R.layout.edit_text
import kotlinx.android.synthetic.main.edit_text.view.*

class MyAdapter (private  val users: MutableList<User>): RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_line_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {    return users.size    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]

        holder?.let {
            holder.title.text = user.name
            holder.cpf.text = user.cpf
            holder.delete.setOnClickListener {
                users.removeAt(position)
                notifyItemRemoved(position)
            }

        holder.update.setOnClickListener {
            val dialogLayout = LayoutInflater.from(holder.itemView.context).inflate(edit_text, null)
            val builder = AlertDialog.Builder(holder.itemView.context)

            builder.setView(dialogLayout)
            builder.setTitle("atualizar registro")
            builder.setPositiveButton("OK"){
                    dialogInterface: DialogInterface, i: Int ->
                var nameValue =  dialogLayout.editTextName.text.toString()
                var cpfValue =  dialogLayout.editTextCPF.text.toString()
                val user = User(nameValue,cpfValue)
                users.set(position,user)
                notifyItemChanged(position)
            }
            builder.show()
            }
        }
    }

    fun addUser(user:User){
        users.add(user)
        notifyItemInserted(itemCount)
        Log.w("check","funcao addUser ${user.name}")
    }
}





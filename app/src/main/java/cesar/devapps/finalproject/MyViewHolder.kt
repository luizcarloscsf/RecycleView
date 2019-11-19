package cesar.devapps.finalproject

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_line_view.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var title: TextView = itemView.item_title
    var cpf: TextView = itemView.item_cpf
    var delete: ImageButton = itemView.findViewById(R.id.button_delete)
    var update: ImageButton = itemView.findViewById(R.id.button_update)
}

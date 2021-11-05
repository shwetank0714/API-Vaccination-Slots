package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vaccinationslots.R
import cowinData.Session

class RecyclerViewAdapter(private val listItems: List<Session>?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val viewOne = itemView.findViewById<TextView>(R.id.one)!!
        val viewTwo = itemView.findViewById<TextView>(R.id.two)!!
        val viewThree = itemView.findViewById<TextView>(R.id.three)!!
        val viewFour = itemView.findViewById<TextView>(R.id.four)!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.viewOne.text = listItems!![position].date
        holder.viewTwo.text = listItems[position].district_name
        holder.viewThree.text = listItems[position].vaccine
        holder.viewFour.text = listItems[position].name
    }

    override fun getItemCount(): Int {
        if (listItems != null) {
            return listItems.size
        }
        return 0
    }
}
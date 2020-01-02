package com.example.projetkotlindam2019.classes
import android.content.Intent
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.activity.CarInfoActivity
import com.example.projetkotlindam2019.activity.MainActivity
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.startActivity


class MercedesCardAdapter(val mercedesList : ArrayList<Car>) : RecyclerView.Adapter<MercedesCardAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()

                val intent = Intent(v.context,CarInfoActivity::class.java)
                intent.putExtra("pos",position)
                intent.putParcelableArrayListExtra("list",mercedesList )

                v.context.startActivity(intent)

                Snackbar.make(v, "Click detected on item $position",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return mercedesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = mercedesList[position].nom
        holder.itemDetail.text = mercedesList[position].marque
        holder.itemImage.setImageResource(mercedesList[position].image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_mercedescard, parent, false)
        return ViewHolder(v)
    }

}
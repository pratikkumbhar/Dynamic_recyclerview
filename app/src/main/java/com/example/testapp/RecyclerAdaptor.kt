package com.example.testapp

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.Retrofit.DataModelX
import com.example.testapp.Retrofit.Trn

class RecyclerAdaptor(private val list: List<Trn>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    class PortViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nametextview : TextView = itemView.findViewById(R.id.nameTextviwe);
        val slugtextview :  TextView = itemView.findViewById(R.id.slugTextviwe);
        val statustextview :  TextView = itemView.findViewById(R.id.statusTextviwe);
        val imageview : ImageView = itemView.findViewById(R.id.imageview)
    }class LandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nametextview : TextView = itemView.findViewById(R.id.landtext);

        val imageview : ImageView = itemView.findViewById(R.id.landimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(context.resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            return  LandViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.iteminlandscape, parent, false));
        }
        return  PortViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false));

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if(holder is PortViewHolder) {
            holder.nametextview.text = list[position].name.toString();
            holder.slugtextview.text = list[position].slug.toString();
            holder.statustextview.text = list[position].status.toString()
            val img = list.get(position).img
            if (img != null) {
                Glide.with(context).load(img).into(holder.imageview);

            }
        }
        else if (holder is LandViewHolder)
        {
            holder.nametextview.text = list[position].name.toString()
            val img = list.get(position).img
            if (img != null) {
                Glide.with(context).load(img).into(holder.imageview);

            }
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

}



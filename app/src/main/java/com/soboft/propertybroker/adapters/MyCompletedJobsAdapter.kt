package com.soboft.propertybroker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.soboft.propertybroker.R
import com.soboft.propertybroker.model.CompletedJobsAssignList

class MyCompletedJobsAdapter(var from: String, var list: List<CompletedJobsAssignList>, var itemClickListener : OnItemClickListener)
    : RecyclerView.Adapter<MyCompletedJobsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_completed_jobs_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.propertyName.text = currentItem.userName
        holder.date.text = currentItem.jobVisitingDate
        holder.time.text = currentItem.jobVisitingTime
        holder.rating.text = currentItem.averageRatting.toString()
        holder.jobstatus.text = currentItem.statusName

        holder.rootLayout.setOnClickListener {
            itemClickListener.onItemClick(position,list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val propertyName: TextView = itemView.findViewById(R.id.name)
        val date : TextView = itemView.findViewById(R.id.date)
        val time : TextView = itemView.findViewById(R.id.time)
        val rootLayout: CardView = itemView.findViewById(R.id.rootLayout)
        val jobstatus : TextView = itemView.findViewById(R.id.jobStatus)
        val ratingLayout: LinearLayout = itemView.findViewById(R.id.ratingLayout)
        val rating : TextView = itemView.findViewById(R.id.myRating)
    }

    interface OnItemClickListener{
        fun onItemClick(itemPosition : Int,data : CompletedJobsAssignList)
    }
}
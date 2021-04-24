package com.illopen.agent.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illopen.agent.R
import com.illopen.agent.databinding.UserLanguageListBinding
import com.illopen.agent.model.AllJobLanguageList
import com.illopen.agent.model.SelectedLanguageModel

class AllJobLanguagesAdapter(var context: Context, var list: ArrayList<SelectedLanguageModel>) : RecyclerView.Adapter<AllJobLanguagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_language_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val views = holder.binding
        val currentItem = list[position]

        if (currentItem.isSelected!!) {
            views.userLanguage.text = currentItem.languageName + " 1"
        } else {
            views.userLanguage.text = currentItem.languageName + " 0"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding  = UserLanguageListBinding.bind(itemView)
    }
}
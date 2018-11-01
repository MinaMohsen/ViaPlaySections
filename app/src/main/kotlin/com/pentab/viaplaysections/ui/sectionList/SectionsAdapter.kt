package com.pentab.viaplaysections.ui.sectionList

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pentab.viaplaysections.R
import com.pentab.viaplaysections.data.entities.Section
import com.pentab.viaplaysections.ui.sectiondetails.SectionDetailsActivity
import kotlinx.android.synthetic.main.section_list_item.view.*


/*
 * SectionsAdapter is the adapter that shows the sections.
 */
class SectionsAdapter : RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

   private val dataSet = ArrayList<Section>()

    fun add(items: List<Section>) {
        dataSet.addAll(items)
        notifyItemRangeInserted(dataSet.size - items.size, items.size)
    }

    fun clear() {
        dataSet.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.section_list_item,
            parent, false
        )
        return SectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.updateView(dataSet[position])
    }

    inner class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            itemView.section_name_textView.setOnClickListener {
                val intent = Intent(itemView.context, SectionDetailsActivity::class.java)
                intent.putExtra("item", dataSet[adapterPosition])
                itemView.context.startActivity(intent)
            }
        }

        fun updateView(data: Section) {
            updateTitle(data)
        }

        private fun updateTitle(section: Section) {
            itemView.section_name_textView.text = section.title
        }


    }

}
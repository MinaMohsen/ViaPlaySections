package com.pentab.viaplaysections.ui.sectiondetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pentab.viaplaysections.R
import com.pentab.viaplaysections.data.entities.Section
import kotlinx.android.synthetic.main.activity_section_details.*

/*
 * SectionDetailsActivity for section details.
 */
class SectionDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section_details)

        val section = intent.getParcelableExtra<Section>("item")

        section_title_textView.text = section.sectionTitle
        section_desc_textView.text = section.sectionDesc

    }
}
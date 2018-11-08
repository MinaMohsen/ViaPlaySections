package com.pentab.viaplaysections.ui.sectionList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pentab.viaplaysections.Injection
import com.pentab.viaplaysections.R
import com.pentab.viaplaysections.data.entities.Section
import kotlinx.android.synthetic.main.activity_sections.*

/*
 * SectionsActivity for sections list.
 */
class SectionsActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var sectionsAdapter: SectionsAdapter
    private lateinit var sectionsViewModel: SectionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sections)

        sectionsViewModel = ViewModelProviders.of(
            this,
            Injection.provideViewModelFactory(this)
        ).get(SectionsViewModel::class.java)

        sectionsAdapter = SectionsAdapter()

        sections_container.setOnRefreshListener(this@SectionsActivity)

        val linearLayoutManager = LinearLayoutManager(
            this@SectionsActivity,
            RecyclerView.VERTICAL, false
        )

        sections_ListView.layoutManager = linearLayoutManager
        sections_ListView.adapter = sectionsAdapter

        observeData()

        requestSections()
    }

    private fun observeData() {
        sectionsViewModel.getLoading()
            .observe(this, Observer { it?.let { updateRefreshLayout(it) } })

        sectionsViewModel.getSections()
            .observe(this, Observer { it?.let { updateUI(it) } })
    }

    private fun updateUI(sections: List<Section>) {
        showEmptyList(sections.isEmpty())
        sectionsAdapter.add(sections)
    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            empty_list.visibility = View.VISIBLE
            sections_ListView.visibility = View.GONE
        } else {
            empty_list.visibility = View.GONE
            sections_ListView.visibility = View.VISIBLE
        }
    }

    private fun updateRefreshLayout(isRefreshing: Boolean) {
        this.sections_container.isRefreshing = isRefreshing
    }

    private fun requestSections() {
        sectionsViewModel.requestSections()
    }

    override fun onRefresh() {
        sectionsAdapter.clear()
        requestSections()
    }
}

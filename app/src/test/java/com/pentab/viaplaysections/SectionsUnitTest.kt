package com.pentab.viaplaysections

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.pentab.viaplaysections.base.BaseTest
import com.pentab.viaplaysections.ui.sectionList.SectionsViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.net.HttpURLConnection
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SectionsUnitTest : BaseTest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var activity: FragmentActivity
    private lateinit var viewModel: SectionsViewModel
    private val EXPECTED_SECTIONS_SIZE = 7

    override fun isMockServerEnabled() = true

    @Before
    override fun setUp() {
        super.setUp()
        this.activity = Robolectric.setupActivity(FragmentActivity::class.java)
        this.viewModel = ViewModelProviders.of(this.activity, viewModelFactory)[SectionsViewModel::class.java]
    }

    @Test
    fun getSections_whenSuccess() {

        this.mockHttpResponse(
            "getSections_whenSuccess.json",
            HttpURLConnection.HTTP_OK
        )

        assertEquals(
            null, this.viewModel.sectionsData.value,
            "Sections should be null because stream not started yet"
        )

        this.viewModel.requestSections()

        assertEquals(
            EXPECTED_SECTIONS_SIZE, this.viewModel.sectionsData.value?.size,
            "Sections must be fetched"
        )
        assertEquals(
            false, this.viewModel.isLoading.value,
            "Should be reset to 'false' because stream ended"
        )
    }

    @Test
    fun getSections_whenNoData() {
        this.mockHttpResponse(
            "getSections_whenSuccess.json",
            HttpURLConnection.HTTP_BAD_GATEWAY
        )
        assertEquals(
            null, this.viewModel.sectionsData.value,
            "Sections should be null because stream not started yet"
        )

        this.viewModel.requestSections()

        assertEquals(
            0, this.viewModel.sectionsData.value?.size,
            "Sections must be empty because of no data"
        )
        assertEquals(
            false, this.viewModel.isLoading.value,
            "Should be reset to 'false' because stream ended"
        )

    }

}
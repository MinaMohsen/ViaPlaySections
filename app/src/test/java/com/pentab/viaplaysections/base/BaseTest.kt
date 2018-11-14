package com.pentab.viaplaysections.base

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.pentab.viaplaysections.BuildConfig
import com.pentab.viaplaysections.di.DaggerTestAppComponent
import com.pentab.viaplaysections.di.TestAppComponent
import com.pentab.viaplaysections.di.TestRxJavaModule
import com.pentab.viaplaysections.di.module.NetModule
import com.pentab.viaplaysections.di.module.RepositoryModule
import com.pentab.viaplaysections.ui.ViewModelFactory
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.Before
import org.robolectric.RuntimeEnvironment
import java.io.File
import javax.inject.Inject
import kotlin.test.AfterTest

abstract class BaseTest {

    lateinit var testAppComponent: TestAppComponent
    lateinit var mockServer: MockWebServer
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var context: Context


    @Before
    open fun setUp() {
        context = RuntimeEnvironment.application.applicationContext
        this.configureMockServer()
        this.configureDi()
    }

    @AfterTest
    open fun tearDown() {
        this.stopMockServer()
    }

    open fun configureDi() {
        this.testAppComponent = DaggerTestAppComponent.builder()
            .netModule(NetModule(if (isMockServerEnabled()) mockServer.url("/").toString() else BuildConfig.baseURL))
            .repositoryModule(RepositoryModule(context))
            .testRxJavaModule(TestRxJavaModule())
            .build()
        this.testAppComponent.inject(this)
    }

    abstract fun isMockServerEnabled(): Boolean

    open fun configureMockServer() {
        if (isMockServerEnabled()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun stopMockServer() {
        if (isMockServerEnabled()) {
            mockServer.shutdown()
        }
    }


    open fun mockHttpResponse(fileName: String, responseCode: Int) =
        mockServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}
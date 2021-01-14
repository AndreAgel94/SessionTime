package com.andre.agel.sessiontime.resources.base

import com.andre.agel.sessiontime.data.network.TmdbServices
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

abstract class BaseTest {

    private lateinit var mMockServerInstance: MockWebServer
    private var mShouldStart = false

    open fun setUp() {
        starMockServer()
    }

    fun mockNetworkResponseWithFileContent(fileName: String, responseCode: Int) =
        mMockServerInstance.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    private fun getJson(path: String): String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    private fun starMockServer() {
        mMockServerInstance = MockWebServer()
        mMockServerInstance.start()
    }

    private fun getMockWebServerUrl() = mMockServerInstance.url("/").toString()

    fun createApi(): TmdbServices {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(getMockWebServerUrl())
            .build()
            .create(TmdbServices::class.java)
    }


    private fun stopMockServer() {
        if (mShouldStart)
            mMockServerInstance.shutdown()
    }

    open fun tearDown() {
        stopMockServer()
    }
}
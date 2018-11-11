//package com.pentab.viaplaysections.data.api
//
//import com.pentab.viaplaysections.BuildConfig
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
///**
// * Retrofit Service Factory that return the ViaPlayService Api Service
// */
//class ViaPlayServiceFactory {
//
//    companion object {
//        fun getViaPlayService(): ViaPlayService {
//            val logger = HttpLoggingInterceptor()
//            logger.level = HttpLoggingInterceptor.Level.BASIC
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(logger)
//                .build()
//
//            return Retrofit.Builder().baseUrl(BuildConfig.baseURL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ViaPlayService::class.java)
//        }
//    }
//
//}
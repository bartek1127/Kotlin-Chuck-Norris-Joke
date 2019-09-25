package com.bartek.chucknorris

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule() {

    @Provides
    @Reusable
    internal fun provideGson(): GsonConverterFactory {
        return GsonConverterFactory.create( Gson() )
    }

    @Provides
    @Reusable
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout( 30, TimeUnit.SECONDS )
            .build()
    }

    @Provides
    @Reusable
    internal fun provideRetrofit(gson: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://api.chucknorris.io/" )
            .addConverterFactory( gson )
            .client( okHttpClient )
            .addCallAdapterFactory( RxJava2CallAdapterFactory.createWithScheduler( Schedulers.io() ) )
            .build()
    }

    @Provides
    @Reusable
    internal fun provideApiService( retrofit: Retrofit): ApiService {
        return retrofit.create( ApiService::class.java )
    }

}
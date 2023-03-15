package com.example.rushandroid.di.module

import android.content.Context
import com.example.rushandroid.data.remote.MyApiService
import com.example.rushandroid.data.remote.RemoteDataSource
import com.example.rushandroid.data.remote.ServiceAPI
import com.example.rushandroid.data.repository.LoginRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()
    @Singleton
    @Provides
    @Named("retrofitWhatEverAPI")
    fun providesWhatEverAPI(gson: Gson, api: MyApiService,
                                          provideOkHttpClient: OkHttpClient
    ) : Retrofit = Retrofit.Builder()
        .baseUrl(api.baseUrl)
        .client(provideOkHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideMyApiService(): MyApiService = MyApiService()

    @Provides
    fun provideprovidesWhatEverAPIRetrofitService(@Named("retrofitWhatEverAPI")retrofit: Retrofit): ServiceAPI = retrofit.create(ServiceAPI::class.java)

    @Singleton
    @Provides
    fun provideprovidesWhatEverAPIRepository(remoteDataSource: RemoteDataSource) = LoginRepository(remoteDataSource)


}
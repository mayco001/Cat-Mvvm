package com.mayco.catmvvm.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mayco.catmvvm.network.response.ApiService
import com.mayco.catmvvm.ultils.Constant.BASE_URL
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// val applicationModulo = module {
//    single { provideHttpLoggingInterceptor() }
//    single { provideOkHttp(get()) }
//    single { provideRetrofit(get()) }
// }
//
// val viewModelModule = module {
//    viewModel { HomeViewModel(get()) }
// }
//
// val repositoryModule = module {
//    factory { CatsRepository(get()) }
// }

@InstallIn()
object Module {

    @Singleton
    @Provides
    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    private fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            addInterceptor(httpLoggingInterceptor)
        }
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    private fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}

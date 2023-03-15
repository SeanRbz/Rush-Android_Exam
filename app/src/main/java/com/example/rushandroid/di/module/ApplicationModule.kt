package com.example.rushandroid.di.module

import android.content.Context
import com.example.rushandroid.data.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
    @Singleton
    @Provides
    fun providLoginRepository(firestore: FirebaseFirestore) =
        LoginRepository(firestore)

}
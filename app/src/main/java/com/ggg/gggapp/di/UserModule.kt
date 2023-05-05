package com.ggg.gggapp.di

import com.ggg.gggapp.repository.UserRepository
import com.ggg.gggapp.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    @Named("userService")
    fun provideAuthService(@Named("retrofit") retrofit : Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    @Named("userRepository")
    fun provideRepository(@Named("userService") service: UserService): UserRepository =
        UserRepository(service)
}
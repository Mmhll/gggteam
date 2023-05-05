package com.ggg.gggapp.di

import com.ggg.gggapp.repository.AuthRepository
import com.ggg.gggapp.service.AuthenticationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthorizationModule {

    @Provides
    @Singleton
    @Named("authenticationService")
    fun provideAuthService(@Named("retrofit") retrofit : Retrofit): AuthenticationService =
        retrofit.create(AuthenticationService::class.java)

    @Provides
    @Singleton
    @Named("authenticationRepository")
    fun provideRepository(@Named("authenticationService") service: AuthenticationService): AuthRepository =
        AuthRepository(service)


    // Получение токена из хранилища SharedPreference
/*    @Provides
    @Named("Token")
    fun provideGetToken(@ApplicationContext context : Context) : String {
        var token = ""
        while(token == ""){
            token = context
                .getSharedPreferences("settings", Context.MODE_PRIVATE)
                .getString("token", "")
                .toString()
        }
        return token
    }*/
}
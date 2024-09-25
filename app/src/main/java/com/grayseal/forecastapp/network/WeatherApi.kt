package com.grayseal.forecastapp.network

import com.grayseal.forecastapp.model.Weather
import com.grayseal.forecastapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


// To prevent creation of different instances of itself
@Singleton
interface WeatherApi {
    @GET(value = "data/3.0/onecall")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = Constants.API_KEY
    ): Weather
}
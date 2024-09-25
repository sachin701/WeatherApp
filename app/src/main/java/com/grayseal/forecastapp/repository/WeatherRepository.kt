package com.grayseal.forecastapp.repository

import android.util.Log
import com.grayseal.forecastapp.data.DataOrException
import com.grayseal.forecastapp.model.Weather
import com.grayseal.forecastapp.network.WeatherApi
import javax.inject.Inject

/*To allow getting the weather data from the WeatherAPI*/
class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(
        latQuery: Double,
        lonQuery: Double,
    ): DataOrException<Weather, Boolean, Exception> {

        Log.e("weatherdatalon"," $lonQuery   $latQuery")

        val response = try {
            api.getWeather(lat = latQuery, lon = lonQuery)
      } catch (e: Exception) {
            return DataOrException(e = e)
        }

        Log.e("weatherdatares","$response")
        return DataOrException(data = response)
    }
}
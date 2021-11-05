package interfaceAPI

import cowinData.CowinData
import cowinData.Session
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FetchSlots {

    // Link: https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=110001&date=31-03-2021

    @GET("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin")
    fun getData(@Query("pincode") pinText:String,
                @Query("date") dateText:String) : Call<CowinData>
}
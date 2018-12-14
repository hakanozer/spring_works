package com.calisma.retrofitusing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
	
	@GET("product.php")
	Call<JsonData> urunGetir(@Query("ref") String ref, @Query("start") String start);

}

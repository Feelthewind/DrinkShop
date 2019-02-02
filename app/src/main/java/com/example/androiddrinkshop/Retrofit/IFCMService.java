package com.example.androiddrinkshop.Retrofit;

import com.example.androiddrinkshop.Model.DataMessage;
import com.example.androiddrinkshop.Model.MyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers(
    {
        "Content-Type:application/json",
        "Authorization:key=AAAA-sUWUZ8:APA91bHCvB0VFYQWGqV-lqGYM6cyewj4-IVh1hsqaHO9fYBCGAPOItp0PB4Wab1DXnhDbjOkT29aboSyItlqAA-25IICR6jVFw0HJi1LHBTL6kUNWE0cUW28BC6BDFs3HsjEtj14NfbI"
    }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body DataMessage body);
}

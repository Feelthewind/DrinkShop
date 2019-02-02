package com.example.androiddrinkshop.Utils;

import com.example.androiddrinkshop.Database.DataSource.CartRepository;
import com.example.androiddrinkshop.Database.DataSource.FavoriteRepository;
import com.example.androiddrinkshop.Database.Local.EDMTRoomDatabase;
import com.example.androiddrinkshop.Model.Category;
import com.example.androiddrinkshop.Model.Drink;
import com.example.androiddrinkshop.Model.Order;
import com.example.androiddrinkshop.Model.User;
import com.example.androiddrinkshop.Retrofit.FCMClient;
import com.example.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.androiddrinkshop.Retrofit.IFCMService;
import com.example.androiddrinkshop.Retrofit.RetrofitClient;
import com.example.androiddrinkshop.Retrofit.RetrofitScalarsClient;

import java.util.ArrayList;
import java.util.List;

public class Common {
    // In Emulator, localhost = 10.0.2.2
    public static final String BASE_URL = "http://10.0.2.2/drinkshop/";
    public static final String API_TOKEN_URL = "http://10.0.2.2/drinkshop/braintree/main.php";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;
    public static Order currentOrder = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingPrice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();

    //Hold field
    public static int sizeOfCup = -1; // -1 : no choice (error), 0 : M, 1 : L
    public static int sugar = -1; // -1 : no choice (error)
    public static int ice = -1; //

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }

    public static IDrinkShopAPI getScalarAPI()
    {
        return RetrofitScalarsClient.getScalarsClient(BASE_URL).create(IDrinkShopAPI.class);
    }

    //Database
    public static EDMTRoomDatabase edmtRoomDatabase;
    public static CartRepository cartRepository;
    public static FavoriteRepository favoriteRepository;

    private static final String FCM_API = "https://fcm.googleapis.com/";

    public static IFCMService getFCMService()
    {
        return FCMClient.getClient(FCM_API).create(IFCMService.class);
    }

    public static String convertCodeToStatus(int orderStatus) {
        switch (orderStatus)
        {
            case 0:
                return "Placed";
            case 1:
                return "Processing";
            case 2:
                return "Shipping";
            case 3:
                return "Shipped";
            case -1:
                return "Cancelled";
                default:
                    return "Order Error";
        }
    }
}

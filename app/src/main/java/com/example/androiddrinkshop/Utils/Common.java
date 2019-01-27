package com.example.androiddrinkshop.Utils;

import com.example.androiddrinkshop.Model.Category;
import com.example.androiddrinkshop.Model.Drink;
import com.example.androiddrinkshop.Model.User;
import com.example.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.androiddrinkshop.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {
    // In Emulator, localhost = 10.0.2.2
    private static final String BASE_URL = "http://10.0.2.2/drinkshop/";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;

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
}

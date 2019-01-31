package com.example.androiddrinkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.androiddrinkshop.Adapter.OrderAdapter;
import com.example.androiddrinkshop.Model.Order;
import com.example.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.androiddrinkshop.Utils.Common;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShowOrderActivity extends AppCompatActivity {

    IDrinkShopAPI mService;
    RecyclerView recycler_orders;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

        mService = Common.getAPI();

        recycler_orders = (RecyclerView)findViewById(R.id.recycler_orders);
        recycler_orders.setLayoutManager(new LinearLayoutManager(this));
        recycler_orders.setHasFixedSize(true);

        loadOrder();
    }

    private void loadOrder() {
        if(Common.currentUser != null) {
            compositeDisposable.add(mService.getOrder(Common.currentUser.getPhone(), "0")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<List<Order>>() {
                        @Override
                        public void accept(List<Order> orders) throws Exception {
                            displayOrder(orders);
                        }
                    }));
        }
        else
        {
            Toast.makeText(this, "Please logging again !", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void displayOrder(List<Order> orders) {
        OrderAdapter adapter = new OrderAdapter(this, orders);
        recycler_orders.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadOrder();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}

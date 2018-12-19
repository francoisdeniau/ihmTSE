package com.tse.francoisdeniau.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.tse.francoisdeniau.myapplication.FormActivity.KEY_USERNAME;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NameItemListener {

    private RecyclerView recyclerView;
    private Button buttonEdition;
    private ListNameAdapter listNameAdapter;

    public final static Integer requestCodeGetUsername = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNameAdapter = new ListNameAdapter(this);
        initViews();
        initList();
    }

    private void initViews(){
        recyclerView = findViewById(R.id.activity_main_recyclerview_name);

        buttonEdition = findViewById(R.id.activity_main_button_edit);
        buttonEdition.setOnClickListener(this);
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickOnCross(String name) {
        Toast.makeText(this,"Clic sur la croix de l'item " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.activity_main_button_edit:
                displayFormActivity();
                break;
        }
    }

    private void displayFormActivity(){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listNameAdapter.updateData(DataManager.getInstance().getNameList());
    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
    }
}

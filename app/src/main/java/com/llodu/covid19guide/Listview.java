package com.llodu.covid19guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Listview extends AppCompatActivity {

    ListView menulst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        menulst = findViewById(R.id.menuList);
        //setting the items

        String[] items = new String[] {

                "Introduction", "Causes","Symptoms", "Spread", "Testing","Treatment",
                "Prevention Methods", "Vaccine", "New Variants"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items);
        menulst.setAdapter(adapter);
        menulst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent= new Intent(view.getContext(), Intro.class);
                    startActivity(intent);
                }
                else if (position==1){
                    Intent intent= new Intent(view.getContext(), Causes.class);
                    startActivity(intent);
                }
                else if (position==2){
                    Intent intent= new Intent(view.getContext(), Symptoms.class);
                    startActivity(intent);
                }
                else if (position==3){
                    Intent intent= new Intent(view.getContext(), Spread.class);
                    startActivity(intent);
                }
                else if (position==4){
                    Intent intent= new Intent(view.getContext(), Testing.class);
                    startActivity(intent);
                }
                else if (position==5){
                    Intent intent= new Intent(view.getContext(), Treatment.class);
                    startActivity(intent);
                }
                else if (position==6){
                    Intent intent= new Intent(view.getContext(), Prevention_Methods.class);
                    startActivity(intent);
                }
                else if (position==7){
                    Intent intent= new Intent(view.getContext(), Vaccine.class);
                    startActivity(intent);
                }
                else if (position==8){
                    Intent intent= new Intent(view.getContext(), Variants.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Listview.this,"Please select an Item",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
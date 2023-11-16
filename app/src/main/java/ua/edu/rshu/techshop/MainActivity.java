package ua.edu.rshu.techshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int count=0;
    Spinner spinnerProduct;
    ArrayList spinnerProductArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap selectedMapProduct;
    String selectProduct;
    double price=0.0;
    // Double price=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinerProduct();
        createMapProduct();
    }
    // Зміна кількості вибраного товару
    public void increaseCount(View view) {
        count+=1;
        TextView countTextView=findViewById(R.id.countTextView);
        countTextView.setText(""+count);
        TextView priceTextView=findViewById(R.id.priceTextView);
        Double pricerez= Double.parseDouble((String) priceTextView.getText())+price;
        Log.d("price",""+pricerez);
        priceTextView.setText(""+pricerez);
    }

    // Зміна кількості вибраного товару
    public void decreaseCount(View view) {
        if (count>1) count-=1;
        TextView countTextView=findViewById(R.id.countTextView);
        countTextView.setText(""+count);
        TextView priceTextView=findViewById(R.id.priceTextView);
        Double pricerez= Double.parseDouble((String) priceTextView.getText())-price;
        Log.d("price",""+pricerez);
        priceTextView.setText(""+pricerez);
    }

    public void createSpinerProduct(){
        spinnerProduct=findViewById(R.id.spinnerProduct);
        spinnerProduct.setOnItemSelectedListener(this);
//назви продуктів
        spinnerProductArrayList=new ArrayList();
        spinnerProductArrayList.add("Computers");
        spinnerProductArrayList.add("Smartphon");
        spinnerProductArrayList.add("Planshet");
        spinnerAdapter= new
                ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,spinnerProductArrayList);
        spinnerAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinnerProduct.setAdapter(spinnerAdapter);
    }
    public void createMapProduct(){
        selectedMapProduct=new HashMap();
        selectedMapProduct.put("Computers",25635.00);
        selectedMapProduct.put("Smartphon",12544.00);
        selectedMapProduct.put("Planshet",8254.5);

    }

     @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectProduct=spinnerProduct.getSelectedItem().toString();
        price=(double) selectedMapProduct.get(selectProduct);
// price= (Double) selectedMapProduct.get(selectProduct);
        Log.d("selectedProduct",selectProduct);
        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText(""+price);
        ImageView imageSelectedProduct=findViewById(R.id.imageSelectedProduct);
        switch(selectProduct){
            case "Computers":
                imageSelectedProduct.setImageResource(R.drawable.comp1);
                break;
            case "Smartphon":
                imageSelectedProduct.setImageResource(R.drawable.smartphon_xiomi);
                break;
            case "Planshet":
                imageSelectedProduct.setImageResource(R.drawable.planshet_linovo);
                break;
        }
        TextView countTextView=findViewById(R.id.countTextView);
        count=1;
        countTextView.setText(""+count);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
package ua.edu.rshu.techshop;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConstraintLayout constraintLayout=new ConstraintLayout(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Order");

        //повернемо об'єкт Intent, за допомогою, якого була запущена дана активність
        Intent getOrderIntent = getIntent();
        //дістаємо дані з переданого інтента
        String userName = getOrderIntent.getStringExtra("userName");
        String selectedProduct = getOrderIntent.getStringExtra("selectedProduct");
        int countProduct = getOrderIntent.getIntExtra("countProduct", 0);
        double priceByProduct = getOrderIntent.getDoubleExtra("priceByProduct", 0.0);

        String orderText = "Ім\'я замовника: " + userName +
                "\n Назва товару: " + selectedProduct +
                "\n Ціна за од.товару: " + priceByProduct +
                "\n Кількість товару: " + countProduct +
                "\n Загальна вартість: " + countProduct * priceByProduct;
        //створимо елемент TextView програмно (ви можете в xml це зробити)
        TextView orderTextView = new TextView(this);
        //встановлюємо значення атрибута text
        orderTextView.setText(orderText);
        //задаємо розмір шрифту
        orderTextView.setTextSize(28);
        //встановлюємо візуальний інтерфейс для activity
//        setContentView(orderTextView);
        orderTextView.setId(View.generateViewId());
        ConstraintLayout.LayoutParams textViewLayout = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        textViewLayout.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        textViewLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        textViewLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        textViewLayout.topMargin=20;
        orderTextView.setLayoutParams(textViewLayout);
        constraintLayout.addView(orderTextView);
//Створюємо об'єкт Button, при натисненні на яку запускатимемо неявний Intennt
        Button sendOrderBtn=new Button(this);
        sendOrderBtn.setText("Send Order");
        sendOrderBtn.setHeight(40);
        sendOrderBtn.setTextColor(Color.parseColor("#2a706e"));
// sendOrderBtn.set
// setContentView(sendOrderBtn);
        ConstraintLayout.LayoutParams buttonLayout = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        buttonLayout.topToBottom= orderTextView.getId();
        sendOrderBtn.setLayoutParams(buttonLayout);
        constraintLayout.addView(sendOrderBtn);
        sendOrderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // команди, які виконують після натиснення на кнопку
            }
        });
        //встановлюємо візуальний інтерфейс для activity
        setContentView(constraintLayout);
    }
}
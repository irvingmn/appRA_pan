package com.quinncurtis.chart2dandroid.examples.bargraphs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenuActivity extends Activity   implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View button1 = findViewById(R.id.menuitem1_button);
        button1.setOnClickListener(this);

        View button2 = findViewById(R.id.menuitem2_button);
        button2.setOnClickListener(this);
        
        View button3 = findViewById(R.id.menuitem3_button);
        button3.setOnClickListener(this);
        
        View button4 = findViewById(R.id.menuitem4_button);
        button4.setOnClickListener(this);
        
        View button5 = findViewById(R.id.menuitem5_button);
        button5.setOnClickListener(this);
        
        View button6 = findViewById(R.id.menuitem6_button);
        button6.setOnClickListener(this);

        View button7 = findViewById(R.id.menuitem7_button);
        button7.setOnClickListener(this);
        
        View button8 = findViewById(R.id.menuitem8_button);
        button8.setOnClickListener(this);
        
        View button9 = findViewById(R.id.menuitem9_button);
        button9.setOnClickListener(this);
        
        View button10 = findViewById(R.id.menuitem10_button);
        button10.setOnClickListener(this);    
        
        View button11 = findViewById(R.id.menuitem11_button);
        button11.setOnClickListener(this);           
        
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);   
        
    }
    
    public void onClick(View v) {
    	int id = v.getId();
        if (id == R.id.exit_button)
         finish();
        else
        {
       
          Intent intent = new Intent(this, PlotSelectorActivity.class);
          intent.putExtra("com.quinncurtis.chart2dandroid.examples.bargraphs.MenuItem", id);
      
          startActivity(intent);
        }
     } 
     
}
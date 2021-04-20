package com.example.project_l;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Beforegame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforegame);
        this.inbtn();
    }
/*    Toast   toast;*/
    private void inbtn() {
        //สร้างปุ่มบวกให้กดแล้วในเกมเป็นการบวก
        Button btnA = (Button)this.findViewById(R.id.additionButton);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  toast = Toast.makeText(getApplicationContext(), "ADDITION", Toast.LENGTH_SHORT);
                toast.show();*/
                String operator = "+";
                Intent intent = new Intent(Beforegame.this,game.class);
                intent.putExtra("operator",operator);

                Beforegame.this.startActivity(intent);
            }
        });
        //ลบ
        Button btnS = (Button)this.findViewById(R.id.subtractionButton);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* toast = Toast.makeText(getApplicationContext(), "SUBTRACTION", Toast.LENGTH_SHORT);
                toast.show();*/
                String operator = "-";
                Intent intent = new Intent(Beforegame.this,game.class);
                intent.putExtra("operator",operator);
                Beforegame.this.startActivity(intent);
            }
        });
        //คูณ
        Button btnM = (Button)this.findViewById(R.id.multiplicationButton);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  toast = Toast.makeText(getApplicationContext(), "MULTIPLICTION", Toast.LENGTH_SHORT);
                toast.show();*/
                String operator = "x";
                Intent intent = new Intent(Beforegame.this,game.class);
                intent.putExtra("operator",operator);
                Beforegame.this.startActivity(intent);
            }
        });
        //หาร
        Button btnD = (Button)this.findViewById(R.id.divisionButton);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   toast = Toast.makeText(getApplicationContext(), "DIVISION", Toast.LENGTH_SHORT);
                toast.show();*/
                String operator = "÷";
                Intent intent = new Intent(Beforegame.this,game.class);
                intent.putExtra("operator",operator);
                Beforegame.this.startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beforegame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

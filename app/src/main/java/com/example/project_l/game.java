//เพิ่มว่าได้กี่คะแนนเป็นdialogขึ้นและถามว่าเริ่มใหม่(before)หรือไปหน้าหลัก(main)
package com.example.project_l;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.project_l.DB.MyHelper;
import org.w3c.dom.Text;

public class game extends AppCompatActivity {
    private  CountDownTimer cdtStart;
    private  CountDownTimer cdt;///class timer
    private  TextView tvTimer; /// clock
    private MyHelper mHelper;///
    private SQLiteDatabase mDatabase;
    public int totalPoint=0;///
    private int answer=0;///answer
    private String frist;///a
    private String last;///b
    private TextView question;///question?
    private String operator;///operator
    private TextView text;///answer by user
    private ProgressBar pgTimer;
    private int totalQues;//
    private TextView score_Sum;///sum score
    private  Button enter;
    int Operatorlevel=0;
    MediaPlayer soundTrue;
    MediaPlayer soundFalse;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = this.getIntent();
        operator = intent.getStringExtra("operator");
        //database
        mHelper = new MyHelper(this);
        mDatabase = mHelper.getWritableDatabase();
        //
        tvTimer = (TextView)findViewById(R.id.tvTimer);
        text=(TextView)findViewById(R.id.textView);
        score_Sum =(TextView)findViewById(R.id.sum_score);
       question = (TextView)findViewById(R.id.question);
       //sound
        soundTrue = MediaPlayer.create(this,R.raw.true1);
        soundFalse = MediaPlayer.create(this,R.raw.false1);
        //
        pgTimer=(ProgressBar)findViewById(R.id.pgTimer);
        pgTimer.setVisibility(View.INVISIBLE);
        //button
        Button delete =(Button)findViewById(R.id.buttondelete);
        enter =(Button)findViewById(R.id.buttonenter);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 =(Button)findViewById(R.id.button2);
        Button b3 =(Button)findViewById(R.id.button3);
        Button b4 =(Button)findViewById(R.id.button4);
        Button b5 =(Button)findViewById(R.id.button5);
        Button b6 =(Button)findViewById(R.id.button6);
        Button b7 =(Button)findViewById(R.id.button7);
        Button b8 =(Button)findViewById(R.id.button8);
        Button b9 =(Button)findViewById(R.id.button9);
        Button b0 =(Button)findViewById(R.id.button0);
        //

        enter.setEnabled(false);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = text.getText().toString();
                if (text.length() != 0) {
                    if (str.equals(Integer.toString(answer))) {
                        soundTrue.start();
                        text.setText("");
                        totalPoint += 10;
                        String point = Integer.toString(totalPoint);
                        score_Sum.setText(point);

                        if (operator.equals("-") || operator.equals("÷")) {
                            if (totalPoint < 120) {
                                last = random(1, 0);
                                frist = random(1, Integer.parseInt(last));
                            } else if (totalPoint <= 200) {
                                last = random(2, 0);
                                frist = random(2, Integer.parseInt(last));
                            }
                        } else {
                            if (totalPoint < 150) {
                                frist = random(1, 0);
                                last = random(1, 0);
                            } else if (totalPoint <= 200) {
                                frist = random(1, 0);
                                last = random(2, 0);
                            }
                        }
                    } else {
                        text.setText("");
                        soundFalse.start();
                        if (operator.equals("-") || operator.equals("÷")) {
                            if (totalPoint < 120) {
                                last = random(1, 1);
                                frist = random(1, Integer.parseInt(last));
                            } else if (totalPoint <= 200) {
                                last = random(2, 0);
                                frist = random(2, Integer.parseInt(last));
                            }
                        } else {
                            if (totalPoint < 150) {
                                frist = random(1, 0);
                                last = random(1, 0);
                            } else if (totalPoint <= 200) {
                                frist = random(1, 0);
                                last = random(2, 0);
                            }

                        }
                    }
                    question.setText(frist + operator + last);
                    setAnswer(frist, last);
                    totalQues++;
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("8");

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.length()==6){
                    text.setText("");
                }
                text.append("0");
            }
        });

      cdt = new CountDownTimer(60000, 50) {
        public void onTick ( long millisUntilFinished){
            String strTime = String.format("%.1f"
                    , (double) millisUntilFinished / 1000);
            tvTimer.setText(String.valueOf(strTime));
        }
        //////TIME OUT*************
       public void onFinish() {
           saveScore();
           tvTimer.setText("0");
           text.setText("");
           question.setText("FINISH");
           pgTimer.setVisibility(View.INVISIBLE);

           String msgResult = String.format(
                   "Currect answer: %d / %d \nTotal score: %d",
                   totalPoint / 10,totalQues,
                   totalPoint);
           builder = new AlertDialog.Builder(game.this);
           builder.setTitle("TOTAL SCORE")
                   .setMessage(msgResult)
                   .setCancelable(false)
                   .setNeutralButton("SELECT OPERATOR", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {

                                   Intent intent = new Intent(game.this,Beforegame.class);
                                   game.this.startActivity(intent);
                               }
                           }
                   )
                   .setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           startGame();
                       }
                   })
                   .setNegativeButton("" +
                           "HOME", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Intent intent = new Intent(game.this,MainActivity.class);
                           game.this.startActivity(intent);
                       }
                   }).show();
       }
       };
        ////***************
        }
    public void startGame(){

        enter.setEnabled(true);
        text.setText("");
        totalPoint=0;
        score_Sum.setText("0");
        tvTimer.setText("60");

        last = random(1,0);
        frist = random(1,Integer.parseInt(last));

        question.setText(frist + operator + last);
        setAnswer(frist,last);
        totalQues++;
        cdt.start();
        pgTimer.setVisibility(View.VISIBLE);
    }

    public void saveScore(){
        /////////////////////////////send score to table
        ContentValues cv = new ContentValues();
        cv.put(MyHelper.COL_SCORE, totalPoint);//count
        setLevel();
        cv.put(MyHelper.COL_DIFFICULTY, Operatorlevel);
        mDatabase.insert(MyHelper.TABAL_NAME, null, cv);

    }
    public void setLevel(){
        switch (operator){
            case "+":
                Operatorlevel=0;
                break;
            case "-":
                Operatorlevel=1;
                break;
            case "x":
                Operatorlevel=2;
                break;
            case "÷":
                Operatorlevel=3;
                break;
        }
    }
    public void setAnswer(String frist,String last){
        switch (operator){
            case "+" : answer=Integer.parseInt(frist)+Integer.parseInt(last);
                break;
            case  "-" :
                answer=Integer.parseInt(frist)-Integer.parseInt(last);
                break;
            case  "x": answer=Integer.parseInt(frist)*Integer.parseInt(last);
                break;
            case  "÷":
                answer=Integer.parseInt(frist)/Integer.parseInt(last);
                break;
        }
    }
    public String getText(){
        TextView text=(TextView)findViewById(R.id.textView);
        String t = text.getText().toString();
        return t;
    }
    /////random
    public String random(int level,int n) {
        int random;
        if (operator.equals("÷")) {
            if (level == 1) {
                random = (int) ((Math.random() * (9 - n)) + n + 1);
            } else {
                random = (int) ((Math.random() * ((20 + 1) - n)) + n + 1);
            }

            return Integer.toString(random);
        }
        else {
            if (level == 1) {
                random = (int) ((Math.random() * (9 - n)) + n);
            } else {
                random = (int) ((Math.random() * ((20 + 1) - n)) + n);
            }

            return Integer.toString(random);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
                ///
                startGame();
                 ///
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



package com.example.project_l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;

import com.example.project_l.DB.MyHelper;

public class score extends AppCompatActivity {

    private static  final String TAG = "HighScoreActivity";

    private MyHelper mHelper;
    private SQLiteDatabase mDatabase;
    private ListView list;
    private SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        list = (ListView) findViewById(R.id.highScoreListView);

        mHelper = new MyHelper(this);
        mDatabase = mHelper.getWritableDatabase();

        mAdapter = new SimpleCursorAdapter(this,
                R.layout.layerlist,
                null,
                new String[] {MyHelper.COL_SCORE},
                new int[] {R.id.outputscore});

        list.setAdapter(mAdapter);

        RadioGroup difficultyRadioGroup = (RadioGroup) findViewById(R.id.difficultyRadioGroup);
        difficultyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkId) {
                switch (checkId){
                    case R.id.plusRadioButton:
                        showHighScoreByDifficulty(0);
                        break;

                    case R.id.minusRadioButton:
                        showHighScoreByDifficulty(1);
                        break;

                    case R.id.multiplyRadioButton:
                        showHighScoreByDifficulty(2);
                        break;
                    case R.id.divideRadioButton:
                        showHighScoreByDifficulty(3);
                        break;
                }
            }
        });

    }
    private void showHighScoreByDifficulty(int diff) {
        //ชื่อข้อมูลแต่ละคอลัมที่จะเอามา new String[] {MyHelper.COL_ID, MyHelper.COL_SCORE, MyHelper.COL_DIFFICULTY}
        Cursor c = mDatabase.query(MyHelper.TABAL_NAME, //ชื่อตาราง
                null,
                MyHelper.COL_DIFFICULTY + "=" + diff,
                null,
                null,
                null,
                MyHelper.COL_SCORE + " DESC", // เรียงคะแนนจากน้อยไปมาก
                null);

        mAdapter.changeCursor(c);
    }
}

package com.example.myquizapp6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sb;
    int rightAns = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (Button) findViewById(R.id.sb);
        sb.setOnClickListener(this);
    }
    private void chans(){
        CheckBox ans1 = (CheckBox) findViewById(R.id.q11);
        CheckBox ans2 = (CheckBox) findViewById(R.id.q12);
        CheckBox ans3 = (CheckBox) findViewById(R.id.q13);
        boolean ans1Checked = ans1.isChecked();
        boolean ans2Checked = ans2.isChecked();
        boolean ans3Checked = ans3.isChecked();

        if (!ans1Checked && !ans2Checked && ans3Checked)
            rightAns += 1;
        else
            rightAns += 0;
    }

    private void chans2(){
        RadioButton radioButtonBruce = (RadioButton) findViewById(R.id.rb);
        boolean isRadioButtonBruceChecked = radioButtonBruce.isChecked();
        if (isRadioButtonBruceChecked)
            rightAns += 1;
         else
            rightAns += 0;
    }
    private String getQuestionThreeUserInput() {
        EditText userInputLastName = (EditText) findViewById(R.id.inpans);
        String n = userInputLastName.getText().toString();
        return n;
    }

    /**
     * Question 3 evaluation
     */
    private void chans3(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("drake"))
            rightAns += 1;
         else
            rightAns += 0;
    }

    /**
     * Question 4 evaluation
     */
    private void chans4(){
        RadioButton rb2= (RadioButton) findViewById(R.id.r2);
        boolean isRadioButton2007Checked = rb2.isChecked();
        if (isRadioButton2007Checked)
            rightAns += 1;
         else
            rightAns += 0;
    }

    private void chans5(){
        CheckBox ans1 = (CheckBox) findViewById(R.id.q21);
        CheckBox ans2 = (CheckBox) findViewById(R.id.q22);
        CheckBox answerPeter = (CheckBox) findViewById(R.id.q23);
        boolean isans1Checked = ans1.isChecked();
        boolean isans2Checked = ans2.isChecked();
        boolean ans3 = answerPeter.isChecked();
        if (isans1Checked && isans2Checked && !ans3)
            rightAns += 1;
         else
            rightAns += 0;
    }

    private void chall(){
        chans();
        chans2();
        chans3();
        chans4();
        chans5();
    }
    private void resall(){
        rightAns = 0;
    }
    private String getStringFromID(int id) {
        return getResources().getString(id);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sb) {
            chall();
            Toast.makeText(MainActivity.this, getStringFromID(R.string.right_answer) + rightAns + getStringFromID(R.string.by_5),
                    Toast.LENGTH_LONG).show();
            resall();
        }
    }

}
package com.example.androituan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtPassword;
    EditText txtLenght;
    CheckBox chkLower;
    CheckBox chkUpper;
    CheckBox chkNumber;
    CheckBox chkSymbol;
    Button btnTao;
    ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau2d);

        try {
            txtPassword = findViewById(R.id.password);
            txtLenght = findViewById(R.id.passLen);
            btnTao = findViewById(R.id.buttonGenerate);
            chkLower = findViewById(R.id.lowerCase);
            chkUpper = findViewById(R.id.upperCase);
            chkNumber = findViewById(R.id.includeNum);
            chkSymbol = findViewById(R.id.includeSymbol);

            btnTao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.clear();
                    txtPassword.setText("");
                    if (chkLower.isChecked())
                        list.add(1);
                    if (chkUpper.isChecked())
                        list.add(2);
                    if (chkNumber.isChecked())
                        list.add(3);
                    if (chkSymbol.isChecked())
                        list.add(4);
                    int lenght = Integer.parseInt(String.valueOf(txtLenght.getText()));
                    String password = "";
                    for (int i = 0; i < lenght; i++) {
                        int tmp = rdOnePosition(list);
                        if (tmp == 1)
                            password += rdLowerCharacter();

                        if (tmp == 2)
                            password += rdUpperCharacter();
                        if (tmp == 3)
                            password += rdNumber();
                    }
                    txtPassword.setText(password);
                }
            });
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    int rdOnePosition(ArrayList<Integer> b){
        Random r = new Random();
        int randomIndex = r.nextInt(b.size());
        return b.get(randomIndex);
    }
    char rdUpperCharacter(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'A');
        return c;
    }
    char rdLowerCharacter(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }
    char rdNumber(){
        Random r = new Random();
        char c = (char)(r.nextInt(9) + '0');
        return c;
    }
}
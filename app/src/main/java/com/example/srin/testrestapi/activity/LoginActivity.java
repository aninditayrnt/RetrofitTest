package com.example.srin.testrestapi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.model.AccountDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button loginButton;
    TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        loginButton = (Button) findViewById(R.id.loginButton);
        signupText = (TextView) findViewById(R.id.signupButton);

        signupText.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signupButton :
                Intent i = new Intent(this, SignUpActivity.class);
                this.startActivity(i);
                break;
            case R.id.loginButton :
                if(!username.getText().toString().matches("") && !password.getText().toString().matches("")) {
                    List<AccountDatabase> acc_list = new ArrayList<>();
//                    List<AccountDatabase> pass_list = new ArrayList<>();
                    long count = AccountDatabase.count(AccountDatabase.class);

                    if(count>0) {
                        acc_list = AccountDatabase.find(AccountDatabase.class, "username = ?", username.getText().toString());
                        if(acc_list.size() != 0) {
                            AccountDatabase ad = AccountDatabase.findById(AccountDatabase.class, acc_list.get(0).getId());
                            if(ad.getPassword().matches(password.getText().toString())) {
                                Intent in = new Intent(this, MainActivity.class);
                                startActivity(in);
//                                finish();
                            }else {
                                Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                                password.setText("");
                            }
                        }else {
                            Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                            password.setText("");
                        }
                    }
                }else {
                    Toast.makeText(this, "Field cannot be empty.", Toast.LENGTH_SHORT).show();
                }
        }
    }
}

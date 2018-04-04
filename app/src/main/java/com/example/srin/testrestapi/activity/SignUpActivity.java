package com.example.srin.testrestapi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.model.AccountDatabase;
import com.orm.SugarContext;

import java.util.List;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    EditText email, username, password, confirmpassword;
    Button signUp;

    String em, un, pass, confpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_sign_up);

        Intent i = getIntent();

        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpass);
        signUp = (Button) findViewById(R.id.finish);

        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish: {
                if(!email.getText().toString().matches("") && !username.getText().toString().matches("") && !password.getText().toString().matches("") && !confirmpassword.getText().toString().matches("")) {
                    pass = password.getText().toString();
                    confpass = confirmpassword.getText().toString();
                    if(!password.getText().toString().equals(confirmpassword.getText().toString())) {
                        Toast.makeText(this, "Confirm Password Wrong", Toast.LENGTH_SHORT).show();
                    }else {
                        em = email.getText().toString();
                        un = username.getText().toString();
                        pass = password.getText().toString();
                        confpass = confirmpassword.getText().toString();
                        List<AccountDatabase> email_list = AccountDatabase.find(AccountDatabase.class, "email = ?", em);
                        List<AccountDatabase> username_list = AccountDatabase.find(AccountDatabase.class, "username = ?", un);
                        List<AccountDatabase> pass_list = AccountDatabase.find(AccountDatabase.class, "password = ?", pass);

                        if(email_list.size() == 0 && username_list.size() == 0 && pass_list.size() == 0) {
                            AccountDatabase ad = new AccountDatabase(email.getText().toString(), username.getText().toString(), password.getText().toString());
                            ad.setEmail(email.getText().toString());
                            ad.setUsername(username.getText().toString());
                            ad.setPassword(password.getText().toString());
                            //                        ad.setId(Long.parseLong(username.getText().toString()));
                            ad.save();
                            Intent intent = new Intent(this, LoginActivity.class);
                            this.startActivity(intent);
                        }else if(email_list.size() != 0){
                            Toast.makeText(this, "E-mail already taken.", Toast.LENGTH_SHORT).show();
                        }else if(username_list.size() != 0){
                            Toast.makeText(this, "Username already taken.", Toast.LENGTH_SHORT).show();
                        }else if(pass_list.size() != 0){
                            Toast.makeText(this, "Password already taken.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(this, "Please fill all of the data above", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}

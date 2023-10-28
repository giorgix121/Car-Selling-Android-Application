package gigi.myauto;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gigi.myauto.models.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText editText5, editText6, editText9, editText4;
    private Button button2;
    private DBHandler dbHandler;
    private User user;
    private ContentValues values;
    private TextView signInHere;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHandler = new DBHandler(this);

        editText4 = (EditText) findViewById(R.id.editText4);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText5 = (EditText) findViewById(R.id.editText5);
        button2 = (Button) findViewById(R.id.button2);
        signInHere = (TextView) findViewById(R.id.sign_in_here);

        signInHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Name = editText4.getText().toString().trim();
                String LastName = editText5.getText().toString().trim();
                String Password = editText6.getText().toString().trim();
                String Phone = editText9.getText().toString().trim();

                User user = new User();
                user.setFirstName(Name);
                user.setLastName(LastName);
                user.setPassword(Password);
                user.setPhone(Phone);

                dbHandler.register(user);

                if (Name.equals("") || LastName.equals("") || Password.equals("") || Phone.equals("")) {

                    Toast.makeText(SignUpActivity.this, "Fill All Fields",
                            Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SignUpActivity.this, "Account Successfully Created",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                }




            }
        });


  }

}

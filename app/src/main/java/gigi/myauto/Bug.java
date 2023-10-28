package gigi.myauto;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Bug extends Fragment {

    View myView;
    private EditText editText, editText2 ,editText3;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_bug, container, false);



        editText =(EditText) myView.findViewById(R.id.editText);
        editText2 = (EditText) myView.findViewById(R.id.editText2);
        editText3 = (EditText) myView.findViewById(R.id.editText3);
        button = (Button) myView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = editText.getText().toString();
                String subject = editText2.getText().toString();
                String message = editText3.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));




            }
        });

        return myView;
    }
}


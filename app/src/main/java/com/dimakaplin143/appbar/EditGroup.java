package com.dimakaplin143.appbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditGroup extends AppCompatActivity {
    private String email;
    private String name;
    private EmailValidator emailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editgroup);

        emailValidator = new EmailValidator();

        Button okButton = (Button) findViewById(R.id.ok);
        Button clearButton = (Button) findViewById(R.id.clear);
        EditText inputName = (EditText) findViewById(R.id.edit_name);
        EditText inputEmail = (EditText) findViewById(R.id.edit_email);

        email = inputEmail.getText().toString();
        name = inputName.getText().toString();

        okButton.setOnClickListener(v -> {
            submit();
        });

        clearButton.setOnClickListener(v -> {
            inputName.setText("");
            inputEmail.setText("");
            email = "";
            name = "";
        });

    }

    private void submit() {
        EditText inputName = (EditText) findViewById(R.id.edit_name);
        EditText inputEmail = (EditText) findViewById(R.id.edit_email);

        email = inputEmail.getText().toString();
        name = inputName.getText().toString();

        if(!"".equals(email) && !"".equals(name)) {
            if(emailValidator.validate(email)) {
                wasSubscripted();
            } else {
                emailError();
            }

        }
        else {

            notSubscripted();
        }



    }

    private void wasSubscripted() {
        String mess = name + ", вы успешно подписались на наш порноканал, спам придет на адрес " + email;
        Toast toast = Toast.makeText(getApplicationContext(),
                mess, Toast.LENGTH_LONG);
        toast.show();
    }

    private void notSubscripted() {
        String mess = "У вас пустые поля";
        Toast toast = Toast.makeText(getApplicationContext(),
                mess, Toast.LENGTH_LONG);
        toast.show();
    }

    private void emailError() {
        String mess = "адрес " + email + " введен с ошибкой, проверьете его";
        Toast toast = Toast.makeText(getApplicationContext(),
                mess, Toast.LENGTH_LONG);
        toast.show();
    }


}

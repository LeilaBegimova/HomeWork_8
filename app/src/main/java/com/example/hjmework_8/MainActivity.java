package com.example.hjmework_8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPassword;
    private MaterialButton btn;

    private String userName = "admin@gmail.com";
    private String password = "admin123";

    private Map<String, String> SignInInfo = new HashMap<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignInInfo.put("admin123", "admin@gmail.com");
        editName = this.findViewById(R.id.pochta);
        editPassword = this.findViewById(R.id.parol);
        btn = findViewById(R.id.knopka_vhod);
        signIn();
    }

    private void signIn() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etUserneme = editName.getText().toString().trim();
                String etPassword = editPassword.getText().toString().trim();
                if (etPassword.isEmpty() || etUserneme.isEmpty()) {
                    if (etPassword.isEmpty()) {
                        editPassword.setError("нет значений");
                    } else if (etUserneme.isEmpty()) {
                        editName.setError("нет значений");
                    } else {
                        editName.setError("нет значений");
                        editPassword.setError("нет значений");
                    }
                } else if (etUserneme.equals(userName) && etPassword.equals(password)) {
                    Toast.makeText(MainActivity.this, "Вход выполнен успешно!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неверный email или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
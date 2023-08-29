package com.example.springmodulofinal4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.springmodulofinal4.databinding.ActivitySecundaBinding;

public class SecundaActivity extends AppCompatActivity {


    private ActivitySecundaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLinkedIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkedINURL = "https://www.linkedin.com/in/alexis-huaiquil-alister/";
                Uri uri = Uri.parse(linkedINURL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        binding.buttonWSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroTelefono ="+5698862953";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+numeroTelefono));
                startActivity(intent);
            }
        });


        binding.buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "ing.ahuaiquil@gmail.com"; // Correo electrónico del destinatario
                String mensaje = binding.EditTextMsje.getText().toString(); // Contenido del correo electrónico

                if (!mensaje.isEmpty()) {
                    Intent intentMail = new Intent(Intent.ACTION_SEND);
                    intentMail.setType("text/plain");
                    intentMail.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
                    intentMail.putExtra(Intent.EXTRA_SUBJECT, mensaje);
                    if (intentMail.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentMail);
                    }else {
                        Toast.makeText(SecundaActivity.this, "No hay una aplicación de correo electrónico disponible", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SecundaActivity.this, "Favor completar el mensaje para enviar", Toast.LENGTH_SHORT).show();

                }
            }

        });








    }
}
package com.example.felipe.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import java.io.File;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //instanciando os  botoes
        Button Foto = (Button) findViewById(R.id.btnFoto);
        Button Video = (Button) findViewById(R.id.btnVideo);

        //mostrar o que vai acontecer quando clicar no botao foto
        Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cria e starta a intent
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

                //decobrindo o endereço do cartao de memoria e salvando o arquivo
                String arquivo = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".jpg";
                File file = new File(arquivo);
                Uri outputFileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
        });


        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cria e starta a intent
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent);

                //decobrindo o endereço do cartao de memoria e salvando o arquivo
                String arquivo = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".mp4";
                File file = new File(arquivo);
                Uri outputFileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
        });
    }
}

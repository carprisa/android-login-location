package com.carprisa.login_mapas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /* Declaramos las variables privadas que solo serán accesibles desde los métodos del código
    Se corresponden con las cajas de texto donde se introduce el nombre de usuario, el botón de
    entrar y la caja donde aparece el mensaje de error en caso de que se introduzca un usuario
    no registrado
     */
    private TextView msjLogin;
    private Button boton;
    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*  Tras la creación de la actividad inicial enlazada con el layout activity_main, se procede
        a recoger en las variables declaradas anteriormente los valores de las clases corresondientes a
        cada variable. Se realiza buscando por el identificador que hemos usado en el xml (el layout)
        por el que se identifica cada objeto en el archivo R, que es donde están todas las asociacioens
         */

        boton = (Button) findViewById(R.id.button);
        msjLogin = (TextView) findViewById(R.id.mensaje);
        text = (EditText) findViewById(R.id.editText);

        /* A continiación ponemos a la escucha el botón. Esto quiere decir que se prepara para
        recibir el evento click
        */
        boton.setOnClickListener(this);

    }

    /*
    A continuación sobreescribimos el evento onClick, que es el ejecuta acciones tras recibir el
    botón el evento . Se detallan entre corchetes
     */
    @Override
    public void onClick(View view) {
        /*
        Convertimos a objeto String el valor de la variable text del campo nombre, que
        se trata de un objeto EditText. Aquí se rellena el nombre de usuario
        */
        String nombre = text.getText().toString();

            switch(nombre){
                // En caso de nombre==xxxx, cambiamos de actividad a Gijón en Google Maps API 2

                case "carlos":
                    Intent i = new Intent(this, ClaseMapa.class);
                    startActivity(i);
                    // Después de cada acción se escribe en blanco el último campo, así en caso de
                    // introducir un usuario erróneo, no se queda el mensaje de forma permanente en
                    // pantalla
                    msjLogin.setText("");
                    break;
                case "juan":
                    Intent ii = new Intent(this, MapsJuan.class);
                    startActivity(ii);
                    msjLogin.setText("");
                    break;
                case "maria":
                    Intent iii = new Intent(this, MapsMaria.class);
                    startActivity(iii);
                    msjLogin.setText("");
                    break;
                default:
                    msjLogin.setText("Usuario inexistente. Introduzca uno válido por favor.");
            }
    }
    /*
    El siguiente método es el llamado por el botón "info que se encuentra en la actividad principal.
    Al botón se le ha asociado un evento onClick que llama al método muestraInfo cuando es pulsado.
    Se ejecuta a continuación el intent que hace que salte a la activity de mostrar la información
    de la aplicación.
     */
    public void muestraInfo (View view){

        Intent info = new Intent(this, info.class);
        startActivity(info);
    }
}


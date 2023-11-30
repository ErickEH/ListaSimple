package com.example.nodo;
//Hernandez Garcia Erick Emmanuel I3A
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


//Se crean los punteros de Nodo, inicio y ultimo
    private Nodos inicio = null;
    private Nodos ultimo = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Se enlazan los tres elementos de mi xml
        final EditText inputEditText = findViewById(R.id.inputEditText);
        final TextView outputTextView = findViewById(R.id.outputTextView);
        Button addButton = findViewById(R.id.addButton);

        //Se hace la funcion que hara el boton al ser presionado
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se extrae el numero ingresado en el EditText
                int valor = Integer.parseInt(inputEditText.getText().toString());
                //Lista simple
                Nodos nuevoNodo = new Nodos(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                } else {
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                }
                //se actualiza el EditText para que el usuario pueda poner mas datos
                inputEditText.setText("");
                actualizarSalida();
            }
        });
    }


    //Se crea la funcion para imprimir todos los nodos existentes en dato
    private void actualizarSalida() {
        StringBuilder resultado = new StringBuilder();
        Nodos imp = inicio;
        while (imp != null) {
            resultado.append(imp.dato).append("\n");
            imp = imp.siguiente;
        }
        TextView outputTextView = findViewById(R.id.outputTextView);
        outputTextView.setText(resultado.toString());
    }
}
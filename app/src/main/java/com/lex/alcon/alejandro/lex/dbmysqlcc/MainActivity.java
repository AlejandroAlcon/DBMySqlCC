package com.lex.alcon.alejandro.lex.dbmysqlcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etxtnom,etxtappat,etxtapmat;
    EditText id;
    ImageView imgViewPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxtnom=findViewById(R.id.editText);
        etxtappat=findViewById(R.id.editText2);
        etxtapmat=findViewById(R.id.editText3);
        id=findViewById(R.id.editText4);
        imgViewPhoto=findViewById(R.id.imageViewPhoto);
        String url="http://fundacionaydha.org/img/3.png";
        Picasso.with(this).load(url).into(imgViewPhoto);

    }
    public void guardar(View view)
    {
        String url="http://fundacionaydha.org/insert.php";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                limpiar();
            }
        }, new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("nom",etxtnom.getText().toString().trim());
                params.put("appat",etxtappat.getText().toString().trim());
                params.put("apmat",etxtapmat.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void mostrar(View view)
    {
        Intent intent=new Intent(this, MostrarActivity.class);
        startActivity(intent);
    }
    public void modificar(View view)
    {
        String url="http://fundacionaydha.org/update.php";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                limpiar();
            }
        }, new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id.getText().toString().trim());
                params.put("nom",etxtnom.getText().toString().trim());
                params.put("appat",etxtappat.getText().toString().trim());
                params.put("apmat",etxtapmat.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void eliminar(View view)
    {
        String url="http://fundacionaydha.org/eliminar.php";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                limpiar();
            }
        }, new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void limpiar(View view)
    {

    }
    public void limpiar()
    {
        etxtnom.setText("");
        etxtappat.setText("");
        etxtapmat.setText("");
        id.setText("");
    }
}

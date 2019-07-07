package com.lex.alcon.alejandro.lex.dbmysqlcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MostrarActivity extends AppCompatActivity {

    String[] Descripcion =new String[100];

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listView=findViewById(R.id.listViewDatos);
        //llenar();
        String url="http://fundacionaydha.org/mostrar.php";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray=response.getJSONArray("persona");

                            int Limit=jsonArray.length();

                            //JSONObject object=jsonArray.getJSONObject(0);
                            //Toast.makeText(getApplicationContext(),object.getString("nombres"),Toast.LENGTH_LONG).show();
                            String all="";
                            for (int i=0;i<Limit;i++) {
                                JSONObject object=jsonArray.getJSONObject(i);
                                Descripcion[i]=object.getString("nombres");
                                all=all+object.getString("nombres")+" "+object.getString("ap_paterno")+
                                        " "+object.getString("ap_materno")+" \n";

                            }

                            Toast.makeText(getApplicationContext(),all,Toast.LENGTH_LONG).show();
                            //DatoAdapter adapter=new DatoAdapter((Activity)getApplicationContext(), Descripcion);
                            //listView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response",error.getMessage());
                    }
                }
        );

// add it to the RequestQueue
        requestQueue.add(getRequest);

    }
    public void llenar()
    {

        /*
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();


                    JSONArray jsonArray=jsonObject.getJSONArray("persona");
                    int Limit=jsonArray.length();
                    for (int i=0;i<Limit;i++) {
                        JSONObject object=new JSONObject(String.valueOf(jsonArray.getJSONObject(i)));
                        Descripcion[i]=object.getString("nombres");
                    }
                    DatoAdapter adapter=new DatoAdapter((Activity) getApplicationContext(), Descripcion);
                    listView.setAdapter(adapter);

                    } catch (JSONException e) {
                    e.printStackTrace();
                }
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
                return params;
            }
        };
        requestQueue.add(stringRequest);
        */
    }
}

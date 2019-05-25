package com.example.quizzappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddQuestion  extends AppCompatActivity {
    private EditText question, answer, category;
    private Button btn_wer;
    private TextView text;
    private static String URL_SEND="http://192.168.0.176/android_register_login/addquestion.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addquestion);

        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        category = findViewById(R.id.category);
        btn_wer = findViewById(R.id.btn_wer);
        text = findViewById(R.id.text);

        btn_wer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send();
            }
        });
    }

            private void Send() {

                final String question = this.question.getText().toString().trim();
                final String answer = this.answer.getText().toString().trim();
                final String category = this.category.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SEND,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")){
                                Toast.makeText(AddQuestion.this, "Wysłano pomyślnie!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Home.class));

                            }

                        }catch(JSONException e){
                            e.printStackTrace();
                            Toast.makeText(AddQuestion.this, "Problem z wysłaniem " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(AddQuestion.this, "Problem z wysłaniem " + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("question", question);
                        params.put("answer", answer);
                        params.put("category", category);
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
            }
}

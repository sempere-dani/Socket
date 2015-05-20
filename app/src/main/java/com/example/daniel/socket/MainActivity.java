package com.example.daniel.socket;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    final String HOST = "192.168.0.193";

    final int PUERTO = 5678;
    EditText ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip=(EditText)findViewById(R.id.editText);

        Button buttonSend = (Button)findViewById(R.id.send);

        buttonSend.setOnClickListener(buttonSendOnClickListener);
    }

    Button.OnClickListener buttonSendOnClickListener
            = new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
           ;
            //pasamos a MyClientTask el valor de HOST
            /*Intent intent=new Intent(MainActivity.this,MyClientTask.class);
            intent.putExtra("ip",HOST);
            startActivity(intent);*/

            MyClientTask myClientTask=new MyClientTask(ip.getText().toString(),PUERTO);
            System.out.println("IP equipo "+ip.getText().toString());
            myClientTask.execute();
        }};




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

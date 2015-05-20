package com.example.daniel.socket;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Daniel on 19/05/2015.
 */
public class Task2 extends AsyncTask<Void,Void,Void> {


    String dstAddress;
    int dstPort;
    String response;



    Task2(String addr, int port) {
        dstAddress = addr;
        dstPort = port;

    }


    @Override
    protected Void doInBackground(Void... params) {

        try {
            //Process p = Runtime.getRuntime().exec("su");//permiso SU
            Socket skCliente = new Socket( dstAddress , dstPort );

            OutputStream salida = skCliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream( salida );

//lee el  archivo
            File myfile=new File("data/data/com.example.daniel.socket/androidify.png");


            //mensaje hacia pc
            flujo.writeUTF("sending..."+"\n"+"file size= "+ myfile.length()+"\n"+
                    "FINISH !!!");



            skCliente.close();



        } catch( Exception e ) { System.out.println(e); }
        //Toast.makeText(AppContext.getContext(), "msg msg", Toast.LENGTH_SHORT).show();
        return null;
    }
}

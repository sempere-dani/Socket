package com.example.daniel.socket;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Daniel on 09/05/2015.
 */
public class MyClientTask extends AsyncTask<Void,Void,Void> {



    String dstAddress;
    int dstPort;
    String response;



    MyClientTask(String addr, int port) {
        dstAddress = addr;
        dstPort = port;

    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            //Process p = Runtime.getRuntime().exec("su");//permiso SU
            Socket skCliente = new Socket( dstAddress , dstPort );

            DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());


//lee el  archivo
            File myfile=new File("data/data/com.example.daniel.socket/androidify.png");

            System.out.println("file created ");
            //crea un array de la misma longitud que el archivo para q se pueda leer por el metodo read
            byte[] mybytearray  =new byte[(int) myfile.length()];
            System.out.println("file size= "+ mybytearray.length);
            FileInputStream fileInputStream=new FileInputStream(myfile);
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            bufferedInputStream.read(mybytearray,0,mybytearray.length);
            OutputStream outputStream= skCliente.getOutputStream();
            //DataOutputStream flujo = new DataOutputStream( outputStream );
            System.out.println("sending...");
            //mensaje hacia pc
            salida.writeUTF( mybytearray.length+"\n");


            outputStream.write(mybytearray, 0, mybytearray.length);

            outputStream.flush();


            skCliente.close();




        } catch( Exception e ) { System.out.println(e); }
        //Toast.makeText(AppContext.getContext(), "msg msg", Toast.LENGTH_SHORT).show();
        return null;
    }

}

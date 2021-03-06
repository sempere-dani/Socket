package com.example.daniel.socket;

import android.app.Application;
import android.content.Context;

/**
 * Created by Daniel on 11/05/2015.
 */
public class AppContext extends Application {


    /**
     * Keeps a reference of the application context
     */
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return sContext;
    }
}

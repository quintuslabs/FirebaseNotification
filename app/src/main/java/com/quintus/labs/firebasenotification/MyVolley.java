package com.quintus.labs.firebasenotification;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * FirebaseNotification
 * https://github.com/quintuslabs/FirebaseNotification
 * Created on 18-Nov-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class MyVolley {

    private static MyVolley mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;

    private MyVolley(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MyVolley getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyVolley(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
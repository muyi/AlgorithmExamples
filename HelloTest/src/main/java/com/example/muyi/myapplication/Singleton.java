package com.example.muyi.myapplication;

import android.util.Log;

/**
 * Created by T530 on 2017/3/24.
 */

public enum Singleton {

    INSTANCE {
        @Override
        protected void read() {
            Log.d("Singleton", "read");
        }

        @Override
        protected void write() {
            Log.d("Singleton", "write");
        }
    };

    protected abstract void read();

    protected abstract void write();

}

package com.example.paulac.cis;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by paulac on 2/22/16.
 */
public class UserLocalStore {

    public static final String SP = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context con) {
        userLocalDatabase = con.getSharedPreferences(SP, 0);
    }
}

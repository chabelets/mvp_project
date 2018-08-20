package com.example.tom.mvp_chabelets.util;

import android.content.Context;
import android.content.Intent;

import com.example.tom.mvp_chabelets.features.main.MainActivity;

public class Starter {

    public static void startMainActivity(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }
}

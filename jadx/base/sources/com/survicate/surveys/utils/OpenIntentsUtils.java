package com.survicate.surveys.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public class OpenIntentsUtils {
    public static void openLink(Context context, String str) {
        if (isLink(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }

    private static boolean isLink(String str) {
        return Pattern.compile("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&/=]*)").matcher(str).matches();
    }
}

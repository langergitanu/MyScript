package com.pdftron.pdfnet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFNet;
import com.pdftron.pdf.PDFViewCtrl;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TrialKeyProvider {
    private static final String PROD_URL = "https://pws-collect.pdftron.com/api/key";
    private static final String TAG = "TrialKeyProvider";

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045 A[PHI: r1
      0x0045: PHI (r1v5 java.net.HttpURLConnection) = (r1v4 java.net.HttpURLConnection), (r1v8 java.net.HttpURLConnection) binds: [B:20:0x0043, B:11:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String generateTrialKey() throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(PROD_URL).openConnection();
                try {
                    if (httpURLConnection.getResponseCode() == 200) {
                        try {
                            String strOptString = new JSONObject(PDFViewCtrl.readStream(new BufferedInputStream(httpURLConnection.getInputStream()))).optString(SubscriberAttributeKt.JSON_NAME_KEY);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return strOptString;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        return null;
    }

    public static boolean shouldGenerateTrialKey(Context context, String str) throws PDFNetException {
        if (str != null && !str.trim().isEmpty()) {
            PDFNet.setTempPath(context.getCacheDir().getPath());
            PDFNet.setPersistentCachePath(context.getFilesDir().getPath());
            try {
                PDFNet.initialize(str);
                return false;
            } catch (Exception e) {
                Log.e(TAG, e.getMessage() != null ? e.getMessage() : "Invalid key used to initialize");
                PDFNet.initialize("demo:demo@pdftron.com:73b0e0bd01e77b55b3c29607184e8750c2d5e94da67da8f1d0");
                Log.e(TAG, "PDFNet has been initialized in demo mode! A valid key is required for production mode!");
            }
        }
        return true;
    }

    public static String getLicenseKey(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null && bundle.containsKey("pdftron_license_key")) {
                String string = bundle.getString("pdftron_license_key");
                if (string == null || string.trim().isEmpty()) {
                    String trialKey = SharedPreferencesUtils.getTrialKey(context);
                    if (trialKey != null) {
                        return trialKey;
                    }
                }
                return string;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void setTrialKey(Context context, String str) {
        SharedPreferencesUtils.setTrialKey(context, str);
    }

    public static String getTrialKey(Context context) {
        return SharedPreferencesUtils.getTrialKey(context);
    }
}

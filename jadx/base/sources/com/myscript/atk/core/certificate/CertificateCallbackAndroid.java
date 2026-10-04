package com.myscript.atk.core.certificate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class CertificateCallbackAndroid implements ICertificatePlatformCallback {
    private static final boolean DBG = false;
    private static final String K4d8be9 = "4d8be95b0232d243bf67e13f764634b4b75cd6cf";
    private static final String K9c1a5a = "9c1a5a3db7d550a39a98b80c46e6081580b226e3";
    private static final String Kebaed9 = "ebaed9907ac2053a6c934518a2213b42c9508908";
    private static final String Kf4ef8b = "f4ef8bac9f1875bc2e2c2762c31bb1f949c04848";
    private static final String Kf976b2 = "f976b2fb18f45aa807fc681736e44a554f4e0b98";
    private static final String Ks4gezc = "s4gezc8h9q6rcqykg4zcs69ugebcxyut99mg47d9";
    private static final String TAG = "CertificateCallback";
    private final Context mApplicationContext;

    public CertificateCallbackAndroid(Context context) {
        this.mApplicationContext = context == null ? null : context.getApplicationContext();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public byte[] getInstanceData() {
        return Base64.decode(this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).getString(K9c1a5a, ""), 0);
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public byte[] getLicenseData() {
        return Base64.decode(this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).getString(Kf976b2, ""), 0);
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public byte[] requestLicenseData(String str) {
        byte[] bArr = new byte[0];
        if (!checkInternetPermission(this.mApplicationContext)) {
            Log.e(TAG, "Need to add the android.permission.INTERNET");
            return bArr;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.addRequestProperty("Accept", "application/vnd.myscript.atk.certificate");
            httpURLConnection.connect();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    Log.e(TAG, "requestLicenseData(): code=" + responseCode);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bArr;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int i = inputStream.read(bArr2);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return byteArray;
            } finally {
            }
        } catch (IOException unused2) {
            return bArr;
        }
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public String getDeviceId() {
        return Settings.Secure.getString(this.mApplicationContext.getContentResolver(), "android_id");
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public String getAppName() {
        return this.mApplicationContext.getPackageName();
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public long getDate() {
        return this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).getLong(K4d8be9, 0L);
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public long getLastSuccessfulConnectionDate() {
        return this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).getLong(Ks4gezc, -1L);
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public void init(byte[] bArr) {
        SharedPreferences sharedPreferences = this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0);
        if (Arrays.equals(Base64.decode(sharedPreferences.getString(Kebaed9, ""), 0), bArr)) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(Kebaed9, Base64.encodeToString(bArr, 0));
        editorEdit.remove(K9c1a5a);
        editorEdit.remove(Kf976b2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            long j = this.mApplicationContext.getPackageManager().getPackageInfo(getAppName(), 0).firstInstallTime;
            if (j < jCurrentTimeMillis) {
                jCurrentTimeMillis = j;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        editorEdit.putLong(K4d8be9, jCurrentTimeMillis / 1000);
        editorEdit.apply();
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public void reset(byte[] bArr) {
        SharedPreferences.Editor editorEdit = this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).edit();
        editorEdit.remove(K4d8be9);
        editorEdit.remove(Ks4gezc);
        editorEdit.remove(Kebaed9);
        editorEdit.remove(Kf976b2);
        editorEdit.remove(K9c1a5a);
        editorEdit.apply();
        init(bArr);
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public void storeLicenseData(byte[] bArr) {
        SharedPreferences.Editor editorEdit = this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).edit();
        editorEdit.putString(Kf976b2, Base64.encodeToString(bArr, 0));
        editorEdit.apply();
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public void storeLastSuccessfulConnectionDate() {
        SharedPreferences.Editor editorEdit = this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).edit();
        editorEdit.putLong(Ks4gezc, System.currentTimeMillis() / 1000);
        editorEdit.apply();
    }

    @Override // com.myscript.atk.core.certificate.ICertificatePlatformCallback
    public void storeInstanceData(byte[] bArr) {
        SharedPreferences.Editor editorEdit = this.mApplicationContext.getSharedPreferences(Kf4ef8b, 0).edit();
        editorEdit.putString(K9c1a5a, Base64.encodeToString(bArr, 0));
        editorEdit.apply();
    }

    private static boolean checkInternetPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }
}

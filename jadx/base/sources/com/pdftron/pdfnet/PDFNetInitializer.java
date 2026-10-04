package com.pdftron.pdfnet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFNet;

/* JADX INFO: loaded from: classes7.dex */
public class PDFNetInitializer extends ContentProvider {
    public static final String MSG = "Tried to auto-initialize Apryse SDK but no license key was found.\nPlease add your license as described in this article: \nhttps://www.pdftron.com/documentation/android/guides/getting-started/add-license.";
    private static final String TAG = "PDFNetInitializer";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        String licenseKey = getLicenseKey(context);
        if (licenseKey != null && context != null) {
            try {
                PDFNet.initialize(context, C6969R.raw.pdfnet, licenseKey);
                return true;
            } catch (PDFNetException e) {
                e.printStackTrace();
                return true;
            }
        }
        Log.w(TAG, MSG);
        return true;
    }

    public static void checkPackage(Context context, ContentProvider contentProvider) {
        if (Build.VERSION.SDK_INT <= 28) {
            String callingPackage = contentProvider.getCallingPackage();
            if (context == null || callingPackage == null || !callingPackage.equals(context.getPackageName())) {
                throw new SecurityException("Provider should not be called outside of app!");
            }
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        checkPackage(getContext(), this);
        return null;
    }

    public static String getLicenseKey(Context context) {
        return TrialKeyProvider.getLicenseKey(context);
    }
}

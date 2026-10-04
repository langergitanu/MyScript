package com.myscript.atk.core;

import android.content.res.AssetManager;
import android.util.Log;
import com.revenuecat.purchases.common.networking.ETagPayloadStore;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class AssetUtils {
    private static final String TAG = "AssetUtils";

    private AssetUtils() {
    }

    public static boolean copyAssetFiles(android.content.Context context, String str, Pattern pattern, File file, boolean z) {
        boolean z2;
        boolean z3;
        File file2 = file;
        AssetManager assets = context.getAssets();
        boolean z4 = false;
        try {
            String[] list = assets.list(str);
            int length = list.length;
            boolean zRenameTo = true;
            int i = 0;
            while (i < length) {
                String str2 = list[i];
                if (pattern.matcher(str2).matches()) {
                    File file3 = new File(file2, str2);
                    if (z || !file3.isFile()) {
                        if (!file2.isDirectory() && !file2.mkdirs()) {
                            Log.e(TAG, "Cannot create target directory " + file2);
                            return z4;
                        }
                        File file4 = new File(file2, str2 + ETagPayloadStore.TEMP_SUFFIX);
                        try {
                            InputStream inputStreamOpen = assets.open(str + File.separatorChar + str2);
                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                            try {
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i2 = inputStreamOpen.read(bArr);
                                        z3 = zRenameTo;
                                        if (i2 == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i2);
                                        zRenameTo = z3;
                                    }
                                    fileOutputStream.flush();
                                    try {
                                        inputStreamOpen.close();
                                    } catch (IOException unused) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    z2 = z3;
                                } catch (IOException e) {
                                    Log.e(TAG, "Error while copying file " + str2, e);
                                    try {
                                        inputStreamOpen.close();
                                    } catch (IOException unused3) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused4) {
                                    }
                                    z2 = false;
                                }
                                zRenameTo = z2 & file4.renameTo(file3);
                                if (file4.isFile()) {
                                    file4.delete();
                                }
                            } catch (Throwable th) {
                                try {
                                    inputStreamOpen.close();
                                } catch (IOException unused5) {
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused6) {
                                    throw th;
                                }
                            }
                        } catch (IOException e2) {
                            Log.e(TAG, "Error while handling assets", e2);
                            return false;
                        }
                    }
                }
                i++;
                file2 = file;
                z4 = false;
            }
            return zRenameTo;
        } catch (IOException e3) {
            Log.e(TAG, "Cannot list assets " + str, e3);
            return false;
        }
    }
}

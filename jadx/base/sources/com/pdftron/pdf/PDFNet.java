package com.pdftron.pdf;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class PDFNet {

    /* JADX INFO: renamed from: a */
    private static final String f1632a = "com.pdftron.pdf.PDFNet";

    /* JADX INFO: renamed from: b */
    private static volatile boolean f1633b = false;
    public static final int e_CNS1 = 4;
    public static final int e_GB1 = 3;
    public static final int e_Identity = 0;
    public static final int e_Japan1 = 1;
    public static final int e_Japan2 = 2;
    public static final int e_Korea1 = 5;
    public static final int e_icm = 1;
    public static final int e_lcms = 0;
    public static final int e_no_cms = 2;

    static native boolean InitAndroidFonts();

    public static native boolean IsARM();

    public static native boolean IsARMv7();

    public static native boolean addFontSubst(int i, String str) throws PDFNetException;

    public static native boolean addFontSubst(String str, String str2) throws PDFNetException;

    public static native void addPDFTronCustomHandler(int i) throws PDFNetException;

    public static native void addResourceSearchPath(String str);

    public static native void enableJavaScript(boolean z);

    public static native String getResourcesPath() throws PDFNetException;

    public static native String getSystemFontList() throws PDFNetException;

    public static native double getVersion() throws PDFNetException;

    public static native String getVersionString() throws PDFNetException;

    public static native void initialize(String str);

    public static native boolean isJavaScriptEnabled();

    public static native void setColorManagement(int i) throws PDFNetException;

    public static native void setDefaultDeviceCMYKProfile(String str) throws PDFNetException;

    public static native void setDefaultDeviceRGBProfile(String str) throws PDFNetException;

    public static native void setDefaultDiskCachingEnabled(boolean z) throws PDFNetException;

    public static native void setPersistentCachePath(String str) throws PDFNetException;

    public static native boolean setResourcesPath(String str);

    public static native void setTempPath(String str) throws PDFNetException;

    public static native void setViewerCache(int i, boolean z);

    public static native void terminate();

    static {
        StringBuffer stringBuffer = new StringBuffer("abi: ");
        stringBuffer.append(Build.CPU_ABI).append("\n");
        if (new File("/proc/cpuinfo").exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        stringBuffer.append(line + "\n");
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String lowerCase = stringBuffer.toString().toLowerCase();
        try {
            System.loadLibrary("PDFNetC");
            f1633b = false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e("PDFNet", "PDFNetC loadLibrary error with cpu_info: " + lowerCase);
            Log.e("PDFNet", "PDFNetC loadLibrary error: " + e2.getMessage());
            throw new ExceptionInInitializerError("Unexpected loadLibrary error. If this error persists please go to pdftron.com/kb_android_loadlibrary_error");
        }
    }

    public static boolean hasBeenInitialized() {
        return f1633b;
    }

    public static void initialize(Context context, int i, String str) throws PDFNetException {
        if (context == null) {
            throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initialize()", "Context cannot be null to initialize PDFNet library.");
        }
        if (f1633b) {
            Log.e(f1632a, "PDFNet has already been initialized! `PDFNet.initialize(...)` should only be called 1 single time!");
        }
        try {
            setTempPath(context.getCacheDir().getPath());
            setPersistentCachePath(context.getFilesDir().getPath());
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e("PDFNet", e.getMessage());
            }
        }
        try {
            initialize(str);
        } catch (Exception e2) {
            initialize("demo:demo@pdftron.com:73b0e0bd01e77b55b3c29607184e8750c2d5e94da67da8f1d0");
            Log.e(f1632a, "PDFNet has been initialized in demo mode! A valid key is required for production mode!");
            if (e2.getMessage() != null) {
                Log.e("PDFNet", e2.getMessage());
            }
        }
        m1198a(context, i, false);
        InitAndroidFonts();
        try {
            setViewerCache(0, false);
            setColorManagement(2);
        } catch (Exception unused) {
        }
        try {
            new Rect();
            Obj.__Create(0L, 0);
        } catch (Exception unused2) {
        }
        f1633b = true;
    }

    /* JADX INFO: renamed from: a */
    private static void m1198a(Context context, int i, boolean z) throws PDFNetException {
        if (context == null) {
            throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Context cannot be null to initialize resource file.");
        }
        File file = new File(context.getFilesDir() + File.separator + "pdfnet.res");
        if (!file.exists()) {
            StatFs statFs = new StatFs(context.getFilesDir().getPath());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) < 2903023) {
                throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Not enough space available to copy resources file.");
            }
            try {
                InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("pdfnet.res", 0);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStreamOpenRawResource.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        fileOutputStreamOpenFileOutput.write(bArr, 0, i2);
                    }
                }
                inputStreamOpenRawResource.close();
                fileOutputStreamOpenFileOutput.flush();
                fileOutputStreamOpenFileOutput.close();
            } catch (Resources.NotFoundException unused) {
                throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Resource file ID does not exist.");
            } catch (FileNotFoundException unused2) {
                throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Resource file not found.");
            } catch (IOException unused3) {
                throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Error writing resource file to internal storage.");
            } catch (Exception unused4) {
                throw new PDFNetException("", 0L, "com.pdftron.pdf.PDFNet", "initializeResource()", "Unknown error.");
            }
        }
        setResourcesPath(file.getAbsolutePath());
    }
}

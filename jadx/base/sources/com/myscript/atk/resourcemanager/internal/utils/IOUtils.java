package com.myscript.atk.resourcemanager.internal.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes4.dex */
public final class IOUtils {
    private static final String TAG = "IOUtils";

    private IOUtils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static String fileToString(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String strStreamToString = streamToString(fileInputStream);
            closeQuietly(fileInputStream);
            return strStreamToString;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public static String streamToString(InputStream inputStream) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage(), e);
        } catch (IOException e2) {
            Log.e(TAG, e2.getMessage(), e2);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append('\n');
            return sb.toString();
        }
        inputStream.close();
        return sb.toString();
    }

    public static void write(String str, File file) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileWriter.write(str);
            closeQuietly(fileWriter);
        } catch (IOException e2) {
            e = e2;
            fileWriter2 = fileWriter;
            Log.e(TAG, e.getMessage(), e);
            closeQuietly(fileWriter2);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            closeQuietly(fileWriter2);
            throw th;
        }
    }

    public static String read(File file) throws Throwable {
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            closeQuietly(fileReader);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileReader2 = fileReader;
            Log.e(TAG, e.getMessage(), e);
            closeQuietly(fileReader2);
        } catch (IOException e4) {
            e = e4;
            fileReader2 = fileReader;
            Log.e(TAG, e.getMessage(), e);
            closeQuietly(fileReader2);
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            closeQuietly(fileReader2);
            throw th;
        }
        return sb.toString();
    }
}

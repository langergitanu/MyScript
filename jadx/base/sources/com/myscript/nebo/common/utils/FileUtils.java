package com.myscript.nebo.common.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import okhttp3.internal.p041ws.RealWebSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class FileUtils {
    private static final String TAG = "FileUtils";

    public interface IFileUtilsProgression {
        void copyCanceled();

        void copyError();

        void copyFileEnded();

        boolean copyFileProgress(int i);

        void copyFileStarted();
    }

    private FileUtils() {
    }

    public static String readFile(File file) {
        if (file != null && file.isFile()) {
            StringBuilder sb = new StringBuilder();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        sb.append(new String(bArr, 0, i));
                    } else {
                        fileInputStream.close();
                        return sb.toString();
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, "Error while reading file content " + file.getAbsolutePath(), e);
            }
        }
        return null;
    }

    public static File createFile(File file, File file2) {
        if (!file.isDirectory() && !file.mkdirs()) {
            Log.e(TAG, "Unable to create directory for " + file2.getName() + " export " + file.getAbsolutePath());
            return null;
        }
        if (file2.isFile()) {
            return file2;
        }
        try {
            file2.createNewFile();
            return file2;
        } catch (IOException e) {
            Log.e(TAG, "Something went wrong while creating " + file2.getName() + " file", e);
            return null;
        }
    }

    public static File streamToFile(File file, File file2, FileInputStream fileInputStream, IFileUtilsProgression iFileUtilsProgression) {
        File fileCreateFile = createFile(file, file2);
        boolean zCopyStream = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateFile);
            try {
                zCopyStream = copyStream(fileInputStream, fileOutputStream, iFileUtilsProgression);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            Log.e(TAG, "An error occurred while copying file stream", e);
        }
        if (zCopyStream) {
            return fileCreateFile;
        }
        fileCreateFile.delete();
        return null;
    }

    public static File getUniqueFile(File file, String str) {
        return getUniqueFile(new File(file, str), 0);
    }

    private static File getUniqueFile(File file, int i) {
        String strSubstring;
        if (file == null) {
            Log.e(TAG, "Method shouldn't be invoked with a null file.");
            return null;
        }
        if (!file.exists()) {
            return file;
        }
        int i2 = i + 1;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf("(");
        int iLastIndexOf2 = name.lastIndexOf(".");
        if (iLastIndexOf2 == -1) {
            strSubstring = "";
        } else {
            strSubstring = name.substring(iLastIndexOf2, name.length());
            name = name.substring(0, iLastIndexOf2);
        }
        if (iLastIndexOf != -1) {
            name = name.substring(0, iLastIndexOf);
        }
        File file2 = new File(file.getParentFile(), name + "(" + i2 + ")" + strSubstring);
        return file2.exists() ? getUniqueFile(file, i2) : file2;
    }

    public static InputStream getFileInputStream(Context context, Uri uri) {
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (SecurityException e) {
            Log.e(TAG, "Content provider " + uri.getAuthority() + " has not given permission to read file stream", e);
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "ContentProvider " + uri.getAuthority() + " had a problem while getting file stream with uri " + uri, e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyStream(FileInputStream fileInputStream, OutputStream outputStream, IFileUtilsProgression iFileUtilsProgression) {
        long size;
        int i;
        boolean zCopyFileProgress;
        if (fileInputStream == null) {
            return false;
        }
        if (iFileUtilsProgression != null) {
            iFileUtilsProgression.copyFileStarted();
        }
        try {
            size = fileInputStream.getChannel().size() / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        } catch (IOException e) {
            e.printStackTrace();
            size = 0;
        }
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(outputStream);
        try {
            channel.position(0L);
            i = 0;
            zCopyFileProgress = false;
        } catch (IOException e2) {
            e2.printStackTrace();
            if (iFileUtilsProgression != null) {
                iFileUtilsProgression.copyError();
            }
        }
        while (channel.read(byteBufferAllocate) != -1) {
            byteBufferAllocate.flip();
            writableByteChannelNewChannel.write(byteBufferAllocate);
            byteBufferAllocate.clear();
            i++;
            int iMin = Math.min((int) (((long) (i * 100)) / Math.max(1L, size)), 100);
            if (iFileUtilsProgression != null) {
                zCopyFileProgress = iFileUtilsProgression.copyFileProgress(iMin);
            }
            if (zCopyFileProgress) {
                iFileUtilsProgression.copyCanceled();
                return false;
            }
            if (iFileUtilsProgression != null) {
                iFileUtilsProgression.copyFileEnded();
            }
            return true;
        }
        if (iFileUtilsProgression != null) {
        }
        return true;
    }

    public static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }
}

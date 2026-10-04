package com.myscript.atk.resourcemanager.internal.helper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
public class Md5Helper {
    private static final String ALGORITHM = "MD5";

    public static String getMd5(String str) throws NoSuchAlgorithmException, IOException {
        return getMd5(new FileInputStream(new File(str)));
    }

    public static String getMd5(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[8192];
        int i2 = bufferedInputStream.read(bArr);
        while (true) {
            if (i2 < 0) {
                break;
            }
            messageDigest.update(bArr, 0, i2);
            i2 = bufferedInputStream.read(bArr);
        }
        inputStream.close();
        bufferedInputStream.close();
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String getMd5ForString(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}

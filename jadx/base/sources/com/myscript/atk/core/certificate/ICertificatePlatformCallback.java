package com.myscript.atk.core.certificate;

/* JADX INFO: loaded from: classes4.dex */
public interface ICertificatePlatformCallback {
    String getAppName();

    long getDate();

    String getDeviceId();

    byte[] getInstanceData();

    long getLastSuccessfulConnectionDate();

    byte[] getLicenseData();

    void init(byte[] bArr);

    byte[] requestLicenseData(String str);

    void reset(byte[] bArr);

    void storeInstanceData(byte[] bArr);

    void storeLastSuccessfulConnectionDate();

    void storeLicenseData(byte[] bArr);
}

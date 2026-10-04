package com.revenuecat.purchases.utils;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.ChecksumKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: UrlConnectionFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a$\u0010\u000b\u001a\u00020\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0000\u001a,\u0010\u0012\u001a\u00020\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"DEFAULT_CONNECTION_TIMEOUT_MS", "", "DOWNLOAD_BUFFER_SIZE", "streamWithDigest", "", "input", "Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "digest", "Ljava/security/MessageDigest;", "downloadToFile", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", ImagesContract.URL, "", "outputFile", "Ljava/io/File;", "description", "downloadToFileAndVerifyChecksum", "expectedChecksum", "Lcom/revenuecat/purchases/models/Checksum;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class UrlConnectionFactoryKt {
    public static final int DEFAULT_CONNECTION_TIMEOUT_MS = 5000;
    private static final int DOWNLOAD_BUFFER_SIZE = 262144;

    private static final void streamWithDigest(InputStream inputStream, OutputStream outputStream, MessageDigest messageDigest) throws IOException {
        byte[] bArr = new byte[262144];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            messageDigest.update(bArr, 0, i);
            outputStream.write(bArr, 0, i);
        }
    }

    public static final void downloadToFile(UrlConnectionFactory urlConnectionFactory, String url, File outputFile, String description) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(description, "description");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Downloading " + description + " from " + url);
        }
        UrlConnection urlConnection = null;
        try {
            UrlConnection urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(urlConnectionFactory, url, 5000, 5000, null, 8, null);
            try {
                if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                    throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading " + description + " from " + url);
                }
                FileOutputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
                try {
                    InputStream inputStream2 = inputStream;
                    inputStream = new FileOutputStream(outputFile);
                    try {
                        ByteStreamsKt.copyTo$default(inputStream2, inputStream, 0, 2, null);
                        CloseableKt.closeFinally(inputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        if (urlConnectionCreateConnection$default != null) {
                            urlConnectionCreateConnection$default.disconnect();
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th2) {
                th = th2;
                urlConnection = urlConnectionCreateConnection$default;
                if (urlConnection == null) {
                    throw th;
                }
                urlConnection.disconnect();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static final void downloadToFileAndVerifyChecksum(UrlConnectionFactory urlConnectionFactory, String url, File outputFile, Checksum expectedChecksum, String description) throws Throwable {
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(expectedChecksum, "expectedChecksum");
        Intrinsics.checkNotNullParameter(description, "description");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Downloading " + description + " from " + url);
        }
        MessageDigest digest = MessageDigest.getInstance(expectedChecksum.getAlgorithm().getAlgorithmName());
        UrlConnection urlConnection = null;
        try {
            UrlConnection urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(urlConnectionFactory, url, 5000, 5000, null, 8, null);
            try {
                if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                    throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading " + description + " from " + url);
                }
                FileOutputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
                try {
                    InputStream inputStream2 = inputStream;
                    inputStream = new FileOutputStream(outputFile);
                    try {
                        Intrinsics.checkNotNullExpressionValue(digest, "digest");
                        streamWithDigest(inputStream2, inputStream, digest);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        Checksum.Algorithm algorithm = expectedChecksum.getAlgorithm();
                        byte[] bArrDigest = digest.digest();
                        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest()");
                        Checksum checksum = new Checksum(algorithm, ChecksumKt.toHexString(bArrDigest));
                        if (!Intrinsics.areEqual(checksum, expectedChecksum)) {
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Downloaded " + description + " at " + url + " failed " + expectedChecksum.getAlgorithm().getAlgorithmName() + " verification. expected=" + expectedChecksum.getValue() + ", actual=" + checksum.getValue(), null);
                            throw new Checksum.ChecksumValidationException();
                        }
                        if (urlConnectionCreateConnection$default != null) {
                            urlConnectionCreateConnection$default.disconnect();
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                th = th;
                urlConnection = urlConnectionCreateConnection$default;
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

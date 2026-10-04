package com.revenuecat.purchases.storage;

import android.content.Context;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.networking.ETagPayloadStore;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.ChecksumKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DefaultFileRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u00020\u000e*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006 "}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileCache;", "Lcom/revenuecat/purchases/storage/LocalFileCache;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "subDir", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cacheDir", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "cacheDir$delegate", "Lkotlin/Lazy;", "isFalse", "", "(Z)Z", "cachedContentExists", "uri", "Ljava/net/URI;", "generateLocalFilesystemURI", "remoteURL", "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "saveData", "", "inputStream", "Ljava/io/InputStream;", "streamToFile", "file", "streamToFileAndCompareChecksum", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DefaultFileCache implements LocalFileCache {
    private static final int BUFFER_SIZE = 262144;
    public static final String DEFAULT_SUBDIR = "rc_files";

    /* JADX INFO: renamed from: cacheDir$delegate, reason: from kotlin metadata */
    private final Lazy cacheDir;
    private final Context context;
    private final String subDir;

    private final boolean isFalse(boolean z) {
        return !z;
    }

    public DefaultFileCache(Context context, String subDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subDir, "subDir");
        this.context = context;
        this.subDir = subDir;
        this.cacheDir = LazyKt.lazy(new Function0<File>() { // from class: com.revenuecat.purchases.storage.DefaultFileCache$cacheDir$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file = new File(this.this$0.context.getCacheDir(), this.this$0.subDir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
        });
    }

    public /* synthetic */ DefaultFileCache(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? DEFAULT_SUBDIR : str);
    }

    private final File getCacheDir() {
        return (File) this.cacheDir.getValue();
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public URI generateLocalFilesystemURI(URL remoteURL, Checksum checksum) {
        String value;
        Intrinsics.checkNotNullParameter(remoteURL, "remoteURL");
        String string = remoteURL.toString();
        Intrinsics.checkNotNullExpressionValue(string, "remoteURL.toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        StringBuilder sbAppend = new StringBuilder().append(new File(UtilsKt.md5Hex(bytes)).getName());
        if (checksum == null || (value = checksum.getValue()) == null) {
            value = "";
        }
        String string2 = sbAppend.append(value).toString();
        if (string2.length() == 0) {
            return null;
        }
        String path = remoteURL.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "remoteURL.path");
        return new File(getCacheDir(), string2 + '.' + StringsKt.substringAfterLast(path, '.', "")).toURI();
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public boolean cachedContentExists(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new File(uri).exists();
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public void saveData(InputStream inputStream, URI uri, Checksum checksum) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(uri, "uri");
        File file = new File(uri);
        File tempFile = File.createTempFile("rc_download_", ETagPayloadStore.TEMP_SUFFIX, file.getParentFile());
        try {
            if (checksum != null) {
                Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
                if (isFalse(streamToFileAndCompareChecksum(inputStream, tempFile, checksum))) {
                    return;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
                streamToFile(inputStream, tempFile);
            }
            if (!tempFile.renameTo(file)) {
                try {
                    FilesKt.copyTo$default(tempFile, file, true, 0, 4, null);
                } catch (Exception e) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Failed to copy temp file to final file: " + e.getMessage());
                    }
                    file.delete();
                }
            }
        } finally {
            tempFile.delete();
        }
    }

    private final void streamToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ByteStreamsKt.copyTo(inputStream, fileOutputStream, 262144);
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    private final boolean streamToFileAndCompareChecksum(InputStream inputStream, File file, Checksum checksum) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(checksum.getAlgorithm().getAlgorithmName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bArr = new byte[262144];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                    fileOutputStream2.write(bArr, 0, i);
                } else {
                    fileOutputStream2.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    byte[] hash = messageDigest.digest();
                    Checksum.Algorithm algorithm = checksum.getAlgorithm();
                    Intrinsics.checkNotNullExpressionValue(hash, "hash");
                    return Intrinsics.areEqual(checksum, new Checksum(algorithm, ChecksumKt.toHexString(hash)));
                }
            }
        } finally {
        }
    }
}

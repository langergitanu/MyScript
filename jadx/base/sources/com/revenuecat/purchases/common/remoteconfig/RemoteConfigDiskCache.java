package com.revenuecat.purchases.common.remoteconfig;

import android.content.Context;
import androidx.core.util.AtomicFile;
import com.revenuecat.purchases.common.JsonProvider;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: RemoteConfigDiskCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\n\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigDiskCache;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "json", "Lkotlinx/serialization/json/Json;", "lock", "snapshot", "Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState;", "snapshotLoaded", "", "clear", "", "read", "readFromDisk", "targetFile", "Ljava/io/File;", "write", "config", "writeToDisk", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigDiskCache {
    private static final Companion Companion = new Companion(null);
    private static final String REMOTE_CONFIG_FILE_NAME = "remote_config.json";
    private static final String REMOTE_CONFIG_ROOT = "RevenueCat";
    private static final String REMOTE_CONFIG_SUBDIR = "remote_config";
    private final Context applicationContext;
    private final Json json;
    private final Object lock;
    private PersistedRemoteConfigurationState snapshot;
    private boolean snapshotLoaded;

    public RemoteConfigDiskCache(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.json = JsonProvider.INSTANCE.getDefaultJson();
        this.lock = new Object();
    }

    public final PersistedRemoteConfigurationState read() {
        PersistedRemoteConfigurationState persistedRemoteConfigurationState;
        synchronized (this.lock) {
            if (!this.snapshotLoaded) {
                this.snapshot = readFromDisk();
                this.snapshotLoaded = true;
            }
            persistedRemoteConfigurationState = this.snapshot;
        }
        return persistedRemoteConfigurationState;
    }

    public final boolean write(PersistedRemoteConfigurationState config) {
        boolean zWriteToDisk;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            zWriteToDisk = writeToDisk(config);
            if (zWriteToDisk) {
                this.snapshot = config;
                this.snapshotLoaded = true;
            }
        }
        return zWriteToDisk;
    }

    private final PersistedRemoteConfigurationState readFromDisk() {
        File fileTargetFile = targetFile();
        if (!fileTargetFile.exists()) {
            return null;
        }
        AtomicFile atomicFile = new AtomicFile(fileTargetFile);
        try {
            Json json = this.json;
            KSerializer<PersistedRemoteConfigurationState> kSerializerSerializer = PersistedRemoteConfigurationState.INSTANCE.serializer();
            byte[] fully = atomicFile.readFully();
            Intrinsics.checkNotNullExpressionValue(fully, "atomicFile.readFully()");
            return (PersistedRemoteConfigurationState) json.decodeFromString(kSerializerSerializer, new String(fully, Charsets.UTF_8));
        } catch (IOException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to read remote config from disk.", e);
            return null;
        } catch (SerializationException e2) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to deserialize remote config from disk.", e2);
            return null;
        }
    }

    private final boolean writeToDisk(PersistedRemoteConfigurationState config) {
        try {
            try {
                File fileTargetFile = targetFile();
                File parentFile = fileTargetFile.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                String strEncodeToString = this.json.encodeToString(PersistedRemoteConfigurationState.INSTANCE.serializer(), config);
                AtomicFile atomicFile = new AtomicFile(fileTargetFile);
                FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                Intrinsics.checkNotNullExpressionValue(fileOutputStreamStartWrite, "atomicFile.startWrite()");
                try {
                    byte[] bytes = strEncodeToString.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    fileOutputStreamStartWrite.write(bytes);
                    atomicFile.finishWrite(fileOutputStreamStartWrite);
                    return true;
                } catch (IOException e) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                    throw e;
                }
            } catch (IOException e2) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to persist remote config to disk.", e2);
                return false;
            }
        } catch (SerializationException e3) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to serialize remote config for disk persistence.", e3);
            return false;
        }
    }

    public final void clear() {
        synchronized (this.lock) {
            this.snapshot = null;
            this.snapshotLoaded = true;
            try {
                new AtomicFile(targetFile()).delete();
            } catch (SecurityException e) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to clear remote config from disk.", e);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final File targetFile() {
        return new File(new File(new File(this.applicationContext.getNoBackupFilesDir(), "RevenueCat"), REMOTE_CONFIG_SUBDIR), REMOTE_CONFIG_FILE_NAME);
    }

    /* JADX INFO: compiled from: RemoteConfigDiskCache.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigDiskCache$Companion;", "", "()V", "REMOTE_CONFIG_FILE_NAME", "", "REMOTE_CONFIG_ROOT", "REMOTE_CONFIG_SUBDIR", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

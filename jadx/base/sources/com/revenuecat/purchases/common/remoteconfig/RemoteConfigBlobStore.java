package com.revenuecat.purchases.common.remoteconfig;

import android.content.Context;
import androidx.core.util.AtomicFile;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: RemoteConfigBlobStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\u0007J\u0014\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0016\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "knownRefs", "", "", "lock", "blobFile", "Ljava/io/File;", "ref", "blobsDir", "cachedRefs", "", "clear", "", "contains", "", "deleteQuietly", "file", "loadedRefs", "read", "", "retainOnly", "refs", "write", "data", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigBlobStore {
    private static final String BLOBS_DIR = "blobs";
    private static final Companion Companion = new Companion(null);
    private static final String REMOTE_CONFIG_ROOT = "RevenueCat";
    private final Context applicationContext;
    private Set<String> knownRefs;
    private final Object lock;

    public RemoteConfigBlobStore(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.lock = new Object();
    }

    public final boolean contains(String ref) {
        boolean zContains;
        Intrinsics.checkNotNullParameter(ref, "ref");
        synchronized (this.lock) {
            zContains = loadedRefs().contains(ref);
        }
        return zContains;
    }

    public final byte[] read(String ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        File fileBlobFile = blobFile(ref);
        if (fileBlobFile == null || !fileBlobFile.exists()) {
            fileBlobFile = null;
        }
        if (fileBlobFile == null) {
            synchronized (this.lock) {
                Set<String> set = this.knownRefs;
                if (set != null) {
                    Boolean.valueOf(set.remove(ref));
                }
            }
            return null;
        }
        try {
            return FilesKt.readBytes(fileBlobFile);
        } catch (IOException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to read remote config blob '" + ref + "' from disk.", e);
            return null;
        }
    }

    public final boolean write(String ref, byte[] data) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        Intrinsics.checkNotNullParameter(data, "data");
        File fileBlobFile = blobFile(ref);
        if (fileBlobFile != null) {
            try {
                AtomicFile atomicFile = new AtomicFile(fileBlobFile);
                FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                Intrinsics.checkNotNullExpressionValue(fileOutputStreamStartWrite, "atomicFile.startWrite()");
                try {
                    fileOutputStreamStartWrite.write(data);
                    atomicFile.finishWrite(fileOutputStreamStartWrite);
                    synchronized (this.lock) {
                        loadedRefs().add(ref);
                    }
                    return true;
                } catch (IOException e) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                    throw e;
                }
            } catch (IOException e2) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to persist remote config blob '" + ref + "' to disk.", e2);
                return false;
            }
        }
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Refusing to write remote config blob with malformed ref '" + ref + "'.", null);
        return false;
    }

    public final Set<String> cachedRefs() {
        Set<String> set;
        synchronized (this.lock) {
            set = CollectionsKt.toSet(loadedRefs());
        }
        return set;
    }

    public final void retainOnly(Set<String> refs) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(refs, "refs");
        File fileBlobsDir = blobsDir();
        if (fileBlobsDir.exists() && (fileArrListFiles = fileBlobsDir.listFiles()) != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.isFile() && !refs.contains(file.getName())) {
                    arrayList.add(file);
                }
            }
            for (File it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                deleteQuietly(it);
            }
        }
        synchronized (this.lock) {
            loadedRefs().retainAll(refs);
        }
    }

    public final void clear() {
        File[] fileArrListFiles;
        synchronized (this.lock) {
            File fileBlobsDir = blobsDir();
            if (fileBlobsDir.exists() && (fileArrListFiles = fileBlobsDir.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles()");
                for (File it : fileArrListFiles) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    deleteQuietly(it);
                }
            }
            this.knownRefs = new LinkedHashSet();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Set<String> loadedRefs() {
        File[] fileArrListFiles;
        Sequence sequenceAsSequence;
        Sequence sequenceFilter;
        Sequence map;
        LinkedHashSet linkedHashSet = this.knownRefs;
        if (linkedHashSet == null) {
            File fileBlobsDir = blobsDir();
            if (!fileBlobsDir.exists()) {
                fileBlobsDir = null;
            }
            if (fileBlobsDir == null || (fileArrListFiles = fileBlobsDir.listFiles()) == null || (sequenceAsSequence = ArraysKt.asSequence(fileArrListFiles)) == null || (sequenceFilter = SequencesKt.filter(sequenceAsSequence, new Function1<File, Boolean>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore$loadedRefs$1$scanned$2
                /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(File file) {
                    boolean z;
                    if (file.isFile()) {
                        RemoteConfigUtils remoteConfigUtils = RemoteConfigUtils.INSTANCE;
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "it.name");
                        z = remoteConfigUtils.isValidRef(name);
                    }
                    return Boolean.valueOf(z);
                }
            })) == null || (map = SequencesKt.map(sequenceFilter, new Function1<File, String>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore$loadedRefs$1$scanned$3
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(File file) {
                    return file.getName();
                }
            })) == null || (linkedHashSet = SequencesKt.toMutableSet(map)) == null) {
                linkedHashSet = new LinkedHashSet();
            }
            this.knownRefs = linkedHashSet;
        }
        return linkedHashSet;
    }

    private final void deleteQuietly(File file) {
        try {
            if (file.delete()) {
                return;
            }
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to delete unreferenced remote config blob '" + file.getName() + "'.", null);
        } catch (SecurityException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to delete unreferenced remote config blob '" + file.getName() + "'.", e);
        }
    }

    private final File blobsDir() {
        return new File(new File(this.applicationContext.getNoBackupFilesDir(), "RevenueCat"), BLOBS_DIR);
    }

    private final File blobFile(String ref) {
        if (RemoteConfigUtils.INSTANCE.isValidRef(ref)) {
            return new File(blobsDir(), ref);
        }
        return null;
    }

    /* JADX INFO: compiled from: RemoteConfigBlobStore.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore$Companion;", "", "()V", "BLOBS_DIR", "", "REMOTE_CONFIG_ROOT", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

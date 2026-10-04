package com.myscript.nebo.dms.core;

import android.util.Log;
import com.myscript.snt.dms.IZipArchiver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: AndroidZipArchiver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/AndroidZipArchiver;", "Lcom/myscript/snt/dms/IZipArchiver;", "<init>", "()V", "openWriteArchives", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/zip/ZipOutputStream;", "openReadArchives", "Ljava/util/zip/ZipFile;", "addFile", "", "archivePath", "entryName", "sourceFilePath", "listEntries", "", "(Ljava/lang/String;)[Ljava/lang/String;", "extractEntry", "destFilePath", "closeArchive", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AndroidZipArchiver implements IZipArchiver {
    private static final int BUFFER_SIZE = 8192;
    private static final String TAG = "AndroidZipArchiver";
    public static final int $stable = 8;
    private final ConcurrentHashMap<String, ZipOutputStream> openWriteArchives = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ZipFile> openReadArchives = new ConcurrentHashMap<>();

    @Override // com.myscript.snt.dms.IZipArchiver
    public boolean addFile(String archivePath, String entryName, String sourceFilePath) {
        Object objM14499constructorimpl;
        ZipOutputStream zipOutputStreamPutIfAbsent;
        Intrinsics.checkNotNullParameter(archivePath, "archivePath");
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        Intrinsics.checkNotNullParameter(sourceFilePath, "sourceFilePath");
        ConcurrentHashMap<String, ZipOutputStream> concurrentHashMap = this.openWriteArchives;
        ZipOutputStream zipOutputStream = concurrentHashMap.get(archivePath);
        if (zipOutputStream == null && (zipOutputStreamPutIfAbsent = concurrentHashMap.putIfAbsent(archivePath, (zipOutputStream = new ZipOutputStream(new FileOutputStream(archivePath))))) != null) {
            zipOutputStream = zipOutputStreamPutIfAbsent;
        }
        ZipOutputStream zipOutputStream2 = zipOutputStream;
        try {
            Intrinsics.checkNotNull(zipOutputStream2);
            synchronized (zipOutputStream2) {
                FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
                try {
                    FileInputStream fileInputStream2 = fileInputStream;
                    zipOutputStream2.putNextEntry(new ZipEntry(entryName));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i > 0) {
                            zipOutputStream2.write(bArr, 0, i);
                        } else {
                            zipOutputStream2.closeEntry();
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream, null);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } finally {
                }
            }
            return true;
        } catch (IOException e) {
            Log.e(TAG, "addFile failed for " + archivePath + "!/" + entryName + " <- " + sourceFilePath, e);
            ZipOutputStream zipOutputStreamRemove = this.openWriteArchives.remove(archivePath);
            if (zipOutputStreamRemove != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    zipOutputStreamRemove.close();
                    objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                }
                Result.m14498boximpl(objM14499constructorimpl);
            }
            return false;
        }
    }

    @Override // com.myscript.snt.dms.IZipArchiver
    public String[] listEntries(String archivePath) {
        ZipFile zipFilePutIfAbsent;
        Intrinsics.checkNotNullParameter(archivePath, "archivePath");
        try {
            ConcurrentHashMap<String, ZipFile> concurrentHashMap = this.openReadArchives;
            ZipFile zipFile = concurrentHashMap.get(archivePath);
            if (zipFile == null && (zipFilePutIfAbsent = concurrentHashMap.putIfAbsent(archivePath, (zipFile = new ZipFile(archivePath)))) != null) {
                zipFile = zipFilePutIfAbsent;
            }
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            Intrinsics.checkNotNullExpressionValue(enumerationEntries, "entries(...)");
            return (String[]) SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.asSequence(CollectionsKt.iterator(enumerationEntries)), new Function1() { // from class: com.myscript.nebo.dms.core.AndroidZipArchiver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AndroidZipArchiver.listEntries$lambda$1((ZipEntry) obj));
                }
            }), new Function1() { // from class: com.myscript.nebo.dms.core.AndroidZipArchiver$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ((ZipEntry) obj).getName();
                }
            })).toArray(new String[0]);
        } catch (IOException e) {
            Log.e(TAG, "listEntries failed for " + archivePath, e);
            return new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean listEntries$lambda$1(ZipEntry zipEntry) {
        return !zipEntry.isDirectory();
    }

    @Override // com.myscript.snt.dms.IZipArchiver
    public boolean extractEntry(String archivePath, String entryName, String destFilePath) {
        ZipFile zipFilePutIfAbsent;
        Intrinsics.checkNotNullParameter(archivePath, "archivePath");
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        Intrinsics.checkNotNullParameter(destFilePath, "destFilePath");
        try {
            ConcurrentHashMap<String, ZipFile> concurrentHashMap = this.openReadArchives;
            ZipFile zipFile = concurrentHashMap.get(archivePath);
            if (zipFile == null && (zipFilePutIfAbsent = concurrentHashMap.putIfAbsent(archivePath, (zipFile = new ZipFile(archivePath)))) != null) {
                zipFile = zipFilePutIfAbsent;
            }
            ZipFile zipFile2 = zipFile;
            ZipEntry entry = zipFile2.getEntry(entryName);
            if (entry == null) {
                return false;
            }
            File file = new File(destFilePath);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream inputStream = zipFile2.getInputStream(entry);
            try {
                InputStream inputStream2 = inputStream;
                inputStream = new FileOutputStream(file);
                try {
                    Intrinsics.checkNotNull(inputStream2);
                    ByteStreamsKt.copyTo(inputStream2, inputStream, 8192);
                    CloseableKt.closeFinally(inputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            Log.e(TAG, "extractEntry failed for " + archivePath + "!/" + entryName + " -> " + destFilePath, e);
            return false;
        }
    }

    @Override // com.myscript.snt.dms.IZipArchiver
    public boolean closeArchive(String archivePath) {
        Intrinsics.checkNotNullParameter(archivePath, "archivePath");
        ZipOutputStream zipOutputStreamRemove = this.openWriteArchives.remove(archivePath);
        ZipFile zipFileRemove = this.openReadArchives.remove(archivePath);
        boolean z = true;
        if (zipOutputStreamRemove == null && zipFileRemove == null) {
            return true;
        }
        if (zipOutputStreamRemove != null) {
            try {
                zipOutputStreamRemove.close();
            } catch (IOException e) {
                Log.e(TAG, "closeArchive (write) failed for " + archivePath, e);
                z = false;
            }
        }
        if (zipFileRemove != null) {
            try {
                zipFileRemove.close();
            } catch (IOException e2) {
                Log.e(TAG, "closeArchive (read) failed for " + archivePath, e2);
                return false;
            }
        }
        return z;
    }
}

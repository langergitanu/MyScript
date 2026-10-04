package com.myscript.shared.datacollect;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.FilesKt;
import kotlin.sequences.SequencesKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: ZipUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0005¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/shared/datacollect/ZipUtils;", "", "<init>", "()V", "createZipArchive", "Ljava/io/File;", "outputDir", "filesToZip", "", "zipFileName", "", "addFileEntry", "", "zos", "Ljava/util/zip/ZipOutputStream;", "file", "entryName", "buffer", "", "addDirectoryEntries", "dir", "entryPrefix", "calculateSHA256", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ZipUtils {
    public static final ZipUtils INSTANCE = new ZipUtils();

    private ZipUtils() {
    }

    public final File createZipArchive(File outputDir, List<? extends File> filesToZip, String zipFileName) {
        Intrinsics.checkNotNullParameter(outputDir, "outputDir");
        Intrinsics.checkNotNullParameter(filesToZip, "filesToZip");
        Intrinsics.checkNotNullParameter(zipFileName, "zipFileName");
        List<? extends File> list = filesToZip;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (File file : list) {
                if (!file.isFile() && !file.isDirectory()) {
                    return null;
                }
            }
        }
        File file2 = new File(outputDir, zipFileName);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            try {
                ZipOutputStream zipOutputStream2 = zipOutputStream;
                byte[] bArr = new byte[1024];
                for (File file3 : filesToZip) {
                    if (file3.isFile()) {
                        ZipUtils zipUtils = INSTANCE;
                        String name = file3.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        zipUtils.addFileEntry(zipOutputStream2, file3, name, bArr);
                    } else if (file3.isDirectory()) {
                        ZipUtils zipUtils2 = INSTANCE;
                        String name2 = file3.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        zipUtils2.addDirectoryEntries(zipOutputStream2, file3, name2, bArr);
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zipOutputStream, null);
                return file2;
            } finally {
            }
        } catch (Exception unused) {
            if (file2.exists()) {
                file2.delete();
            }
            return null;
        }
    }

    private final void addFileEntry(ZipOutputStream zos, File file, String entryName, byte[] buffer) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            zos.putNextEntry(new ZipEntry(entryName));
            while (true) {
                int i = fileInputStream2.read(buffer);
                if (i > 0) {
                    zos.write(buffer, 0, i);
                } else {
                    zos.closeEntry();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
            }
        } finally {
        }
    }

    private final void addDirectoryEntries(ZipOutputStream zos, File dir, String entryPrefix, byte[] buffer) {
        for (File file : SequencesKt.filter(FilesKt.walkTopDown(dir), new Function1() { // from class: com.myscript.shared.datacollect.ZipUtils$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ZipUtils.addDirectoryEntries$lambda$0((File) obj));
            }
        })) {
            INSTANCE.addFileEntry(zos, file, entryPrefix + DomExceptionUtils.SEPARATOR + FilesKt.relativeTo(file, dir), buffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addDirectoryEntries$lambda$0(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isFile();
    }

    public final String calculateSHA256(File file) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream2.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    byte[] bArrDigest = messageDigest.digest();
                    Intrinsics.checkNotNull(bArrDigest);
                    return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.myscript.shared.datacollect.ZipUtils$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ZipUtils.calculateSHA256$lambda$1(((Byte) obj).byteValue());
                        }
                    }, 30, (Object) null);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence calculateSHA256$lambda$1(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}

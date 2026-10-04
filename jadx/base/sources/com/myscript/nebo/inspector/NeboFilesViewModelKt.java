package com.myscript.nebo.inspector;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"filepathMd5sum", "", "Ljava/io/File;", "getFilepathMd5sum", "(Ljava/io/File;)Ljava/lang/String;", "nebo-inspector_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFilesViewModelKt {
    public static final String getFilepathMd5sum(File file) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        byte[] bytes = absolutePath.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String string = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.padStart(string, 32, '0');
    }
}

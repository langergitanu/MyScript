package com.myscript.nebo.inspector;

import android.content.Context;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NeboInspectorActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"createNeboFile", "Lcom/myscript/nebo/inspector/NeboFile;", "Landroid/content/Context;", "file", "Ljava/io/File;", "nebo-inspector_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboInspectorActivityKt {
    public static final NeboFile createNeboFile(Context context, File file) {
        String absolutePath;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        File parentFile = context.getFilesDir().getParentFile();
        if (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null) {
            absolutePath = "";
        }
        String absolutePath2 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        return new NeboFile(file, StringsKt.removePrefix(absolutePath2, (CharSequence) (absolutePath + DomExceptionUtils.SEPARATOR)));
    }
}

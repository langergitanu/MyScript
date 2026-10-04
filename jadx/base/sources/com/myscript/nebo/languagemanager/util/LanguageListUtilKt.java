package com.myscript.nebo.languagemanager.util;

import com.myscript.atk.resourcemanager.internal.Constants;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageListUtil.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u0002H\u0002¨\u0006\u0006"}, m1599d2 = {"isAncestorOf", "", "Ljava/io/File;", "other", "listConfFiles", "", "language-manager_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageListUtilKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isAncestorOf(File file, File file2) {
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String absolutePath2 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        return StringsKt.startsWith$default(absolutePath, absolutePath2, false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<File> listConfFiles(File file) {
        List<File> list;
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.myscript.nebo.languagemanager.util.LanguageListUtilKt$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return LanguageListUtilKt.listConfFiles$lambda$0(file2);
            }
        });
        return (fileArrListFiles == null || (list = ArraysKt.toList(fileArrListFiles)) == null) ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean listConfFiles$lambda$0(File file) {
        if (!file.isFile()) {
            return false;
        }
        Intrinsics.checkNotNull(file);
        return Intrinsics.areEqual(FilesKt.getExtension(file), StringsKt.removePrefix(Constants.CONF_FILENAME_EXT, (CharSequence) "."));
    }
}

package com.myscript.nebo.inspector;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NeboFilesInspector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fR\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFilesInspector;", "", "inputDirs", "", "Ljava/io/File;", "rootOutputDir", "<init>", "([Ljava/io/File;Ljava/io/File;)V", "[Ljava/io/File;", "HiddenNeboFileFilter", "Lkotlin/Function1;", "", "getHiddenNeboFileFilter", "()Lkotlin/jvm/functions/Function1;", "findFiles", "", "acceptFilter", "clear", "", "files", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFilesInspector {
    private final Function1<File, Boolean> HiddenNeboFileFilter;
    private final File[] inputDirs;
    private final File rootOutputDir;

    public NeboFilesInspector(File[] inputDirs, File rootOutputDir) {
        Intrinsics.checkNotNullParameter(inputDirs, "inputDirs");
        Intrinsics.checkNotNullParameter(rootOutputDir, "rootOutputDir");
        this.inputDirs = inputDirs;
        this.rootOutputDir = rootOutputDir;
        this.HiddenNeboFileFilter = new Function1() { // from class: com.myscript.nebo.inspector.NeboFilesInspector$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NeboFilesInspector.HiddenNeboFileFilter$lambda$0(this.f$0, (File) obj));
            }
        };
    }

    public final Function1<File, Boolean> getHiddenNeboFileFilter() {
        return this.HiddenNeboFileFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HiddenNeboFileFilter$lambda$0(NeboFilesInspector neboFilesInspector, File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.isDirectory() || FilesKt.startsWith(file, neboFilesInspector.rootOutputDir) || !Intrinsics.areEqual(FilesKt.getExtension(file), "nebo")) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        if (StringsKt.contains$default((CharSequence) absolutePath, (CharSequence) "/test_user_dir/", false, 2, (Object) null)) {
            return false;
        }
        String absolutePath2 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        if (StringsKt.contains$default((CharSequence) absolutePath2, (CharSequence) "/user_dir/", false, 2, (Object) null)) {
            return false;
        }
        String absolutePath3 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
        if (StringsKt.contains$default((CharSequence) absolutePath3, (CharSequence) "/cache/page_preview/", false, 2, (Object) null)) {
            return false;
        }
        String absolutePath4 = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath4, "getAbsolutePath(...)");
        return !StringsKt.contains$default((CharSequence) absolutePath4, (CharSequence) "/cache/sharepage/", false, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findFiles$default(NeboFilesInspector neboFilesInspector, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = neboFilesInspector.HiddenNeboFileFilter;
        }
        return neboFilesInspector.findFiles(function1);
    }

    public final List<File> findFiles(Function1<? super File, Boolean> acceptFilter) {
        Intrinsics.checkNotNullParameter(acceptFilter, "acceptFilter");
        ArrayList arrayList = new ArrayList();
        for (File file : this.inputDirs) {
            for (File file2 : FilesKt.walk$default(file, null, 1, null)) {
                if (acceptFilter.invoke(file2).booleanValue()) {
                    arrayList.add(file2);
                }
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    public final void clear(List<? extends File> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        Iterator<T> it = files.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }
}

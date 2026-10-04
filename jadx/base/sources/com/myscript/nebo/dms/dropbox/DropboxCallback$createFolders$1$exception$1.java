package com.myscript.nebo.dms.dropbox;

import com.myscript.snt.dms.CloudFile;
import com.myscript.snt.dms.CloudFileData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropboxCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class DropboxCallback$createFolders$1$exception$1 extends AdaptedFunctionReference implements Function2<String, CloudFile, List<CloudFileData>> {
    DropboxCallback$createFolders$1$exception$1(Object obj) {
        super(2, obj, DropboxCallback.class, "listFromCache", "listFromCache(Ljava/lang/String;Lcom/myscript/snt/dms/CloudFile;Z)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final List<CloudFileData> invoke(String str, CloudFile p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return DropboxCallback.listFromCache$default((DropboxCallback) this.receiver, str, p1, false, 4, null);
    }
}

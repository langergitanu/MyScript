package com.myscript.nebo.dms.dropbox.api;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxClientV2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: ListFolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0086\u0002¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/ListFolder;", "", "<init>", "()V", "get", "", "Lcom/dropbox/core/v2/files/Metadata;", "dbxClient", "Lcom/dropbox/core/v2/DbxClientV2;", ClientCookie.PATH_ATTR, "", "recursive", "", "predicate", "Lkotlin/Function1;", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListFolder {
    public static final ListFolder INSTANCE = new ListFolder();

    private ListFolder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List get$default(ListFolder listFolder, DbxClientV2 dbxClientV2, String str, boolean z, Function1 function1, int i, Object obj) throws DbxException {
        if ((i & 8) != 0) {
            function1 = null;
        }
        return listFolder.get(dbxClientV2, str, z, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<com.dropbox.core.p013v2.files.Metadata> get(DbxClientV2 dbxClient, String path, boolean recursive, Function1<? super com.dropbox.core.p013v2.files.Metadata, Boolean> predicate) throws DbxException {
        Intrinsics.checkNotNullParameter(dbxClient, "dbxClient");
        if (path == null) {
            path = "";
        }
        List<com.dropbox.core.p013v2.files.Metadata> entries = dbxClient.files().listFolderBuilder(Intrinsics.areEqual(path, DomExceptionUtils.SEPARATOR) ? "" : path).withRecursive(Boolean.valueOf(recursive)).start().getEntries();
        if (entries == null) {
            return null;
        }
        if (predicate == null) {
            return entries;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

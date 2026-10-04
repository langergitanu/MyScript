package com.myscript.nebo.dms.dropbox.api;

import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.ListFolderResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: ListFolderByParcel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010!J\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010!J\b\u0010#\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/ListFolderByParcel;", "", "dbxClient", "Lcom/dropbox/core/v2/DbxClientV2;", ClientCookie.PATH_ATTR, "", "startCursor", "recursive", "", "predicate", "Lkotlin/Function1;", "Lcom/dropbox/core/v2/files/Metadata;", "<init>", "(Lcom/dropbox/core/v2/DbxClientV2;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "getDbxClient", "()Lcom/dropbox/core/v2/DbxClientV2;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getStartCursor", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "listFolderResult", "Lcom/dropbox/core/v2/files/ListFolderResult;", "getListFolderResult", "()Lcom/dropbox/core/v2/files/ListFolderResult;", "setListFolderResult", "(Lcom/dropbox/core/v2/files/ListFolderResult;)V", "currentCursor", "getCurrentCursor", "setCurrentCursor", "begin", "", "next", "getCursor", "Companion", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListFolderByParcel {
    public static final String TAG = "ListFolderByParcel";
    private String currentCursor;
    private final DbxClientV2 dbxClient;
    private ListFolderResult listFolderResult;
    private String path;
    private final Function1<com.dropbox.core.p013v2.files.Metadata, Boolean> predicate;
    private final String startCursor;

    /* JADX WARN: Multi-variable type inference failed */
    public ListFolderByParcel(DbxClientV2 dbxClient, String str, String str2, boolean z, Function1<? super com.dropbox.core.p013v2.files.Metadata, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dbxClient, "dbxClient");
        this.dbxClient = dbxClient;
        this.path = str;
        this.startCursor = str2;
        this.predicate = function1;
        this.currentCursor = str2;
        str = str == null ? "" : str;
        this.path = str;
        if (Intrinsics.areEqual(str, DomExceptionUtils.SEPARATOR)) {
            this.path = "";
        }
        try {
            if (this.currentCursor == null) {
                this.listFolderResult = dbxClient.files().listFolderBuilder(this.path).withRecursive(Boolean.valueOf(z)).start();
            } else {
                this.listFolderResult = dbxClient.files().listFolderContinue(this.currentCursor);
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "ListFolderByParcel init failed for folder id or folder path: " + this.path);
            Log.e(TAG, "ListFolderByParcel init failed: " + e.getMessage());
            throw e;
        }
    }

    public /* synthetic */ ListFolderByParcel(DbxClientV2 dbxClientV2, String str, String str2, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dbxClientV2, str, str2, z, (i & 16) != 0 ? null : function1);
    }

    public final DbxClientV2 getDbxClient() {
        return this.dbxClient;
    }

    public final String getPath() {
        return this.path;
    }

    public final Function1<com.dropbox.core.p013v2.files.Metadata, Boolean> getPredicate() {
        return this.predicate;
    }

    public final String getStartCursor() {
        return this.startCursor;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final ListFolderResult getListFolderResult() {
        return this.listFolderResult;
    }

    public final void setListFolderResult(ListFolderResult listFolderResult) {
        this.listFolderResult = listFolderResult;
    }

    public final String getCurrentCursor() {
        return this.currentCursor;
    }

    public final void setCurrentCursor(String str) {
        this.currentCursor = str;
    }

    public final List<com.dropbox.core.p013v2.files.Metadata> begin() throws DbxException {
        List<com.dropbox.core.p013v2.files.Metadata> entries;
        ListFolderResult listFolderResult = this.listFolderResult;
        this.currentCursor = listFolderResult != null ? listFolderResult.getCursor() : null;
        if (this.predicate == null) {
            ListFolderResult listFolderResult2 = this.listFolderResult;
            if (listFolderResult2 != null) {
                return listFolderResult2.getEntries();
            }
            return null;
        }
        ListFolderResult listFolderResult3 = this.listFolderResult;
        if (listFolderResult3 == null || (entries = listFolderResult3.getEntries()) == null) {
            return null;
        }
        Function1<com.dropbox.core.p013v2.files.Metadata, Boolean> function1 = this.predicate;
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (function1.invoke((com.dropbox.core.p013v2.files.Metadata) obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<com.dropbox.core.p013v2.files.Metadata> next() throws DbxException {
        List<com.dropbox.core.p013v2.files.Metadata> entries;
        ListFolderResult listFolderResult = this.listFolderResult;
        if (listFolderResult != null) {
            listFolderResult.getHasMore();
            ListFolderResult listFolderResultListFolderContinue = this.dbxClient.files().listFolderContinue(this.currentCursor);
            this.listFolderResult = listFolderResultListFolderContinue;
            this.currentCursor = listFolderResultListFolderContinue != null ? listFolderResultListFolderContinue.getCursor() : null;
            if (this.predicate != null) {
                ListFolderResult listFolderResult2 = this.listFolderResult;
                if (listFolderResult2 == null || (entries = listFolderResult2.getEntries()) == null) {
                    return null;
                }
                Function1<com.dropbox.core.p013v2.files.Metadata, Boolean> function1 = this.predicate;
                ArrayList arrayList = new ArrayList();
                for (Object obj : entries) {
                    if (function1.invoke((com.dropbox.core.p013v2.files.Metadata) obj).booleanValue()) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            ListFolderResult listFolderResult3 = this.listFolderResult;
            if (listFolderResult3 != null) {
                return listFolderResult3.getEntries();
            }
        }
        return null;
    }

    public final String getCursor() {
        ListFolderResult listFolderResult = this.listFolderResult;
        if (listFolderResult != null) {
            return listFolderResult.getCursor();
        }
        return null;
    }
}

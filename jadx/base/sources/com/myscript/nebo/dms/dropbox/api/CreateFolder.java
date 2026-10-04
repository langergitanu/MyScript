package com.myscript.nebo.dms.dropbox.api;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.FolderMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: CreateFolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\u0002¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/CreateFolder;", "", "<init>", "()V", "get", "Lcom/dropbox/core/v2/files/FolderMetadata;", "dbxClient", "Lcom/dropbox/core/v2/DbxClientV2;", ClientCookie.PATH_ATTR, "", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateFolder {
    public static final CreateFolder INSTANCE = new CreateFolder();

    private CreateFolder() {
    }

    public final FolderMetadata get(DbxClientV2 dbxClient, String path) throws DbxException {
        Intrinsics.checkNotNullParameter(dbxClient, "dbxClient");
        FolderMetadata metadata = dbxClient.files().createFolderV2(path, false).getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "getMetadata(...)");
        return metadata;
    }
}

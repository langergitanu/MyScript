package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ListFilesArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListReceivedFilesBuilder {
    private final ListFilesArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    ListReceivedFilesBuilder(DbxUserSharingRequests dbxUserSharingRequests, ListFilesArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListReceivedFilesBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public ListReceivedFilesBuilder withActions(List<FileAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public ListFilesResult start() throws DbxException {
        return this._client.listReceivedFiles(this._builder.build());
    }
}

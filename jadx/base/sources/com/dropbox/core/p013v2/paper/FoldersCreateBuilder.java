package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.paper.PaperFolderCreateArg;

/* JADX INFO: loaded from: classes4.dex */
public class FoldersCreateBuilder {
    private final PaperFolderCreateArg.Builder _builder;
    private final DbxUserPaperRequests _client;

    FoldersCreateBuilder(DbxUserPaperRequests dbxUserPaperRequests, PaperFolderCreateArg.Builder builder) {
        if (dbxUserPaperRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserPaperRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public FoldersCreateBuilder withParentFolderId(String str) {
        this._builder.withParentFolderId(str);
        return this;
    }

    public FoldersCreateBuilder withIsTeamFolder(Boolean bool) {
        this._builder.withIsTeamFolder(bool);
        return this;
    }

    public PaperFolderCreateResult start() throws DbxException {
        return this._client.foldersCreate(this._builder.build());
    }
}

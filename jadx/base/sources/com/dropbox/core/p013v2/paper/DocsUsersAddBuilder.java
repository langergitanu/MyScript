package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.paper.AddPaperDocUser;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DocsUsersAddBuilder {
    private final AddPaperDocUser.Builder _builder;
    private final DbxUserPaperRequests _client;

    DocsUsersAddBuilder(DbxUserPaperRequests dbxUserPaperRequests, AddPaperDocUser.Builder builder) {
        if (dbxUserPaperRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserPaperRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DocsUsersAddBuilder withCustomMessage(String str) {
        this._builder.withCustomMessage(str);
        return this;
    }

    public DocsUsersAddBuilder withQuiet(Boolean bool) {
        this._builder.withQuiet(bool);
        return this;
    }

    public List<AddPaperDocUserMemberResult> start() throws DbxException {
        return this._client.docsUsersAdd(this._builder.build());
    }
}

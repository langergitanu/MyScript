package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.AddFileMemberArgs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AddFileMemberBuilder {
    private final AddFileMemberArgs.Builder _builder;
    private final DbxUserSharingRequests _client;

    AddFileMemberBuilder(DbxUserSharingRequests dbxUserSharingRequests, AddFileMemberArgs.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public AddFileMemberBuilder withCustomMessage(String str) {
        this._builder.withCustomMessage(str);
        return this;
    }

    public AddFileMemberBuilder withQuiet(Boolean bool) {
        this._builder.withQuiet(bool);
        return this;
    }

    public AddFileMemberBuilder withAccessLevel(AccessLevel accessLevel) {
        this._builder.withAccessLevel(accessLevel);
        return this;
    }

    public AddFileMemberBuilder withAddMessageAsComment(Boolean bool) {
        this._builder.withAddMessageAsComment(bool);
        return this;
    }

    public List<FileMemberActionResult> start() throws DbxException {
        return this._client.addFileMember(this._builder.build());
    }
}

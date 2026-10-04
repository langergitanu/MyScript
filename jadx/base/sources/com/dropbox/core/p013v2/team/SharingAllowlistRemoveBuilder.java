package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.SharingAllowlistRemoveArgs;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SharingAllowlistRemoveBuilder {
    private final SharingAllowlistRemoveArgs.Builder _builder;
    private final DbxTeamTeamRequests _client;

    SharingAllowlistRemoveBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, SharingAllowlistRemoveArgs.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public SharingAllowlistRemoveBuilder withDomains(List<String> list) {
        this._builder.withDomains(list);
        return this;
    }

    public SharingAllowlistRemoveBuilder withEmails(List<String> list) {
        this._builder.withEmails(list);
        return this;
    }

    public SharingAllowlistRemoveResponse start() throws DbxException {
        return this._client.sharingAllowlistRemove(this._builder.build());
    }
}

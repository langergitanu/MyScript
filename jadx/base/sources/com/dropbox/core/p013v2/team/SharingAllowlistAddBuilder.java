package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.SharingAllowlistAddArgs;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SharingAllowlistAddBuilder {
    private final SharingAllowlistAddArgs.Builder _builder;
    private final DbxTeamTeamRequests _client;

    SharingAllowlistAddBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, SharingAllowlistAddArgs.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public SharingAllowlistAddBuilder withDomains(List<String> list) {
        this._builder.withDomains(list);
        return this;
    }

    public SharingAllowlistAddBuilder withEmails(List<String> list) {
        this._builder.withEmails(list);
        return this;
    }

    public SharingAllowlistAddResponse start() throws DbxException {
        return this._client.sharingAllowlistAdd(this._builder.build());
    }
}

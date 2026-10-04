package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyUpdateArg;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsUpdatePolicyBuilder {
    private final LegalHoldsPolicyUpdateArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    LegalHoldsUpdatePolicyBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, LegalHoldsPolicyUpdateArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public LegalHoldsUpdatePolicyBuilder withName(String str) {
        this._builder.withName(str);
        return this;
    }

    public LegalHoldsUpdatePolicyBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public LegalHoldsUpdatePolicyBuilder withMembers(List<String> list) {
        this._builder.withMembers(list);
        return this;
    }

    public LegalHoldPolicy start() throws DbxException {
        return this._client.legalHoldsUpdatePolicy(this._builder.build());
    }
}

package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyCreateArg;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsCreatePolicyBuilder {
    private final LegalHoldsPolicyCreateArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    LegalHoldsCreatePolicyBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, LegalHoldsPolicyCreateArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public LegalHoldsCreatePolicyBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public LegalHoldsCreatePolicyBuilder withStartDate(Date date) {
        this._builder.withStartDate(date);
        return this;
    }

    public LegalHoldsCreatePolicyBuilder withEndDate(Date date) {
        this._builder.withEndDate(date);
        return this;
    }

    public LegalHoldPolicy start() throws DbxException {
        return this._client.legalHoldsCreatePolicy(this._builder.build());
    }
}

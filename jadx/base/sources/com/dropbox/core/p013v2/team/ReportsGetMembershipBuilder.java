package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.DateRange;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class ReportsGetMembershipBuilder {
    private final DateRange.Builder _builder;
    private final DbxTeamTeamRequests _client;

    ReportsGetMembershipBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, DateRange.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ReportsGetMembershipBuilder withStartDate(Date date) {
        this._builder.withStartDate(date);
        return this;
    }

    public ReportsGetMembershipBuilder withEndDate(Date date) {
        this._builder.withEndDate(date);
        return this;
    }

    public GetMembershipReport start() throws DbxException {
        return this._client.reportsGetMembership(this._builder.build());
    }
}

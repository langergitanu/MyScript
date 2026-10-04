package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.DateRange;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class ReportsGetActivityBuilder {
    private final DateRange.Builder _builder;
    private final DbxTeamTeamRequests _client;

    ReportsGetActivityBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, DateRange.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ReportsGetActivityBuilder withStartDate(Date date) {
        this._builder.withStartDate(date);
        return this;
    }

    public ReportsGetActivityBuilder withEndDate(Date date) {
        this._builder.withEndDate(date);
        return this;
    }

    public GetActivityReport start() throws DbxException {
        return this._client.reportsGetActivity(this._builder.build());
    }
}

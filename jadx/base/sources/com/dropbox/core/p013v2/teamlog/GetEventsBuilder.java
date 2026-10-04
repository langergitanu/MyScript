package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.teamcommon.TimeRange;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsArg;

/* JADX INFO: loaded from: classes5.dex */
public class GetEventsBuilder {
    private final GetTeamEventsArg.Builder _builder;
    private final DbxTeamTeamLogRequests _client;

    GetEventsBuilder(DbxTeamTeamLogRequests dbxTeamTeamLogRequests, GetTeamEventsArg.Builder builder) {
        if (dbxTeamTeamLogRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamLogRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GetEventsBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public GetEventsBuilder withAccountId(String str) {
        this._builder.withAccountId(str);
        return this;
    }

    public GetEventsBuilder withTime(TimeRange timeRange) {
        this._builder.withTime(timeRange);
        return this;
    }

    public GetEventsBuilder withCategory(EventCategory eventCategory) {
        this._builder.withCategory(eventCategory);
        return this;
    }

    public GetEventsBuilder withEventType(EventTypeArg eventTypeArg) {
        this._builder.withEventType(eventTypeArg);
        return this;
    }

    public GetTeamEventsResult start() throws DbxException {
        return this._client.getEvents(this._builder.build());
    }
}

package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsArg;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsContinueArg;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsContinueError;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsError;
import com.dropbox.core.p013v2.teamlog.GetTeamEventsResult;

/* JADX INFO: loaded from: classes5.dex */
public class DbxTeamTeamLogRequests {
    private final DbxRawClientV2 client;

    public DbxTeamTeamLogRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    GetTeamEventsResult getEvents(GetTeamEventsArg getTeamEventsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTeamEventsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team_log/get_events", getTeamEventsArg, false, GetTeamEventsArg.Serializer.INSTANCE, GetTeamEventsResult.Serializer.INSTANCE, GetTeamEventsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetTeamEventsErrorException("2/team_log/get_events", e.getRequestId(), e.getUserMessage(), (GetTeamEventsError) e.getErrorValue());
        }
    }

    public GetTeamEventsResult getEvents() throws DbxException {
        return getEvents(new GetTeamEventsArg());
    }

    public GetEventsBuilder getEventsBuilder() {
        return new GetEventsBuilder(this, GetTeamEventsArg.newBuilder());
    }

    GetTeamEventsResult getEventsContinue(GetTeamEventsContinueArg getTeamEventsContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTeamEventsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team_log/get_events/continue", getTeamEventsContinueArg, false, GetTeamEventsContinueArg.Serializer.INSTANCE, GetTeamEventsResult.Serializer.INSTANCE, GetTeamEventsContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetTeamEventsContinueErrorException("2/team_log/get_events/continue", e.getRequestId(), e.getUserMessage(), (GetTeamEventsContinueError) e.getErrorValue());
        }
    }

    public GetTeamEventsResult getEventsContinue(String str) throws DbxException {
        return getEventsContinue(new GetTeamEventsContinueArg(str));
    }
}

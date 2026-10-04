package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.PropertyFieldTemplate;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateResult;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PropertiesTemplateUpdateBuilder {
    private final UpdateTemplateArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    PropertiesTemplateUpdateBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, UpdateTemplateArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public PropertiesTemplateUpdateBuilder withName(String str) {
        this._builder.withName(str);
        return this;
    }

    public PropertiesTemplateUpdateBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public PropertiesTemplateUpdateBuilder withAddFields(List<PropertyFieldTemplate> list) {
        this._builder.withAddFields(list);
        return this;
    }

    public UpdateTemplateResult start() throws DbxException {
        return this._client.propertiesTemplateUpdate(this._builder.build());
    }
}

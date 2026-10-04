package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TemplatesUpdateForTeamBuilder {
    private final UpdateTemplateArg.Builder _builder;
    private final DbxTeamFilePropertiesRequests _client;

    TemplatesUpdateForTeamBuilder(DbxTeamFilePropertiesRequests dbxTeamFilePropertiesRequests, UpdateTemplateArg.Builder builder) {
        if (dbxTeamFilePropertiesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamFilePropertiesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public TemplatesUpdateForTeamBuilder withName(String str) {
        this._builder.withName(str);
        return this;
    }

    public TemplatesUpdateForTeamBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public TemplatesUpdateForTeamBuilder withAddFields(List<PropertyFieldTemplate> list) {
        this._builder.withAddFields(list);
        return this;
    }

    public UpdateTemplateResult start() throws DbxException {
        return this._client.templatesUpdateForTeam(this._builder.build());
    }
}

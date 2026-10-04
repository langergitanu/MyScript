package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TemplatesUpdateForUserBuilder {
    private final UpdateTemplateArg.Builder _builder;
    private final DbxUserFilePropertiesRequests _client;

    TemplatesUpdateForUserBuilder(DbxUserFilePropertiesRequests dbxUserFilePropertiesRequests, UpdateTemplateArg.Builder builder) {
        if (dbxUserFilePropertiesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilePropertiesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public TemplatesUpdateForUserBuilder withName(String str) {
        this._builder.withName(str);
        return this;
    }

    public TemplatesUpdateForUserBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public TemplatesUpdateForUserBuilder withAddFields(List<PropertyFieldTemplate> list) {
        this._builder.withAddFields(list);
        return this;
    }

    public UpdateTemplateResult start() throws DbxException {
        return this._client.templatesUpdateForUser(this._builder.build());
    }
}

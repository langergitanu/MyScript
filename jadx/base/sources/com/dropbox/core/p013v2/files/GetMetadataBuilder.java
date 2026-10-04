package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.GetMetadataArg;

/* JADX INFO: loaded from: classes4.dex */
public class GetMetadataBuilder {
    private final GetMetadataArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    GetMetadataBuilder(DbxUserFilesRequests dbxUserFilesRequests, GetMetadataArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GetMetadataBuilder withIncludeMediaInfo(Boolean bool) {
        this._builder.withIncludeMediaInfo(bool);
        return this;
    }

    public GetMetadataBuilder withIncludeDeleted(Boolean bool) {
        this._builder.withIncludeDeleted(bool);
        return this;
    }

    public GetMetadataBuilder withIncludeHasExplicitSharedMembers(Boolean bool) {
        this._builder.withIncludeHasExplicitSharedMembers(bool);
        return this;
    }

    public GetMetadataBuilder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
        this._builder.withIncludePropertyGroups(templateFilterBase);
        return this;
    }

    public Metadata start() throws DbxException {
        return this._client.getMetadata(this._builder.build());
    }
}

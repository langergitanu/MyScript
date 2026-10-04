package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.AlphaGetMetadataArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AlphaGetMetadataBuilder {
    private final AlphaGetMetadataArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    AlphaGetMetadataBuilder(DbxUserFilesRequests dbxUserFilesRequests, AlphaGetMetadataArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public AlphaGetMetadataBuilder withIncludeMediaInfo(Boolean bool) {
        this._builder.withIncludeMediaInfo(bool);
        return this;
    }

    public AlphaGetMetadataBuilder withIncludeDeleted(Boolean bool) {
        this._builder.withIncludeDeleted(bool);
        return this;
    }

    public AlphaGetMetadataBuilder withIncludeHasExplicitSharedMembers(Boolean bool) {
        this._builder.withIncludeHasExplicitSharedMembers(bool);
        return this;
    }

    public AlphaGetMetadataBuilder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
        this._builder.withIncludePropertyGroups(templateFilterBase);
        return this;
    }

    public AlphaGetMetadataBuilder withIncludePropertyTemplates(List<String> list) {
        this._builder.withIncludePropertyTemplates(list);
        return this;
    }

    public Metadata start() throws DbxException {
        return this._client.alphaGetMetadata(this._builder.build());
    }
}

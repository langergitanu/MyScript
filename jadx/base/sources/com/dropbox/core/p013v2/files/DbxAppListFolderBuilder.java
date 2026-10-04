package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.ListFolderArg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppListFolderBuilder {
    private final ListFolderArg.Builder _builder;
    private final DbxAppFilesRequests _client;

    DbxAppListFolderBuilder(DbxAppFilesRequests dbxAppFilesRequests, ListFolderArg.Builder builder) {
        if (dbxAppFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxAppFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxAppListFolderBuilder withRecursive(Boolean bool) {
        this._builder.withRecursive(bool);
        return this;
    }

    public DbxAppListFolderBuilder withIncludeMediaInfo(Boolean bool) {
        this._builder.withIncludeMediaInfo(bool);
        return this;
    }

    public DbxAppListFolderBuilder withIncludeDeleted(Boolean bool) {
        this._builder.withIncludeDeleted(bool);
        return this;
    }

    public DbxAppListFolderBuilder withIncludeHasExplicitSharedMembers(Boolean bool) {
        this._builder.withIncludeHasExplicitSharedMembers(bool);
        return this;
    }

    public DbxAppListFolderBuilder withIncludeMountedFolders(Boolean bool) {
        this._builder.withIncludeMountedFolders(bool);
        return this;
    }

    public DbxAppListFolderBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public DbxAppListFolderBuilder withSharedLink(SharedLink sharedLink) {
        this._builder.withSharedLink(sharedLink);
        return this;
    }

    public DbxAppListFolderBuilder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
        this._builder.withIncludePropertyGroups(templateFilterBase);
        return this;
    }

    public DbxAppListFolderBuilder withIncludeNonDownloadableFiles(Boolean bool) {
        this._builder.withIncludeNonDownloadableFiles(bool);
        return this;
    }

    public ListFolderResult start() throws DbxException {
        return this._client.listFolder(this._builder.build());
    }
}

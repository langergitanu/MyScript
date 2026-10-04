package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.ListFolderArg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserListFolderBuilder {
    private final ListFolderArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    DbxUserListFolderBuilder(DbxUserFilesRequests dbxUserFilesRequests, ListFolderArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxUserListFolderBuilder withRecursive(Boolean bool) {
        this._builder.withRecursive(bool);
        return this;
    }

    public DbxUserListFolderBuilder withIncludeMediaInfo(Boolean bool) {
        this._builder.withIncludeMediaInfo(bool);
        return this;
    }

    public DbxUserListFolderBuilder withIncludeDeleted(Boolean bool) {
        this._builder.withIncludeDeleted(bool);
        return this;
    }

    public DbxUserListFolderBuilder withIncludeHasExplicitSharedMembers(Boolean bool) {
        this._builder.withIncludeHasExplicitSharedMembers(bool);
        return this;
    }

    public DbxUserListFolderBuilder withIncludeMountedFolders(Boolean bool) {
        this._builder.withIncludeMountedFolders(bool);
        return this;
    }

    public DbxUserListFolderBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public DbxUserListFolderBuilder withSharedLink(SharedLink sharedLink) {
        this._builder.withSharedLink(sharedLink);
        return this;
    }

    public DbxUserListFolderBuilder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
        this._builder.withIncludePropertyGroups(templateFilterBase);
        return this;
    }

    public DbxUserListFolderBuilder withIncludeNonDownloadableFiles(Boolean bool) {
        this._builder.withIncludeNonDownloadableFiles(bool);
        return this;
    }

    public ListFolderResult start() throws DbxException {
        return this._client.listFolder(this._builder.build());
    }
}

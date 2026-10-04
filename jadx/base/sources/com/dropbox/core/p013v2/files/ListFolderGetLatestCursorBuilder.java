package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.ListFolderArg;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderGetLatestCursorBuilder {
    private final ListFolderArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    ListFolderGetLatestCursorBuilder(DbxUserFilesRequests dbxUserFilesRequests, ListFolderArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListFolderGetLatestCursorBuilder withRecursive(Boolean bool) {
        this._builder.withRecursive(bool);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludeMediaInfo(Boolean bool) {
        this._builder.withIncludeMediaInfo(bool);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludeDeleted(Boolean bool) {
        this._builder.withIncludeDeleted(bool);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludeHasExplicitSharedMembers(Boolean bool) {
        this._builder.withIncludeHasExplicitSharedMembers(bool);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludeMountedFolders(Boolean bool) {
        this._builder.withIncludeMountedFolders(bool);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withSharedLink(SharedLink sharedLink) {
        this._builder.withSharedLink(sharedLink);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
        this._builder.withIncludePropertyGroups(templateFilterBase);
        return this;
    }

    public ListFolderGetLatestCursorBuilder withIncludeNonDownloadableFiles(Boolean bool) {
        this._builder.withIncludeNonDownloadableFiles(bool);
        return this;
    }

    public ListFolderGetLatestCursorResult start() throws DbxException {
        return this._client.listFolderGetLatestCursor(this._builder.build());
    }
}

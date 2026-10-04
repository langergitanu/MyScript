package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxUploadStyleBuilder;
import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.files.UploadArg;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UploadBuilder extends DbxUploadStyleBuilder<FileMetadata, UploadError, UploadErrorException> {
    private final UploadArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    UploadBuilder(DbxUserFilesRequests dbxUserFilesRequests, UploadArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public UploadBuilder withMode(WriteMode writeMode) {
        this._builder.withMode(writeMode);
        return this;
    }

    public UploadBuilder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public UploadBuilder withClientModified(Date date) {
        this._builder.withClientModified(date);
        return this;
    }

    public UploadBuilder withMute(Boolean bool) {
        this._builder.withMute(bool);
        return this;
    }

    public UploadBuilder withPropertyGroups(List<PropertyGroup> list) {
        this._builder.withPropertyGroups(list);
        return this;
    }

    public UploadBuilder withStrictConflict(Boolean bool) {
        this._builder.withStrictConflict(bool);
        return this;
    }

    public UploadBuilder withContentHash(String str) {
        this._builder.withContentHash(str);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxUploadStyleBuilder
    public UploadUploader start() throws DbxException {
        return this._client.upload(this._builder.build());
    }
}

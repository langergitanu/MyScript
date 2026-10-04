package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileCategory;
import com.dropbox.core.p013v2.files.FileStatus;
import com.dropbox.core.p013v2.files.SearchOrderBy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class SearchOptions {

    @Nullable
    protected final String accountId;

    @Nullable
    protected final List<FileCategory> fileCategories;

    @Nullable
    protected final List<String> fileExtensions;

    @Nonnull
    protected final FileStatus fileStatus;
    protected final boolean filenameOnly;
    protected final long maxResults;

    @Nullable
    protected final SearchOrderBy orderBy;

    @Nullable
    protected final String path;

    public SearchOptions(@Nullable String str, long j, @Nullable SearchOrderBy searchOrderBy, @Nonnull FileStatus fileStatus, boolean z, @Nullable List<String> list, @Nullable List<FileCategory> list2, @Nullable String str2) {
        if (str != null && !Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
        }
        this.maxResults = j;
        this.orderBy = searchOrderBy;
        if (fileStatus == null) {
            throw new IllegalArgumentException("Required value for 'fileStatus' is null");
        }
        this.fileStatus = fileStatus;
        this.filenameOnly = z;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'fileExtensions' is null");
                }
            }
        }
        this.fileExtensions = list;
        if (list2 != null) {
            Iterator<FileCategory> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'fileCategories' is null");
                }
            }
        }
        this.fileCategories = list2;
        if (str2 != null) {
            if (str2.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (str2.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = str2;
    }

    public SearchOptions() {
        this(null, 100L, null, FileStatus.ACTIVE, false, null, null, null);
    }

    @Nullable
    public String getPath() {
        return this.path;
    }

    public long getMaxResults() {
        return this.maxResults;
    }

    @Nullable
    public SearchOrderBy getOrderBy() {
        return this.orderBy;
    }

    @Nonnull
    public FileStatus getFileStatus() {
        return this.fileStatus;
    }

    public boolean getFilenameOnly() {
        return this.filenameOnly;
    }

    @Nullable
    public List<String> getFileExtensions() {
        return this.fileExtensions;
    }

    @Nullable
    public List<FileCategory> getFileCategories() {
        return this.fileCategories;
    }

    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String path = null;
        protected long maxResults = 100;
        protected SearchOrderBy orderBy = null;
        protected FileStatus fileStatus = FileStatus.ACTIVE;
        protected boolean filenameOnly = false;
        protected List<String> fileExtensions = null;
        protected List<FileCategory> fileCategories = null;
        protected String accountId = null;

        protected Builder() {
        }

        public Builder withPath(String str) {
            if (str != null && !Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            return this;
        }

        public Builder withMaxResults(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
            }
            if (l.longValue() > 1000) {
                throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
            }
            if (l != null) {
                this.maxResults = l.longValue();
                return this;
            }
            this.maxResults = 100L;
            return this;
        }

        public Builder withOrderBy(SearchOrderBy searchOrderBy) {
            this.orderBy = searchOrderBy;
            return this;
        }

        public Builder withFileStatus(FileStatus fileStatus) {
            if (fileStatus != null) {
                this.fileStatus = fileStatus;
                return this;
            }
            this.fileStatus = FileStatus.ACTIVE;
            return this;
        }

        public Builder withFilenameOnly(Boolean bool) {
            if (bool != null) {
                this.filenameOnly = bool.booleanValue();
                return this;
            }
            this.filenameOnly = false;
            return this;
        }

        public Builder withFileExtensions(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'fileExtensions' is null");
                    }
                }
            }
            this.fileExtensions = list;
            return this;
        }

        public Builder withFileCategories(List<FileCategory> list) {
            if (list != null) {
                Iterator<FileCategory> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'fileCategories' is null");
                    }
                }
            }
            this.fileCategories = list;
            return this;
        }

        public Builder withAccountId(String str) {
            if (str != null) {
                if (str.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (str.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = str;
            return this;
        }

        public SearchOptions build() {
            return new SearchOptions(this.path, this.maxResults, this.orderBy, this.fileStatus, this.filenameOnly, this.fileExtensions, this.fileCategories, this.accountId);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, Long.valueOf(this.maxResults), this.orderBy, this.fileStatus, Boolean.valueOf(this.filenameOnly), this.fileExtensions, this.fileCategories, this.accountId});
    }

    public boolean equals(Object obj) {
        SearchOptions searchOptions;
        String str;
        String str2;
        SearchOrderBy searchOrderBy;
        SearchOrderBy searchOrderBy2;
        FileStatus fileStatus;
        FileStatus fileStatus2;
        List<String> list;
        List<String> list2;
        List<FileCategory> list3;
        List<FileCategory> list4;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (searchOptions = (SearchOptions) obj).path) || (str != null && str.equals(str2))) && this.maxResults == searchOptions.maxResults && (((searchOrderBy = this.orderBy) == (searchOrderBy2 = searchOptions.orderBy) || (searchOrderBy != null && searchOrderBy.equals(searchOrderBy2))) && (((fileStatus = this.fileStatus) == (fileStatus2 = searchOptions.fileStatus) || fileStatus.equals(fileStatus2)) && this.filenameOnly == searchOptions.filenameOnly && (((list = this.fileExtensions) == (list2 = searchOptions.fileExtensions) || (list != null && list.equals(list2))) && (((list3 = this.fileCategories) == (list4 = searchOptions.fileCategories) || (list3 != null && list3.equals(list4))) && ((str3 = this.accountId) == (str4 = searchOptions.accountId) || (str3 != null && str3.equals(str4)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchOptions> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchOptions searchOptions, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (searchOptions.path != null) {
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(searchOptions.path, jsonGenerator);
            }
            jsonGenerator.writeFieldName("max_results");
            StoneSerializers.uInt64().serialize(Long.valueOf(searchOptions.maxResults), jsonGenerator);
            if (searchOptions.orderBy != null) {
                jsonGenerator.writeFieldName("order_by");
                StoneSerializers.nullable(SearchOrderBy.Serializer.INSTANCE).serialize(searchOptions.orderBy, jsonGenerator);
            }
            jsonGenerator.writeFieldName("file_status");
            FileStatus.Serializer.INSTANCE.serialize(searchOptions.fileStatus, jsonGenerator);
            jsonGenerator.writeFieldName("filename_only");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(searchOptions.filenameOnly), jsonGenerator);
            if (searchOptions.fileExtensions != null) {
                jsonGenerator.writeFieldName("file_extensions");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(searchOptions.fileExtensions, jsonGenerator);
            }
            if (searchOptions.fileCategories != null) {
                jsonGenerator.writeFieldName("file_categories");
                StoneSerializers.nullable(StoneSerializers.list(FileCategory.Serializer.INSTANCE)).serialize(searchOptions.fileCategories, jsonGenerator);
            }
            if (searchOptions.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(searchOptions.accountId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchOptions deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 100L;
                Boolean boolDeserialize = false;
                String str = null;
                SearchOrderBy searchOrderBy = null;
                List list = null;
                List list2 = null;
                String str2 = null;
                FileStatus fileStatusDeserialize = FileStatus.ACTIVE;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("max_results".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("order_by".equals(currentName)) {
                        searchOrderBy = (SearchOrderBy) StoneSerializers.nullable(SearchOrderBy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("file_status".equals(currentName)) {
                        fileStatusDeserialize = FileStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("filename_only".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("file_extensions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else if ("file_categories".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(FileCategory.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("account_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SearchOptions searchOptions = new SearchOptions(str, lDeserialize.longValue(), searchOrderBy, fileStatusDeserialize, boolDeserialize.booleanValue(), list, list2, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchOptions, searchOptions.toStringMultiline());
                return searchOptions;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

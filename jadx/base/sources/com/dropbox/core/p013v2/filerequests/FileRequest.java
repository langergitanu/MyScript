package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.p013v2.filerequests.FileRequestDeadline;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FileRequest {

    @Nonnull
    protected final Date created;

    @Nullable
    protected final FileRequestDeadline deadline;

    @Nullable
    protected final String description;

    @Nullable
    protected final String destination;
    protected final long fileCount;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f682id;
    protected final boolean isOpen;

    @Nonnull
    protected final String title;

    @Nonnull
    protected final String url;

    public FileRequest(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull Date date, boolean z, long j, @Nullable String str4, @Nullable FileRequestDeadline fileRequestDeadline, @Nullable String str5) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f682id = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        if (str2.length() < 1) {
            throw new IllegalArgumentException("String 'url' is shorter than 1");
        }
        this.url = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        if (str3.length() < 1) {
            throw new IllegalArgumentException("String 'title' is shorter than 1");
        }
        this.title = str3;
        if (str4 != null && !Pattern.matches("/(.|[\\r\\n])*", str4)) {
            throw new IllegalArgumentException("String 'destination' does not match pattern");
        }
        this.destination = str4;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'created' is null");
        }
        this.created = LangUtil.truncateMillis(date);
        this.deadline = fileRequestDeadline;
        this.isOpen = z;
        this.fileCount = j;
        this.description = str5;
    }

    public FileRequest(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull Date date, boolean z, long j) {
        this(str, str2, str3, date, z, j, null, null, null);
    }

    @Nonnull
    public String getId() {
        return this.f682id;
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public String getTitle() {
        return this.title;
    }

    @Nonnull
    public Date getCreated() {
        return this.created;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public long getFileCount() {
        return this.fileCount;
    }

    @Nullable
    public String getDestination() {
        return this.destination;
    }

    @Nullable
    public FileRequestDeadline getDeadline() {
        return this.deadline;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public static Builder newBuilder(String str, String str2, String str3, Date date, boolean z, long j) {
        return new Builder(str, str2, str3, date, z, j);
    }

    public static class Builder {
        protected final Date created;
        protected FileRequestDeadline deadline;
        protected String description;
        protected String destination;
        protected final long fileCount;

        /* JADX INFO: renamed from: id */
        protected final String f683id;
        protected final boolean isOpen;
        protected final String title;
        protected final String url;

        protected Builder(String str, String str2, String str3, Date date, boolean z, long j) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.f683id = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            if (str2.length() < 1) {
                throw new IllegalArgumentException("String 'url' is shorter than 1");
            }
            this.url = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'title' is null");
            }
            if (str3.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
            this.title = str3;
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'created' is null");
            }
            this.created = LangUtil.truncateMillis(date);
            this.isOpen = z;
            this.fileCount = j;
            this.destination = null;
            this.deadline = null;
            this.description = null;
        }

        public Builder withDestination(String str) {
            if (str != null && !Pattern.matches("/(.|[\\r\\n])*", str)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
            this.destination = str;
            return this;
        }

        public Builder withDeadline(FileRequestDeadline fileRequestDeadline) {
            this.deadline = fileRequestDeadline;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public FileRequest build() {
            return new FileRequest(this.f683id, this.url, this.title, this.created, this.isOpen, this.fileCount, this.destination, this.deadline, this.description);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f682id, this.url, this.title, this.destination, this.created, this.deadline, Boolean.valueOf(this.isOpen), Long.valueOf(this.fileCount), this.description});
    }

    public boolean equals(Object obj) {
        FileRequest fileRequest;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Date date;
        Date date2;
        String str7;
        String str8;
        FileRequestDeadline fileRequestDeadline;
        FileRequestDeadline fileRequestDeadline2;
        String str9;
        String str10;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.f682id) == (str2 = (fileRequest = (FileRequest) obj).f682id) || str.equals(str2)) && (((str3 = this.url) == (str4 = fileRequest.url) || str3.equals(str4)) && (((str5 = this.title) == (str6 = fileRequest.title) || str5.equals(str6)) && (((date = this.created) == (date2 = fileRequest.created) || date.equals(date2)) && this.isOpen == fileRequest.isOpen && this.fileCount == fileRequest.fileCount && (((str7 = this.destination) == (str8 = fileRequest.destination) || (str7 != null && str7.equals(str8))) && (((fileRequestDeadline = this.deadline) == (fileRequestDeadline2 = fileRequest.deadline) || (fileRequestDeadline != null && fileRequestDeadline.equals(fileRequestDeadline2))) && ((str9 = this.description) == (str10 = fileRequest.description) || (str9 != null && str9.equals(str10))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequest> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequest fileRequest, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(fileRequest.f682id, jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(fileRequest.url, jsonGenerator);
            jsonGenerator.writeFieldName("title");
            StoneSerializers.string().serialize(fileRequest.title, jsonGenerator);
            jsonGenerator.writeFieldName("created");
            StoneSerializers.timestamp().serialize(fileRequest.created, jsonGenerator);
            jsonGenerator.writeFieldName("is_open");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fileRequest.isOpen), jsonGenerator);
            jsonGenerator.writeFieldName("file_count");
            StoneSerializers.int64().serialize(Long.valueOf(fileRequest.fileCount), jsonGenerator);
            if (fileRequest.destination != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.DESTINATION);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequest.destination, jsonGenerator);
            }
            if (fileRequest.deadline != null) {
                jsonGenerator.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(fileRequest.deadline, jsonGenerator);
            }
            if (fileRequest.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequest.description, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequest deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                Date dateDeserialize = null;
                String str = null;
                FileRequestDeadline fileRequestDeadline = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("title".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("is_open".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("file_count".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.DESTINATION.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("deadline".equals(currentName)) {
                        fileRequestDeadline = (FileRequestDeadline) StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"title\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"created\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_open\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file_count\" missing.");
                }
                FileRequest fileRequest = new FileRequest(strDeserialize, strDeserialize2, strDeserialize3, dateDeserialize, boolDeserialize.booleanValue(), lDeserialize.longValue(), str, fileRequestDeadline, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequest, fileRequest.toStringMultiline());
                return fileRequest;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

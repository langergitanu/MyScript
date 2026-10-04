package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class ApiApp {

    @Nonnull
    protected final String appId;

    @Nonnull
    protected final String appName;
    protected final boolean isAppFolder;

    @Nullable
    protected final Date linked;

    @Nullable
    protected final String publisher;

    @Nullable
    protected final String publisherUrl;

    public ApiApp(@Nonnull String str, @Nonnull String str2, boolean z, @Nullable String str3, @Nullable String str4, @Nullable Date date) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'appId' is null");
        }
        this.appId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'appName' is null");
        }
        this.appName = str2;
        this.publisher = str3;
        this.publisherUrl = str4;
        this.linked = LangUtil.truncateMillis(date);
        this.isAppFolder = z;
    }

    public ApiApp(@Nonnull String str, @Nonnull String str2, boolean z) {
        this(str, str2, z, null, null, null);
    }

    @Nonnull
    public String getAppId() {
        return this.appId;
    }

    @Nonnull
    public String getAppName() {
        return this.appName;
    }

    public boolean getIsAppFolder() {
        return this.isAppFolder;
    }

    @Nullable
    public String getPublisher() {
        return this.publisher;
    }

    @Nullable
    public String getPublisherUrl() {
        return this.publisherUrl;
    }

    @Nullable
    public Date getLinked() {
        return this.linked;
    }

    public static Builder newBuilder(String str, String str2, boolean z) {
        return new Builder(str, str2, z);
    }

    public static class Builder {
        protected final String appId;
        protected final String appName;
        protected final boolean isAppFolder;
        protected Date linked;
        protected String publisher;
        protected String publisherUrl;

        protected Builder(String str, String str2, boolean z) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'appId' is null");
            }
            this.appId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'appName' is null");
            }
            this.appName = str2;
            this.isAppFolder = z;
            this.publisher = null;
            this.publisherUrl = null;
            this.linked = null;
        }

        public Builder withPublisher(String str) {
            this.publisher = str;
            return this;
        }

        public Builder withPublisherUrl(String str) {
            this.publisherUrl = str;
            return this;
        }

        public Builder withLinked(Date date) {
            this.linked = LangUtil.truncateMillis(date);
            return this;
        }

        public ApiApp build() {
            return new ApiApp(this.appId, this.appName, this.isAppFolder, this.publisher, this.publisherUrl, this.linked);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.appId, this.appName, this.publisher, this.publisherUrl, this.linked, Boolean.valueOf(this.isAppFolder)});
    }

    public boolean equals(Object obj) {
        ApiApp apiApp;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.appId) == (str2 = (apiApp = (ApiApp) obj).appId) || str.equals(str2)) && (((str3 = this.appName) == (str4 = apiApp.appName) || str3.equals(str4)) && this.isAppFolder == apiApp.isAppFolder && (((str5 = this.publisher) == (str6 = apiApp.publisher) || (str5 != null && str5.equals(str6))) && (((str7 = this.publisherUrl) == (str8 = apiApp.publisherUrl) || (str7 != null && str7.equals(str8))) && ((date = this.linked) == (date2 = apiApp.linked) || (date != null && date.equals(date2))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ApiApp> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ApiApp apiApp, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("app_id");
            StoneSerializers.string().serialize(apiApp.appId, jsonGenerator);
            jsonGenerator.writeFieldName("app_name");
            StoneSerializers.string().serialize(apiApp.appName, jsonGenerator);
            jsonGenerator.writeFieldName("is_app_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(apiApp.isAppFolder), jsonGenerator);
            if (apiApp.publisher != null) {
                jsonGenerator.writeFieldName("publisher");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(apiApp.publisher, jsonGenerator);
            }
            if (apiApp.publisherUrl != null) {
                jsonGenerator.writeFieldName("publisher_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(apiApp.publisherUrl, jsonGenerator);
            }
            if (apiApp.linked != null) {
                jsonGenerator.writeFieldName("linked");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(apiApp.linked, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ApiApp deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String str = null;
                String str2 = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("app_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("app_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_app_folder".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("publisher".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("publisher_url".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("linked".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"app_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"app_name\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_app_folder\" missing.");
                }
                ApiApp apiApp = new ApiApp(strDeserialize, strDeserialize2, boolDeserialize.booleanValue(), str, str2, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(apiApp, apiApp.toStringMultiline());
                return apiApp;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

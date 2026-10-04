package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class MinimalFileLinkMetadata {

    /* JADX INFO: renamed from: id */
    @Nullable
    protected final String f701id;

    @Nullable
    protected final String path;

    @Nonnull
    protected final String rev;

    @Nonnull
    protected final String url;

    public MinimalFileLinkMetadata(@Nonnull String str, @Nonnull String str2, @Nullable String str3, @Nullable String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (str3 != null && str3.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.f701id = str3;
        this.path = str4;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (str2.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", str2)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = str2;
    }

    public MinimalFileLinkMetadata(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null, null);
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public String getRev() {
        return this.rev;
    }

    @Nullable
    public String getId() {
        return this.f701id;
    }

    @Nullable
    public String getPath() {
        return this.path;
    }

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder {

        /* JADX INFO: renamed from: id */
        protected String f702id;
        protected String path;
        protected final String rev;
        protected final String url;

        protected Builder(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = str2;
            this.f702id = null;
            this.path = null;
        }

        public Builder withId(String str) {
            if (str != null && str.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.f702id = str;
            return this;
        }

        public Builder withPath(String str) {
            this.path = str;
            return this;
        }

        public MinimalFileLinkMetadata build() {
            return new MinimalFileLinkMetadata(this.url, this.rev, this.f702id, this.path);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.f701id, this.path, this.rev});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MinimalFileLinkMetadata minimalFileLinkMetadata = (MinimalFileLinkMetadata) obj;
        String str7 = this.url;
        String str8 = minimalFileLinkMetadata.url;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.rev) == (str2 = minimalFileLinkMetadata.rev) || str.equals(str2)) && (((str3 = this.f701id) == (str4 = minimalFileLinkMetadata.f701id) || (str3 != null && str3.equals(str4))) && ((str5 = this.path) == (str6 = minimalFileLinkMetadata.path) || (str5 != null && str5.equals(str6))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MinimalFileLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MinimalFileLinkMetadata minimalFileLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(minimalFileLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("rev");
            StoneSerializers.string().serialize(minimalFileLinkMetadata.rev, jsonGenerator);
            if (minimalFileLinkMetadata.f701id != null) {
                jsonGenerator.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(minimalFileLinkMetadata.f701id, jsonGenerator);
            }
            if (minimalFileLinkMetadata.path != null) {
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(minimalFileLinkMetadata.path, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MinimalFileLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("rev".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"rev\" missing.");
                }
                MinimalFileLinkMetadata minimalFileLinkMetadata = new MinimalFileLinkMetadata(strDeserialize, strDeserialize2, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(minimalFileLinkMetadata, minimalFileLinkMetadata.toStringMultiline());
                return minimalFileLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

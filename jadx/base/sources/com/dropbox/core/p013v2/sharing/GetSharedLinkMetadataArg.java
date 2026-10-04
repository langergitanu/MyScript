package com.dropbox.core.p013v2.sharing;

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
class GetSharedLinkMetadataArg {

    @Nullable
    protected final String linkPassword;

    @Nullable
    protected final String path;

    @Nonnull
    protected final String url;

    public GetSharedLinkMetadataArg(@Nonnull String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (str2 != null && !Pattern.matches("/(.|[\\r\\n])*", str2)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str2;
        this.linkPassword = str3;
    }

    public GetSharedLinkMetadataArg(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nullable
    public String getPath() {
        return this.path;
    }

    @Nullable
    public String getLinkPassword() {
        return this.linkPassword;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected String linkPassword;
        protected String path;
        protected final String url;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = str;
            this.path = null;
            this.linkPassword = null;
        }

        public Builder withPath(String str) {
            if (str != null && !Pattern.matches("/(.|[\\r\\n])*", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            return this;
        }

        public Builder withLinkPassword(String str) {
            this.linkPassword = str;
            return this;
        }

        public GetSharedLinkMetadataArg build() {
            return new GetSharedLinkMetadataArg(this.url, this.path, this.linkPassword);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.path, this.linkPassword});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetSharedLinkMetadataArg getSharedLinkMetadataArg = (GetSharedLinkMetadataArg) obj;
        String str5 = this.url;
        String str6 = getSharedLinkMetadataArg.url;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.path) == (str2 = getSharedLinkMetadataArg.path) || (str != null && str.equals(str2))) && ((str3 = this.linkPassword) == (str4 = getSharedLinkMetadataArg.linkPassword) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetSharedLinkMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetSharedLinkMetadataArg getSharedLinkMetadataArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(getSharedLinkMetadataArg.url, jsonGenerator);
            if (getSharedLinkMetadataArg.path != null) {
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(getSharedLinkMetadataArg.path, jsonGenerator);
            }
            if (getSharedLinkMetadataArg.linkPassword != null) {
                jsonGenerator.writeFieldName("link_password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(getSharedLinkMetadataArg.linkPassword, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetSharedLinkMetadataArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("link_password".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                GetSharedLinkMetadataArg getSharedLinkMetadataArg = new GetSharedLinkMetadataArg(strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getSharedLinkMetadataArg, getSharedLinkMetadataArg.toStringMultiline());
                return getSharedLinkMetadataArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

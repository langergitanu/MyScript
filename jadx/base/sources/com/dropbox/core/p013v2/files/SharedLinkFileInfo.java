package com.dropbox.core.p013v2.files;

import androidx.autofill.HintConstants;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class SharedLinkFileInfo {

    @Nullable
    protected final String password;

    @Nullable
    protected final String path;

    @Nonnull
    protected final String url;

    public SharedLinkFileInfo(@Nonnull String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        this.path = str2;
        this.password = str3;
    }

    public SharedLinkFileInfo(@Nonnull String str) {
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
    public String getPassword() {
        return this.password;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected String password;
        protected String path;
        protected final String url;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = str;
            this.path = null;
            this.password = null;
        }

        public Builder withPath(String str) {
            this.path = str;
            return this;
        }

        public Builder withPassword(String str) {
            this.password = str;
            return this;
        }

        public SharedLinkFileInfo build() {
            return new SharedLinkFileInfo(this.url, this.path, this.password);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.path, this.password});
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
        SharedLinkFileInfo sharedLinkFileInfo = (SharedLinkFileInfo) obj;
        String str5 = this.url;
        String str6 = sharedLinkFileInfo.url;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.path) == (str2 = sharedLinkFileInfo.path) || (str != null && str.equals(str2))) && ((str3 = this.password) == (str4 = sharedLinkFileInfo.password) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkFileInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkFileInfo sharedLinkFileInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(sharedLinkFileInfo.url, jsonGenerator);
            if (sharedLinkFileInfo.path != null) {
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkFileInfo.path, jsonGenerator);
            }
            if (sharedLinkFileInfo.password != null) {
                jsonGenerator.writeFieldName(HintConstants.AUTOFILL_HINT_PASSWORD);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkFileInfo.password, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkFileInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                SharedLinkFileInfo sharedLinkFileInfo = new SharedLinkFileInfo(strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkFileInfo, sharedLinkFileInfo.toStringMultiline());
                return sharedLinkFileInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

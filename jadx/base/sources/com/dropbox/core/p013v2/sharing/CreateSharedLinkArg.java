package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.PendingUploadMode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class CreateSharedLinkArg {

    @Nonnull
    protected final String path;

    @Nullable
    protected final PendingUploadMode pendingUpload;
    protected final boolean shortUrl;

    public CreateSharedLinkArg(@Nonnull String str, boolean z, @Nullable PendingUploadMode pendingUploadMode) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = str;
        this.shortUrl = z;
        this.pendingUpload = pendingUploadMode;
    }

    public CreateSharedLinkArg(@Nonnull String str) {
        this(str, false, null);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public boolean getShortUrl() {
        return this.shortUrl;
    }

    @Nullable
    public PendingUploadMode getPendingUpload() {
        return this.pendingUpload;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String path;
        protected PendingUploadMode pendingUpload;
        protected boolean shortUrl;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            this.path = str;
            this.shortUrl = false;
            this.pendingUpload = null;
        }

        public Builder withShortUrl(Boolean bool) {
            if (bool != null) {
                this.shortUrl = bool.booleanValue();
                return this;
            }
            this.shortUrl = false;
            return this;
        }

        public Builder withPendingUpload(PendingUploadMode pendingUploadMode) {
            this.pendingUpload = pendingUploadMode;
            return this;
        }

        public CreateSharedLinkArg build() {
            return new CreateSharedLinkArg(this.path, this.shortUrl, this.pendingUpload);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, Boolean.valueOf(this.shortUrl), this.pendingUpload});
    }

    public boolean equals(Object obj) {
        CreateSharedLinkArg createSharedLinkArg;
        String str;
        String str2;
        PendingUploadMode pendingUploadMode;
        PendingUploadMode pendingUploadMode2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (createSharedLinkArg = (CreateSharedLinkArg) obj).path) || str.equals(str2)) && this.shortUrl == createSharedLinkArg.shortUrl && ((pendingUploadMode = this.pendingUpload) == (pendingUploadMode2 = createSharedLinkArg.pendingUpload) || (pendingUploadMode != null && pendingUploadMode.equals(pendingUploadMode2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateSharedLinkArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateSharedLinkArg createSharedLinkArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(createSharedLinkArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("short_url");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(createSharedLinkArg.shortUrl), jsonGenerator);
            if (createSharedLinkArg.pendingUpload != null) {
                jsonGenerator.writeFieldName("pending_upload");
                StoneSerializers.nullable(PendingUploadMode.Serializer.INSTANCE).serialize(createSharedLinkArg.pendingUpload, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateSharedLinkArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                PendingUploadMode pendingUploadMode = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("short_url".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("pending_upload".equals(currentName)) {
                        pendingUploadMode = (PendingUploadMode) StoneSerializers.nullable(PendingUploadMode.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                CreateSharedLinkArg createSharedLinkArg = new CreateSharedLinkArg(strDeserialize, boolDeserialize.booleanValue(), pendingUploadMode);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createSharedLinkArg, createSharedLinkArg.toStringMultiline());
                return createSharedLinkArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

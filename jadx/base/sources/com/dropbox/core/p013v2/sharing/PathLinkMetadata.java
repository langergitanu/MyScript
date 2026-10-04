package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.Visibility;
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
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class PathLinkMetadata extends LinkMetadata {

    @Nonnull
    protected final String path;

    public PathLinkMetadata(@Nonnull String str, @Nonnull Visibility visibility, @Nonnull String str2, @Nullable Date date) {
        super(str, visibility, date);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = str2;
    }

    public PathLinkMetadata(@Nonnull String str, @Nonnull Visibility visibility, @Nonnull String str2) {
        this(str, visibility, str2, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    @Nonnull
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.path});
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PathLinkMetadata pathLinkMetadata = (PathLinkMetadata) obj;
        return (this.url == pathLinkMetadata.url || this.url.equals(pathLinkMetadata.url)) && (this.visibility == pathLinkMetadata.visibility || this.visibility.equals(pathLinkMetadata.visibility)) && (((str = this.path) == (str2 = pathLinkMetadata.path) || str.equals(str2)) && (this.expires == pathLinkMetadata.expires || (this.expires != null && this.expires.equals(pathLinkMetadata.expires))));
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PathLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PathLinkMetadata pathLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(pathLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("visibility");
            Visibility.Serializer.INSTANCE.serialize(pathLinkMetadata.visibility, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(pathLinkMetadata.path, jsonGenerator);
            if (pathLinkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(pathLinkMetadata.expires, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public PathLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if (ClientCookie.PATH_ATTR.equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Visibility visibilityDeserialize = null;
                String strDeserialize2 = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("visibility".equals(currentName)) {
                        visibilityDeserialize = Visibility.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ClientCookie.EXPIRES_ATTR.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (visibilityDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"visibility\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                PathLinkMetadata pathLinkMetadata = new PathLinkMetadata(strDeserialize, visibilityDeserialize, strDeserialize2, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(pathLinkMetadata, pathLinkMetadata.toStringMultiline());
                return pathLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

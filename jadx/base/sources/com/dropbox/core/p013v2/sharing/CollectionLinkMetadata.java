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
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class CollectionLinkMetadata extends LinkMetadata {
    public CollectionLinkMetadata(@Nonnull String str, @Nonnull Visibility visibility, @Nullable Date date) {
        super(str, visibility, date);
    }

    public CollectionLinkMetadata(@Nonnull String str, @Nonnull Visibility visibility) {
        this(str, visibility, null);
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

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        CollectionLinkMetadata collectionLinkMetadata = (CollectionLinkMetadata) obj;
        return (this.url == collectionLinkMetadata.url || this.url.equals(collectionLinkMetadata.url)) && (this.visibility == collectionLinkMetadata.visibility || this.visibility.equals(collectionLinkMetadata.visibility)) && (this.expires == collectionLinkMetadata.expires || (this.expires != null && this.expires.equals(collectionLinkMetadata.expires)));
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.LinkMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CollectionLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CollectionLinkMetadata collectionLinkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("collection", jsonGenerator);
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(collectionLinkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("visibility");
            Visibility.Serializer.INSTANCE.serialize(collectionLinkMetadata.visibility, jsonGenerator);
            if (collectionLinkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(collectionLinkMetadata.expires, jsonGenerator);
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
        public CollectionLinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("collection".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Visibility visibilityDeserialize = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("visibility".equals(currentName)) {
                        visibilityDeserialize = Visibility.Serializer.INSTANCE.deserialize(jsonParser);
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
                CollectionLinkMetadata collectionLinkMetadata = new CollectionLinkMetadata(strDeserialize, visibilityDeserialize, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(collectionLinkMetadata, collectionLinkMetadata.toStringMultiline());
                return collectionLinkMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

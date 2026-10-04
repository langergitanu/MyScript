package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.CollectionLinkMetadata;
import com.dropbox.core.p013v2.sharing.PathLinkMetadata;
import com.dropbox.core.p013v2.sharing.Visibility;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
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
public class LinkMetadata {

    @Nullable
    protected final Date expires;

    @Nonnull
    protected final String url;

    @Nonnull
    protected final Visibility visibility;

    public LinkMetadata(@Nonnull String str, @Nonnull Visibility visibility, @Nullable Date date) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (visibility == null) {
            throw new IllegalArgumentException("Required value for 'visibility' is null");
        }
        this.visibility = visibility;
        this.expires = LangUtil.truncateMillis(date);
    }

    public LinkMetadata(@Nonnull String str, @Nonnull Visibility visibility) {
        this(str, visibility, null);
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Nullable
    public Date getExpires() {
        return this.expires;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.visibility, this.expires});
    }

    public boolean equals(Object obj) {
        Visibility visibility;
        Visibility visibility2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LinkMetadata linkMetadata = (LinkMetadata) obj;
        String str = this.url;
        String str2 = linkMetadata.url;
        return (str == str2 || str.equals(str2)) && ((visibility = this.visibility) == (visibility2 = linkMetadata.visibility) || visibility.equals(visibility2)) && ((date = this.expires) == (date2 = linkMetadata.expires) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LinkMetadata linkMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (linkMetadata instanceof PathLinkMetadata) {
                PathLinkMetadata.Serializer.INSTANCE.serialize((PathLinkMetadata) linkMetadata, jsonGenerator, z);
                return;
            }
            if (linkMetadata instanceof CollectionLinkMetadata) {
                CollectionLinkMetadata.Serializer.INSTANCE.serialize((CollectionLinkMetadata) linkMetadata, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(linkMetadata.url, jsonGenerator);
            jsonGenerator.writeFieldName("visibility");
            Visibility.Serializer.INSTANCE.serialize(linkMetadata.visibility, jsonGenerator);
            if (linkMetadata.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(linkMetadata.expires, jsonGenerator);
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
        public LinkMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LinkMetadata linkMetadataDeserialize;
            String strDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
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
                linkMetadataDeserialize = new LinkMetadata(strDeserialize, visibilityDeserialize, date);
            } else if ("".equals(tag)) {
                linkMetadataDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                linkMetadataDeserialize = PathLinkMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("collection".equals(tag)) {
                linkMetadataDeserialize = CollectionLinkMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(linkMetadataDeserialize, linkMetadataDeserialize.toStringMultiline());
            return linkMetadataDeserialize;
        }
    }
}

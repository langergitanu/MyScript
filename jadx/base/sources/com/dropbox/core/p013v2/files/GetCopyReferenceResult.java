package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.Metadata;
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
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class GetCopyReferenceResult {

    @Nonnull
    protected final String copyReference;

    @Nonnull
    protected final Date expires;

    @Nonnull
    protected final Metadata metadata;

    public GetCopyReferenceResult(@Nonnull Metadata metadata, @Nonnull String str, @Nonnull Date date) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'copyReference' is null");
        }
        this.copyReference = str;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'expires' is null");
        }
        this.expires = LangUtil.truncateMillis(date);
    }

    @Nonnull
    public Metadata getMetadata() {
        return this.metadata;
    }

    @Nonnull
    public String getCopyReference() {
        return this.copyReference;
    }

    @Nonnull
    public Date getExpires() {
        return this.expires;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.metadata, this.copyReference, this.expires});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetCopyReferenceResult getCopyReferenceResult = (GetCopyReferenceResult) obj;
        Metadata metadata = this.metadata;
        Metadata metadata2 = getCopyReferenceResult.metadata;
        return (metadata == metadata2 || metadata.equals(metadata2)) && ((str = this.copyReference) == (str2 = getCopyReferenceResult.copyReference) || str.equals(str2)) && ((date = this.expires) == (date2 = getCopyReferenceResult.expires) || date.equals(date2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetCopyReferenceResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetCopyReferenceResult getCopyReferenceResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            Metadata.Serializer.INSTANCE.serialize(getCopyReferenceResult.metadata, jsonGenerator);
            jsonGenerator.writeFieldName("copy_reference");
            StoneSerializers.string().serialize(getCopyReferenceResult.copyReference, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
            StoneSerializers.timestamp().serialize(getCopyReferenceResult.expires, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetCopyReferenceResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Metadata metadataDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                Date dateDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        metadataDeserialize = Metadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("copy_reference".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ClientCookie.EXPIRES_ATTR.equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (metadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"copy_reference\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"expires\" missing.");
                }
                GetCopyReferenceResult getCopyReferenceResult = new GetCopyReferenceResult(metadataDeserialize, strDeserialize, dateDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getCopyReferenceResult, getCopyReferenceResult.toStringMultiline());
                return getCopyReferenceResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

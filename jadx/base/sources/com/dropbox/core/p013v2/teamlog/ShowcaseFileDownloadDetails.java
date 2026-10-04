package com.dropbox.core.p013v2.teamlog;

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

/* JADX INFO: loaded from: classes5.dex */
public class ShowcaseFileDownloadDetails {

    @Nonnull
    protected final String downloadType;

    @Nonnull
    protected final String eventUuid;

    public ShowcaseFileDownloadDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'downloadType' is null");
        }
        this.downloadType = str2;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public String getDownloadType() {
        return this.downloadType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.downloadType});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ShowcaseFileDownloadDetails showcaseFileDownloadDetails = (ShowcaseFileDownloadDetails) obj;
        String str3 = this.eventUuid;
        String str4 = showcaseFileDownloadDetails.eventUuid;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.downloadType) == (str2 = showcaseFileDownloadDetails.downloadType) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseFileDownloadDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseFileDownloadDetails showcaseFileDownloadDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(showcaseFileDownloadDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("download_type");
            StoneSerializers.string().serialize(showcaseFileDownloadDetails.downloadType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseFileDownloadDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("download_type".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"download_type\" missing.");
                }
                ShowcaseFileDownloadDetails showcaseFileDownloadDetails = new ShowcaseFileDownloadDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseFileDownloadDetails, showcaseFileDownloadDetails.toStringMultiline());
                return showcaseFileDownloadDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

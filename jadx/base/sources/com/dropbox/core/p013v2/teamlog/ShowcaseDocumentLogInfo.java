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
public class ShowcaseDocumentLogInfo {

    @Nonnull
    protected final String showcaseId;

    @Nonnull
    protected final String showcaseTitle;

    public ShowcaseDocumentLogInfo(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'showcaseId' is null");
        }
        this.showcaseId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'showcaseTitle' is null");
        }
        this.showcaseTitle = str2;
    }

    @Nonnull
    public String getShowcaseId() {
        return this.showcaseId;
    }

    @Nonnull
    public String getShowcaseTitle() {
        return this.showcaseTitle;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.showcaseId, this.showcaseTitle});
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
        ShowcaseDocumentLogInfo showcaseDocumentLogInfo = (ShowcaseDocumentLogInfo) obj;
        String str3 = this.showcaseId;
        String str4 = showcaseDocumentLogInfo.showcaseId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.showcaseTitle) == (str2 = showcaseDocumentLogInfo.showcaseTitle) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseDocumentLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseDocumentLogInfo showcaseDocumentLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("showcase_id");
            StoneSerializers.string().serialize(showcaseDocumentLogInfo.showcaseId, jsonGenerator);
            jsonGenerator.writeFieldName("showcase_title");
            StoneSerializers.string().serialize(showcaseDocumentLogInfo.showcaseTitle, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseDocumentLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("showcase_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("showcase_title".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"showcase_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"showcase_title\" missing.");
                }
                ShowcaseDocumentLogInfo showcaseDocumentLogInfo = new ShowcaseDocumentLogInfo(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseDocumentLogInfo, showcaseDocumentLogInfo.toStringMultiline());
                return showcaseDocumentLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

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
public class BinderRemoveSectionDetails {

    @Nonnull
    protected final String binderItemName;

    @Nonnull
    protected final String docTitle;

    @Nonnull
    protected final String eventUuid;

    public BinderRemoveSectionDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'docTitle' is null");
        }
        this.docTitle = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'binderItemName' is null");
        }
        this.binderItemName = str3;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public String getDocTitle() {
        return this.docTitle;
    }

    @Nonnull
    public String getBinderItemName() {
        return this.binderItemName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.docTitle, this.binderItemName});
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
        BinderRemoveSectionDetails binderRemoveSectionDetails = (BinderRemoveSectionDetails) obj;
        String str5 = this.eventUuid;
        String str6 = binderRemoveSectionDetails.eventUuid;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.docTitle) == (str2 = binderRemoveSectionDetails.docTitle) || str.equals(str2)) && ((str3 = this.binderItemName) == (str4 = binderRemoveSectionDetails.binderItemName) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<BinderRemoveSectionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(BinderRemoveSectionDetails binderRemoveSectionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(binderRemoveSectionDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("doc_title");
            StoneSerializers.string().serialize(binderRemoveSectionDetails.docTitle, jsonGenerator);
            jsonGenerator.writeFieldName("binder_item_name");
            StoneSerializers.string().serialize(binderRemoveSectionDetails.binderItemName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public BinderRemoveSectionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("doc_title".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("binder_item_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_title\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"binder_item_name\" missing.");
                }
                BinderRemoveSectionDetails binderRemoveSectionDetails = new BinderRemoveSectionDetails(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(binderRemoveSectionDetails, binderRemoveSectionDetails.toStringMultiline());
                return binderRemoveSectionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

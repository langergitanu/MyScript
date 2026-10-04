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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class BinderRenamePageDetails {

    @Nonnull
    protected final String binderItemName;

    @Nonnull
    protected final String docTitle;

    @Nonnull
    protected final String eventUuid;

    @Nullable
    protected final String previousBinderItemName;

    public BinderRenamePageDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nullable String str4) {
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
        this.previousBinderItemName = str4;
    }

    public BinderRenamePageDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this(str, str2, str3, null);
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

    @Nullable
    public String getPreviousBinderItemName() {
        return this.previousBinderItemName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.docTitle, this.binderItemName, this.previousBinderItemName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        BinderRenamePageDetails binderRenamePageDetails = (BinderRenamePageDetails) obj;
        String str7 = this.eventUuid;
        String str8 = binderRenamePageDetails.eventUuid;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.docTitle) == (str2 = binderRenamePageDetails.docTitle) || str.equals(str2)) && (((str3 = this.binderItemName) == (str4 = binderRenamePageDetails.binderItemName) || str3.equals(str4)) && ((str5 = this.previousBinderItemName) == (str6 = binderRenamePageDetails.previousBinderItemName) || (str5 != null && str5.equals(str6))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<BinderRenamePageDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(BinderRenamePageDetails binderRenamePageDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(binderRenamePageDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("doc_title");
            StoneSerializers.string().serialize(binderRenamePageDetails.docTitle, jsonGenerator);
            jsonGenerator.writeFieldName("binder_item_name");
            StoneSerializers.string().serialize(binderRenamePageDetails.binderItemName, jsonGenerator);
            if (binderRenamePageDetails.previousBinderItemName != null) {
                jsonGenerator.writeFieldName("previous_binder_item_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(binderRenamePageDetails.previousBinderItemName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public BinderRenamePageDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("doc_title".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("binder_item_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_binder_item_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                BinderRenamePageDetails binderRenamePageDetails = new BinderRenamePageDetails(strDeserialize, strDeserialize2, strDeserialize3, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(binderRenamePageDetails, binderRenamePageDetails.toStringMultiline());
                return binderRenamePageDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

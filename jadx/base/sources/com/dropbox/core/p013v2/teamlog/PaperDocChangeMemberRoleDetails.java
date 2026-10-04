package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperAccessType;
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
public class PaperDocChangeMemberRoleDetails {

    @Nonnull
    protected final PaperAccessType accessType;

    @Nonnull
    protected final String eventUuid;

    public PaperDocChangeMemberRoleDetails(@Nonnull String str, @Nonnull PaperAccessType paperAccessType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (paperAccessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = paperAccessType;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public PaperAccessType getAccessType() {
        return this.accessType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.accessType});
    }

    public boolean equals(Object obj) {
        PaperAccessType paperAccessType;
        PaperAccessType paperAccessType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDocChangeMemberRoleDetails paperDocChangeMemberRoleDetails = (PaperDocChangeMemberRoleDetails) obj;
        String str = this.eventUuid;
        String str2 = paperDocChangeMemberRoleDetails.eventUuid;
        return (str == str2 || str.equals(str2)) && ((paperAccessType = this.accessType) == (paperAccessType2 = paperDocChangeMemberRoleDetails.accessType) || paperAccessType.equals(paperAccessType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocChangeMemberRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocChangeMemberRoleDetails paperDocChangeMemberRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperDocChangeMemberRoleDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("access_type");
            PaperAccessType.Serializer.INSTANCE.serialize(paperDocChangeMemberRoleDetails.accessType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocChangeMemberRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperAccessType paperAccessTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("access_type".equals(currentName)) {
                        paperAccessTypeDeserialize = PaperAccessType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (paperAccessTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                PaperDocChangeMemberRoleDetails paperDocChangeMemberRoleDetails = new PaperDocChangeMemberRoleDetails(strDeserialize, paperAccessTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocChangeMemberRoleDetails, paperDocChangeMemberRoleDetails.toStringMultiline());
                return paperDocChangeMemberRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

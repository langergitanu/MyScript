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
public class PaperPublishedLinkChangePermissionDetails {

    @Nonnull
    protected final String eventUuid;

    @Nonnull
    protected final String newPermissionLevel;

    @Nonnull
    protected final String previousPermissionLevel;

    public PaperPublishedLinkChangePermissionDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'newPermissionLevel' is null");
        }
        this.newPermissionLevel = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'previousPermissionLevel' is null");
        }
        this.previousPermissionLevel = str3;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public String getNewPermissionLevel() {
        return this.newPermissionLevel;
    }

    @Nonnull
    public String getPreviousPermissionLevel() {
        return this.previousPermissionLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.newPermissionLevel, this.previousPermissionLevel});
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
        PaperPublishedLinkChangePermissionDetails paperPublishedLinkChangePermissionDetails = (PaperPublishedLinkChangePermissionDetails) obj;
        String str5 = this.eventUuid;
        String str6 = paperPublishedLinkChangePermissionDetails.eventUuid;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.newPermissionLevel) == (str2 = paperPublishedLinkChangePermissionDetails.newPermissionLevel) || str.equals(str2)) && ((str3 = this.previousPermissionLevel) == (str4 = paperPublishedLinkChangePermissionDetails.previousPermissionLevel) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperPublishedLinkChangePermissionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperPublishedLinkChangePermissionDetails paperPublishedLinkChangePermissionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperPublishedLinkChangePermissionDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("new_permission_level");
            StoneSerializers.string().serialize(paperPublishedLinkChangePermissionDetails.newPermissionLevel, jsonGenerator);
            jsonGenerator.writeFieldName("previous_permission_level");
            StoneSerializers.string().serialize(paperPublishedLinkChangePermissionDetails.previousPermissionLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperPublishedLinkChangePermissionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("new_permission_level".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_permission_level".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_permission_level\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_permission_level\" missing.");
                }
                PaperPublishedLinkChangePermissionDetails paperPublishedLinkChangePermissionDetails = new PaperPublishedLinkChangePermissionDetails(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperPublishedLinkChangePermissionDetails, paperPublishedLinkChangePermissionDetails.toStringMultiline());
                return paperPublishedLinkChangePermissionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

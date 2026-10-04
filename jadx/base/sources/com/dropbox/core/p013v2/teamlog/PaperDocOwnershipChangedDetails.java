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
public class PaperDocOwnershipChangedDetails {

    @Nonnull
    protected final String eventUuid;

    @Nonnull
    protected final String newOwnerUserId;

    @Nullable
    protected final String oldOwnerUserId;

    public PaperDocOwnershipChangedDetails(@Nonnull String str, @Nonnull String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (str3 != null) {
            if (str3.length() < 40) {
                throw new IllegalArgumentException("String 'oldOwnerUserId' is shorter than 40");
            }
            if (str3.length() > 40) {
                throw new IllegalArgumentException("String 'oldOwnerUserId' is longer than 40");
            }
        }
        this.oldOwnerUserId = str3;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'newOwnerUserId' is null");
        }
        if (str2.length() < 40) {
            throw new IllegalArgumentException("String 'newOwnerUserId' is shorter than 40");
        }
        if (str2.length() > 40) {
            throw new IllegalArgumentException("String 'newOwnerUserId' is longer than 40");
        }
        this.newOwnerUserId = str2;
    }

    public PaperDocOwnershipChangedDetails(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null);
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public String getNewOwnerUserId() {
        return this.newOwnerUserId;
    }

    @Nullable
    public String getOldOwnerUserId() {
        return this.oldOwnerUserId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.oldOwnerUserId, this.newOwnerUserId});
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
        PaperDocOwnershipChangedDetails paperDocOwnershipChangedDetails = (PaperDocOwnershipChangedDetails) obj;
        String str5 = this.eventUuid;
        String str6 = paperDocOwnershipChangedDetails.eventUuid;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.newOwnerUserId) == (str2 = paperDocOwnershipChangedDetails.newOwnerUserId) || str.equals(str2)) && ((str3 = this.oldOwnerUserId) == (str4 = paperDocOwnershipChangedDetails.oldOwnerUserId) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocOwnershipChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocOwnershipChangedDetails paperDocOwnershipChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperDocOwnershipChangedDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("new_owner_user_id");
            StoneSerializers.string().serialize(paperDocOwnershipChangedDetails.newOwnerUserId, jsonGenerator);
            if (paperDocOwnershipChangedDetails.oldOwnerUserId != null) {
                jsonGenerator.writeFieldName("old_owner_user_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperDocOwnershipChangedDetails.oldOwnerUserId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocOwnershipChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_owner_user_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("old_owner_user_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_owner_user_id\" missing.");
                }
                PaperDocOwnershipChangedDetails paperDocOwnershipChangedDetails = new PaperDocOwnershipChangedDetails(strDeserialize, strDeserialize2, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocOwnershipChangedDetails, paperDocOwnershipChangedDetails.toStringMultiline());
                return paperDocOwnershipChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

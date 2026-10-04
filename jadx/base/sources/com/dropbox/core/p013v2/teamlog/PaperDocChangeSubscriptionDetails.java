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
public class PaperDocChangeSubscriptionDetails {

    @Nonnull
    protected final String eventUuid;

    @Nonnull
    protected final String newSubscriptionLevel;

    @Nullable
    protected final String previousSubscriptionLevel;

    public PaperDocChangeSubscriptionDetails(@Nonnull String str, @Nonnull String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'newSubscriptionLevel' is null");
        }
        this.newSubscriptionLevel = str2;
        this.previousSubscriptionLevel = str3;
    }

    public PaperDocChangeSubscriptionDetails(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null);
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public String getNewSubscriptionLevel() {
        return this.newSubscriptionLevel;
    }

    @Nullable
    public String getPreviousSubscriptionLevel() {
        return this.previousSubscriptionLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.newSubscriptionLevel, this.previousSubscriptionLevel});
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
        PaperDocChangeSubscriptionDetails paperDocChangeSubscriptionDetails = (PaperDocChangeSubscriptionDetails) obj;
        String str5 = this.eventUuid;
        String str6 = paperDocChangeSubscriptionDetails.eventUuid;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.newSubscriptionLevel) == (str2 = paperDocChangeSubscriptionDetails.newSubscriptionLevel) || str.equals(str2)) && ((str3 = this.previousSubscriptionLevel) == (str4 = paperDocChangeSubscriptionDetails.previousSubscriptionLevel) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocChangeSubscriptionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocChangeSubscriptionDetails paperDocChangeSubscriptionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperDocChangeSubscriptionDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("new_subscription_level");
            StoneSerializers.string().serialize(paperDocChangeSubscriptionDetails.newSubscriptionLevel, jsonGenerator);
            if (paperDocChangeSubscriptionDetails.previousSubscriptionLevel != null) {
                jsonGenerator.writeFieldName("previous_subscription_level");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperDocChangeSubscriptionDetails.previousSubscriptionLevel, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocChangeSubscriptionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("new_subscription_level".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_subscription_level".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_subscription_level\" missing.");
                }
                PaperDocChangeSubscriptionDetails paperDocChangeSubscriptionDetails = new PaperDocChangeSubscriptionDetails(strDeserialize, strDeserialize2, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocChangeSubscriptionDetails, paperDocChangeSubscriptionDetails.toStringMultiline());
                return paperDocChangeSubscriptionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

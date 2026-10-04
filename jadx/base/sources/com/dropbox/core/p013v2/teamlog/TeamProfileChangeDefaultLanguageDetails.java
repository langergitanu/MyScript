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
public class TeamProfileChangeDefaultLanguageDetails {

    @Nonnull
    protected final String newValue;

    @Nonnull
    protected final String previousValue;

    public TeamProfileChangeDefaultLanguageDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        if (str.length() < 2) {
            throw new IllegalArgumentException("String 'newValue' is shorter than 2");
        }
        this.newValue = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        if (str2.length() < 2) {
            throw new IllegalArgumentException("String 'previousValue' is shorter than 2");
        }
        this.previousValue = str2;
    }

    @Nonnull
    public String getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public String getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
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
        TeamProfileChangeDefaultLanguageDetails teamProfileChangeDefaultLanguageDetails = (TeamProfileChangeDefaultLanguageDetails) obj;
        String str3 = this.newValue;
        String str4 = teamProfileChangeDefaultLanguageDetails.newValue;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.previousValue) == (str2 = teamProfileChangeDefaultLanguageDetails.previousValue) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamProfileChangeDefaultLanguageDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamProfileChangeDefaultLanguageDetails teamProfileChangeDefaultLanguageDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            StoneSerializers.string().serialize(teamProfileChangeDefaultLanguageDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            StoneSerializers.string().serialize(teamProfileChangeDefaultLanguageDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamProfileChangeDefaultLanguageDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("new_value".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                TeamProfileChangeDefaultLanguageDetails teamProfileChangeDefaultLanguageDetails = new TeamProfileChangeDefaultLanguageDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamProfileChangeDefaultLanguageDetails, teamProfileChangeDefaultLanguageDetails.toStringMultiline());
                return teamProfileChangeDefaultLanguageDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

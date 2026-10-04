package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ShowcaseExternalSharingPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ShowcaseChangeExternalSharingPolicyDetails {

    @Nonnull
    protected final ShowcaseExternalSharingPolicy newValue;

    @Nonnull
    protected final ShowcaseExternalSharingPolicy previousValue;

    public ShowcaseChangeExternalSharingPolicyDetails(@Nonnull ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy, @Nonnull ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy2) {
        if (showcaseExternalSharingPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = showcaseExternalSharingPolicy;
        if (showcaseExternalSharingPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = showcaseExternalSharingPolicy2;
    }

    @Nonnull
    public ShowcaseExternalSharingPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ShowcaseExternalSharingPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy;
        ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ShowcaseChangeExternalSharingPolicyDetails showcaseChangeExternalSharingPolicyDetails = (ShowcaseChangeExternalSharingPolicyDetails) obj;
        ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy3 = this.newValue;
        ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy4 = showcaseChangeExternalSharingPolicyDetails.newValue;
        return (showcaseExternalSharingPolicy3 == showcaseExternalSharingPolicy4 || showcaseExternalSharingPolicy3.equals(showcaseExternalSharingPolicy4)) && ((showcaseExternalSharingPolicy = this.previousValue) == (showcaseExternalSharingPolicy2 = showcaseChangeExternalSharingPolicyDetails.previousValue) || showcaseExternalSharingPolicy.equals(showcaseExternalSharingPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseChangeExternalSharingPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseChangeExternalSharingPolicyDetails showcaseChangeExternalSharingPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ShowcaseExternalSharingPolicy.Serializer.INSTANCE.serialize(showcaseChangeExternalSharingPolicyDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ShowcaseExternalSharingPolicy.Serializer.INSTANCE.serialize(showcaseChangeExternalSharingPolicyDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseChangeExternalSharingPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ShowcaseExternalSharingPolicy showcaseExternalSharingPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ShowcaseExternalSharingPolicy showcaseExternalSharingPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        showcaseExternalSharingPolicyDeserialize = ShowcaseExternalSharingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        showcaseExternalSharingPolicyDeserialize2 = ShowcaseExternalSharingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (showcaseExternalSharingPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (showcaseExternalSharingPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ShowcaseChangeExternalSharingPolicyDetails showcaseChangeExternalSharingPolicyDetails = new ShowcaseChangeExternalSharingPolicyDetails(showcaseExternalSharingPolicyDeserialize, showcaseExternalSharingPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseChangeExternalSharingPolicyDetails, showcaseChangeExternalSharingPolicyDetails.toStringMultiline());
                return showcaseChangeExternalSharingPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

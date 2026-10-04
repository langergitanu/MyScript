package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ShowcaseEnabledPolicy;
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
public class ShowcaseChangeEnabledPolicyDetails {

    @Nonnull
    protected final ShowcaseEnabledPolicy newValue;

    @Nonnull
    protected final ShowcaseEnabledPolicy previousValue;

    public ShowcaseChangeEnabledPolicyDetails(@Nonnull ShowcaseEnabledPolicy showcaseEnabledPolicy, @Nonnull ShowcaseEnabledPolicy showcaseEnabledPolicy2) {
        if (showcaseEnabledPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = showcaseEnabledPolicy;
        if (showcaseEnabledPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = showcaseEnabledPolicy2;
    }

    @Nonnull
    public ShowcaseEnabledPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ShowcaseEnabledPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ShowcaseEnabledPolicy showcaseEnabledPolicy;
        ShowcaseEnabledPolicy showcaseEnabledPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ShowcaseChangeEnabledPolicyDetails showcaseChangeEnabledPolicyDetails = (ShowcaseChangeEnabledPolicyDetails) obj;
        ShowcaseEnabledPolicy showcaseEnabledPolicy3 = this.newValue;
        ShowcaseEnabledPolicy showcaseEnabledPolicy4 = showcaseChangeEnabledPolicyDetails.newValue;
        return (showcaseEnabledPolicy3 == showcaseEnabledPolicy4 || showcaseEnabledPolicy3.equals(showcaseEnabledPolicy4)) && ((showcaseEnabledPolicy = this.previousValue) == (showcaseEnabledPolicy2 = showcaseChangeEnabledPolicyDetails.previousValue) || showcaseEnabledPolicy.equals(showcaseEnabledPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseChangeEnabledPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseChangeEnabledPolicyDetails showcaseChangeEnabledPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ShowcaseEnabledPolicy.Serializer.INSTANCE.serialize(showcaseChangeEnabledPolicyDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ShowcaseEnabledPolicy.Serializer.INSTANCE.serialize(showcaseChangeEnabledPolicyDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseChangeEnabledPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ShowcaseEnabledPolicy showcaseEnabledPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ShowcaseEnabledPolicy showcaseEnabledPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        showcaseEnabledPolicyDeserialize = ShowcaseEnabledPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        showcaseEnabledPolicyDeserialize2 = ShowcaseEnabledPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (showcaseEnabledPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (showcaseEnabledPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ShowcaseChangeEnabledPolicyDetails showcaseChangeEnabledPolicyDetails = new ShowcaseChangeEnabledPolicyDetails(showcaseEnabledPolicyDeserialize, showcaseEnabledPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseChangeEnabledPolicyDetails, showcaseChangeEnabledPolicyDetails.toStringMultiline());
                return showcaseChangeEnabledPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

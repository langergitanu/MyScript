package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ShowcaseDownloadPolicy;
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
public class ShowcaseChangeDownloadPolicyDetails {

    @Nonnull
    protected final ShowcaseDownloadPolicy newValue;

    @Nonnull
    protected final ShowcaseDownloadPolicy previousValue;

    public ShowcaseChangeDownloadPolicyDetails(@Nonnull ShowcaseDownloadPolicy showcaseDownloadPolicy, @Nonnull ShowcaseDownloadPolicy showcaseDownloadPolicy2) {
        if (showcaseDownloadPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = showcaseDownloadPolicy;
        if (showcaseDownloadPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = showcaseDownloadPolicy2;
    }

    @Nonnull
    public ShowcaseDownloadPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ShowcaseDownloadPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ShowcaseDownloadPolicy showcaseDownloadPolicy;
        ShowcaseDownloadPolicy showcaseDownloadPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ShowcaseChangeDownloadPolicyDetails showcaseChangeDownloadPolicyDetails = (ShowcaseChangeDownloadPolicyDetails) obj;
        ShowcaseDownloadPolicy showcaseDownloadPolicy3 = this.newValue;
        ShowcaseDownloadPolicy showcaseDownloadPolicy4 = showcaseChangeDownloadPolicyDetails.newValue;
        return (showcaseDownloadPolicy3 == showcaseDownloadPolicy4 || showcaseDownloadPolicy3.equals(showcaseDownloadPolicy4)) && ((showcaseDownloadPolicy = this.previousValue) == (showcaseDownloadPolicy2 = showcaseChangeDownloadPolicyDetails.previousValue) || showcaseDownloadPolicy.equals(showcaseDownloadPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseChangeDownloadPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseChangeDownloadPolicyDetails showcaseChangeDownloadPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ShowcaseDownloadPolicy.Serializer.INSTANCE.serialize(showcaseChangeDownloadPolicyDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ShowcaseDownloadPolicy.Serializer.INSTANCE.serialize(showcaseChangeDownloadPolicyDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseChangeDownloadPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ShowcaseDownloadPolicy showcaseDownloadPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ShowcaseDownloadPolicy showcaseDownloadPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        showcaseDownloadPolicyDeserialize = ShowcaseDownloadPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        showcaseDownloadPolicyDeserialize2 = ShowcaseDownloadPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (showcaseDownloadPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (showcaseDownloadPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ShowcaseChangeDownloadPolicyDetails showcaseChangeDownloadPolicyDetails = new ShowcaseChangeDownloadPolicyDetails(showcaseDownloadPolicyDeserialize, showcaseDownloadPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseChangeDownloadPolicyDetails, showcaseChangeDownloadPolicyDetails.toStringMultiline());
                return showcaseChangeDownloadPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

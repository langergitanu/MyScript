package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.MemberSuggestionsPolicy;
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
public class MemberSuggestionsChangePolicyDetails {

    @Nonnull
    protected final MemberSuggestionsPolicy newValue;

    @Nullable
    protected final MemberSuggestionsPolicy previousValue;

    public MemberSuggestionsChangePolicyDetails(@Nonnull MemberSuggestionsPolicy memberSuggestionsPolicy, @Nullable MemberSuggestionsPolicy memberSuggestionsPolicy2) {
        if (memberSuggestionsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = memberSuggestionsPolicy;
        this.previousValue = memberSuggestionsPolicy2;
    }

    public MemberSuggestionsChangePolicyDetails(@Nonnull MemberSuggestionsPolicy memberSuggestionsPolicy) {
        this(memberSuggestionsPolicy, null);
    }

    @Nonnull
    public MemberSuggestionsPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public MemberSuggestionsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        MemberSuggestionsPolicy memberSuggestionsPolicy;
        MemberSuggestionsPolicy memberSuggestionsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberSuggestionsChangePolicyDetails memberSuggestionsChangePolicyDetails = (MemberSuggestionsChangePolicyDetails) obj;
        MemberSuggestionsPolicy memberSuggestionsPolicy3 = this.newValue;
        MemberSuggestionsPolicy memberSuggestionsPolicy4 = memberSuggestionsChangePolicyDetails.newValue;
        return (memberSuggestionsPolicy3 == memberSuggestionsPolicy4 || memberSuggestionsPolicy3.equals(memberSuggestionsPolicy4)) && ((memberSuggestionsPolicy = this.previousValue) == (memberSuggestionsPolicy2 = memberSuggestionsChangePolicyDetails.previousValue) || (memberSuggestionsPolicy != null && memberSuggestionsPolicy.equals(memberSuggestionsPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberSuggestionsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberSuggestionsChangePolicyDetails memberSuggestionsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MemberSuggestionsPolicy.Serializer.INSTANCE.serialize(memberSuggestionsChangePolicyDetails.newValue, jsonGenerator);
            if (memberSuggestionsChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(MemberSuggestionsPolicy.Serializer.INSTANCE).serialize(memberSuggestionsChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberSuggestionsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberSuggestionsPolicy memberSuggestionsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberSuggestionsPolicy memberSuggestionsPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        memberSuggestionsPolicyDeserialize = MemberSuggestionsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        memberSuggestionsPolicy = (MemberSuggestionsPolicy) StoneSerializers.nullable(MemberSuggestionsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberSuggestionsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberSuggestionsChangePolicyDetails memberSuggestionsChangePolicyDetails = new MemberSuggestionsChangePolicyDetails(memberSuggestionsPolicyDeserialize, memberSuggestionsPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberSuggestionsChangePolicyDetails, memberSuggestionsChangePolicyDetails.toStringMultiline());
                return memberSuggestionsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

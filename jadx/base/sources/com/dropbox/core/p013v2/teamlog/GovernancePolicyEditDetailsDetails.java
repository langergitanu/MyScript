package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PolicyType;
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
public class GovernancePolicyEditDetailsDetails {

    @Nonnull
    protected final String attribute;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String newValue;

    @Nullable
    protected final PolicyType policyType;

    @Nonnull
    protected final String previousValue;

    public GovernancePolicyEditDetailsDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5, @Nullable PolicyType policyType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.policyType = policyType;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'attribute' is null");
        }
        this.attribute = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = str4;
        if (str5 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = str5;
    }

    public GovernancePolicyEditDetailsDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5) {
        this(str, str2, str3, str4, str5, null);
    }

    @Nonnull
    public String getGovernancePolicyId() {
        return this.governancePolicyId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getAttribute() {
        return this.attribute;
    }

    @Nonnull
    public String getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public String getNewValue() {
        return this.newValue;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.attribute, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        PolicyType policyType;
        PolicyType policyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyEditDetailsDetails governancePolicyEditDetailsDetails = (GovernancePolicyEditDetailsDetails) obj;
        String str9 = this.governancePolicyId;
        String str10 = governancePolicyEditDetailsDetails.governancePolicyId;
        return (str9 == str10 || str9.equals(str10)) && ((str = this.name) == (str2 = governancePolicyEditDetailsDetails.name) || str.equals(str2)) && (((str3 = this.attribute) == (str4 = governancePolicyEditDetailsDetails.attribute) || str3.equals(str4)) && (((str5 = this.previousValue) == (str6 = governancePolicyEditDetailsDetails.previousValue) || str5.equals(str6)) && (((str7 = this.newValue) == (str8 = governancePolicyEditDetailsDetails.newValue) || str7.equals(str8)) && ((policyType = this.policyType) == (policyType2 = governancePolicyEditDetailsDetails.policyType) || (policyType != null && policyType.equals(policyType2))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyEditDetailsDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyEditDetailsDetails governancePolicyEditDetailsDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyEditDetailsDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyEditDetailsDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("attribute");
            StoneSerializers.string().serialize(governancePolicyEditDetailsDetails.attribute, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            StoneSerializers.string().serialize(governancePolicyEditDetailsDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            StoneSerializers.string().serialize(governancePolicyEditDetailsDetails.newValue, jsonGenerator);
            if (governancePolicyEditDetailsDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyEditDetailsDetails.policyType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyEditDetailsDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                String strDeserialize5 = null;
                PolicyType policyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("attribute".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        strDeserialize5 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("policy_type".equals(currentName)) {
                        policyType = (PolicyType) StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"governance_policy_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"attribute\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (strDeserialize5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                GovernancePolicyEditDetailsDetails governancePolicyEditDetailsDetails = new GovernancePolicyEditDetailsDetails(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4, strDeserialize5, policyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyEditDetailsDetails, governancePolicyEditDetailsDetails.toStringMultiline());
                return governancePolicyEditDetailsDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

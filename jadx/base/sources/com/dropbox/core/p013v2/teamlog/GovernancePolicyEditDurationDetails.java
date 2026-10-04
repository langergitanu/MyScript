package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DurationLogInfo;
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
public class GovernancePolicyEditDurationDetails {

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final DurationLogInfo newValue;

    @Nullable
    protected final PolicyType policyType;

    @Nonnull
    protected final DurationLogInfo previousValue;

    public GovernancePolicyEditDurationDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DurationLogInfo durationLogInfo, @Nonnull DurationLogInfo durationLogInfo2, @Nullable PolicyType policyType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.policyType = policyType;
        if (durationLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = durationLogInfo;
        if (durationLogInfo2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = durationLogInfo2;
    }

    public GovernancePolicyEditDurationDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DurationLogInfo durationLogInfo, @Nonnull DurationLogInfo durationLogInfo2) {
        this(str, str2, durationLogInfo, durationLogInfo2, null);
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
    public DurationLogInfo getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public DurationLogInfo getNewValue() {
        return this.newValue;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        DurationLogInfo durationLogInfo;
        DurationLogInfo durationLogInfo2;
        DurationLogInfo durationLogInfo3;
        DurationLogInfo durationLogInfo4;
        PolicyType policyType;
        PolicyType policyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyEditDurationDetails governancePolicyEditDurationDetails = (GovernancePolicyEditDurationDetails) obj;
        String str3 = this.governancePolicyId;
        String str4 = governancePolicyEditDurationDetails.governancePolicyId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = governancePolicyEditDurationDetails.name) || str.equals(str2)) && (((durationLogInfo = this.previousValue) == (durationLogInfo2 = governancePolicyEditDurationDetails.previousValue) || durationLogInfo.equals(durationLogInfo2)) && (((durationLogInfo3 = this.newValue) == (durationLogInfo4 = governancePolicyEditDurationDetails.newValue) || durationLogInfo3.equals(durationLogInfo4)) && ((policyType = this.policyType) == (policyType2 = governancePolicyEditDurationDetails.policyType) || (policyType != null && policyType.equals(policyType2)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyEditDurationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyEditDurationDetails governancePolicyEditDurationDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyEditDurationDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyEditDurationDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            DurationLogInfo.Serializer.INSTANCE.serialize(governancePolicyEditDurationDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            DurationLogInfo.Serializer.INSTANCE.serialize(governancePolicyEditDurationDetails.newValue, jsonGenerator);
            if (governancePolicyEditDurationDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyEditDurationDetails.policyType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyEditDurationDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                DurationLogInfo durationLogInfoDeserialize = null;
                DurationLogInfo durationLogInfoDeserialize2 = null;
                PolicyType policyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        durationLogInfoDeserialize = DurationLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        durationLogInfoDeserialize2 = DurationLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (durationLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (durationLogInfoDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                GovernancePolicyEditDurationDetails governancePolicyEditDurationDetails = new GovernancePolicyEditDurationDetails(strDeserialize, strDeserialize2, durationLogInfoDeserialize, durationLogInfoDeserialize2, policyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyEditDurationDetails, governancePolicyEditDurationDetails.toStringMultiline());
                return governancePolicyEditDurationDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

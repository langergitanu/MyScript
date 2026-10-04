package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DispositionActionType;
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
public class GovernancePolicyContentDisposedDetails {

    @Nonnull
    protected final DispositionActionType dispositionType;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    public GovernancePolicyContentDisposedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DispositionActionType dispositionActionType, @Nullable PolicyType policyType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.policyType = policyType;
        if (dispositionActionType == null) {
            throw new IllegalArgumentException("Required value for 'dispositionType' is null");
        }
        this.dispositionType = dispositionActionType;
    }

    public GovernancePolicyContentDisposedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DispositionActionType dispositionActionType) {
        this(str, str2, dispositionActionType, null);
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
    public DispositionActionType getDispositionType() {
        return this.dispositionType;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.dispositionType});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        DispositionActionType dispositionActionType;
        DispositionActionType dispositionActionType2;
        PolicyType policyType;
        PolicyType policyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyContentDisposedDetails governancePolicyContentDisposedDetails = (GovernancePolicyContentDisposedDetails) obj;
        String str3 = this.governancePolicyId;
        String str4 = governancePolicyContentDisposedDetails.governancePolicyId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = governancePolicyContentDisposedDetails.name) || str.equals(str2)) && (((dispositionActionType = this.dispositionType) == (dispositionActionType2 = governancePolicyContentDisposedDetails.dispositionType) || dispositionActionType.equals(dispositionActionType2)) && ((policyType = this.policyType) == (policyType2 = governancePolicyContentDisposedDetails.policyType) || (policyType != null && policyType.equals(policyType2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyContentDisposedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyContentDisposedDetails governancePolicyContentDisposedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyContentDisposedDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyContentDisposedDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("disposition_type");
            DispositionActionType.Serializer.INSTANCE.serialize(governancePolicyContentDisposedDetails.dispositionType, jsonGenerator);
            if (governancePolicyContentDisposedDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyContentDisposedDetails.policyType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyContentDisposedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                DispositionActionType dispositionActionTypeDeserialize = null;
                PolicyType policyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("disposition_type".equals(currentName)) {
                        dispositionActionTypeDeserialize = DispositionActionType.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (dispositionActionTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"disposition_type\" missing.");
                }
                GovernancePolicyContentDisposedDetails governancePolicyContentDisposedDetails = new GovernancePolicyContentDisposedDetails(strDeserialize, strDeserialize2, dispositionActionTypeDeserialize, policyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyContentDisposedDetails, governancePolicyContentDisposedDetails.toStringMultiline());
                return governancePolicyContentDisposedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

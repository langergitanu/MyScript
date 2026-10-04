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
public class GovernancePolicyExportRemovedDetails {

    @Nonnull
    protected final String exportName;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    public GovernancePolicyExportRemovedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nullable PolicyType policyType) {
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
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = str3;
    }

    public GovernancePolicyExportRemovedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this(str, str2, str3, null);
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
    public String getExportName() {
        return this.exportName;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.exportName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        PolicyType policyType;
        PolicyType policyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyExportRemovedDetails governancePolicyExportRemovedDetails = (GovernancePolicyExportRemovedDetails) obj;
        String str5 = this.governancePolicyId;
        String str6 = governancePolicyExportRemovedDetails.governancePolicyId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = governancePolicyExportRemovedDetails.name) || str.equals(str2)) && (((str3 = this.exportName) == (str4 = governancePolicyExportRemovedDetails.exportName) || str3.equals(str4)) && ((policyType = this.policyType) == (policyType2 = governancePolicyExportRemovedDetails.policyType) || (policyType != null && policyType.equals(policyType2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyExportRemovedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyExportRemovedDetails governancePolicyExportRemovedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyExportRemovedDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyExportRemovedDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("export_name");
            StoneSerializers.string().serialize(governancePolicyExportRemovedDetails.exportName, jsonGenerator);
            if (governancePolicyExportRemovedDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyExportRemovedDetails.policyType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyExportRemovedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                PolicyType policyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
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
                    throw new JsonParseException(jsonParser, "Required field \"export_name\" missing.");
                }
                GovernancePolicyExportRemovedDetails governancePolicyExportRemovedDetails = new GovernancePolicyExportRemovedDetails(strDeserialize, strDeserialize2, strDeserialize3, policyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyExportRemovedDetails, governancePolicyExportRemovedDetails.toStringMultiline());
                return governancePolicyExportRemovedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

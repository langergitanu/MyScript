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
public class GovernancePolicyAddFolderFailedDetails {

    @Nonnull
    protected final String folder;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    @Nullable
    protected final String reason;

    public GovernancePolicyAddFolderFailedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nullable PolicyType policyType, @Nullable String str4) {
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
            throw new IllegalArgumentException("Required value for 'folder' is null");
        }
        this.folder = str3;
        this.reason = str4;
    }

    public GovernancePolicyAddFolderFailedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this(str, str2, str3, null, null);
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
    public String getFolder() {
        return this.folder;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    @Nullable
    public String getReason() {
        return this.reason;
    }

    public static Builder newBuilder(String str, String str2, String str3) {
        return new Builder(str, str2, str3);
    }

    public static class Builder {
        protected final String folder;
        protected final String governancePolicyId;
        protected final String name;
        protected PolicyType policyType;
        protected String reason;

        protected Builder(String str, String str2, String str3) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'folder' is null");
            }
            this.folder = str3;
            this.policyType = null;
            this.reason = null;
        }

        public Builder withPolicyType(PolicyType policyType) {
            this.policyType = policyType;
            return this;
        }

        public Builder withReason(String str) {
            this.reason = str;
            return this;
        }

        public GovernancePolicyAddFolderFailedDetails build() {
            return new GovernancePolicyAddFolderFailedDetails(this.governancePolicyId, this.name, this.folder, this.policyType, this.reason);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.folder, this.reason});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        PolicyType policyType;
        PolicyType policyType2;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyAddFolderFailedDetails governancePolicyAddFolderFailedDetails = (GovernancePolicyAddFolderFailedDetails) obj;
        String str7 = this.governancePolicyId;
        String str8 = governancePolicyAddFolderFailedDetails.governancePolicyId;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.name) == (str2 = governancePolicyAddFolderFailedDetails.name) || str.equals(str2)) && (((str3 = this.folder) == (str4 = governancePolicyAddFolderFailedDetails.folder) || str3.equals(str4)) && (((policyType = this.policyType) == (policyType2 = governancePolicyAddFolderFailedDetails.policyType) || (policyType != null && policyType.equals(policyType2))) && ((str5 = this.reason) == (str6 = governancePolicyAddFolderFailedDetails.reason) || (str5 != null && str5.equals(str6)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyAddFolderFailedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyAddFolderFailedDetails governancePolicyAddFolderFailedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyAddFolderFailedDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyAddFolderFailedDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("folder");
            StoneSerializers.string().serialize(governancePolicyAddFolderFailedDetails.folder, jsonGenerator);
            if (governancePolicyAddFolderFailedDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyAddFolderFailedDetails.policyType, jsonGenerator);
            }
            if (governancePolicyAddFolderFailedDetails.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(governancePolicyAddFolderFailedDetails.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyAddFolderFailedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PolicyType policyType = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("folder".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("policy_type".equals(currentName)) {
                        policyType = (PolicyType) StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("reason".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                    throw new JsonParseException(jsonParser, "Required field \"folder\" missing.");
                }
                GovernancePolicyAddFolderFailedDetails governancePolicyAddFolderFailedDetails = new GovernancePolicyAddFolderFailedDetails(strDeserialize, strDeserialize2, strDeserialize3, policyType, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyAddFolderFailedDetails, governancePolicyAddFolderFailedDetails.toStringMultiline());
                return governancePolicyAddFolderFailedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

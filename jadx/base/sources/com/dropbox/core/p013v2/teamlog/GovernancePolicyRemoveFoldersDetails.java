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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GovernancePolicyRemoveFoldersDetails {

    @Nullable
    protected final List<String> folders;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    @Nullable
    protected final String reason;

    public GovernancePolicyRemoveFoldersDetails(@Nonnull String str, @Nonnull String str2, @Nullable PolicyType policyType, @Nullable List<String> list, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.policyType = policyType;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'folders' is null");
                }
            }
        }
        this.folders = list;
        this.reason = str3;
    }

    public GovernancePolicyRemoveFoldersDetails(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null, null, null);
    }

    @Nonnull
    public String getGovernancePolicyId() {
        return this.governancePolicyId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    @Nullable
    public List<String> getFolders() {
        return this.folders;
    }

    @Nullable
    public String getReason() {
        return this.reason;
    }

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder {
        protected List<String> folders;
        protected final String governancePolicyId;
        protected final String name;
        protected PolicyType policyType;
        protected String reason;

        protected Builder(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            this.policyType = null;
            this.folders = null;
            this.reason = null;
        }

        public Builder withPolicyType(PolicyType policyType) {
            this.policyType = policyType;
            return this;
        }

        public Builder withFolders(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'folders' is null");
                    }
                }
            }
            this.folders = list;
            return this;
        }

        public Builder withReason(String str) {
            this.reason = str;
            return this;
        }

        public GovernancePolicyRemoveFoldersDetails build() {
            return new GovernancePolicyRemoveFoldersDetails(this.governancePolicyId, this.name, this.policyType, this.folders, this.reason);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.folders, this.reason});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        PolicyType policyType;
        PolicyType policyType2;
        List<String> list;
        List<String> list2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyRemoveFoldersDetails governancePolicyRemoveFoldersDetails = (GovernancePolicyRemoveFoldersDetails) obj;
        String str5 = this.governancePolicyId;
        String str6 = governancePolicyRemoveFoldersDetails.governancePolicyId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = governancePolicyRemoveFoldersDetails.name) || str.equals(str2)) && (((policyType = this.policyType) == (policyType2 = governancePolicyRemoveFoldersDetails.policyType) || (policyType != null && policyType.equals(policyType2))) && (((list = this.folders) == (list2 = governancePolicyRemoveFoldersDetails.folders) || (list != null && list.equals(list2))) && ((str3 = this.reason) == (str4 = governancePolicyRemoveFoldersDetails.reason) || (str3 != null && str3.equals(str4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyRemoveFoldersDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyRemoveFoldersDetails governancePolicyRemoveFoldersDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyRemoveFoldersDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyRemoveFoldersDetails.name, jsonGenerator);
            if (governancePolicyRemoveFoldersDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyRemoveFoldersDetails.policyType, jsonGenerator);
            }
            if (governancePolicyRemoveFoldersDetails.folders != null) {
                jsonGenerator.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(governancePolicyRemoveFoldersDetails.folders, jsonGenerator);
            }
            if (governancePolicyRemoveFoldersDetails.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(governancePolicyRemoveFoldersDetails.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyRemoveFoldersDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PolicyType policyType = null;
                List list = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("policy_type".equals(currentName)) {
                        policyType = (PolicyType) StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("folders".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
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
                GovernancePolicyRemoveFoldersDetails governancePolicyRemoveFoldersDetails = new GovernancePolicyRemoveFoldersDetails(strDeserialize, strDeserialize2, policyType, list, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyRemoveFoldersDetails, governancePolicyRemoveFoldersDetails.toStringMultiline());
                return governancePolicyRemoveFoldersDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

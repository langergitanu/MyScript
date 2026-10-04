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
public class GovernancePolicyAddFoldersDetails {

    @Nullable
    protected final List<String> folders;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    public GovernancePolicyAddFoldersDetails(@Nonnull String str, @Nonnull String str2, @Nullable PolicyType policyType, @Nullable List<String> list) {
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
    }

    public GovernancePolicyAddFoldersDetails(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null, null);
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

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder {
        protected List<String> folders;
        protected final String governancePolicyId;
        protected final String name;
        protected PolicyType policyType;

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

        public GovernancePolicyAddFoldersDetails build() {
            return new GovernancePolicyAddFoldersDetails(this.governancePolicyId, this.name, this.policyType, this.folders);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.folders});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        PolicyType policyType;
        PolicyType policyType2;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GovernancePolicyAddFoldersDetails governancePolicyAddFoldersDetails = (GovernancePolicyAddFoldersDetails) obj;
        String str3 = this.governancePolicyId;
        String str4 = governancePolicyAddFoldersDetails.governancePolicyId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = governancePolicyAddFoldersDetails.name) || str.equals(str2)) && (((policyType = this.policyType) == (policyType2 = governancePolicyAddFoldersDetails.policyType) || (policyType != null && policyType.equals(policyType2))) && ((list = this.folders) == (list2 = governancePolicyAddFoldersDetails.folders) || (list != null && list.equals(list2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyAddFoldersDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyAddFoldersDetails governancePolicyAddFoldersDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyAddFoldersDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyAddFoldersDetails.name, jsonGenerator);
            if (governancePolicyAddFoldersDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyAddFoldersDetails.policyType, jsonGenerator);
            }
            if (governancePolicyAddFoldersDetails.folders != null) {
                jsonGenerator.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(governancePolicyAddFoldersDetails.folders, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyAddFoldersDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PolicyType policyType = null;
                List list = null;
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
                GovernancePolicyAddFoldersDetails governancePolicyAddFoldersDetails = new GovernancePolicyAddFoldersDetails(strDeserialize, strDeserialize2, policyType, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyAddFoldersDetails, governancePolicyAddFoldersDetails.toStringMultiline());
                return governancePolicyAddFoldersDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

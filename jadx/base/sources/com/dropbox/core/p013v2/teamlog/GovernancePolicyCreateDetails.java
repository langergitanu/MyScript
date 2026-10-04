package com.dropbox.core.p013v2.teamlog;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GovernancePolicyCreateDetails {

    @Nonnull
    protected final DurationLogInfo duration;

    @Nullable
    protected final List<String> folders;

    @Nonnull
    protected final String governancePolicyId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final PolicyType policyType;

    public GovernancePolicyCreateDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DurationLogInfo durationLogInfo, @Nullable PolicyType policyType, @Nullable List<String> list) {
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
            throw new IllegalArgumentException("Required value for 'duration' is null");
        }
        this.duration = durationLogInfo;
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

    public GovernancePolicyCreateDetails(@Nonnull String str, @Nonnull String str2, @Nonnull DurationLogInfo durationLogInfo) {
        this(str, str2, durationLogInfo, null, null);
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
    public DurationLogInfo getDuration() {
        return this.duration;
    }

    @Nullable
    public PolicyType getPolicyType() {
        return this.policyType;
    }

    @Nullable
    public List<String> getFolders() {
        return this.folders;
    }

    public static Builder newBuilder(String str, String str2, DurationLogInfo durationLogInfo) {
        return new Builder(str, str2, durationLogInfo);
    }

    public static class Builder {
        protected final DurationLogInfo duration;
        protected List<String> folders;
        protected final String governancePolicyId;
        protected final String name;
        protected PolicyType policyType;

        protected Builder(String str, String str2, DurationLogInfo durationLogInfo) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            if (durationLogInfo == null) {
                throw new IllegalArgumentException("Required value for 'duration' is null");
            }
            this.duration = durationLogInfo;
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

        public GovernancePolicyCreateDetails build() {
            return new GovernancePolicyCreateDetails(this.governancePolicyId, this.name, this.duration, this.policyType, this.folders);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.governancePolicyId, this.name, this.policyType, this.duration, this.folders});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        DurationLogInfo durationLogInfo;
        DurationLogInfo durationLogInfo2;
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
        GovernancePolicyCreateDetails governancePolicyCreateDetails = (GovernancePolicyCreateDetails) obj;
        String str3 = this.governancePolicyId;
        String str4 = governancePolicyCreateDetails.governancePolicyId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = governancePolicyCreateDetails.name) || str.equals(str2)) && (((durationLogInfo = this.duration) == (durationLogInfo2 = governancePolicyCreateDetails.duration) || durationLogInfo.equals(durationLogInfo2)) && (((policyType = this.policyType) == (policyType2 = governancePolicyCreateDetails.policyType) || (policyType != null && policyType.equals(policyType2))) && ((list = this.folders) == (list2 = governancePolicyCreateDetails.folders) || (list != null && list.equals(list2)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GovernancePolicyCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GovernancePolicyCreateDetails governancePolicyCreateDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(governancePolicyCreateDetails.governancePolicyId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(governancePolicyCreateDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName(TypedValues.TransitionType.S_DURATION);
            DurationLogInfo.Serializer.INSTANCE.serialize(governancePolicyCreateDetails.duration, jsonGenerator);
            if (governancePolicyCreateDetails.policyType != null) {
                jsonGenerator.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(governancePolicyCreateDetails.policyType, jsonGenerator);
            }
            if (governancePolicyCreateDetails.folders != null) {
                jsonGenerator.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(governancePolicyCreateDetails.folders, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GovernancePolicyCreateDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PolicyType policyType = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("governance_policy_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (TypedValues.TransitionType.S_DURATION.equals(currentName)) {
                        durationLogInfoDeserialize = DurationLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (durationLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"duration\" missing.");
                }
                GovernancePolicyCreateDetails governancePolicyCreateDetails = new GovernancePolicyCreateDetails(strDeserialize, strDeserialize2, durationLogInfoDeserialize, policyType, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(governancePolicyCreateDetails, governancePolicyCreateDetails.toStringMultiline());
                return governancePolicyCreateDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

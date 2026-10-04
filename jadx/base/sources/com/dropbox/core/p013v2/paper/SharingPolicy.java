package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.SharingPublicPolicyType;
import com.dropbox.core.p013v2.paper.SharingTeamPolicyType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SharingPolicy {

    @Nullable
    protected final SharingPublicPolicyType publicSharingPolicy;

    @Nullable
    protected final SharingTeamPolicyType teamSharingPolicy;

    public SharingPolicy(@Nullable SharingPublicPolicyType sharingPublicPolicyType, @Nullable SharingTeamPolicyType sharingTeamPolicyType) {
        this.publicSharingPolicy = sharingPublicPolicyType;
        this.teamSharingPolicy = sharingTeamPolicyType;
    }

    public SharingPolicy() {
        this(null, null);
    }

    @Nullable
    public SharingPublicPolicyType getPublicSharingPolicy() {
        return this.publicSharingPolicy;
    }

    @Nullable
    public SharingTeamPolicyType getTeamSharingPolicy() {
        return this.teamSharingPolicy;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected SharingPublicPolicyType publicSharingPolicy = null;
        protected SharingTeamPolicyType teamSharingPolicy = null;

        protected Builder() {
        }

        public Builder withPublicSharingPolicy(SharingPublicPolicyType sharingPublicPolicyType) {
            this.publicSharingPolicy = sharingPublicPolicyType;
            return this;
        }

        public Builder withTeamSharingPolicy(SharingTeamPolicyType sharingTeamPolicyType) {
            this.teamSharingPolicy = sharingTeamPolicyType;
            return this;
        }

        public SharingPolicy build() {
            return new SharingPolicy(this.publicSharingPolicy, this.teamSharingPolicy);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.publicSharingPolicy, this.teamSharingPolicy});
    }

    public boolean equals(Object obj) {
        SharingTeamPolicyType sharingTeamPolicyType;
        SharingTeamPolicyType sharingTeamPolicyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingPolicy sharingPolicy = (SharingPolicy) obj;
        SharingPublicPolicyType sharingPublicPolicyType = this.publicSharingPolicy;
        SharingPublicPolicyType sharingPublicPolicyType2 = sharingPolicy.publicSharingPolicy;
        return (sharingPublicPolicyType == sharingPublicPolicyType2 || (sharingPublicPolicyType != null && sharingPublicPolicyType.equals(sharingPublicPolicyType2))) && ((sharingTeamPolicyType = this.teamSharingPolicy) == (sharingTeamPolicyType2 = sharingPolicy.teamSharingPolicy) || (sharingTeamPolicyType != null && sharingTeamPolicyType.equals(sharingTeamPolicyType2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingPolicy sharingPolicy, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharingPolicy.publicSharingPolicy != null) {
                jsonGenerator.writeFieldName("public_sharing_policy");
                StoneSerializers.nullable(SharingPublicPolicyType.Serializer.INSTANCE).serialize(sharingPolicy.publicSharingPolicy, jsonGenerator);
            }
            if (sharingPolicy.teamSharingPolicy != null) {
                jsonGenerator.writeFieldName("team_sharing_policy");
                StoneSerializers.nullable(SharingTeamPolicyType.Serializer.INSTANCE).serialize(sharingPolicy.teamSharingPolicy, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingPolicy deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharingPublicPolicyType sharingPublicPolicyType = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharingTeamPolicyType sharingTeamPolicyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("public_sharing_policy".equals(currentName)) {
                        sharingPublicPolicyType = (SharingPublicPolicyType) StoneSerializers.nullable(SharingPublicPolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("team_sharing_policy".equals(currentName)) {
                        sharingTeamPolicyType = (SharingTeamPolicyType) StoneSerializers.nullable(SharingTeamPolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharingPolicy sharingPolicy = new SharingPolicy(sharingPublicPolicyType, sharingTeamPolicyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingPolicy, sharingPolicy.toStringMultiline());
                return sharingPolicy;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

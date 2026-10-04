package com.dropbox.core.p013v2.teamlog;

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
public class PaperDocChangeSharingPolicyDetails {

    @Nonnull
    protected final String eventUuid;

    @Nullable
    protected final String publicSharingPolicy;

    @Nullable
    protected final String teamSharingPolicy;

    public PaperDocChangeSharingPolicyDetails(@Nonnull String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        this.publicSharingPolicy = str2;
        this.teamSharingPolicy = str3;
    }

    public PaperDocChangeSharingPolicyDetails(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nullable
    public String getPublicSharingPolicy() {
        return this.publicSharingPolicy;
    }

    @Nullable
    public String getTeamSharingPolicy() {
        return this.teamSharingPolicy;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String eventUuid;
        protected String publicSharingPolicy;
        protected String teamSharingPolicy;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'eventUuid' is null");
            }
            this.eventUuid = str;
            this.publicSharingPolicy = null;
            this.teamSharingPolicy = null;
        }

        public Builder withPublicSharingPolicy(String str) {
            this.publicSharingPolicy = str;
            return this;
        }

        public Builder withTeamSharingPolicy(String str) {
            this.teamSharingPolicy = str;
            return this;
        }

        public PaperDocChangeSharingPolicyDetails build() {
            return new PaperDocChangeSharingPolicyDetails(this.eventUuid, this.publicSharingPolicy, this.teamSharingPolicy);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.publicSharingPolicy, this.teamSharingPolicy});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDocChangeSharingPolicyDetails paperDocChangeSharingPolicyDetails = (PaperDocChangeSharingPolicyDetails) obj;
        String str5 = this.eventUuid;
        String str6 = paperDocChangeSharingPolicyDetails.eventUuid;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.publicSharingPolicy) == (str2 = paperDocChangeSharingPolicyDetails.publicSharingPolicy) || (str != null && str.equals(str2))) && ((str3 = this.teamSharingPolicy) == (str4 = paperDocChangeSharingPolicyDetails.teamSharingPolicy) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocChangeSharingPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocChangeSharingPolicyDetails paperDocChangeSharingPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperDocChangeSharingPolicyDetails.eventUuid, jsonGenerator);
            if (paperDocChangeSharingPolicyDetails.publicSharingPolicy != null) {
                jsonGenerator.writeFieldName("public_sharing_policy");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperDocChangeSharingPolicyDetails.publicSharingPolicy, jsonGenerator);
            }
            if (paperDocChangeSharingPolicyDetails.teamSharingPolicy != null) {
                jsonGenerator.writeFieldName("team_sharing_policy");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperDocChangeSharingPolicyDetails.teamSharingPolicy, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocChangeSharingPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("public_sharing_policy".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team_sharing_policy".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                PaperDocChangeSharingPolicyDetails paperDocChangeSharingPolicyDetails = new PaperDocChangeSharingPolicyDetails(strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocChangeSharingPolicyDetails, paperDocChangeSharingPolicyDetails.toStringMultiline());
                return paperDocChangeSharingPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ActionDetails;
import com.dropbox.core.p013v2.teamlog.MemberStatus;
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
public class MemberChangeStatusDetails {

    @Nullable
    protected final ActionDetails action;

    @Nullable
    protected final String newTeam;

    @Nonnull
    protected final MemberStatus newValue;

    @Nullable
    protected final String previousTeam;

    @Nullable
    protected final MemberStatus previousValue;

    public MemberChangeStatusDetails(@Nonnull MemberStatus memberStatus, @Nullable MemberStatus memberStatus2, @Nullable ActionDetails actionDetails, @Nullable String str, @Nullable String str2) {
        this.previousValue = memberStatus2;
        if (memberStatus == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = memberStatus;
        this.action = actionDetails;
        this.newTeam = str;
        this.previousTeam = str2;
    }

    public MemberChangeStatusDetails(@Nonnull MemberStatus memberStatus) {
        this(memberStatus, null, null, null, null);
    }

    @Nonnull
    public MemberStatus getNewValue() {
        return this.newValue;
    }

    @Nullable
    public MemberStatus getPreviousValue() {
        return this.previousValue;
    }

    @Nullable
    public ActionDetails getAction() {
        return this.action;
    }

    @Nullable
    public String getNewTeam() {
        return this.newTeam;
    }

    @Nullable
    public String getPreviousTeam() {
        return this.previousTeam;
    }

    public static Builder newBuilder(MemberStatus memberStatus) {
        return new Builder(memberStatus);
    }

    public static class Builder {
        protected ActionDetails action;
        protected String newTeam;
        protected final MemberStatus newValue;
        protected String previousTeam;
        protected MemberStatus previousValue;

        protected Builder(MemberStatus memberStatus) {
            if (memberStatus == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = memberStatus;
            this.previousValue = null;
            this.action = null;
            this.newTeam = null;
            this.previousTeam = null;
        }

        public Builder withPreviousValue(MemberStatus memberStatus) {
            this.previousValue = memberStatus;
            return this;
        }

        public Builder withAction(ActionDetails actionDetails) {
            this.action = actionDetails;
            return this;
        }

        public Builder withNewTeam(String str) {
            this.newTeam = str;
            return this;
        }

        public Builder withPreviousTeam(String str) {
            this.previousTeam = str;
            return this;
        }

        public MemberChangeStatusDetails build() {
            return new MemberChangeStatusDetails(this.newValue, this.previousValue, this.action, this.newTeam, this.previousTeam);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue, this.action, this.newTeam, this.previousTeam});
    }

    public boolean equals(Object obj) {
        MemberStatus memberStatus;
        MemberStatus memberStatus2;
        ActionDetails actionDetails;
        ActionDetails actionDetails2;
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
        MemberChangeStatusDetails memberChangeStatusDetails = (MemberChangeStatusDetails) obj;
        MemberStatus memberStatus3 = this.newValue;
        MemberStatus memberStatus4 = memberChangeStatusDetails.newValue;
        return (memberStatus3 == memberStatus4 || memberStatus3.equals(memberStatus4)) && ((memberStatus = this.previousValue) == (memberStatus2 = memberChangeStatusDetails.previousValue) || (memberStatus != null && memberStatus.equals(memberStatus2))) && (((actionDetails = this.action) == (actionDetails2 = memberChangeStatusDetails.action) || (actionDetails != null && actionDetails.equals(actionDetails2))) && (((str = this.newTeam) == (str2 = memberChangeStatusDetails.newTeam) || (str != null && str.equals(str2))) && ((str3 = this.previousTeam) == (str4 = memberChangeStatusDetails.previousTeam) || (str3 != null && str3.equals(str4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberChangeStatusDetails memberChangeStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MemberStatus.Serializer.INSTANCE.serialize(memberChangeStatusDetails.newValue, jsonGenerator);
            if (memberChangeStatusDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(MemberStatus.Serializer.INSTANCE).serialize(memberChangeStatusDetails.previousValue, jsonGenerator);
            }
            if (memberChangeStatusDetails.action != null) {
                jsonGenerator.writeFieldName("action");
                StoneSerializers.nullable(ActionDetails.Serializer.INSTANCE).serialize(memberChangeStatusDetails.action, jsonGenerator);
            }
            if (memberChangeStatusDetails.newTeam != null) {
                jsonGenerator.writeFieldName("new_team");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberChangeStatusDetails.newTeam, jsonGenerator);
            }
            if (memberChangeStatusDetails.previousTeam != null) {
                jsonGenerator.writeFieldName("previous_team");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberChangeStatusDetails.previousTeam, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberChangeStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberStatus memberStatusDeserialize = null;
                MemberStatus memberStatus = null;
                ActionDetails actionDetails = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        memberStatusDeserialize = MemberStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        memberStatus = (MemberStatus) StoneSerializers.nullable(MemberStatus.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("action".equals(currentName)) {
                        actionDetails = (ActionDetails) StoneSerializers.nullable(ActionDetails.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("new_team".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_team".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberChangeStatusDetails memberChangeStatusDetails = new MemberChangeStatusDetails(memberStatusDeserialize, memberStatus, actionDetails, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberChangeStatusDetails, memberChangeStatusDetails.toStringMultiline());
                return memberChangeStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

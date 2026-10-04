package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamMembershipType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class MemberChangeMembershipTypeDetails {

    @Nonnull
    protected final TeamMembershipType newValue;

    @Nonnull
    protected final TeamMembershipType prevValue;

    public MemberChangeMembershipTypeDetails(@Nonnull TeamMembershipType teamMembershipType, @Nonnull TeamMembershipType teamMembershipType2) {
        if (teamMembershipType == null) {
            throw new IllegalArgumentException("Required value for 'prevValue' is null");
        }
        this.prevValue = teamMembershipType;
        if (teamMembershipType2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamMembershipType2;
    }

    @Nonnull
    public TeamMembershipType getPrevValue() {
        return this.prevValue;
    }

    @Nonnull
    public TeamMembershipType getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.prevValue, this.newValue});
    }

    public boolean equals(Object obj) {
        TeamMembershipType teamMembershipType;
        TeamMembershipType teamMembershipType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberChangeMembershipTypeDetails memberChangeMembershipTypeDetails = (MemberChangeMembershipTypeDetails) obj;
        TeamMembershipType teamMembershipType3 = this.prevValue;
        TeamMembershipType teamMembershipType4 = memberChangeMembershipTypeDetails.prevValue;
        return (teamMembershipType3 == teamMembershipType4 || teamMembershipType3.equals(teamMembershipType4)) && ((teamMembershipType = this.newValue) == (teamMembershipType2 = memberChangeMembershipTypeDetails.newValue) || teamMembershipType.equals(teamMembershipType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberChangeMembershipTypeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberChangeMembershipTypeDetails memberChangeMembershipTypeDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("prev_value");
            TeamMembershipType.Serializer.INSTANCE.serialize(memberChangeMembershipTypeDetails.prevValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            TeamMembershipType.Serializer.INSTANCE.serialize(memberChangeMembershipTypeDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberChangeMembershipTypeDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMembershipType teamMembershipTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamMembershipType teamMembershipTypeDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("prev_value".equals(currentName)) {
                        teamMembershipTypeDeserialize = TeamMembershipType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        teamMembershipTypeDeserialize2 = TeamMembershipType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMembershipTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"prev_value\" missing.");
                }
                if (teamMembershipTypeDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberChangeMembershipTypeDetails memberChangeMembershipTypeDetails = new MemberChangeMembershipTypeDetails(teamMembershipTypeDeserialize, teamMembershipTypeDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberChangeMembershipTypeDetails, memberChangeMembershipTypeDetails.toStringMultiline());
                return memberChangeMembershipTypeDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

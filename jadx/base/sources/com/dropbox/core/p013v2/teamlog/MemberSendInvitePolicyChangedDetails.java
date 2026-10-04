package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.MemberSendInvitePolicy;
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
public class MemberSendInvitePolicyChangedDetails {

    @Nonnull
    protected final MemberSendInvitePolicy newValue;

    @Nonnull
    protected final MemberSendInvitePolicy previousValue;

    public MemberSendInvitePolicyChangedDetails(@Nonnull MemberSendInvitePolicy memberSendInvitePolicy, @Nonnull MemberSendInvitePolicy memberSendInvitePolicy2) {
        if (memberSendInvitePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = memberSendInvitePolicy;
        if (memberSendInvitePolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = memberSendInvitePolicy2;
    }

    @Nonnull
    public MemberSendInvitePolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public MemberSendInvitePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        MemberSendInvitePolicy memberSendInvitePolicy;
        MemberSendInvitePolicy memberSendInvitePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberSendInvitePolicyChangedDetails memberSendInvitePolicyChangedDetails = (MemberSendInvitePolicyChangedDetails) obj;
        MemberSendInvitePolicy memberSendInvitePolicy3 = this.newValue;
        MemberSendInvitePolicy memberSendInvitePolicy4 = memberSendInvitePolicyChangedDetails.newValue;
        return (memberSendInvitePolicy3 == memberSendInvitePolicy4 || memberSendInvitePolicy3.equals(memberSendInvitePolicy4)) && ((memberSendInvitePolicy = this.previousValue) == (memberSendInvitePolicy2 = memberSendInvitePolicyChangedDetails.previousValue) || memberSendInvitePolicy.equals(memberSendInvitePolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberSendInvitePolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberSendInvitePolicyChangedDetails memberSendInvitePolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MemberSendInvitePolicy.Serializer.INSTANCE.serialize(memberSendInvitePolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            MemberSendInvitePolicy.Serializer.INSTANCE.serialize(memberSendInvitePolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberSendInvitePolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberSendInvitePolicy memberSendInvitePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberSendInvitePolicy memberSendInvitePolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        memberSendInvitePolicyDeserialize = MemberSendInvitePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        memberSendInvitePolicyDeserialize2 = MemberSendInvitePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberSendInvitePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (memberSendInvitePolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                MemberSendInvitePolicyChangedDetails memberSendInvitePolicyChangedDetails = new MemberSendInvitePolicyChangedDetails(memberSendInvitePolicyDeserialize, memberSendInvitePolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberSendInvitePolicyChangedDetails, memberSendInvitePolicyChangedDetails.toStringMultiline());
                return memberSendInvitePolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

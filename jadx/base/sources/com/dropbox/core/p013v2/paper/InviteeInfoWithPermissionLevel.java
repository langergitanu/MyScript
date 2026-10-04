package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.PaperDocPermissionLevel;
import com.dropbox.core.p013v2.sharing.InviteeInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class InviteeInfoWithPermissionLevel {

    @Nonnull
    protected final InviteeInfo invitee;

    @Nonnull
    protected final PaperDocPermissionLevel permissionLevel;

    public InviteeInfoWithPermissionLevel(@Nonnull InviteeInfo inviteeInfo, @Nonnull PaperDocPermissionLevel paperDocPermissionLevel) {
        if (inviteeInfo == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        this.invitee = inviteeInfo;
        if (paperDocPermissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = paperDocPermissionLevel;
    }

    @Nonnull
    public InviteeInfo getInvitee() {
        return this.invitee;
    }

    @Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return this.permissionLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.invitee, this.permissionLevel});
    }

    public boolean equals(Object obj) {
        PaperDocPermissionLevel paperDocPermissionLevel;
        PaperDocPermissionLevel paperDocPermissionLevel2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        InviteeInfoWithPermissionLevel inviteeInfoWithPermissionLevel = (InviteeInfoWithPermissionLevel) obj;
        InviteeInfo inviteeInfo = this.invitee;
        InviteeInfo inviteeInfo2 = inviteeInfoWithPermissionLevel.invitee;
        return (inviteeInfo == inviteeInfo2 || inviteeInfo.equals(inviteeInfo2)) && ((paperDocPermissionLevel = this.permissionLevel) == (paperDocPermissionLevel2 = inviteeInfoWithPermissionLevel.permissionLevel) || paperDocPermissionLevel.equals(paperDocPermissionLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<InviteeInfoWithPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(InviteeInfoWithPermissionLevel inviteeInfoWithPermissionLevel, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("invitee");
            InviteeInfo.Serializer.INSTANCE.serialize(inviteeInfoWithPermissionLevel.invitee, jsonGenerator);
            jsonGenerator.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(inviteeInfoWithPermissionLevel.permissionLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public InviteeInfoWithPermissionLevel deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            InviteeInfo inviteeInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDocPermissionLevel paperDocPermissionLevelDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("invitee".equals(currentName)) {
                        inviteeInfoDeserialize = InviteeInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permission_level".equals(currentName)) {
                        paperDocPermissionLevelDeserialize = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (inviteeInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitee\" missing.");
                }
                if (paperDocPermissionLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"permission_level\" missing.");
                }
                InviteeInfoWithPermissionLevel inviteeInfoWithPermissionLevel = new InviteeInfoWithPermissionLevel(inviteeInfoDeserialize, paperDocPermissionLevelDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(inviteeInfoWithPermissionLevel, inviteeInfoWithPermissionLevel.toStringMultiline());
                return inviteeInfoWithPermissionLevel;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

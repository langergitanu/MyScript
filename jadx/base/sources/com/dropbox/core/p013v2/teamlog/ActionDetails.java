package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.JoinTeamDetails;
import com.dropbox.core.p013v2.teamlog.MemberRemoveActionType;
import com.dropbox.core.p013v2.teamlog.TeamInviteDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class ActionDetails {
    public static final ActionDetails OTHER = new ActionDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private MemberRemoveActionType removeActionValue;
    private TeamInviteDetails teamInviteDetailsValue;
    private JoinTeamDetails teamJoinDetailsValue;

    public enum Tag {
        REMOVE_ACTION,
        TEAM_INVITE_DETAILS,
        TEAM_JOIN_DETAILS,
        OTHER
    }

    private ActionDetails() {
    }

    private ActionDetails withTag(Tag tag) {
        ActionDetails actionDetails = new ActionDetails();
        actionDetails._tag = tag;
        return actionDetails;
    }

    private ActionDetails withTagAndRemoveAction(Tag tag, MemberRemoveActionType memberRemoveActionType) {
        ActionDetails actionDetails = new ActionDetails();
        actionDetails._tag = tag;
        actionDetails.removeActionValue = memberRemoveActionType;
        return actionDetails;
    }

    private ActionDetails withTagAndTeamInviteDetails(Tag tag, TeamInviteDetails teamInviteDetails) {
        ActionDetails actionDetails = new ActionDetails();
        actionDetails._tag = tag;
        actionDetails.teamInviteDetailsValue = teamInviteDetails;
        return actionDetails;
    }

    private ActionDetails withTagAndTeamJoinDetails(Tag tag, JoinTeamDetails joinTeamDetails) {
        ActionDetails actionDetails = new ActionDetails();
        actionDetails._tag = tag;
        actionDetails.teamJoinDetailsValue = joinTeamDetails;
        return actionDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isRemoveAction() {
        return this._tag == Tag.REMOVE_ACTION;
    }

    public static ActionDetails removeAction(MemberRemoveActionType memberRemoveActionType) {
        if (memberRemoveActionType == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndRemoveAction(Tag.REMOVE_ACTION, memberRemoveActionType);
    }

    public MemberRemoveActionType getRemoveActionValue() {
        if (this._tag != Tag.REMOVE_ACTION) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVE_ACTION, but was Tag." + this._tag.name());
        }
        return this.removeActionValue;
    }

    public boolean isTeamInviteDetails() {
        return this._tag == Tag.TEAM_INVITE_DETAILS;
    }

    public static ActionDetails teamInviteDetails(TeamInviteDetails teamInviteDetails) {
        if (teamInviteDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndTeamInviteDetails(Tag.TEAM_INVITE_DETAILS, teamInviteDetails);
    }

    public TeamInviteDetails getTeamInviteDetailsValue() {
        if (this._tag != Tag.TEAM_INVITE_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_INVITE_DETAILS, but was Tag." + this._tag.name());
        }
        return this.teamInviteDetailsValue;
    }

    public boolean isTeamJoinDetails() {
        return this._tag == Tag.TEAM_JOIN_DETAILS;
    }

    public static ActionDetails teamJoinDetails(JoinTeamDetails joinTeamDetails) {
        if (joinTeamDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActionDetails().withTagAndTeamJoinDetails(Tag.TEAM_JOIN_DETAILS, joinTeamDetails);
    }

    public JoinTeamDetails getTeamJoinDetailsValue() {
        if (this._tag != Tag.TEAM_JOIN_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_JOIN_DETAILS, but was Tag." + this._tag.name());
        }
        return this.teamJoinDetailsValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.removeActionValue, this.teamInviteDetailsValue, this.teamJoinDetailsValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ActionDetails)) {
            return false;
        }
        ActionDetails actionDetails = (ActionDetails) obj;
        if (this._tag != actionDetails._tag) {
            return false;
        }
        int i = C44331.$SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag[this._tag.ordinal()];
        if (i == 1) {
            MemberRemoveActionType memberRemoveActionType = this.removeActionValue;
            MemberRemoveActionType memberRemoveActionType2 = actionDetails.removeActionValue;
            return memberRemoveActionType == memberRemoveActionType2 || memberRemoveActionType.equals(memberRemoveActionType2);
        }
        if (i == 2) {
            TeamInviteDetails teamInviteDetails = this.teamInviteDetailsValue;
            TeamInviteDetails teamInviteDetails2 = actionDetails.teamInviteDetailsValue;
            return teamInviteDetails == teamInviteDetails2 || teamInviteDetails.equals(teamInviteDetails2);
        }
        if (i != 3) {
            return i == 4;
        }
        JoinTeamDetails joinTeamDetails = this.teamJoinDetailsValue;
        JoinTeamDetails joinTeamDetails2 = actionDetails.teamJoinDetailsValue;
        return joinTeamDetails == joinTeamDetails2 || joinTeamDetails.equals(joinTeamDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ActionDetails$1 */
    static /* synthetic */ class C44331 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag = iArr;
            try {
                iArr[Tag.REMOVE_ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag[Tag.TEAM_INVITE_DETAILS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag[Tag.TEAM_JOIN_DETAILS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ActionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ActionDetails actionDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C44331.$SwitchMap$com$dropbox$core$v2$teamlog$ActionDetails$Tag[actionDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("remove_action", jsonGenerator);
                jsonGenerator.writeFieldName("remove_action");
                MemberRemoveActionType.Serializer.INSTANCE.serialize(actionDetails.removeActionValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("team_invite_details", jsonGenerator);
                TeamInviteDetails.Serializer.INSTANCE.serialize(actionDetails.teamInviteDetailsValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("team_join_details", jsonGenerator);
                JoinTeamDetails.Serializer.INSTANCE.serialize(actionDetails.teamJoinDetailsValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ActionDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ActionDetails actionDetailsTeamJoinDetails;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("remove_action".equals(tag)) {
                expectField("remove_action", jsonParser);
                actionDetailsTeamJoinDetails = ActionDetails.removeAction(MemberRemoveActionType.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_invite_details".equals(tag)) {
                actionDetailsTeamJoinDetails = ActionDetails.teamInviteDetails(TeamInviteDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("team_join_details".equals(tag)) {
                actionDetailsTeamJoinDetails = ActionDetails.teamJoinDetails(JoinTeamDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                actionDetailsTeamJoinDetails = ActionDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return actionDetailsTeamJoinDetails;
        }
    }
}

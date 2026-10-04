package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RemovedStatus;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamMemberStatus {
    public static final TeamMemberStatus ACTIVE = new TeamMemberStatus().withTag(Tag.ACTIVE);
    public static final TeamMemberStatus INVITED = new TeamMemberStatus().withTag(Tag.INVITED);
    public static final TeamMemberStatus SUSPENDED = new TeamMemberStatus().withTag(Tag.SUSPENDED);
    private Tag _tag;
    private RemovedStatus removedValue;

    public enum Tag {
        ACTIVE,
        INVITED,
        SUSPENDED,
        REMOVED
    }

    private TeamMemberStatus() {
    }

    private TeamMemberStatus withTag(Tag tag) {
        TeamMemberStatus teamMemberStatus = new TeamMemberStatus();
        teamMemberStatus._tag = tag;
        return teamMemberStatus;
    }

    private TeamMemberStatus withTagAndRemoved(Tag tag, RemovedStatus removedStatus) {
        TeamMemberStatus teamMemberStatus = new TeamMemberStatus();
        teamMemberStatus._tag = tag;
        teamMemberStatus.removedValue = removedStatus;
        return teamMemberStatus;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isActive() {
        return this._tag == Tag.ACTIVE;
    }

    public boolean isInvited() {
        return this._tag == Tag.INVITED;
    }

    public boolean isSuspended() {
        return this._tag == Tag.SUSPENDED;
    }

    public boolean isRemoved() {
        return this._tag == Tag.REMOVED;
    }

    public static TeamMemberStatus removed(RemovedStatus removedStatus) {
        if (removedStatus == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMemberStatus().withTagAndRemoved(Tag.REMOVED, removedStatus);
    }

    public RemovedStatus getRemovedValue() {
        if (this._tag != Tag.REMOVED) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVED, but was Tag." + this._tag.name());
        }
        return this.removedValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.removedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamMemberStatus)) {
            return false;
        }
        TeamMemberStatus teamMemberStatus = (TeamMemberStatus) obj;
        if (this._tag != teamMemberStatus._tag) {
            return false;
        }
        int i = C44141.$SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return false;
            }
            RemovedStatus removedStatus = this.removedValue;
            RemovedStatus removedStatus2 = teamMemberStatus.removedValue;
            if (removedStatus != removedStatus2 && !removedStatus.equals(removedStatus2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamMemberStatus$1 */
    static /* synthetic */ class C44141 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag = iArr;
            try {
                iArr[Tag.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag[Tag.INVITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag[Tag.SUSPENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag[Tag.REMOVED.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<TeamMemberStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMemberStatus teamMemberStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44141.$SwitchMap$com$dropbox$core$v2$team$TeamMemberStatus$Tag[teamMemberStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invited");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("suspended");
            } else {
                if (i == 4) {
                    jsonGenerator.writeStartObject();
                    writeTag("removed", jsonGenerator);
                    RemovedStatus.Serializer.INSTANCE.serialize(teamMemberStatus.removedValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamMemberStatus.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMemberStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMemberStatus teamMemberStatusRemoved;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                teamMemberStatusRemoved = TeamMemberStatus.ACTIVE;
            } else if ("invited".equals(tag)) {
                teamMemberStatusRemoved = TeamMemberStatus.INVITED;
            } else if ("suspended".equals(tag)) {
                teamMemberStatusRemoved = TeamMemberStatus.SUSPENDED;
            } else if ("removed".equals(tag)) {
                teamMemberStatusRemoved = TeamMemberStatus.removed(RemovedStatus.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMemberStatusRemoved;
        }
    }
}

package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.users.IndividualSpaceAllocation;
import com.dropbox.core.p013v2.users.TeamSpaceAllocation;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class SpaceAllocation {
    public static final SpaceAllocation OTHER = new SpaceAllocation().withTag(Tag.OTHER);
    private Tag _tag;
    private IndividualSpaceAllocation individualValue;
    private TeamSpaceAllocation teamValue;

    public enum Tag {
        INDIVIDUAL,
        TEAM,
        OTHER
    }

    private SpaceAllocation() {
    }

    private SpaceAllocation withTag(Tag tag) {
        SpaceAllocation spaceAllocation = new SpaceAllocation();
        spaceAllocation._tag = tag;
        return spaceAllocation;
    }

    private SpaceAllocation withTagAndIndividual(Tag tag, IndividualSpaceAllocation individualSpaceAllocation) {
        SpaceAllocation spaceAllocation = new SpaceAllocation();
        spaceAllocation._tag = tag;
        spaceAllocation.individualValue = individualSpaceAllocation;
        return spaceAllocation;
    }

    private SpaceAllocation withTagAndTeam(Tag tag, TeamSpaceAllocation teamSpaceAllocation) {
        SpaceAllocation spaceAllocation = new SpaceAllocation();
        spaceAllocation._tag = tag;
        spaceAllocation.teamValue = teamSpaceAllocation;
        return spaceAllocation;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIndividual() {
        return this._tag == Tag.INDIVIDUAL;
    }

    public static SpaceAllocation individual(IndividualSpaceAllocation individualSpaceAllocation) {
        if (individualSpaceAllocation == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation().withTagAndIndividual(Tag.INDIVIDUAL, individualSpaceAllocation);
    }

    public IndividualSpaceAllocation getIndividualValue() {
        if (this._tag != Tag.INDIVIDUAL) {
            throw new IllegalStateException("Invalid tag: required Tag.INDIVIDUAL, but was Tag." + this._tag.name());
        }
        return this.individualValue;
    }

    public boolean isTeam() {
        return this._tag == Tag.TEAM;
    }

    public static SpaceAllocation team(TeamSpaceAllocation teamSpaceAllocation) {
        if (teamSpaceAllocation == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation().withTagAndTeam(Tag.TEAM, teamSpaceAllocation);
    }

    public TeamSpaceAllocation getTeamValue() {
        if (this._tag != Tag.TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM, but was Tag." + this._tag.name());
        }
        return this.teamValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.individualValue, this.teamValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SpaceAllocation)) {
            return false;
        }
        SpaceAllocation spaceAllocation = (SpaceAllocation) obj;
        if (this._tag != spaceAllocation._tag) {
            return false;
        }
        int i = C45651.$SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag[this._tag.ordinal()];
        if (i == 1) {
            IndividualSpaceAllocation individualSpaceAllocation = this.individualValue;
            IndividualSpaceAllocation individualSpaceAllocation2 = spaceAllocation.individualValue;
            return individualSpaceAllocation == individualSpaceAllocation2 || individualSpaceAllocation.equals(individualSpaceAllocation2);
        }
        if (i != 2) {
            return i == 3;
        }
        TeamSpaceAllocation teamSpaceAllocation = this.teamValue;
        TeamSpaceAllocation teamSpaceAllocation2 = spaceAllocation.teamValue;
        return teamSpaceAllocation == teamSpaceAllocation2 || teamSpaceAllocation.equals(teamSpaceAllocation2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.SpaceAllocation$1 */
    static /* synthetic */ class C45651 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag = iArr;
            try {
                iArr[Tag.INDIVIDUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag[Tag.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SpaceAllocation spaceAllocation, JsonGenerator jsonGenerator) throws IOException {
            int i = C45651.$SwitchMap$com$dropbox$core$v2$users$SpaceAllocation$Tag[spaceAllocation.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("individual", jsonGenerator);
                IndividualSpaceAllocation.Serializer.INSTANCE.serialize(spaceAllocation.individualValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("team", jsonGenerator);
                TeamSpaceAllocation.Serializer.INSTANCE.serialize(spaceAllocation.teamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SpaceAllocation deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SpaceAllocation spaceAllocationTeam;
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
            if ("individual".equals(tag)) {
                spaceAllocationTeam = SpaceAllocation.individual(IndividualSpaceAllocation.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("team".equals(tag)) {
                spaceAllocationTeam = SpaceAllocation.team(TeamSpaceAllocation.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                spaceAllocationTeam = SpaceAllocation.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return spaceAllocationTeam;
        }
    }
}

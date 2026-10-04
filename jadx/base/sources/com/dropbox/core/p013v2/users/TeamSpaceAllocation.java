package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.teamcommon.MemberSpaceLimitType;
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

/* JADX INFO: loaded from: classes5.dex */
public class TeamSpaceAllocation {
    protected final long allocated;
    protected final long used;
    protected final long userWithinTeamSpaceAllocated;

    @Nonnull
    protected final MemberSpaceLimitType userWithinTeamSpaceLimitType;
    protected final long userWithinTeamSpaceUsedCached;

    public TeamSpaceAllocation(long j, long j2, long j3, @Nonnull MemberSpaceLimitType memberSpaceLimitType, long j4) {
        this.used = j;
        this.allocated = j2;
        this.userWithinTeamSpaceAllocated = j3;
        if (memberSpaceLimitType == null) {
            throw new IllegalArgumentException("Required value for 'userWithinTeamSpaceLimitType' is null");
        }
        this.userWithinTeamSpaceLimitType = memberSpaceLimitType;
        this.userWithinTeamSpaceUsedCached = j4;
    }

    public long getUsed() {
        return this.used;
    }

    public long getAllocated() {
        return this.allocated;
    }

    public long getUserWithinTeamSpaceAllocated() {
        return this.userWithinTeamSpaceAllocated;
    }

    @Nonnull
    public MemberSpaceLimitType getUserWithinTeamSpaceLimitType() {
        return this.userWithinTeamSpaceLimitType;
    }

    public long getUserWithinTeamSpaceUsedCached() {
        return this.userWithinTeamSpaceUsedCached;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.used), Long.valueOf(this.allocated), Long.valueOf(this.userWithinTeamSpaceAllocated), this.userWithinTeamSpaceLimitType, Long.valueOf(this.userWithinTeamSpaceUsedCached)});
    }

    public boolean equals(Object obj) {
        MemberSpaceLimitType memberSpaceLimitType;
        MemberSpaceLimitType memberSpaceLimitType2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            TeamSpaceAllocation teamSpaceAllocation = (TeamSpaceAllocation) obj;
            if (this.used == teamSpaceAllocation.used && this.allocated == teamSpaceAllocation.allocated && this.userWithinTeamSpaceAllocated == teamSpaceAllocation.userWithinTeamSpaceAllocated && (((memberSpaceLimitType = this.userWithinTeamSpaceLimitType) == (memberSpaceLimitType2 = teamSpaceAllocation.userWithinTeamSpaceLimitType) || memberSpaceLimitType.equals(memberSpaceLimitType2)) && this.userWithinTeamSpaceUsedCached == teamSpaceAllocation.userWithinTeamSpaceUsedCached)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamSpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamSpaceAllocation teamSpaceAllocation, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("used");
            StoneSerializers.uInt64().serialize(Long.valueOf(teamSpaceAllocation.used), jsonGenerator);
            jsonGenerator.writeFieldName("allocated");
            StoneSerializers.uInt64().serialize(Long.valueOf(teamSpaceAllocation.allocated), jsonGenerator);
            jsonGenerator.writeFieldName("user_within_team_space_allocated");
            StoneSerializers.uInt64().serialize(Long.valueOf(teamSpaceAllocation.userWithinTeamSpaceAllocated), jsonGenerator);
            jsonGenerator.writeFieldName("user_within_team_space_limit_type");
            MemberSpaceLimitType.Serializer.INSTANCE.serialize(teamSpaceAllocation.userWithinTeamSpaceLimitType, jsonGenerator);
            jsonGenerator.writeFieldName("user_within_team_space_used_cached");
            StoneSerializers.uInt64().serialize(Long.valueOf(teamSpaceAllocation.userWithinTeamSpaceUsedCached), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamSpaceAllocation deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize2 = null;
                Long lDeserialize3 = null;
                Long lDeserialize4 = null;
                MemberSpaceLimitType memberSpaceLimitTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("used".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("allocated".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("user_within_team_space_allocated".equals(currentName)) {
                        lDeserialize3 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("user_within_team_space_limit_type".equals(currentName)) {
                        memberSpaceLimitTypeDeserialize = MemberSpaceLimitType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("user_within_team_space_used_cached".equals(currentName)) {
                        lDeserialize4 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"used\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allocated\" missing.");
                }
                if (lDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_within_team_space_allocated\" missing.");
                }
                if (memberSpaceLimitTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_within_team_space_limit_type\" missing.");
                }
                if (lDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_within_team_space_used_cached\" missing.");
                }
                TeamSpaceAllocation teamSpaceAllocation = new TeamSpaceAllocation(lDeserialize.longValue(), lDeserialize2.longValue(), lDeserialize3.longValue(), memberSpaceLimitTypeDeserialize, lDeserialize4.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamSpaceAllocation, teamSpaceAllocation.toStringMultiline());
                return teamSpaceAllocation;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

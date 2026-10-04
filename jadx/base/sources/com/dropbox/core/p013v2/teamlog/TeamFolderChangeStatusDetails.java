package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.team.TeamFolderStatus;
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
public class TeamFolderChangeStatusDetails {

    @Nonnull
    protected final TeamFolderStatus newValue;

    @Nullable
    protected final TeamFolderStatus previousValue;

    public TeamFolderChangeStatusDetails(@Nonnull TeamFolderStatus teamFolderStatus, @Nullable TeamFolderStatus teamFolderStatus2) {
        if (teamFolderStatus == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamFolderStatus;
        this.previousValue = teamFolderStatus2;
    }

    public TeamFolderChangeStatusDetails(@Nonnull TeamFolderStatus teamFolderStatus) {
        this(teamFolderStatus, null);
    }

    @Nonnull
    public TeamFolderStatus getNewValue() {
        return this.newValue;
    }

    @Nullable
    public TeamFolderStatus getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TeamFolderStatus teamFolderStatus;
        TeamFolderStatus teamFolderStatus2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamFolderChangeStatusDetails teamFolderChangeStatusDetails = (TeamFolderChangeStatusDetails) obj;
        TeamFolderStatus teamFolderStatus3 = this.newValue;
        TeamFolderStatus teamFolderStatus4 = teamFolderChangeStatusDetails.newValue;
        return (teamFolderStatus3 == teamFolderStatus4 || teamFolderStatus3.equals(teamFolderStatus4)) && ((teamFolderStatus = this.previousValue) == (teamFolderStatus2 = teamFolderChangeStatusDetails.previousValue) || (teamFolderStatus != null && teamFolderStatus.equals(teamFolderStatus2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderChangeStatusDetails teamFolderChangeStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TeamFolderStatus.Serializer.INSTANCE.serialize(teamFolderChangeStatusDetails.newValue, jsonGenerator);
            if (teamFolderChangeStatusDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(TeamFolderStatus.Serializer.INSTANCE).serialize(teamFolderChangeStatusDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderChangeStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamFolderStatus teamFolderStatusDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamFolderStatus teamFolderStatus = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        teamFolderStatusDeserialize = TeamFolderStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        teamFolderStatus = (TeamFolderStatus) StoneSerializers.nullable(TeamFolderStatus.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamFolderStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TeamFolderChangeStatusDetails teamFolderChangeStatusDetails = new TeamFolderChangeStatusDetails(teamFolderStatusDeserialize, teamFolderStatus);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderChangeStatusDetails, teamFolderChangeStatusDetails.toStringMultiline());
                return teamFolderChangeStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

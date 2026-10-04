package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamFolderAccessError;
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
public class TeamFolderListError {

    @Nonnull
    protected final TeamFolderAccessError accessError;

    public TeamFolderListError(@Nonnull TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Required value for 'accessError' is null");
        }
        this.accessError = teamFolderAccessError;
    }

    @Nonnull
    public TeamFolderAccessError getAccessError() {
        return this.accessError;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessError});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamFolderAccessError teamFolderAccessError = this.accessError;
        TeamFolderAccessError teamFolderAccessError2 = ((TeamFolderListError) obj).accessError;
        return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderListError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderListError teamFolderListError, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_error");
            TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderListError.accessError, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderListError deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamFolderAccessError teamFolderAccessErrorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_error".equals(currentName)) {
                        teamFolderAccessErrorDeserialize = TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamFolderAccessErrorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_error\" missing.");
                }
                TeamFolderListError teamFolderListError = new TeamFolderListError(teamFolderAccessErrorDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderListError, teamFolderListError.toStringMultiline());
                return teamFolderListError;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

package com.dropbox.core.p013v2.teamlog;

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
public class TeamFolderRenameDetails {

    @Nonnull
    protected final String newFolderName;

    @Nonnull
    protected final String previousFolderName;

    public TeamFolderRenameDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'previousFolderName' is null");
        }
        this.previousFolderName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'newFolderName' is null");
        }
        this.newFolderName = str2;
    }

    @Nonnull
    public String getPreviousFolderName() {
        return this.previousFolderName;
    }

    @Nonnull
    public String getNewFolderName() {
        return this.newFolderName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousFolderName, this.newFolderName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamFolderRenameDetails teamFolderRenameDetails = (TeamFolderRenameDetails) obj;
        String str3 = this.previousFolderName;
        String str4 = teamFolderRenameDetails.previousFolderName;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.newFolderName) == (str2 = teamFolderRenameDetails.newFolderName) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderRenameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderRenameDetails teamFolderRenameDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_folder_name");
            StoneSerializers.string().serialize(teamFolderRenameDetails.previousFolderName, jsonGenerator);
            jsonGenerator.writeFieldName("new_folder_name");
            StoneSerializers.string().serialize(teamFolderRenameDetails.newFolderName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderRenameDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_folder_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_folder_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_folder_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_folder_name\" missing.");
                }
                TeamFolderRenameDetails teamFolderRenameDetails = new TeamFolderRenameDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderRenameDetails, teamFolderRenameDetails.toStringMultiline());
                return teamFolderRenameDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

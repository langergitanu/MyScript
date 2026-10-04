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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class TeamSharingWhitelistSubjectsChangedDetails {

    @Nonnull
    protected final List<String> addedWhitelistSubjects;

    @Nonnull
    protected final List<String> removedWhitelistSubjects;

    public TeamSharingWhitelistSubjectsChangedDetails(@Nonnull List<String> list, @Nonnull List<String> list2) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'addedWhitelistSubjects' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'addedWhitelistSubjects' is null");
            }
        }
        this.addedWhitelistSubjects = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'removedWhitelistSubjects' is null");
        }
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'removedWhitelistSubjects' is null");
            }
        }
        this.removedWhitelistSubjects = list2;
    }

    @Nonnull
    public List<String> getAddedWhitelistSubjects() {
        return this.addedWhitelistSubjects;
    }

    @Nonnull
    public List<String> getRemovedWhitelistSubjects() {
        return this.removedWhitelistSubjects;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.addedWhitelistSubjects, this.removedWhitelistSubjects});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamSharingWhitelistSubjectsChangedDetails teamSharingWhitelistSubjectsChangedDetails = (TeamSharingWhitelistSubjectsChangedDetails) obj;
        List<String> list3 = this.addedWhitelistSubjects;
        List<String> list4 = teamSharingWhitelistSubjectsChangedDetails.addedWhitelistSubjects;
        return (list3 == list4 || list3.equals(list4)) && ((list = this.removedWhitelistSubjects) == (list2 = teamSharingWhitelistSubjectsChangedDetails.removedWhitelistSubjects) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamSharingWhitelistSubjectsChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamSharingWhitelistSubjectsChangedDetails teamSharingWhitelistSubjectsChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("added_whitelist_subjects");
            StoneSerializers.list(StoneSerializers.string()).serialize(teamSharingWhitelistSubjectsChangedDetails.addedWhitelistSubjects, jsonGenerator);
            jsonGenerator.writeFieldName("removed_whitelist_subjects");
            StoneSerializers.list(StoneSerializers.string()).serialize(teamSharingWhitelistSubjectsChangedDetails.removedWhitelistSubjects, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamSharingWhitelistSubjectsChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("added_whitelist_subjects".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("removed_whitelist_subjects".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"added_whitelist_subjects\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"removed_whitelist_subjects\" missing.");
                }
                TeamSharingWhitelistSubjectsChangedDetails teamSharingWhitelistSubjectsChangedDetails = new TeamSharingWhitelistSubjectsChangedDetails(list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamSharingWhitelistSubjectsChangedDetails, teamSharingWhitelistSubjectsChangedDetails.toStringMultiline());
                return teamSharingWhitelistSubjectsChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

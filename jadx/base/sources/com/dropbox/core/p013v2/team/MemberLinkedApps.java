package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.ApiApp;
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
public class MemberLinkedApps {

    @Nonnull
    protected final List<ApiApp> linkedApiApps;

    @Nonnull
    protected final String teamMemberId;

    public MemberLinkedApps(@Nonnull String str, @Nonnull List<ApiApp> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'linkedApiApps' is null");
        }
        Iterator<ApiApp> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'linkedApiApps' is null");
            }
        }
        this.linkedApiApps = list;
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nonnull
    public List<ApiApp> getLinkedApiApps() {
        return this.linkedApiApps;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberId, this.linkedApiApps});
    }

    public boolean equals(Object obj) {
        List<ApiApp> list;
        List<ApiApp> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberLinkedApps memberLinkedApps = (MemberLinkedApps) obj;
        String str = this.teamMemberId;
        String str2 = memberLinkedApps.teamMemberId;
        return (str == str2 || str.equals(str2)) && ((list = this.linkedApiApps) == (list2 = memberLinkedApps.linkedApiApps) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberLinkedApps> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberLinkedApps memberLinkedApps, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(memberLinkedApps.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("linked_api_apps");
            StoneSerializers.list(ApiApp.Serializer.INSTANCE).serialize(memberLinkedApps.linkedApiApps, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberLinkedApps deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("linked_api_apps".equals(currentName)) {
                        list = (List) StoneSerializers.list(ApiApp.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"linked_api_apps\" missing.");
                }
                MemberLinkedApps memberLinkedApps = new MemberLinkedApps(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberLinkedApps, memberLinkedApps.toStringMultiline());
                return memberLinkedApps;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

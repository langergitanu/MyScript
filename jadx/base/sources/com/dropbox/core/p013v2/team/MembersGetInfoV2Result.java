package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MembersGetInfoItemV2;
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
public class MembersGetInfoV2Result {

    @Nonnull
    protected final List<MembersGetInfoItemV2> membersInfo;

    public MembersGetInfoV2Result(@Nonnull List<MembersGetInfoItemV2> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'membersInfo' is null");
        }
        Iterator<MembersGetInfoItemV2> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'membersInfo' is null");
            }
        }
        this.membersInfo = list;
    }

    @Nonnull
    public List<MembersGetInfoItemV2> getMembersInfo() {
        return this.membersInfo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.membersInfo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<MembersGetInfoItemV2> list = this.membersInfo;
        List<MembersGetInfoItemV2> list2 = ((MembersGetInfoV2Result) obj).membersInfo;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersGetInfoV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersGetInfoV2Result membersGetInfoV2Result, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("members_info");
            StoneSerializers.list(MembersGetInfoItemV2.Serializer.INSTANCE).serialize(membersGetInfoV2Result.membersInfo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersGetInfoV2Result deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
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
                    if ("members_info".equals(currentName)) {
                        list = (List) StoneSerializers.list(MembersGetInfoItemV2.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members_info\" missing.");
                }
                MembersGetInfoV2Result membersGetInfoV2Result = new MembersGetInfoV2Result(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersGetInfoV2Result, membersGetInfoV2Result.toStringMultiline());
                return membersGetInfoV2Result;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

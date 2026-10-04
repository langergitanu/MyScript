package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberAddArg;
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
class MembersAddArg extends MembersAddArgBase {

    @Nonnull
    protected final List<MemberAddArg> newMembers;

    public MembersAddArg(@Nonnull List<MemberAddArg> list, boolean z) {
        super(z);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'newMembers' is null");
        }
        Iterator<MemberAddArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'newMembers' is null");
            }
        }
        this.newMembers = list;
    }

    public MembersAddArg(@Nonnull List<MemberAddArg> list) {
        this(list, false);
    }

    @Nonnull
    public List<MemberAddArg> getNewMembers() {
        return this.newMembers;
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public boolean getForceAsync() {
        return this.forceAsync;
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.newMembers});
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public boolean equals(Object obj) {
        MembersAddArg membersAddArg;
        List<MemberAddArg> list;
        List<MemberAddArg> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.newMembers) == (list2 = (membersAddArg = (MembersAddArg) obj).newMembers) || list.equals(list2)) && this.forceAsync == membersAddArg.forceAsync;
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersAddArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersAddArg membersAddArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_members");
            StoneSerializers.list(MemberAddArg.Serializer.INSTANCE).serialize(membersAddArg.newMembers, jsonGenerator);
            jsonGenerator.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersAddArg.forceAsync), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersAddArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_members".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberAddArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("force_async".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_members\" missing.");
                }
                MembersAddArg membersAddArg = new MembersAddArg(list, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersAddArg, membersAddArg.toStringMultiline());
                return membersAddArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberAddV2Arg;
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
class MembersAddV2Arg extends MembersAddArgBase {

    @Nonnull
    protected final List<MemberAddV2Arg> newMembers;

    public MembersAddV2Arg(@Nonnull List<MemberAddV2Arg> list, boolean z) {
        super(z);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'newMembers' is null");
        }
        Iterator<MemberAddV2Arg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'newMembers' is null");
            }
        }
        this.newMembers = list;
    }

    public MembersAddV2Arg(@Nonnull List<MemberAddV2Arg> list) {
        this(list, false);
    }

    @Nonnull
    public List<MemberAddV2Arg> getNewMembers() {
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
        MembersAddV2Arg membersAddV2Arg;
        List<MemberAddV2Arg> list;
        List<MemberAddV2Arg> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.newMembers) == (list2 = (membersAddV2Arg = (MembersAddV2Arg) obj).newMembers) || list.equals(list2)) && this.forceAsync == membersAddV2Arg.forceAsync;
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersAddArgBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersAddV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersAddV2Arg membersAddV2Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_members");
            StoneSerializers.list(MemberAddV2Arg.Serializer.INSTANCE).serialize(membersAddV2Arg.newMembers, jsonGenerator);
            jsonGenerator.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersAddV2Arg.forceAsync), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersAddV2Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                        list = (List) StoneSerializers.list(MemberAddV2Arg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("force_async".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_members\" missing.");
                }
                MembersAddV2Arg membersAddV2Arg = new MembersAddV2Arg(list, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersAddV2Arg, membersAddV2Arg.toStringMultiline());
                return membersAddV2Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

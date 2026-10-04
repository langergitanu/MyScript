package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.AddMember;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class AddPaperDocUser extends RefPaperDoc {

    @Nullable
    protected final String customMessage;

    @Nonnull
    protected final List<AddMember> members;
    protected final boolean quiet;

    public AddPaperDocUser(@Nonnull String str, @Nonnull List<AddMember> list, @Nullable String str2, boolean z) {
        super(str);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        if (list.size() > 20) {
            throw new IllegalArgumentException("List 'members' has more than 20 items");
        }
        Iterator<AddMember> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = list;
        this.customMessage = str2;
        this.quiet = z;
    }

    public AddPaperDocUser(@Nonnull String str, @Nonnull List<AddMember> list) {
        this(str, list, null, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public List<AddMember> getMembers() {
        return this.members;
    }

    @Nullable
    public String getCustomMessage() {
        return this.customMessage;
    }

    public boolean getQuiet() {
        return this.quiet;
    }

    public static Builder newBuilder(String str, List<AddMember> list) {
        return new Builder(str, list);
    }

    public static class Builder {
        protected String customMessage;
        protected final String docId;
        protected final List<AddMember> members;
        protected boolean quiet;

        protected Builder(String str, List<AddMember> list) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'docId' is null");
            }
            this.docId = str;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            if (list.size() > 20) {
                throw new IllegalArgumentException("List 'members' has more than 20 items");
            }
            Iterator<AddMember> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = list;
            this.customMessage = null;
            this.quiet = false;
        }

        public Builder withCustomMessage(String str) {
            this.customMessage = str;
            return this;
        }

        public Builder withQuiet(Boolean bool) {
            if (bool != null) {
                this.quiet = bool.booleanValue();
                return this;
            }
            this.quiet = false;
            return this;
        }

        public AddPaperDocUser build() {
            return new AddPaperDocUser(this.docId, this.members, this.customMessage, this.quiet);
        }
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.members, this.customMessage, Boolean.valueOf(this.quiet)});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        List<AddMember> list;
        List<AddMember> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            AddPaperDocUser addPaperDocUser = (AddPaperDocUser) obj;
            if ((this.docId == addPaperDocUser.docId || this.docId.equals(addPaperDocUser.docId)) && (((list = this.members) == (list2 = addPaperDocUser.members) || list.equals(list2)) && (((str = this.customMessage) == (str2 = addPaperDocUser.customMessage) || (str != null && str.equals(str2))) && this.quiet == addPaperDocUser.quiet))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddPaperDocUser> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddPaperDocUser addPaperDocUser, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(addPaperDocUser.docId, jsonGenerator);
            jsonGenerator.writeFieldName("members");
            StoneSerializers.list(AddMember.Serializer.INSTANCE).serialize(addPaperDocUser.members, jsonGenerator);
            if (addPaperDocUser.customMessage != null) {
                jsonGenerator.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(addPaperDocUser.customMessage, jsonGenerator);
            }
            jsonGenerator.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(addPaperDocUser.quiet), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddPaperDocUser deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                Boolean boolDeserialize = false;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.list(AddMember.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("custom_message".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("quiet".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                AddPaperDocUser addPaperDocUser = new AddPaperDocUser(strDeserialize, list, str, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addPaperDocUser, addPaperDocUser.toStringMultiline());
                return addPaperDocUser;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

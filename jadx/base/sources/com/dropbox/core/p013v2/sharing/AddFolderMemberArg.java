package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AddMember;
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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class AddFolderMemberArg {

    @Nullable
    protected final String customMessage;

    @Nonnull
    protected final List<AddMember> members;
    protected final boolean quiet;

    @Nonnull
    protected final String sharedFolderId;

    public AddFolderMemberArg(@Nonnull String str, @Nonnull List<AddMember> list, boolean z, @Nullable String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        Iterator<AddMember> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = list;
        this.quiet = z;
        if (str2 != null && str2.length() < 1) {
            throw new IllegalArgumentException("String 'customMessage' is shorter than 1");
        }
        this.customMessage = str2;
    }

    public AddFolderMemberArg(@Nonnull String str, @Nonnull List<AddMember> list) {
        this(str, list, false, null);
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public List<AddMember> getMembers() {
        return this.members;
    }

    public boolean getQuiet() {
        return this.quiet;
    }

    @Nullable
    public String getCustomMessage() {
        return this.customMessage;
    }

    public static Builder newBuilder(String str, List<AddMember> list) {
        return new Builder(str, list);
    }

    public static class Builder {
        protected String customMessage;
        protected final List<AddMember> members;
        protected boolean quiet;
        protected final String sharedFolderId;

        protected Builder(String str, List<AddMember> list) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            Iterator<AddMember> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = list;
            this.quiet = false;
            this.customMessage = null;
        }

        public Builder withQuiet(Boolean bool) {
            if (bool != null) {
                this.quiet = bool.booleanValue();
                return this;
            }
            this.quiet = false;
            return this;
        }

        public Builder withCustomMessage(String str) {
            if (str != null && str.length() < 1) {
                throw new IllegalArgumentException("String 'customMessage' is shorter than 1");
            }
            this.customMessage = str;
            return this;
        }

        public AddFolderMemberArg build() {
            return new AddFolderMemberArg(this.sharedFolderId, this.members, this.quiet, this.customMessage);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderId, this.members, Boolean.valueOf(this.quiet), this.customMessage});
    }

    public boolean equals(Object obj) {
        AddFolderMemberArg addFolderMemberArg;
        String str;
        String str2;
        List<AddMember> list;
        List<AddMember> list2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.sharedFolderId) == (str2 = (addFolderMemberArg = (AddFolderMemberArg) obj).sharedFolderId) || str.equals(str2)) && (((list = this.members) == (list2 = addFolderMemberArg.members) || list.equals(list2)) && this.quiet == addFolderMemberArg.quiet && ((str3 = this.customMessage) == (str4 = addFolderMemberArg.customMessage) || (str3 != null && str3.equals(str4))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddFolderMemberArg addFolderMemberArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(addFolderMemberArg.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("members");
            StoneSerializers.list(AddMember.Serializer.INSTANCE).serialize(addFolderMemberArg.members, jsonGenerator);
            jsonGenerator.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(addFolderMemberArg.quiet), jsonGenerator);
            if (addFolderMemberArg.customMessage != null) {
                jsonGenerator.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(addFolderMemberArg.customMessage, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddFolderMemberArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.list(AddMember.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("quiet".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("custom_message".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                AddFolderMemberArg addFolderMemberArg = new AddFolderMemberArg(strDeserialize, list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addFolderMemberArg, addFolderMemberArg.toStringMultiline());
                return addFolderMemberArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

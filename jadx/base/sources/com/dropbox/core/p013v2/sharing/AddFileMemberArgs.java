package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.MemberSelector;
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
class AddFileMemberArgs {

    @Nonnull
    protected final AccessLevel accessLevel;
    protected final boolean addMessageAsComment;

    @Nullable
    protected final String customMessage;

    @Nonnull
    protected final String file;

    @Nonnull
    protected final List<MemberSelector> members;
    protected final boolean quiet;

    public AddFileMemberArgs(@Nonnull String str, @Nonnull List<MemberSelector> list, @Nullable String str2, boolean z, @Nonnull AccessLevel accessLevel, boolean z2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        Iterator<MemberSelector> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = list;
        this.customMessage = str2;
        this.quiet = z;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
        this.addMessageAsComment = z2;
    }

    public AddFileMemberArgs(@Nonnull String str, @Nonnull List<MemberSelector> list) {
        this(str, list, null, false, AccessLevel.VIEWER, false);
    }

    @Nonnull
    public String getFile() {
        return this.file;
    }

    @Nonnull
    public List<MemberSelector> getMembers() {
        return this.members;
    }

    @Nullable
    public String getCustomMessage() {
        return this.customMessage;
    }

    public boolean getQuiet() {
        return this.quiet;
    }

    @Nonnull
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public boolean getAddMessageAsComment() {
        return this.addMessageAsComment;
    }

    public static Builder newBuilder(String str, List<MemberSelector> list) {
        return new Builder(str, list);
    }

    public static class Builder {
        protected AccessLevel accessLevel;
        protected boolean addMessageAsComment;
        protected String customMessage;
        protected final String file;
        protected final List<MemberSelector> members;
        protected boolean quiet;

        protected Builder(String str, List<MemberSelector> list) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'file' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'file' is shorter than 1");
            }
            if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
                throw new IllegalArgumentException("String 'file' does not match pattern");
            }
            this.file = str;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            Iterator<MemberSelector> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = list;
            this.customMessage = null;
            this.quiet = false;
            this.accessLevel = AccessLevel.VIEWER;
            this.addMessageAsComment = false;
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

        public Builder withAccessLevel(AccessLevel accessLevel) {
            if (accessLevel != null) {
                this.accessLevel = accessLevel;
                return this;
            }
            this.accessLevel = AccessLevel.VIEWER;
            return this;
        }

        public Builder withAddMessageAsComment(Boolean bool) {
            if (bool != null) {
                this.addMessageAsComment = bool.booleanValue();
                return this;
            }
            this.addMessageAsComment = false;
            return this;
        }

        public AddFileMemberArgs build() {
            return new AddFileMemberArgs(this.file, this.members, this.customMessage, this.quiet, this.accessLevel, this.addMessageAsComment);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.file, this.members, this.customMessage, Boolean.valueOf(this.quiet), this.accessLevel, Boolean.valueOf(this.addMessageAsComment)});
    }

    public boolean equals(Object obj) {
        AddFileMemberArgs addFileMemberArgs;
        String str;
        String str2;
        List<MemberSelector> list;
        List<MemberSelector> list2;
        String str3;
        String str4;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.file) == (str2 = (addFileMemberArgs = (AddFileMemberArgs) obj).file) || str.equals(str2)) && (((list = this.members) == (list2 = addFileMemberArgs.members) || list.equals(list2)) && (((str3 = this.customMessage) == (str4 = addFileMemberArgs.customMessage) || (str3 != null && str3.equals(str4))) && this.quiet == addFileMemberArgs.quiet && (((accessLevel = this.accessLevel) == (accessLevel2 = addFileMemberArgs.accessLevel) || accessLevel.equals(accessLevel2)) && this.addMessageAsComment == addFileMemberArgs.addMessageAsComment)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddFileMemberArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddFileMemberArgs addFileMemberArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file");
            StoneSerializers.string().serialize(addFileMemberArgs.file, jsonGenerator);
            jsonGenerator.writeFieldName("members");
            StoneSerializers.list(MemberSelector.Serializer.INSTANCE).serialize(addFileMemberArgs.members, jsonGenerator);
            if (addFileMemberArgs.customMessage != null) {
                jsonGenerator.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(addFileMemberArgs.customMessage, jsonGenerator);
            }
            jsonGenerator.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(addFileMemberArgs.quiet), jsonGenerator);
            jsonGenerator.writeFieldName("access_level");
            AccessLevel.Serializer.INSTANCE.serialize(addFileMemberArgs.accessLevel, jsonGenerator);
            jsonGenerator.writeFieldName("add_message_as_comment");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(addFileMemberArgs.addMessageAsComment), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddFileMemberArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                Boolean boolDeserialize2 = false;
                String strDeserialize = null;
                List list = null;
                String str = null;
                AccessLevel accessLevelDeserialize = AccessLevel.VIEWER;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberSelector.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("custom_message".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("quiet".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("add_message_as_comment".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                AddFileMemberArgs addFileMemberArgs = new AddFileMemberArgs(strDeserialize, list, str, boolDeserialize.booleanValue(), accessLevelDeserialize, boolDeserialize2.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addFileMemberArgs, addFileMemberArgs.toStringMultiline());
                return addFileMemberArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg;
import com.dropbox.core.p013v2.sharing.MemberAction;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class ListFolderMembersArgs extends ListFolderMembersCursorArg {

    @Nonnull
    protected final String sharedFolderId;

    public ListFolderMembersArgs(@Nonnull String str, @Nullable List<MemberAction> list, long j) {
        super(list, j);
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
    }

    public ListFolderMembersArgs(@Nonnull String str) {
        this(str, null, 1000L);
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    @Nullable
    public List<MemberAction> getActions() {
        return this.actions;
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    public long getLimit() {
        return this.limit;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends ListFolderMembersCursorArg.Builder {
        protected final String sharedFolderId;

        @Override // com.dropbox.core.v2.sharing.ListFolderMembersCursorArg.Builder
        public /* bridge */ /* synthetic */ ListFolderMembersCursorArg.Builder withActions(List list) {
            return withActions((List<MemberAction>) list);
        }

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str;
        }

        @Override // com.dropbox.core.v2.sharing.ListFolderMembersCursorArg.Builder
        public Builder withActions(List<MemberAction> list) {
            super.withActions(list);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ListFolderMembersCursorArg.Builder
        public Builder withLimit(Long l) {
            super.withLimit(l);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.ListFolderMembersCursorArg.Builder
        public ListFolderMembersArgs build() {
            return new ListFolderMembersArgs(this.sharedFolderId, this.actions, this.limit);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sharedFolderId});
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    public boolean equals(Object obj) {
        ListFolderMembersArgs listFolderMembersArgs;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.sharedFolderId) == (str2 = (listFolderMembersArgs = (ListFolderMembersArgs) obj).sharedFolderId) || str.equals(str2)) && ((this.actions == listFolderMembersArgs.actions || (this.actions != null && this.actions.equals(listFolderMembersArgs.actions))) && this.limit == listFolderMembersArgs.limit);
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.ListFolderMembersCursorArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFolderMembersArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFolderMembersArgs listFolderMembersArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(listFolderMembersArgs.sharedFolderId, jsonGenerator);
            if (listFolderMembersArgs.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).serialize(listFolderMembersArgs.actions, jsonGenerator);
            }
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(listFolderMembersArgs.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFolderMembersArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1000L;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("actions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                ListFolderMembersArgs listFolderMembersArgs = new ListFolderMembersArgs(strDeserialize, list, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFolderMembersArgs, listFolderMembersArgs.toStringMultiline());
                return listFolderMembersArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

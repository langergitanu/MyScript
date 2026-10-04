package com.dropbox.core.p013v2.sharing;

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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class ListFileMembersArg {

    @Nullable
    protected final List<MemberAction> actions;

    @Nonnull
    protected final String file;
    protected final boolean includeInherited;
    protected final long limit;

    public ListFileMembersArg(@Nonnull String str, @Nullable List<MemberAction> list, boolean z, long j) {
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
        if (list != null) {
            Iterator<MemberAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = list;
        this.includeInherited = z;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 300) {
            throw new IllegalArgumentException("Number 'limit' is larger than 300L");
        }
        this.limit = j;
    }

    public ListFileMembersArg(@Nonnull String str) {
        this(str, null, true, 100L);
    }

    @Nonnull
    public String getFile() {
        return this.file;
    }

    @Nullable
    public List<MemberAction> getActions() {
        return this.actions;
    }

    public boolean getIncludeInherited() {
        return this.includeInherited;
    }

    public long getLimit() {
        return this.limit;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected List<MemberAction> actions;
        protected final String file;
        protected boolean includeInherited;
        protected long limit;

        protected Builder(String str) {
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
            this.actions = null;
            this.includeInherited = true;
            this.limit = 100L;
        }

        public Builder withActions(List<MemberAction> list) {
            if (list != null) {
                Iterator<MemberAction> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = list;
            return this;
        }

        public Builder withIncludeInherited(Boolean bool) {
            if (bool != null) {
                this.includeInherited = bool.booleanValue();
                return this;
            }
            this.includeInherited = true;
            return this;
        }

        public Builder withLimit(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 300) {
                throw new IllegalArgumentException("Number 'limit' is larger than 300L");
            }
            if (l != null) {
                this.limit = l.longValue();
                return this;
            }
            this.limit = 100L;
            return this;
        }

        public ListFileMembersArg build() {
            return new ListFileMembersArg(this.file, this.actions, this.includeInherited, this.limit);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.file, this.actions, Boolean.valueOf(this.includeInherited), Long.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        ListFileMembersArg listFileMembersArg;
        String str;
        String str2;
        List<MemberAction> list;
        List<MemberAction> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.file) == (str2 = (listFileMembersArg = (ListFileMembersArg) obj).file) || str.equals(str2)) && (((list = this.actions) == (list2 = listFileMembersArg.actions) || (list != null && list.equals(list2))) && this.includeInherited == listFileMembersArg.includeInherited && this.limit == listFileMembersArg.limit);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFileMembersArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFileMembersArg listFileMembersArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file");
            StoneSerializers.string().serialize(listFileMembersArg.file, jsonGenerator);
            if (listFileMembersArg.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).serialize(listFileMembersArg.actions, jsonGenerator);
            }
            jsonGenerator.writeFieldName("include_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFileMembersArg.includeInherited), jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(listFileMembersArg.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFileMembersArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                Long lDeserialize = 100L;
                String strDeserialize = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("actions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("include_inherited".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file\" missing.");
                }
                ListFileMembersArg listFileMembersArg = new ListFileMembersArg(strDeserialize, list, boolDeserialize.booleanValue(), lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFileMembersArg, listFileMembersArg.toStringMultiline());
                return listFileMembersArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

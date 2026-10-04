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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class ListFolderMembersCursorArg {

    @Nullable
    protected final List<MemberAction> actions;
    protected final long limit;

    public ListFolderMembersCursorArg(@Nullable List<MemberAction> list, long j) {
        if (list != null) {
            Iterator<MemberAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = list;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = j;
    }

    public ListFolderMembersCursorArg() {
        this(null, 1000L);
    }

    @Nullable
    public List<MemberAction> getActions() {
        return this.actions;
    }

    public long getLimit() {
        return this.limit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected List<MemberAction> actions = null;
        protected long limit = 1000;

        protected Builder() {
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

        public Builder withLimit(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 1000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
            }
            if (l != null) {
                this.limit = l.longValue();
                return this;
            }
            this.limit = 1000L;
            return this;
        }

        public ListFolderMembersCursorArg build() {
            return new ListFolderMembersCursorArg(this.actions, this.limit);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.actions, Long.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        ListFolderMembersCursorArg listFolderMembersCursorArg;
        List<MemberAction> list;
        List<MemberAction> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.actions) == (list2 = (listFolderMembersCursorArg = (ListFolderMembersCursorArg) obj).actions) || (list != null && list.equals(list2))) && this.limit == listFolderMembersCursorArg.limit;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<ListFolderMembersCursorArg> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFolderMembersCursorArg listFolderMembersCursorArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (listFolderMembersCursorArg.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).serialize(listFolderMembersCursorArg.actions, jsonGenerator);
            }
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(listFolderMembersCursorArg.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFolderMembersCursorArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1000L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("actions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ListFolderMembersCursorArg listFolderMembersCursorArg = new ListFolderMembersCursorArg(list, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFolderMembersCursorArg, listFolderMembersCursorArg.toStringMultiline());
                return listFolderMembersCursorArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

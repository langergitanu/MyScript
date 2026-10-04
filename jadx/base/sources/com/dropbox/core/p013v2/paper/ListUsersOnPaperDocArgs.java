package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.UserOnPaperDocFilter;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class ListUsersOnPaperDocArgs extends RefPaperDoc {

    @Nonnull
    protected final UserOnPaperDocFilter filterBy;
    protected final int limit;

    public ListUsersOnPaperDocArgs(@Nonnull String str, int i, @Nonnull UserOnPaperDocFilter userOnPaperDocFilter) {
        super(str);
        if (i < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (i > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        this.limit = i;
        if (userOnPaperDocFilter == null) {
            throw new IllegalArgumentException("Required value for 'filterBy' is null");
        }
        this.filterBy = userOnPaperDocFilter;
    }

    public ListUsersOnPaperDocArgs(@Nonnull String str) {
        this(str, 1000, UserOnPaperDocFilter.SHARED);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    public int getLimit() {
        return this.limit;
    }

    @Nonnull
    public UserOnPaperDocFilter getFilterBy() {
        return this.filterBy;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String docId;
        protected UserOnPaperDocFilter filterBy;
        protected int limit;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'docId' is null");
            }
            this.docId = str;
            this.limit = 1000;
            this.filterBy = UserOnPaperDocFilter.SHARED;
        }

        public Builder withLimit(Integer num) {
            if (num.intValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1");
            }
            if (num.intValue() > 1000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000");
            }
            if (num != null) {
                this.limit = num.intValue();
                return this;
            }
            this.limit = 1000;
            return this;
        }

        public Builder withFilterBy(UserOnPaperDocFilter userOnPaperDocFilter) {
            if (userOnPaperDocFilter != null) {
                this.filterBy = userOnPaperDocFilter;
                return this;
            }
            this.filterBy = UserOnPaperDocFilter.SHARED;
            return this;
        }

        public ListUsersOnPaperDocArgs build() {
            return new ListUsersOnPaperDocArgs(this.docId, this.limit, this.filterBy);
        }
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.limit), this.filterBy});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        UserOnPaperDocFilter userOnPaperDocFilter;
        UserOnPaperDocFilter userOnPaperDocFilter2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ListUsersOnPaperDocArgs listUsersOnPaperDocArgs = (ListUsersOnPaperDocArgs) obj;
            if ((this.docId == listUsersOnPaperDocArgs.docId || this.docId.equals(listUsersOnPaperDocArgs.docId)) && this.limit == listUsersOnPaperDocArgs.limit && ((userOnPaperDocFilter = this.filterBy) == (userOnPaperDocFilter2 = listUsersOnPaperDocArgs.filterBy) || userOnPaperDocFilter.equals(userOnPaperDocFilter2))) {
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

    static class Serializer extends StructSerializer<ListUsersOnPaperDocArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListUsersOnPaperDocArgs listUsersOnPaperDocArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(listUsersOnPaperDocArgs.docId, jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.int32().serialize(Integer.valueOf(listUsersOnPaperDocArgs.limit), jsonGenerator);
            jsonGenerator.writeFieldName("filter_by");
            UserOnPaperDocFilter.Serializer.INSTANCE.serialize(listUsersOnPaperDocArgs.filterBy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListUsersOnPaperDocArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Integer numDeserialize = 1000;
                UserOnPaperDocFilter userOnPaperDocFilterDeserialize = UserOnPaperDocFilter.SHARED;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        numDeserialize = StoneSerializers.int32().deserialize(jsonParser);
                    } else if ("filter_by".equals(currentName)) {
                        userOnPaperDocFilterDeserialize = UserOnPaperDocFilter.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                ListUsersOnPaperDocArgs listUsersOnPaperDocArgs = new ListUsersOnPaperDocArgs(strDeserialize, numDeserialize.intValue(), userOnPaperDocFilterDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listUsersOnPaperDocArgs, listUsersOnPaperDocArgs.toStringMultiline());
                return listUsersOnPaperDocArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

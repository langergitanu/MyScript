package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.ListPaperDocsFilterBy;
import com.dropbox.core.p013v2.paper.ListPaperDocsSortBy;
import com.dropbox.core.p013v2.paper.ListPaperDocsSortOrder;
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
class ListPaperDocsArgs {

    @Nonnull
    protected final ListPaperDocsFilterBy filterBy;
    protected final int limit;

    @Nonnull
    protected final ListPaperDocsSortBy sortBy;

    @Nonnull
    protected final ListPaperDocsSortOrder sortOrder;

    public ListPaperDocsArgs(@Nonnull ListPaperDocsFilterBy listPaperDocsFilterBy, @Nonnull ListPaperDocsSortBy listPaperDocsSortBy, @Nonnull ListPaperDocsSortOrder listPaperDocsSortOrder, int i) {
        if (listPaperDocsFilterBy == null) {
            throw new IllegalArgumentException("Required value for 'filterBy' is null");
        }
        this.filterBy = listPaperDocsFilterBy;
        if (listPaperDocsSortBy == null) {
            throw new IllegalArgumentException("Required value for 'sortBy' is null");
        }
        this.sortBy = listPaperDocsSortBy;
        if (listPaperDocsSortOrder == null) {
            throw new IllegalArgumentException("Required value for 'sortOrder' is null");
        }
        this.sortOrder = listPaperDocsSortOrder;
        if (i < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (i > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        this.limit = i;
    }

    public ListPaperDocsArgs() {
        this(ListPaperDocsFilterBy.DOCS_ACCESSED, ListPaperDocsSortBy.ACCESSED, ListPaperDocsSortOrder.ASCENDING, 1000);
    }

    @Nonnull
    public ListPaperDocsFilterBy getFilterBy() {
        return this.filterBy;
    }

    @Nonnull
    public ListPaperDocsSortBy getSortBy() {
        return this.sortBy;
    }

    @Nonnull
    public ListPaperDocsSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public int getLimit() {
        return this.limit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected ListPaperDocsFilterBy filterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
        protected ListPaperDocsSortBy sortBy = ListPaperDocsSortBy.ACCESSED;
        protected ListPaperDocsSortOrder sortOrder = ListPaperDocsSortOrder.ASCENDING;
        protected int limit = 1000;

        protected Builder() {
        }

        public Builder withFilterBy(ListPaperDocsFilterBy listPaperDocsFilterBy) {
            if (listPaperDocsFilterBy != null) {
                this.filterBy = listPaperDocsFilterBy;
                return this;
            }
            this.filterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
            return this;
        }

        public Builder withSortBy(ListPaperDocsSortBy listPaperDocsSortBy) {
            if (listPaperDocsSortBy != null) {
                this.sortBy = listPaperDocsSortBy;
                return this;
            }
            this.sortBy = ListPaperDocsSortBy.ACCESSED;
            return this;
        }

        public Builder withSortOrder(ListPaperDocsSortOrder listPaperDocsSortOrder) {
            if (listPaperDocsSortOrder != null) {
                this.sortOrder = listPaperDocsSortOrder;
                return this;
            }
            this.sortOrder = ListPaperDocsSortOrder.ASCENDING;
            return this;
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

        public ListPaperDocsArgs build() {
            return new ListPaperDocsArgs(this.filterBy, this.sortBy, this.sortOrder, this.limit);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.filterBy, this.sortBy, this.sortOrder, Integer.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        ListPaperDocsArgs listPaperDocsArgs;
        ListPaperDocsFilterBy listPaperDocsFilterBy;
        ListPaperDocsFilterBy listPaperDocsFilterBy2;
        ListPaperDocsSortBy listPaperDocsSortBy;
        ListPaperDocsSortBy listPaperDocsSortBy2;
        ListPaperDocsSortOrder listPaperDocsSortOrder;
        ListPaperDocsSortOrder listPaperDocsSortOrder2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((listPaperDocsFilterBy = this.filterBy) == (listPaperDocsFilterBy2 = (listPaperDocsArgs = (ListPaperDocsArgs) obj).filterBy) || listPaperDocsFilterBy.equals(listPaperDocsFilterBy2)) && (((listPaperDocsSortBy = this.sortBy) == (listPaperDocsSortBy2 = listPaperDocsArgs.sortBy) || listPaperDocsSortBy.equals(listPaperDocsSortBy2)) && (((listPaperDocsSortOrder = this.sortOrder) == (listPaperDocsSortOrder2 = listPaperDocsArgs.sortOrder) || listPaperDocsSortOrder.equals(listPaperDocsSortOrder2)) && this.limit == listPaperDocsArgs.limit));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListPaperDocsArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListPaperDocsArgs listPaperDocsArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("filter_by");
            ListPaperDocsFilterBy.Serializer.INSTANCE.serialize(listPaperDocsArgs.filterBy, jsonGenerator);
            jsonGenerator.writeFieldName("sort_by");
            ListPaperDocsSortBy.Serializer.INSTANCE.serialize(listPaperDocsArgs.sortBy, jsonGenerator);
            jsonGenerator.writeFieldName("sort_order");
            ListPaperDocsSortOrder.Serializer.INSTANCE.serialize(listPaperDocsArgs.sortOrder, jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.int32().serialize(Integer.valueOf(listPaperDocsArgs.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListPaperDocsArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ListPaperDocsFilterBy listPaperDocsFilterByDeserialize = ListPaperDocsFilterBy.DOCS_ACCESSED;
                ListPaperDocsSortBy listPaperDocsSortByDeserialize = ListPaperDocsSortBy.ACCESSED;
                ListPaperDocsSortOrder listPaperDocsSortOrderDeserialize = ListPaperDocsSortOrder.ASCENDING;
                Integer numDeserialize = 1000;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("filter_by".equals(currentName)) {
                        listPaperDocsFilterByDeserialize = ListPaperDocsFilterBy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("sort_by".equals(currentName)) {
                        listPaperDocsSortByDeserialize = ListPaperDocsSortBy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("sort_order".equals(currentName)) {
                        listPaperDocsSortOrderDeserialize = ListPaperDocsSortOrder.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        numDeserialize = StoneSerializers.int32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ListPaperDocsArgs listPaperDocsArgs = new ListPaperDocsArgs(listPaperDocsFilterByDeserialize, listPaperDocsSortByDeserialize, listPaperDocsSortOrderDeserialize, numDeserialize.intValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listPaperDocsArgs, listPaperDocsArgs.toStringMultiline());
                return listPaperDocsArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

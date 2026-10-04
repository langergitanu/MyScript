package com.dropbox.core.p013v2.team;

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
public class SharingAllowlistListResponse {

    @Nonnull
    protected final String cursor;

    @Nonnull
    protected final List<String> domains;

    @Nonnull
    protected final List<String> emails;
    protected final boolean hasMore;

    public SharingAllowlistListResponse(@Nonnull List<String> list, @Nonnull List<String> list2, @Nonnull String str, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'domains' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'domains' is null");
            }
        }
        this.domains = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'emails' is null");
        }
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'emails' is null");
            }
        }
        this.emails = list2;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = str;
        this.hasMore = z;
    }

    public SharingAllowlistListResponse(@Nonnull List<String> list, @Nonnull List<String> list2) {
        this(list, list2, "", false);
    }

    @Nonnull
    public List<String> getDomains() {
        return this.domains;
    }

    @Nonnull
    public List<String> getEmails() {
        return this.emails;
    }

    @Nonnull
    public String getCursor() {
        return this.cursor;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public static Builder newBuilder(List<String> list, List<String> list2) {
        return new Builder(list, list2);
    }

    public static class Builder {
        protected String cursor;
        protected final List<String> domains;
        protected final List<String> emails;
        protected boolean hasMore;

        protected Builder(List<String> list, List<String> list2) {
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'domains' is null");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'domains' is null");
                }
            }
            this.domains = list;
            if (list2 == null) {
                throw new IllegalArgumentException("Required value for 'emails' is null");
            }
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
            }
            this.emails = list2;
            this.cursor = "";
            this.hasMore = false;
        }

        public Builder withCursor(String str) {
            if (str != null) {
                this.cursor = str;
                return this;
            }
            this.cursor = "";
            return this;
        }

        public Builder withHasMore(Boolean bool) {
            if (bool != null) {
                this.hasMore = bool.booleanValue();
                return this;
            }
            this.hasMore = false;
            return this;
        }

        public SharingAllowlistListResponse build() {
            return new SharingAllowlistListResponse(this.domains, this.emails, this.cursor, this.hasMore);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domains, this.emails, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        SharingAllowlistListResponse sharingAllowlistListResponse;
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.domains) == (list2 = (sharingAllowlistListResponse = (SharingAllowlistListResponse) obj).domains) || list.equals(list2)) && (((list3 = this.emails) == (list4 = sharingAllowlistListResponse.emails) || list3.equals(list4)) && (((str = this.cursor) == (str2 = sharingAllowlistListResponse.cursor) || str.equals(str2)) && this.hasMore == sharingAllowlistListResponse.hasMore));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingAllowlistListResponse> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingAllowlistListResponse sharingAllowlistListResponse, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("domains");
            StoneSerializers.list(StoneSerializers.string()).serialize(sharingAllowlistListResponse.domains, jsonGenerator);
            jsonGenerator.writeFieldName("emails");
            StoneSerializers.list(StoneSerializers.string()).serialize(sharingAllowlistListResponse.emails, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            StoneSerializers.string().serialize(sharingAllowlistListResponse.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(sharingAllowlistListResponse.hasMore), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingAllowlistListResponse deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = "";
                Boolean boolDeserialize = false;
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("domains".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("emails".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"domains\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"emails\" missing.");
                }
                SharingAllowlistListResponse sharingAllowlistListResponse = new SharingAllowlistListResponse(list, list2, strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingAllowlistListResponse, sharingAllowlistListResponse.toStringMultiline());
                return sharingAllowlistListResponse;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

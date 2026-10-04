package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberProfile;
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

/* JADX INFO: loaded from: classes5.dex */
public class ExcludedUsersListResult {

    @Nullable
    protected final String cursor;
    protected final boolean hasMore;

    @Nonnull
    protected final List<MemberProfile> users;

    public ExcludedUsersListResult(@Nonnull List<MemberProfile> list, boolean z, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        Iterator<MemberProfile> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = list;
        this.cursor = str;
        this.hasMore = z;
    }

    public ExcludedUsersListResult(@Nonnull List<MemberProfile> list, boolean z) {
        this(list, z, null);
    }

    @Nonnull
    public List<MemberProfile> getUsers() {
        return this.users;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.users, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        ExcludedUsersListResult excludedUsersListResult;
        List<MemberProfile> list;
        List<MemberProfile> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.users) == (list2 = (excludedUsersListResult = (ExcludedUsersListResult) obj).users) || list.equals(list2)) && this.hasMore == excludedUsersListResult.hasMore && ((str = this.cursor) == (str2 = excludedUsersListResult.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExcludedUsersListResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExcludedUsersListResult excludedUsersListResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("users");
            StoneSerializers.list(MemberProfile.Serializer.INSTANCE).serialize(excludedUsersListResult.users, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(excludedUsersListResult.hasMore), jsonGenerator);
            if (excludedUsersListResult.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(excludedUsersListResult.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExcludedUsersListResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("users".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberProfile.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"users\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ExcludedUsersListResult excludedUsersListResult = new ExcludedUsersListResult(list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(excludedUsersListResult, excludedUsersListResult.toStringMultiline());
                return excludedUsersListResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

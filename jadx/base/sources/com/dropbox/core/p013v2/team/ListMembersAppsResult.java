package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberLinkedApps;
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
public class ListMembersAppsResult {

    @Nonnull
    protected final List<MemberLinkedApps> apps;

    @Nullable
    protected final String cursor;
    protected final boolean hasMore;

    public ListMembersAppsResult(@Nonnull List<MemberLinkedApps> list, boolean z, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'apps' is null");
        }
        Iterator<MemberLinkedApps> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'apps' is null");
            }
        }
        this.apps = list;
        this.hasMore = z;
        this.cursor = str;
    }

    public ListMembersAppsResult(@Nonnull List<MemberLinkedApps> list, boolean z) {
        this(list, z, null);
    }

    @Nonnull
    public List<MemberLinkedApps> getApps() {
        return this.apps;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.apps, Boolean.valueOf(this.hasMore), this.cursor});
    }

    public boolean equals(Object obj) {
        ListMembersAppsResult listMembersAppsResult;
        List<MemberLinkedApps> list;
        List<MemberLinkedApps> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.apps) == (list2 = (listMembersAppsResult = (ListMembersAppsResult) obj).apps) || list.equals(list2)) && this.hasMore == listMembersAppsResult.hasMore && ((str = this.cursor) == (str2 = listMembersAppsResult.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListMembersAppsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListMembersAppsResult listMembersAppsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("apps");
            StoneSerializers.list(MemberLinkedApps.Serializer.INSTANCE).serialize(listMembersAppsResult.apps, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listMembersAppsResult.hasMore), jsonGenerator);
            if (listMembersAppsResult.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listMembersAppsResult.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListMembersAppsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("apps".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberLinkedApps.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"apps\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListMembersAppsResult listMembersAppsResult = new ListMembersAppsResult(list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listMembersAppsResult, listMembersAppsResult.toStringMultiline());
                return listMembersAppsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

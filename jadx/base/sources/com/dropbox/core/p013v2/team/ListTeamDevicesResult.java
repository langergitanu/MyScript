package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberDevices;
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
public class ListTeamDevicesResult {

    @Nullable
    protected final String cursor;

    @Nonnull
    protected final List<MemberDevices> devices;
    protected final boolean hasMore;

    public ListTeamDevicesResult(@Nonnull List<MemberDevices> list, boolean z, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'devices' is null");
        }
        Iterator<MemberDevices> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'devices' is null");
            }
        }
        this.devices = list;
        this.hasMore = z;
        this.cursor = str;
    }

    public ListTeamDevicesResult(@Nonnull List<MemberDevices> list, boolean z) {
        this(list, z, null);
    }

    @Nonnull
    public List<MemberDevices> getDevices() {
        return this.devices;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.devices, Boolean.valueOf(this.hasMore), this.cursor});
    }

    public boolean equals(Object obj) {
        ListTeamDevicesResult listTeamDevicesResult;
        List<MemberDevices> list;
        List<MemberDevices> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.devices) == (list2 = (listTeamDevicesResult = (ListTeamDevicesResult) obj).devices) || list.equals(list2)) && this.hasMore == listTeamDevicesResult.hasMore && ((str = this.cursor) == (str2 = listTeamDevicesResult.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListTeamDevicesResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListTeamDevicesResult listTeamDevicesResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("devices");
            StoneSerializers.list(MemberDevices.Serializer.INSTANCE).serialize(listTeamDevicesResult.devices, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listTeamDevicesResult.hasMore), jsonGenerator);
            if (listTeamDevicesResult.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listTeamDevicesResult.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListTeamDevicesResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("devices".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberDevices.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"devices\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListTeamDevicesResult listTeamDevicesResult = new ListTeamDevicesResult(list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listTeamDevicesResult, listTeamDevicesResult.toStringMultiline());
                return listTeamDevicesResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ListFoldersResult {

    @Nullable
    protected final String cursor;

    @Nonnull
    protected final List<SharedFolderMetadata> entries;

    public ListFoldersResult(@Nonnull List<SharedFolderMetadata> list, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        Iterator<SharedFolderMetadata> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = list;
        this.cursor = str;
    }

    public ListFoldersResult(@Nonnull List<SharedFolderMetadata> list) {
        this(list, null);
    }

    @Nonnull
    public List<SharedFolderMetadata> getEntries() {
        return this.entries;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.entries, this.cursor});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ListFoldersResult listFoldersResult = (ListFoldersResult) obj;
        List<SharedFolderMetadata> list = this.entries;
        List<SharedFolderMetadata> list2 = listFoldersResult.entries;
        return (list == list2 || list.equals(list2)) && ((str = this.cursor) == (str2 = listFoldersResult.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFoldersResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFoldersResult listFoldersResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            StoneSerializers.list(SharedFolderMetadata.Serializer.INSTANCE).serialize(listFoldersResult.entries, jsonGenerator);
            if (listFoldersResult.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listFoldersResult.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFoldersResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (RemoteConfigConstants.ResponseFieldKey.ENTRIES.equals(currentName)) {
                        list = (List) StoneSerializers.list(SharedFolderMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"entries\" missing.");
                }
                ListFoldersResult listFoldersResult = new ListFoldersResult(list, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFoldersResult, listFoldersResult.toStringMultiline());
                return listFoldersResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

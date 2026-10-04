package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FileAction;
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
class GetFileMetadataBatchArg {

    @Nullable
    protected final List<FileAction> actions;

    @Nonnull
    protected final List<String> files;

    public GetFileMetadataBatchArg(@Nonnull List<String> list, @Nullable List<FileAction> list2) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'files' is null");
        }
        if (list.size() > 100) {
            throw new IllegalArgumentException("List 'files' has more than 100 items");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'files' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'files' is shorter than 1");
            }
            if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
                throw new IllegalArgumentException("Stringan item in list 'files' does not match pattern");
            }
        }
        this.files = list;
        if (list2 != null) {
            Iterator<FileAction> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = list2;
    }

    public GetFileMetadataBatchArg(@Nonnull List<String> list) {
        this(list, null);
    }

    @Nonnull
    public List<String> getFiles() {
        return this.files;
    }

    @Nullable
    public List<FileAction> getActions() {
        return this.actions;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.files, this.actions});
    }

    public boolean equals(Object obj) {
        List<FileAction> list;
        List<FileAction> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetFileMetadataBatchArg getFileMetadataBatchArg = (GetFileMetadataBatchArg) obj;
        List<String> list3 = this.files;
        List<String> list4 = getFileMetadataBatchArg.files;
        return (list3 == list4 || list3.equals(list4)) && ((list = this.actions) == (list2 = getFileMetadataBatchArg.actions) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetFileMetadataBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetFileMetadataBatchArg getFileMetadataBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("files");
            StoneSerializers.list(StoneSerializers.string()).serialize(getFileMetadataBatchArg.files, jsonGenerator);
            if (getFileMetadataBatchArg.actions != null) {
                jsonGenerator.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).serialize(getFileMetadataBatchArg.actions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetFileMetadataBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("files".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("actions".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"files\" missing.");
                }
                GetFileMetadataBatchArg getFileMetadataBatchArg = new GetFileMetadataBatchArg(list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getFileMetadataBatchArg, getFileMetadataBatchArg.toStringMultiline());
                return getFileMetadataBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

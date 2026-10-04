package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.p013v2.filerequests.FileRequest;
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

/* JADX INFO: loaded from: classes4.dex */
public class DeleteAllClosedFileRequestsResult {

    @Nonnull
    protected final List<FileRequest> fileRequests;

    public DeleteAllClosedFileRequestsResult(@Nonnull List<FileRequest> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'fileRequests' is null");
        }
        Iterator<FileRequest> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'fileRequests' is null");
            }
        }
        this.fileRequests = list;
    }

    @Nonnull
    public List<FileRequest> getFileRequests() {
        return this.fileRequests;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileRequests});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<FileRequest> list = this.fileRequests;
        List<FileRequest> list2 = ((DeleteAllClosedFileRequestsResult) obj).fileRequests;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeleteAllClosedFileRequestsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeleteAllClosedFileRequestsResult deleteAllClosedFileRequestsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file_requests");
            StoneSerializers.list(FileRequest.Serializer.INSTANCE).serialize(deleteAllClosedFileRequestsResult.fileRequests, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeleteAllClosedFileRequestsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file_requests".equals(currentName)) {
                        list = (List) StoneSerializers.list(FileRequest.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file_requests\" missing.");
                }
                DeleteAllClosedFileRequestsResult deleteAllClosedFileRequestsResult = new DeleteAllClosedFileRequestsResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deleteAllClosedFileRequestsResult, deleteAllClosedFileRequestsResult.toStringMultiline());
                return deleteAllClosedFileRequestsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}

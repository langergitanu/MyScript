package com.dropbox.core;

import com.dropbox.core.stone.StoneSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class ApiErrorResponse<T> {
    private final T error;
    private LocalizedText userMessage;

    public ApiErrorResponse(T t, LocalizedText localizedText) {
        if (t == null) {
            throw new NullPointerException("error");
        }
        this.error = t;
        this.userMessage = localizedText;
    }

    public T getError() {
        return this.error;
    }

    public LocalizedText getUserMessage() {
        return this.userMessage;
    }

    static final class Serializer<T> extends StoneSerializer<ApiErrorResponse<T>> {
        private StoneSerializer<T> errSerializer;

        public Serializer(StoneSerializer<T> stoneSerializer) {
            this.errSerializer = stoneSerializer;
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ApiErrorResponse<T> apiErrorResponse, JsonGenerator jsonGenerator) throws IOException {
            throw new UnsupportedOperationException("Error wrapper serialization not supported.");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ApiErrorResponse<T> deserialize(JsonParser jsonParser) throws IOException {
            expectStartObject(jsonParser);
            T tDeserialize = null;
            LocalizedText localizedTextDeserialize = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                if ("error".equals(currentName)) {
                    tDeserialize = this.errSerializer.deserialize(jsonParser);
                } else if ("user_message".equals(currentName)) {
                    localizedTextDeserialize = LocalizedText.STONE_SERIALIZER.deserialize(jsonParser);
                } else {
                    skipValue(jsonParser);
                }
            }
            if (tDeserialize == null) {
                throw new JsonParseException(jsonParser, "Required field \"error\" missing.");
            }
            ApiErrorResponse<T> apiErrorResponse = new ApiErrorResponse<>(tDeserialize, localizedTextDeserialize);
            expectEndObject(jsonParser);
            return apiErrorResponse;
        }
    }
}

package com.dropbox.core.stone;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StoneSerializer<T> {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public abstract T deserialize(JsonParser jsonParser) throws IOException;

    public abstract void serialize(T t, JsonGenerator jsonGenerator) throws IOException;

    public String serialize(T t) {
        return serialize((Object) t, false);
    }

    public String serialize(T t, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            serialize(t, byteArrayOutputStream, z);
            return new String(byteArrayOutputStream.toByteArray(), UTF8);
        } catch (JsonGenerationException e) {
            throw new IllegalStateException("Impossible JSON exception", e);
        } catch (IOException e2) {
            throw new IllegalStateException("Impossible I/O exception", e2);
        }
    }

    public void serialize(T t, OutputStream outputStream) throws IOException {
        serialize(t, outputStream, false);
    }

    public void serialize(T t, OutputStream outputStream, boolean z) throws IOException {
        JsonGenerator jsonGeneratorCreateGenerator = Util.JSON.createGenerator(outputStream);
        if (z) {
            jsonGeneratorCreateGenerator.useDefaultPrettyPrinter();
        }
        try {
            serialize(t, jsonGeneratorCreateGenerator);
            jsonGeneratorCreateGenerator.flush();
        } catch (JsonGenerationException e) {
            throw new IllegalStateException("Impossible JSON generation exception", e);
        }
    }

    public T deserialize(String str) throws JsonParseException {
        try {
            JsonParser jsonParserCreateParser = Util.JSON.createParser(str);
            jsonParserCreateParser.nextToken();
            return deserialize(jsonParserCreateParser);
        } catch (JsonParseException e) {
            throw e;
        } catch (IOException e2) {
            throw new IllegalStateException("Impossible I/O exception", e2);
        }
    }

    public T deserialize(InputStream inputStream) throws IOException {
        JsonParser jsonParserCreateParser = Util.JSON.createParser(inputStream);
        jsonParserCreateParser.nextToken();
        return deserialize(jsonParserCreateParser);
    }

    protected static String getStringValue(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonParseException(jsonParser, "expected string value, but was " + jsonParser.getCurrentToken());
        }
        return jsonParser.getText();
    }

    protected static void expectField(String str, JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.FIELD_NAME) {
            throw new JsonParseException(jsonParser, "expected field name, but was: " + jsonParser.getCurrentToken());
        }
        if (!str.equals(jsonParser.getCurrentName())) {
            throw new JsonParseException(jsonParser, "expected field '" + str + "', but was: '" + jsonParser.getCurrentName() + "'");
        }
        jsonParser.nextToken();
    }

    protected static void expectStartObject(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new JsonParseException(jsonParser, "expected object value.");
        }
        jsonParser.nextToken();
    }

    protected static void expectEndObject(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
            throw new JsonParseException(jsonParser, "expected end of object value.");
        }
        jsonParser.nextToken();
    }

    protected static void expectStartArray(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.START_ARRAY) {
            throw new JsonParseException(jsonParser, "expected array value.");
        }
        jsonParser.nextToken();
    }

    protected static void expectEndArray(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
            throw new JsonParseException(jsonParser, "expected end of array value.");
        }
        jsonParser.nextToken();
    }

    protected static void skipValue(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken().isStructStart()) {
            jsonParser.skipChildren();
            jsonParser.nextToken();
        } else {
            if (jsonParser.getCurrentToken().isScalarValue()) {
                jsonParser.nextToken();
                return;
            }
            throw new JsonParseException(jsonParser, "Can't skip JSON value token: " + jsonParser.getCurrentToken());
        }
    }

    protected static void skipFields(JsonParser jsonParser) throws IOException {
        while (jsonParser.getCurrentToken() != null && !jsonParser.getCurrentToken().isStructEnd()) {
            if (jsonParser.getCurrentToken().isStructStart()) {
                jsonParser.skipChildren();
                jsonParser.nextToken();
            } else if (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                jsonParser.nextToken();
            } else if (jsonParser.getCurrentToken().isScalarValue()) {
                jsonParser.nextToken();
            } else {
                throw new JsonParseException(jsonParser, "Can't skip token: " + jsonParser.getCurrentToken());
            }
        }
    }
}

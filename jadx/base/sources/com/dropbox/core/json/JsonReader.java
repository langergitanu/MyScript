package com.dropbox.core.json;

import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonReader<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final JsonReader<Long> UnsignedLongReader = new JsonReader<Long>() { // from class: com.dropbox.core.json.JsonReader.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Long read(JsonParser jsonParser) throws JsonReadException, IOException {
            return Long.valueOf(readUnsignedLong(jsonParser));
        }
    };
    public static final JsonReader<Long> Int64Reader = new JsonReader<Long>() { // from class: com.dropbox.core.json.JsonReader.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Long read(JsonParser jsonParser) throws JsonReadException, IOException {
            long longValue = jsonParser.getLongValue();
            jsonParser.nextToken();
            return Long.valueOf(longValue);
        }
    };
    public static final JsonReader<Integer> Int32Reader = new JsonReader<Integer>() { // from class: com.dropbox.core.json.JsonReader.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Integer read(JsonParser jsonParser) throws JsonReadException, IOException {
            int intValue = jsonParser.getIntValue();
            jsonParser.nextToken();
            return Integer.valueOf(intValue);
        }
    };
    public static final JsonReader<Long> UInt64Reader = new JsonReader<Long>() { // from class: com.dropbox.core.json.JsonReader.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Long read(JsonParser jsonParser) throws JsonReadException, IOException {
            return Long.valueOf(readUnsignedLong(jsonParser));
        }
    };
    public static final JsonReader<Long> UInt32Reader = new JsonReader<Long>() { // from class: com.dropbox.core.json.JsonReader.5
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Long read(JsonParser jsonParser) throws JsonReadException, IOException {
            long unsignedLong = readUnsignedLong(jsonParser);
            if (unsignedLong >= 4294967296L) {
                throw new JsonReadException("expecting a 32-bit unsigned integer, got: " + unsignedLong, jsonParser.getTokenLocation());
            }
            return Long.valueOf(unsignedLong);
        }
    };
    public static final JsonReader<Double> Float64Reader = new JsonReader<Double>() { // from class: com.dropbox.core.json.JsonReader.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Double read(JsonParser jsonParser) throws JsonReadException, IOException {
            double doubleValue = jsonParser.getDoubleValue();
            jsonParser.nextToken();
            return Double.valueOf(doubleValue);
        }
    };
    public static final JsonReader<Float> Float32Reader = new JsonReader<Float>() { // from class: com.dropbox.core.json.JsonReader.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Float read(JsonParser jsonParser) throws JsonReadException, IOException {
            float floatValue = jsonParser.getFloatValue();
            jsonParser.nextToken();
            return Float.valueOf(floatValue);
        }
    };
    public static final JsonReader<String> StringReader = new JsonReader<String>() { // from class: com.dropbox.core.json.JsonReader.8
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                String text = jsonParser.getText();
                jsonParser.nextToken();
                return text;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };
    public static final JsonReader<byte[]> BinaryReader = new JsonReader<byte[]>() { // from class: com.dropbox.core.json.JsonReader.9
        @Override // com.dropbox.core.json.JsonReader
        public byte[] read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                byte[] binaryValue = jsonParser.getBinaryValue();
                jsonParser.nextToken();
                return binaryValue;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };
    public static final JsonReader<Boolean> BooleanReader = new JsonReader<Boolean>() { // from class: com.dropbox.core.json.JsonReader.10
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public Boolean read(JsonParser jsonParser) throws JsonReadException, IOException {
            return Boolean.valueOf(readBoolean(jsonParser));
        }
    };
    public static final JsonReader<Object> VoidReader = new JsonReader<Object>() { // from class: com.dropbox.core.json.JsonReader.11
        @Override // com.dropbox.core.json.JsonReader
        public Object read(JsonParser jsonParser) throws JsonReadException, IOException {
            skipValue(jsonParser);
            return null;
        }
    };
    static final JsonFactory jsonFactory = new JsonFactory();

    public abstract T read(JsonParser jsonParser) throws JsonReadException, IOException;

    public T readFields(JsonParser jsonParser) throws JsonReadException, IOException {
        return null;
    }

    public T readFromTags(String[] strArr, JsonParser jsonParser) throws JsonReadException, IOException {
        return null;
    }

    public void validate(T t) {
    }

    public final T readField(JsonParser jsonParser, String str, Object obj) throws JsonReadException, IOException {
        if (obj != null) {
            throw new JsonReadException("duplicate field \"" + str + "\"", jsonParser.getTokenLocation());
        }
        return read(jsonParser);
    }

    public final T readOptional(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
            jsonParser.nextToken();
            return null;
        }
        return read(jsonParser);
    }

    public static String[] readTags(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() != JsonToken.FIELD_NAME || !".tag".equals(jsonParser.getCurrentName())) {
            return null;
        }
        jsonParser.nextToken();
        if (jsonParser.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonReadException("expected a string value for .tag field", jsonParser.getTokenLocation());
        }
        String text = jsonParser.getText();
        jsonParser.nextToken();
        return text.split("\\.");
    }

    public static JsonToken nextToken(JsonParser jsonParser) throws JsonReadException, IOException {
        try {
            return jsonParser.nextToken();
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public static JsonLocation expectObjectStart(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new JsonReadException("expecting the start of an object (\"{\")", jsonParser.getTokenLocation());
        }
        JsonLocation tokenLocation = jsonParser.getTokenLocation();
        nextToken(jsonParser);
        return tokenLocation;
    }

    public static void expectObjectEnd(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
            throw new JsonReadException("expecting the end of an object (\"}\")", jsonParser.getTokenLocation());
        }
        nextToken(jsonParser);
    }

    public static JsonLocation expectArrayStart(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() != JsonToken.START_ARRAY) {
            throw new JsonReadException("expecting the start of an array (\"[\")", jsonParser.getTokenLocation());
        }
        JsonLocation tokenLocation = jsonParser.getTokenLocation();
        nextToken(jsonParser);
        return tokenLocation;
    }

    public static JsonLocation expectArrayEnd(JsonParser jsonParser) throws JsonReadException, IOException {
        if (jsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
            throw new JsonReadException("expecting the end of an array (\"[\")", jsonParser.getTokenLocation());
        }
        JsonLocation tokenLocation = jsonParser.getTokenLocation();
        nextToken(jsonParser);
        return tokenLocation;
    }

    public static boolean isArrayEnd(JsonParser jsonParser) {
        return jsonParser.getCurrentToken() == JsonToken.END_ARRAY;
    }

    public static boolean isArrayStart(JsonParser jsonParser) {
        return jsonParser.getCurrentToken() == JsonToken.START_ARRAY;
    }

    public static void skipValue(JsonParser jsonParser) throws JsonReadException, IOException {
        try {
            jsonParser.skipChildren();
            jsonParser.nextToken();
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public static long readUnsignedLong(JsonParser jsonParser) throws JsonReadException, IOException {
        try {
            long longValue = jsonParser.getLongValue();
            if (longValue < 0) {
                throw new JsonReadException("expecting a non-negative number, got: " + longValue, jsonParser.getTokenLocation());
            }
            jsonParser.nextToken();
            return longValue;
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public static long readUnsignedLongField(JsonParser jsonParser, String str, long j) throws JsonReadException, IOException {
        if (j >= 0) {
            throw new JsonReadException("duplicate field \"" + str + "\"", jsonParser.getCurrentLocation());
        }
        return readUnsignedLong(jsonParser);
    }

    public static boolean readBoolean(JsonParser jsonParser) throws JsonReadException, IOException {
        try {
            boolean booleanValue = jsonParser.getBooleanValue();
            jsonParser.nextToken();
            return booleanValue;
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public static double readDouble(JsonParser jsonParser) throws JsonReadException, IOException {
        try {
            double doubleValue = jsonParser.getDoubleValue();
            jsonParser.nextToken();
            return doubleValue;
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public static <T> T readEnum(JsonParser jsonParser, HashMap<String, T> map, T t) throws JsonReadException, IOException {
        String text;
        if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
            jsonParser.nextToken();
            String[] tags = readTags(jsonParser);
            if (tags != null && jsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
                text = tags[0];
            } else if (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                text = jsonParser.getText();
                jsonParser.nextToken();
                skipValue(jsonParser);
            } else {
                throw new JsonReadException("expecting a field name", jsonParser.getTokenLocation());
            }
            T t2 = map.get(text);
            if (t2 != null) {
                t = t2;
            }
            if (t == null) {
                throw new JsonReadException("Expected one of " + map + ", got: " + text, jsonParser.getTokenLocation());
            }
            expectObjectEnd(jsonParser);
            return t;
        }
        if (jsonParser.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonReadException("Expected a string value", jsonParser.getTokenLocation());
        }
        String text2 = jsonParser.getText();
        T t3 = map.get(text2);
        if (t3 != null) {
            t = t3;
        }
        if (t == null) {
            throw new JsonReadException("Expected one of " + map + ", got: " + text2, jsonParser.getTokenLocation());
        }
        jsonParser.nextToken();
        return t;
    }

    public static final class FieldMapping {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final HashMap<String, Integer> fields;

        private FieldMapping(HashMap<String, Integer> map) {
            this.fields = map;
        }

        public int get(String str) {
            Integer num = this.fields.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public static final class Builder {
            private HashMap<String, Integer> fields = new HashMap<>();

            public void add(String str, int i) {
                HashMap<String, Integer> map = this.fields;
                if (map == null) {
                    throw new IllegalStateException("already called build(); can't call add() anymore");
                }
                int size = map.size();
                if (i != size) {
                    throw new IllegalStateException("expectedIndex = " + i + ", actual = " + size);
                }
                if (this.fields.put(str, Integer.valueOf(size)) != null) {
                    throw new IllegalStateException("duplicate field name: \"" + str + "\"");
                }
            }

            public FieldMapping build() {
                HashMap<String, Integer> map = this.fields;
                if (map == null) {
                    throw new IllegalStateException("already called build(); can't call build() again");
                }
                this.fields = null;
                return new FieldMapping(map);
            }
        }
    }

    public T readFully(InputStream inputStream) throws JsonReadException, IOException {
        try {
            return readFully(jsonFactory.createParser(inputStream));
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        }
    }

    public T readFully(String str) throws JsonReadException {
        try {
            JsonParser jsonParserCreateParser = jsonFactory.createParser(str);
            try {
                return readFully(jsonParserCreateParser);
            } finally {
                jsonParserCreateParser.close();
            }
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        } catch (IOException e2) {
            throw LangUtil.mkAssert("IOException reading from String", e2);
        }
    }

    public T readFully(byte[] bArr) throws JsonReadException {
        try {
            JsonParser jsonParserCreateParser = jsonFactory.createParser(bArr);
            try {
                return readFully(jsonParserCreateParser);
            } finally {
                jsonParserCreateParser.close();
            }
        } catch (JsonParseException e) {
            throw JsonReadException.fromJackson(e);
        } catch (IOException e2) {
            throw LangUtil.mkAssert("IOException reading from byte[]", e2);
        }
    }

    public T readFromFile(String str) throws FileLoadException {
        return readFromFile(new File(str));
    }

    public T readFromFile(File file) throws FileLoadException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return readFully(fileInputStream);
            } finally {
                IOUtil.closeInput(fileInputStream);
            }
        } catch (JsonReadException e) {
            throw new FileLoadException.JsonError(file, e);
        } catch (IOException e2) {
            throw new FileLoadException.IOError(file, e2);
        }
    }

    public static abstract class FileLoadException extends Exception {
        private static final long serialVersionUID = 0;

        protected FileLoadException(String str) {
            super(str);
        }

        public static final class IOError extends FileLoadException {
            private static final long serialVersionUID = 0;
            public final IOException reason;

            public IOError(File file, IOException iOException) {
                super("unable to read file \"" + file.getPath() + "\": " + iOException.getMessage());
                this.reason = iOException;
            }
        }

        public static final class JsonError extends FileLoadException {
            private static final long serialVersionUID = 0;
            public final JsonReadException reason;

            public JsonError(File file, JsonReadException jsonReadException) {
                super(file.getPath() + ": " + jsonReadException.getMessage());
                this.reason = jsonReadException;
            }
        }
    }

    public T readFully(JsonParser jsonParser) throws JsonReadException, IOException {
        jsonParser.nextToken();
        T t = read(jsonParser);
        if (jsonParser.getCurrentToken() != null) {
            throw new AssertionError("The JSON library should ensure there's no tokens after the main value: " + jsonParser.getCurrentToken() + "@" + jsonParser.getCurrentLocation());
        }
        validate(t);
        return t;
    }
}

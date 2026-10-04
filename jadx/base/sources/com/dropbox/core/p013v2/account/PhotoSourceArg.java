package com.dropbox.core.p013v2.account;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoSourceArg {
    public static final PhotoSourceArg OTHER = new PhotoSourceArg().withTag(Tag.OTHER);
    private Tag _tag;
    private String base64DataValue;

    public enum Tag {
        BASE64_DATA,
        OTHER
    }

    private PhotoSourceArg() {
    }

    private PhotoSourceArg withTag(Tag tag) {
        PhotoSourceArg photoSourceArg = new PhotoSourceArg();
        photoSourceArg._tag = tag;
        return photoSourceArg;
    }

    private PhotoSourceArg withTagAndBase64Data(Tag tag, String str) {
        PhotoSourceArg photoSourceArg = new PhotoSourceArg();
        photoSourceArg._tag = tag;
        photoSourceArg.base64DataValue = str;
        return photoSourceArg;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isBase64Data() {
        return this._tag == Tag.BASE64_DATA;
    }

    public static PhotoSourceArg base64Data(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PhotoSourceArg().withTagAndBase64Data(Tag.BASE64_DATA, str);
    }

    public String getBase64DataValue() {
        if (this._tag != Tag.BASE64_DATA) {
            throw new IllegalStateException("Invalid tag: required Tag.BASE64_DATA, but was Tag." + this._tag.name());
        }
        return this.base64DataValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.base64DataValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PhotoSourceArg)) {
            return false;
        }
        PhotoSourceArg photoSourceArg = (PhotoSourceArg) obj;
        if (this._tag != photoSourceArg._tag) {
            return false;
        }
        int i = C41011.$SwitchMap$com$dropbox$core$v2$account$PhotoSourceArg$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.base64DataValue;
        String str2 = photoSourceArg.base64DataValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.account.PhotoSourceArg$1 */
    static /* synthetic */ class C41011 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$account$PhotoSourceArg$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$account$PhotoSourceArg$Tag = iArr;
            try {
                iArr[Tag.BASE64_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$account$PhotoSourceArg$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<PhotoSourceArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PhotoSourceArg photoSourceArg, JsonGenerator jsonGenerator) throws IOException {
            if (C41011.$SwitchMap$com$dropbox$core$v2$account$PhotoSourceArg$Tag[photoSourceArg.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("base64_data", jsonGenerator);
                jsonGenerator.writeFieldName("base64_data");
                StoneSerializers.string().serialize(photoSourceArg.base64DataValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PhotoSourceArg deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PhotoSourceArg photoSourceArgBase64Data;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("base64_data".equals(tag)) {
                expectField("base64_data", jsonParser);
                photoSourceArgBase64Data = PhotoSourceArg.base64Data(StoneSerializers.string().deserialize(jsonParser));
            } else {
                photoSourceArgBase64Data = PhotoSourceArg.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return photoSourceArgBase64Data;
        }
    }
}

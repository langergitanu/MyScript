package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkExpiry {
    private Tag _tag;
    private Date setExpiryValue;
    public static final LinkExpiry REMOVE_EXPIRY = new LinkExpiry().withTag(Tag.REMOVE_EXPIRY);
    public static final LinkExpiry OTHER = new LinkExpiry().withTag(Tag.OTHER);

    public enum Tag {
        REMOVE_EXPIRY,
        SET_EXPIRY,
        OTHER
    }

    private LinkExpiry() {
    }

    private LinkExpiry withTag(Tag tag) {
        LinkExpiry linkExpiry = new LinkExpiry();
        linkExpiry._tag = tag;
        return linkExpiry;
    }

    private LinkExpiry withTagAndSetExpiry(Tag tag, Date date) {
        LinkExpiry linkExpiry = new LinkExpiry();
        linkExpiry._tag = tag;
        linkExpiry.setExpiryValue = date;
        return linkExpiry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isRemoveExpiry() {
        return this._tag == Tag.REMOVE_EXPIRY;
    }

    public boolean isSetExpiry() {
        return this._tag == Tag.SET_EXPIRY;
    }

    public static LinkExpiry setExpiry(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkExpiry().withTagAndSetExpiry(Tag.SET_EXPIRY, date);
    }

    public Date getSetExpiryValue() {
        if (this._tag != Tag.SET_EXPIRY) {
            throw new IllegalStateException("Invalid tag: required Tag.SET_EXPIRY, but was Tag." + this._tag.name());
        }
        return this.setExpiryValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.setExpiryValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LinkExpiry)) {
            return false;
        }
        LinkExpiry linkExpiry = (LinkExpiry) obj;
        if (this._tag != linkExpiry._tag) {
            return false;
        }
        int i = C42711.$SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i == 3;
            }
            Date date = this.setExpiryValue;
            Date date2 = linkExpiry.setExpiryValue;
            if (date != date2 && !date.equals(date2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkExpiry$1 */
    static /* synthetic */ class C42711 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag = iArr;
            try {
                iArr[Tag.REMOVE_EXPIRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag[Tag.SET_EXPIRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<LinkExpiry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkExpiry linkExpiry, JsonGenerator jsonGenerator) throws IOException {
            int i = C42711.$SwitchMap$com$dropbox$core$v2$sharing$LinkExpiry$Tag[linkExpiry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("remove_expiry");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("set_expiry", jsonGenerator);
                jsonGenerator.writeFieldName("set_expiry");
                StoneSerializers.timestamp().serialize(linkExpiry.setExpiryValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkExpiry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkExpiry expiry;
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
            if ("remove_expiry".equals(tag)) {
                expiry = LinkExpiry.REMOVE_EXPIRY;
            } else if ("set_expiry".equals(tag)) {
                expectField("set_expiry", jsonParser);
                expiry = LinkExpiry.setExpiry(StoneSerializers.timestamp().deserialize(jsonParser));
            } else {
                expiry = LinkExpiry.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return expiry;
        }
    }
}

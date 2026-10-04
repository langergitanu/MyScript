package com.dropbox.core.p012v1;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAccountInfo extends Dumpable {

    /* JADX INFO: renamed from: FM */
    private static final JsonReader.FieldMapping f659FM;
    private static final int FM_country = 2;
    private static final int FM_display_name = 1;
    private static final int FM_email = 6;
    private static final int FM_email_verified = 7;
    private static final int FM_name_details = 5;
    private static final int FM_quota_info = 4;
    private static final int FM_referral_link = 3;
    private static final int FM_uid = 0;
    public static final JsonReader<DbxAccountInfo> Reader = new JsonReader<DbxAccountInfo>() { // from class: com.dropbox.core.v1.DbxAccountInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxAccountInfo read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            Boolean field = null;
            long unsignedLongField = -1;
            String field2 = null;
            String field3 = null;
            String field4 = null;
            Quota field5 = null;
            String field6 = null;
            NameDetails field7 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    int i = DbxAccountInfo.f659FM.get(currentName);
                    switch (i) {
                        case -1:
                            JsonReader.skipValue(jsonParser);
                            continue;
                        case 0:
                            unsignedLongField = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField);
                            continue;
                        case 1:
                            field2 = JsonReader.StringReader.readField(jsonParser, currentName, field2);
                            continue;
                        case 2:
                            field3 = JsonReader.StringReader.readField(jsonParser, currentName, field3);
                            continue;
                        case 3:
                            field4 = JsonReader.StringReader.readField(jsonParser, currentName, field4);
                            continue;
                        case 4:
                            field5 = Quota.Reader.readField(jsonParser, currentName, field5);
                            continue;
                        case 5:
                            field7 = NameDetails.Reader.readField(jsonParser, currentName, field7);
                            continue;
                        case 6:
                            field6 = JsonReader.StringReader.readField(jsonParser, currentName, field6);
                            continue;
                        case 7:
                            field = JsonReader.BooleanReader.readField(jsonParser, currentName, field);
                            continue;
                        default:
                            throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
                throw e.addFieldContext(currentName);
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (unsignedLongField < 0) {
                throw new JsonReadException("missing field \"uid\"", jsonLocationExpectObjectStart);
            }
            if (field2 == null) {
                throw new JsonReadException("missing field \"display_name\"", jsonLocationExpectObjectStart);
            }
            if (field3 == null) {
                throw new JsonReadException("missing field \"country\"", jsonLocationExpectObjectStart);
            }
            if (field4 == null) {
                throw new JsonReadException("missing field \"referral_link\"", jsonLocationExpectObjectStart);
            }
            if (field5 == null) {
                throw new JsonReadException("missing field \"quota_info\"", jsonLocationExpectObjectStart);
            }
            if (field6 == null) {
                throw new JsonReadException("missing field \"email\"", jsonLocationExpectObjectStart);
            }
            if (field7 == null) {
                throw new JsonReadException("missing field \"nameDetails\"", jsonLocationExpectObjectStart);
            }
            if (field == null) {
                throw new JsonReadException("missing field \"emailVerified\"", jsonLocationExpectObjectStart);
            }
            return new DbxAccountInfo(unsignedLongField, field2, field3, field4, field5, field6, field7, field.booleanValue());
        }
    };
    public final String country;
    public final String displayName;
    public final String email;
    public final boolean emailVerified;
    public final NameDetails nameDetails;
    public final Quota quota;
    public final String referralLink;
    public final long userId;

    public DbxAccountInfo(long j, String str, String str2, String str3, Quota quota, String str4, NameDetails nameDetails, boolean z) {
        this.userId = j;
        this.displayName = str;
        this.country = str2;
        this.referralLink = str3;
        this.quota = quota;
        this.email = str4;
        this.nameDetails = nameDetails;
        this.emailVerified = z;
    }

    @Override // com.dropbox.core.util.Dumpable
    protected void dumpFields(DumpWriter dumpWriter) {
        dumpWriter.mo519f("userId").m523v(this.userId);
        dumpWriter.mo519f("displayName").m527v(this.displayName);
        dumpWriter.mo519f("country").m527v(this.country);
        dumpWriter.mo519f("referralLink").m527v(this.referralLink);
        dumpWriter.mo519f("quota").m524v(this.quota);
        dumpWriter.mo519f("nameDetails").m524v(this.nameDetails);
        dumpWriter.mo519f("email").m527v(this.email);
        dumpWriter.mo519f("emailVerified").m529v(this.emailVerified);
    }

    public static final class Quota extends Dumpable {

        /* JADX INFO: renamed from: FM */
        private static final JsonReader.FieldMapping f661FM;
        private static final int FM_normal = 1;
        private static final int FM_quota = 0;
        private static final int FM_shared = 2;
        public static final JsonReader<Quota> Reader = new JsonReader<Quota>() { // from class: com.dropbox.core.v1.DbxAccountInfo.Quota.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final Quota read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
                long unsignedLongField = -1;
                long unsignedLongField2 = -1;
                long unsignedLongField3 = -1;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    int i = Quota.f661FM.get(currentName);
                    if (i == -1) {
                        JsonReader.skipValue(jsonParser);
                    } else if (i == 0) {
                        unsignedLongField = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField);
                    } else if (i == 1) {
                        unsignedLongField2 = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField2);
                    } else {
                        if (i == 2) {
                            try {
                                unsignedLongField3 = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField3);
                            } catch (JsonReadException e) {
                                throw e.addFieldContext(currentName);
                            }
                        } else {
                            throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
                        }
                        throw e.addFieldContext(currentName);
                    }
                }
                JsonReader.expectObjectEnd(jsonParser);
                if (unsignedLongField < 0) {
                    throw new JsonReadException("missing field \"quota\"", jsonLocationExpectObjectStart);
                }
                if (unsignedLongField2 < 0) {
                    throw new JsonReadException("missing field \"normal\"", jsonLocationExpectObjectStart);
                }
                if (unsignedLongField3 < 0) {
                    throw new JsonReadException("missing field \"shared\"", jsonLocationExpectObjectStart);
                }
                return new Quota(unsignedLongField, unsignedLongField2, unsignedLongField3);
            }
        };
        public final long normal;
        public final long shared;
        public final long total;

        public Quota(long j, long j2, long j3) {
            this.total = j;
            this.normal = j2;
            this.shared = j3;
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.mo519f("total").m523v(this.total);
            dumpWriter.mo519f("normal").m523v(this.normal);
            dumpWriter.mo519f("shared").m523v(this.shared);
        }

        static {
            JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
            builder.add("quota", 0);
            builder.add("normal", 1);
            builder.add("shared", 2);
            f661FM = builder.build();
        }
    }

    public static final class NameDetails extends Dumpable {

        /* JADX INFO: renamed from: FM */
        private static final JsonReader.FieldMapping f660FM;
        private static final int FM_familiar_name = 0;
        private static final int FM_given_name = 1;
        private static final int FM_surname = 2;
        public static final JsonReader<NameDetails> Reader = new JsonReader<NameDetails>() { // from class: com.dropbox.core.v1.DbxAccountInfo.NameDetails.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final NameDetails read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
                String field = null;
                String field2 = null;
                String field3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    int i = NameDetails.f660FM.get(currentName);
                    if (i == -1) {
                        JsonReader.skipValue(jsonParser);
                    } else if (i == 0) {
                        field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                    } else if (i == 1) {
                        field3 = JsonReader.StringReader.readField(jsonParser, currentName, field3);
                    } else {
                        if (i == 2) {
                            try {
                                field2 = JsonReader.StringReader.readField(jsonParser, currentName, field2);
                            } catch (JsonReadException e) {
                                throw e.addFieldContext(currentName);
                            }
                        } else {
                            throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
                        }
                        throw e.addFieldContext(currentName);
                    }
                }
                JsonReader.expectObjectEnd(jsonParser);
                if (field == null) {
                    throw new JsonReadException("missing field \"familiarName\"", jsonLocationExpectObjectStart);
                }
                if (field2 == null) {
                    throw new JsonReadException("missing field \"surname\"", jsonLocationExpectObjectStart);
                }
                if (field3 == null) {
                    throw new JsonReadException("missing field \"givenName\"", jsonLocationExpectObjectStart);
                }
                return new NameDetails(field, field3, field2);
            }
        };
        public final String familiarName;
        public final String givenName;
        public final String surname;

        public NameDetails(String str, String str2, String str3) {
            this.familiarName = str;
            this.givenName = str2;
            this.surname = str3;
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.mo519f("familiarName").m527v(this.familiarName);
            dumpWriter.mo519f("givenName").m527v(this.givenName);
            dumpWriter.mo519f("surname").m527v(this.surname);
        }

        static {
            JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
            builder.add("familiar_name", 0);
            builder.add("given_name", 1);
            builder.add("surname", 2);
            f660FM = builder.build();
        }
    }

    static {
        JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
        builder.add("uid", 0);
        builder.add(Keys.DISPLAY_NAME, 1);
        builder.add("country", 2);
        builder.add("referral_link", 3);
        builder.add("quota_info", 4);
        builder.add("name_details", 5);
        builder.add("email", 6);
        builder.add("email_verified", 7);
        f659FM = builder.build();
    }
}

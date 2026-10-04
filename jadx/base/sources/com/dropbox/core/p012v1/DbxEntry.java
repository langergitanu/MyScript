package com.dropbox.core.p012v1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbxEntry extends Dumpable implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: FM */
    private static final JsonReader.FieldMapping f665FM;
    private static final int FM_bytes = 1;
    private static final int FM_client_mtime = 9;
    private static final int FM_contents = 11;
    private static final int FM_hash = 10;
    private static final int FM_icon = 7;
    private static final int FM_is_deleted = 4;
    private static final int FM_is_dir = 3;
    private static final int FM_modified = 8;
    private static final int FM_path = 2;
    private static final int FM_photo_info = 12;
    private static final int FM_rev = 5;
    private static final int FM_size = 0;
    private static final int FM_thumb_exists = 6;
    private static final int FM_video_info = 13;
    public static final JsonReader<DbxEntry> Reader = new JsonReader<DbxEntry>() { // from class: com.dropbox.core.v1.DbxEntry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxEntry read(JsonParser jsonParser) throws JsonReadException, IOException {
            return DbxEntry.read(jsonParser, null).entry;
        }
    };
    public static final JsonReader<DbxEntry> ReaderMaybeDeleted = new JsonReader<DbxEntry>() { // from class: com.dropbox.core.v1.DbxEntry.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxEntry read(JsonParser jsonParser) throws JsonReadException, IOException {
            WithChildrenC maybeDeleted = DbxEntry.readMaybeDeleted(jsonParser, null);
            if (maybeDeleted == null) {
                return null;
            }
            return maybeDeleted.entry;
        }
    };
    public static final long serialVersionUID = 0;
    public final String iconName;
    public final boolean mightHaveThumbnail;
    public final String name;
    public final String path;

    public abstract File asFile();

    public abstract Folder asFolder();

    public abstract boolean isFile();

    public abstract boolean isFolder();

    private DbxEntry(String str, String str2, boolean z) {
        this.name = DbxPathV1.getName(str);
        this.path = str;
        this.iconName = str2;
        this.mightHaveThumbnail = z;
    }

    @Override // com.dropbox.core.util.Dumpable
    protected void dumpFields(DumpWriter dumpWriter) {
        dumpWriter.m527v(this.path);
        dumpWriter.mo519f("iconName").m527v(this.iconName);
        dumpWriter.mo519f("mightHaveThumbnail").m529v(this.mightHaveThumbnail);
    }

    protected boolean partialEquals(DbxEntry dbxEntry) {
        return this.name.equals(dbxEntry.name) && this.path.equals(dbxEntry.path) && this.iconName.equals(dbxEntry.iconName) && this.mightHaveThumbnail == dbxEntry.mightHaveThumbnail;
    }

    protected int partialHashCode() {
        return (((((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + this.iconName.hashCode()) * 31) + this.path.hashCode()) * 31) + (this.mightHaveThumbnail ? 1 : 0);
    }

    public static final class Folder extends DbxEntry {
        public static final JsonReader<Folder> Reader = new JsonReader<Folder>() { // from class: com.dropbox.core.v1.DbxEntry.Folder.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final Folder read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation currentLocation = jsonParser.getCurrentLocation();
                DbxEntry dbxEntry = DbxEntry.read(jsonParser, null).entry;
                if (!(dbxEntry instanceof Folder)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", currentLocation);
                }
                return (Folder) dbxEntry;
            }
        };
        public static final long serialVersionUID = 0;

        @Override // com.dropbox.core.p012v1.DbxEntry
        public Folder asFolder() {
            return this;
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public boolean isFile() {
            return false;
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public boolean isFolder() {
            return true;
        }

        public Folder(String str, String str2, boolean z) {
            super(str, str2, z);
        }

        @Override // com.dropbox.core.util.Dumpable
        protected String getTypeName() {
            return "Folder";
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public File asFile() {
            throw new RuntimeException("not a file");
        }

        public boolean equals(Object obj) {
            return obj != null && getClass().equals(obj.getClass()) && equals((Folder) obj);
        }

        public boolean equals(Folder folder) {
            return partialEquals(folder);
        }

        public int hashCode() {
            return partialHashCode();
        }
    }

    public static final class File extends DbxEntry {
        public static final JsonReader<File> Reader = new JsonReader<File>() { // from class: com.dropbox.core.v1.DbxEntry.File.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final File read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation currentLocation = jsonParser.getCurrentLocation();
                DbxEntry dbxEntry = DbxEntry.read(jsonParser, null).entry;
                if (!(dbxEntry instanceof File)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", currentLocation);
                }
                return (File) dbxEntry;
            }
        };
        public static final JsonReader<File> ReaderMaybeDeleted = new JsonReader<File>() { // from class: com.dropbox.core.v1.DbxEntry.File.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final File read(JsonParser jsonParser) throws JsonReadException, IOException {
                JsonLocation currentLocation = jsonParser.getCurrentLocation();
                WithChildrenC withChildrenC_read = DbxEntry._read(jsonParser, null, true);
                if (withChildrenC_read == null) {
                    return null;
                }
                DbxEntry dbxEntry = withChildrenC_read.entry;
                if (!(dbxEntry instanceof File)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", currentLocation);
                }
                return (File) dbxEntry;
            }
        };
        public static final long serialVersionUID = 0;
        public final Date clientMtime;
        public final String humanSize;
        public final Date lastModified;
        public final long numBytes;
        public final PhotoInfo photoInfo;
        public final String rev;
        public final VideoInfo videoInfo;

        @Override // com.dropbox.core.p012v1.DbxEntry
        public File asFile() {
            return this;
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public boolean isFile() {
            return true;
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public boolean isFolder() {
            return false;
        }

        public File(String str, String str2, boolean z, long j, String str3, Date date, Date date2, String str4, PhotoInfo photoInfo, VideoInfo videoInfo) {
            super(str, str2, z);
            this.numBytes = j;
            this.humanSize = str3;
            this.lastModified = date;
            this.clientMtime = date2;
            this.rev = str4;
            this.photoInfo = photoInfo;
            this.videoInfo = videoInfo;
        }

        public File(String str, String str2, boolean z, long j, String str3, Date date, Date date2, String str4) {
            this(str, str2, z, j, str3, date, date2, str4, null, null);
        }

        @Override // com.dropbox.core.p012v1.DbxEntry, com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            super.dumpFields(dumpWriter);
            dumpWriter.mo519f("numBytes").m523v(this.numBytes);
            dumpWriter.mo519f("humanSize").m527v(this.humanSize);
            dumpWriter.mo519f("lastModified").m528v(this.lastModified);
            dumpWriter.mo519f("clientMtime").m528v(this.clientMtime);
            dumpWriter.mo519f("rev").m527v(this.rev);
            nullablePendingField(dumpWriter, "photoInfo", this.photoInfo, PhotoInfo.PENDING);
            nullablePendingField(dumpWriter, "videoInfo", this.videoInfo, VideoInfo.PENDING);
        }

        private static <T extends Dumpable> void nullablePendingField(DumpWriter dumpWriter, String str, T t, T t2) {
            if (t == null) {
                return;
            }
            dumpWriter.mo519f(str);
            if (t == t2) {
                dumpWriter.verbatim("pending");
            } else {
                dumpWriter.m524v(t);
            }
        }

        @Override // com.dropbox.core.util.Dumpable
        protected String getTypeName() {
            return "File";
        }

        @Override // com.dropbox.core.p012v1.DbxEntry
        public Folder asFolder() {
            throw new RuntimeException("not a folder");
        }

        public boolean equals(Object obj) {
            return obj != null && getClass().equals(obj.getClass()) && equals((File) obj);
        }

        public boolean equals(File file) {
            return partialEquals(file) && this.numBytes == file.numBytes && this.humanSize.equals(file.humanSize) && this.lastModified.equals(file.lastModified) && this.clientMtime.equals(file.clientMtime) && this.rev.equals(file.rev) && LangUtil.nullableEquals(this.photoInfo, file.photoInfo) && LangUtil.nullableEquals(this.videoInfo, file.videoInfo);
        }

        public int hashCode() {
            return (((((((((((partialHashCode() * 31) + ((int) this.numBytes)) * 31) + this.lastModified.hashCode()) * 31) + this.clientMtime.hashCode()) * 31) + this.rev.hashCode()) * 31) + LangUtil.nullableHashCode(this.photoInfo)) * 31) + LangUtil.nullableHashCode(this.videoInfo);
        }

        public static final class PhotoInfo extends Dumpable {
            public final Location location;
            public final Date timeTaken;
            public static JsonReader<PhotoInfo> Reader = new JsonReader<PhotoInfo>() { // from class: com.dropbox.core.v1.DbxEntry.File.PhotoInfo.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.dropbox.core.json.JsonReader
                public PhotoInfo read(JsonParser jsonParser) throws JsonReadException, IOException {
                    JsonReader.expectObjectStart(jsonParser);
                    Date optional = null;
                    Location location = null;
                    while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                        String currentName = jsonParser.getCurrentName();
                        JsonReader.nextToken(jsonParser);
                        if (currentName.equals("lat_long")) {
                            location = Location.Reader.read(jsonParser);
                        } else if (currentName.equals("time_taken")) {
                            optional = JsonDateReader.Dropbox.readOptional(jsonParser);
                        } else {
                            JsonReader.skipValue(jsonParser);
                        }
                    }
                    JsonReader.expectObjectEnd(jsonParser);
                    return new PhotoInfo(optional, location);
                }
            };
            public static final PhotoInfo PENDING = new PhotoInfo(null, null);

            public PhotoInfo(Date date, Location location) {
                this.timeTaken = date;
                this.location = location;
            }

            @Override // com.dropbox.core.util.Dumpable
            protected void dumpFields(DumpWriter dumpWriter) {
                dumpWriter.mo519f("timeTaken").m528v(this.timeTaken);
                dumpWriter.mo519f(FirebaseAnalytics.Param.LOCATION).m524v(this.location);
            }

            public boolean equals(Object obj) {
                return obj != null && getClass().equals(obj.getClass()) && equals((PhotoInfo) obj);
            }

            public boolean equals(PhotoInfo photoInfo) {
                PhotoInfo photoInfo2 = PENDING;
                return (photoInfo == photoInfo2 || this == photoInfo2) ? photoInfo == this : LangUtil.nullableEquals(this.timeTaken, photoInfo.timeTaken) && LangUtil.nullableEquals(this.location, photoInfo.location);
            }

            public int hashCode() {
                return (LangUtil.nullableHashCode(this.timeTaken) * 31) + LangUtil.nullableHashCode(this.location);
            }
        }

        public static final class VideoInfo extends Dumpable {
            public final Long duration;
            public final Location location;
            public final Date timeTaken;
            public static JsonReader<VideoInfo> Reader = new JsonReader<VideoInfo>() { // from class: com.dropbox.core.v1.DbxEntry.File.VideoInfo.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.dropbox.core.json.JsonReader
                public VideoInfo read(JsonParser jsonParser) throws JsonReadException, IOException {
                    JsonReader.expectObjectStart(jsonParser);
                    Date optional = null;
                    Location location = null;
                    Long optional2 = null;
                    while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                        String currentName = jsonParser.getCurrentName();
                        JsonReader.nextToken(jsonParser);
                        if (currentName.equals("lat_long")) {
                            location = Location.Reader.read(jsonParser);
                        } else if (currentName.equals("time_taken")) {
                            optional = JsonDateReader.Dropbox.readOptional(jsonParser);
                        } else if (currentName.equals(TypedValues.TransitionType.S_DURATION)) {
                            optional2 = JsonReader.UnsignedLongReader.readOptional(jsonParser);
                        } else {
                            JsonReader.skipValue(jsonParser);
                        }
                    }
                    JsonReader.expectObjectEnd(jsonParser);
                    return new VideoInfo(optional, location, optional2);
                }
            };
            public static final VideoInfo PENDING = new VideoInfo(null, null, null);

            public VideoInfo(Date date, Location location, Long l) {
                this.timeTaken = date;
                this.location = location;
                this.duration = l;
            }

            @Override // com.dropbox.core.util.Dumpable
            protected void dumpFields(DumpWriter dumpWriter) {
                dumpWriter.mo519f("timeTaken").m528v(this.timeTaken);
                dumpWriter.mo519f(FirebaseAnalytics.Param.LOCATION).m524v(this.location);
                dumpWriter.mo519f(TypedValues.TransitionType.S_DURATION).m526v(this.duration);
            }

            public boolean equals(Object obj) {
                return obj != null && getClass().equals(obj.getClass()) && equals((VideoInfo) obj);
            }

            public boolean equals(VideoInfo videoInfo) {
                VideoInfo videoInfo2 = PENDING;
                return (videoInfo == videoInfo2 || this == videoInfo2) ? videoInfo == this : LangUtil.nullableEquals(this.timeTaken, videoInfo.timeTaken) && LangUtil.nullableEquals(this.location, videoInfo.location) && LangUtil.nullableEquals(this.duration, videoInfo.duration);
            }

            public int hashCode() {
                return (((LangUtil.nullableHashCode(this.timeTaken) * 31) + LangUtil.nullableHashCode(this.location)) * 31) + LangUtil.nullableHashCode(this.duration);
            }
        }

        public static class Location extends Dumpable {
            public static JsonReader<Location> Reader = new JsonReader<Location>() { // from class: com.dropbox.core.v1.DbxEntry.File.Location.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.dropbox.core.json.JsonReader
                public Location read(JsonParser jsonParser) throws JsonReadException, IOException {
                    if (JsonArrayReader.isArrayStart(jsonParser)) {
                        JsonReader.expectArrayStart(jsonParser);
                        Location location = new Location(JsonReader.readDouble(jsonParser), JsonReader.readDouble(jsonParser));
                        JsonReader.expectArrayEnd(jsonParser);
                        return location;
                    }
                    JsonReader.skipValue(jsonParser);
                    return null;
                }
            };
            public final double latitude;
            public final double longitude;

            public Location(double d, double d2) {
                this.latitude = d;
                this.longitude = d2;
            }

            @Override // com.dropbox.core.util.Dumpable
            protected void dumpFields(DumpWriter dumpWriter) {
                dumpWriter.mo519f("latitude").m520v(this.latitude);
                dumpWriter.mo519f("longitude").m520v(this.longitude);
            }

            public int hashCode() {
                long jDoubleToLongBits = Double.doubleToLongBits(this.latitude);
                long jDoubleToLongBits2 = Double.doubleToLongBits(this.longitude);
                return ((PDFACompliance.e_PDFA5_2_7 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
            }

            public boolean equals(Object obj) {
                return obj != null && getClass().equals(obj.getClass()) && equals((Location) obj);
            }

            public boolean equals(Location location) {
                return this.latitude == location.latitude && this.longitude == location.longitude;
            }
        }
    }

    static {
        JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
        builder.add("size", 0);
        builder.add("bytes", 1);
        builder.add(ClientCookie.PATH_ATTR, 2);
        builder.add("is_dir", 3);
        builder.add("is_deleted", 4);
        builder.add("rev", 5);
        builder.add("thumb_exists", 6);
        builder.add("icon", 7);
        builder.add("modified", 8);
        builder.add("client_mtime", 9);
        builder.add("hash", 10);
        builder.add("contents", 11);
        builder.add("photo_info", 12);
        builder.add("video_info", 13);
        f665FM = builder.build();
    }

    public static final class WithChildren extends Dumpable implements Serializable {
        public static final JsonReader<WithChildren> Reader = new JsonReader<WithChildren>() { // from class: com.dropbox.core.v1.DbxEntry.WithChildren.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final WithChildren read(JsonParser jsonParser) throws JsonReadException, IOException {
                WithChildrenC withChildrenC = DbxEntry.read(jsonParser, new Collector.ArrayListCollector());
                return new WithChildren(withChildrenC.entry, withChildrenC.hash, (List) withChildrenC.children);
            }
        };
        public static final JsonReader<WithChildren> ReaderMaybeDeleted = new JsonReader<WithChildren>() { // from class: com.dropbox.core.v1.DbxEntry.WithChildren.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.json.JsonReader
            public final WithChildren read(JsonParser jsonParser) throws JsonReadException, IOException {
                WithChildrenC maybeDeleted = DbxEntry.readMaybeDeleted(jsonParser, new Collector.ArrayListCollector());
                if (maybeDeleted == null) {
                    return null;
                }
                return new WithChildren(maybeDeleted.entry, maybeDeleted.hash, (List) maybeDeleted.children);
            }
        };
        public static final long serialVersionUID = 0;
        public final List<DbxEntry> children;
        public final DbxEntry entry;
        public final String hash;

        public WithChildren(DbxEntry dbxEntry, String str, List<DbxEntry> list) {
            this.entry = dbxEntry;
            this.hash = str;
            this.children = list;
        }

        public boolean equals(Object obj) {
            return obj != null && getClass().equals(obj.getClass()) && equals((WithChildren) obj);
        }

        public boolean equals(WithChildren withChildren) {
            List<DbxEntry> list = this.children;
            if (list == null ? withChildren.children != null : !list.equals(withChildren.children)) {
                return false;
            }
            if (!this.entry.equals(withChildren.entry)) {
                return false;
            }
            String str = this.hash;
            String str2 = withChildren.hash;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.entry.hashCode() * 31;
            String str = this.hash;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<DbxEntry> list = this.children;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.m524v(this.entry);
            dumpWriter.mo519f("hash").m527v(this.hash);
            dumpWriter.mo519f("children").m525v(this.children);
        }
    }

    public static final class WithChildrenC<C> extends Dumpable implements Serializable {
        public static final long serialVersionUID = 0;
        public final C children;
        public final DbxEntry entry;
        public final String hash;

        public WithChildrenC(DbxEntry dbxEntry, String str, C c) {
            this.entry = dbxEntry;
            this.hash = str;
            this.children = c;
        }

        public static class Reader<C> extends JsonReader<WithChildrenC<C>> {
            private final Collector<DbxEntry, ? extends C> collector;

            public Reader(Collector<DbxEntry, ? extends C> collector) {
                this.collector = collector;
            }

            @Override // com.dropbox.core.json.JsonReader
            public final WithChildrenC<C> read(JsonParser jsonParser) throws JsonReadException, IOException {
                return DbxEntry.read(jsonParser, this.collector);
            }
        }

        public static class ReaderMaybeDeleted<C> extends JsonReader<WithChildrenC<C>> {
            private final Collector<DbxEntry, ? extends C> collector;

            public ReaderMaybeDeleted(Collector<DbxEntry, ? extends C> collector) {
                this.collector = collector;
            }

            @Override // com.dropbox.core.json.JsonReader
            public final WithChildrenC<C> read(JsonParser jsonParser) throws JsonReadException, IOException {
                return DbxEntry.readMaybeDeleted(jsonParser, this.collector);
            }
        }

        public boolean equals(Object obj) {
            return obj != null && getClass().equals(obj.getClass()) && equals((WithChildrenC<?>) obj);
        }

        public boolean equals(WithChildrenC<?> withChildrenC) {
            C c = this.children;
            if (c == null ? withChildrenC.children != null : !c.equals(withChildrenC.children)) {
                return false;
            }
            if (!this.entry.equals(withChildrenC.entry)) {
                return false;
            }
            String str = this.hash;
            String str2 = withChildrenC.hash;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.entry.hashCode() * 31;
            String str = this.hash;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            C c = this.children;
            return iHashCode2 + (c != null ? c.hashCode() : 0);
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.m524v(this.entry);
            dumpWriter.mo519f("hash").m527v(this.hash);
            if (this.children != null) {
                dumpWriter.mo519f("children").verbatim(this.children.toString());
            }
        }
    }

    public static <C> WithChildrenC<C> readMaybeDeleted(JsonParser jsonParser, Collector<DbxEntry, ? extends C> collector) throws JsonReadException, IOException {
        return _read(jsonParser, collector, true);
    }

    public static <C> WithChildrenC<C> read(JsonParser jsonParser, Collector<DbxEntry, ? extends C> collector) throws JsonReadException, IOException {
        return _read(jsonParser, collector, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C> WithChildrenC<C> _read(JsonParser jsonParser, Collector<DbxEntry, ? extends C> collector, boolean z) throws JsonReadException, IOException {
        DbxEntry file;
        JsonLocation jsonLocation;
        String str;
        String str2;
        File.PhotoInfo photoInfo;
        Collector<DbxEntry, ? extends C> collector2 = collector;
        JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
        File.PhotoInfo photoInfo2 = null;
        Date field = null;
        String field2 = null;
        Object field3 = null;
        Boolean field4 = null;
        String field5 = null;
        String field6 = null;
        Boolean field7 = null;
        File.VideoInfo videoInfo = null;
        Boolean field8 = null;
        Date field9 = null;
        String field10 = null;
        String field11 = null;
        long unsignedLongField = -1;
        while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            JsonReader.nextToken(jsonParser);
            int i = f665FM.get(currentName);
            switch (i) {
                case -1:
                    str2 = field5;
                    photoInfo = photoInfo2;
                    JsonReader.skipValue(jsonParser);
                    field11 = field11;
                    photoInfo2 = photoInfo;
                    field5 = str2;
                    collector2 = collector;
                    break;
                case 0:
                    str2 = field5;
                    photoInfo = photoInfo2;
                    field11 = JsonReader.StringReader.readField(jsonParser, currentName, field11);
                    photoInfo2 = photoInfo;
                    field5 = str2;
                    collector2 = collector;
                    break;
                case 1:
                    str2 = field5;
                    photoInfo = photoInfo2;
                    unsignedLongField = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField);
                    photoInfo2 = photoInfo;
                    field5 = str2;
                    collector2 = collector;
                    break;
                case 2:
                    field5 = JsonReader.StringReader.readField(jsonParser, currentName, field5);
                    collector2 = collector;
                    break;
                case 3:
                    str = field5;
                    field7 = JsonReader.BooleanReader.readField(jsonParser, currentName, field7);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 4:
                    str = field5;
                    field4 = JsonReader.BooleanReader.readField(jsonParser, currentName, field4);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 5:
                    str = field5;
                    field10 = JsonReader.StringReader.readField(jsonParser, currentName, field10);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 6:
                    str = field5;
                    field8 = JsonReader.BooleanReader.readField(jsonParser, currentName, field8);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 7:
                    str = field5;
                    field6 = JsonReader.StringReader.readField(jsonParser, currentName, field6);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 8:
                    str = field5;
                    field9 = JsonDateReader.Dropbox.readField(jsonParser, currentName, field9);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 9:
                    str = field5;
                    field = JsonDateReader.Dropbox.readField(jsonParser, currentName, field);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 10:
                    str = field5;
                    if (collector2 == null) {
                        throw new JsonReadException("not expecting \"hash\" field, since we didn't ask for children", jsonParser.getCurrentLocation());
                    }
                    field2 = JsonReader.StringReader.readField(jsonParser, currentName, field2);
                    field5 = str;
                    collector2 = collector;
                    break;
                    break;
                case 11:
                    str = field5;
                    if (collector2 == null) {
                        throw new JsonReadException("not expecting \"contents\" field, since we didn't ask for children", jsonParser.getCurrentLocation());
                    }
                    field3 = JsonArrayReader.m517mk(Reader, collector2).readField(jsonParser, currentName, field3);
                    field5 = str;
                    collector2 = collector;
                    break;
                    break;
                case 12:
                    str = field5;
                    photoInfo2 = (File.PhotoInfo) PendingReader.m533mk(File.PhotoInfo.Reader, File.PhotoInfo.PENDING).readField(jsonParser, currentName, photoInfo2);
                    field5 = str;
                    collector2 = collector;
                    break;
                case 13:
                    try {
                        str = field5;
                        videoInfo = (File.VideoInfo) PendingReader.m533mk(File.VideoInfo.Reader, File.VideoInfo.PENDING).readField(jsonParser, currentName, videoInfo);
                        field5 = str;
                        collector2 = collector;
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                    break;
                default:
                    throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
            }
        }
        String str3 = field5;
        File.PhotoInfo photoInfo3 = photoInfo2;
        String str4 = field11;
        JsonReader.expectObjectEnd(jsonParser);
        if (str3 == null) {
            throw new JsonReadException("missing field \"path\"", jsonLocationExpectObjectStart);
        }
        if (field6 == null) {
            throw new JsonReadException("missing field \"icon\"", jsonLocationExpectObjectStart);
        }
        if (field4 == null) {
            field4 = Boolean.FALSE;
        }
        Boolean bool = field4;
        if (field7 == null) {
            field7 = Boolean.FALSE;
        }
        if (field8 == null) {
            field8 = Boolean.FALSE;
        }
        if (field7.booleanValue() && (field3 != null || field2 != null)) {
            if (field2 == null) {
                throw new JsonReadException("missing \"hash\", when we asked for children", jsonLocationExpectObjectStart);
            }
            if (field3 == null) {
                throw new JsonReadException("missing \"contents\", when we asked for children", jsonLocationExpectObjectStart);
            }
        }
        if (field7.booleanValue()) {
            file = new Folder(str3, field6, field8.booleanValue());
            jsonLocation = jsonLocationExpectObjectStart;
        } else {
            if (str4 == null) {
                throw new JsonReadException("missing \"size\" for a file entry", jsonLocationExpectObjectStart);
            }
            if (unsignedLongField == -1) {
                throw new JsonReadException("missing \"bytes\" for a file entry", jsonLocationExpectObjectStart);
            }
            if (field9 == null) {
                throw new JsonReadException("missing \"modified\" for a file entry", jsonLocationExpectObjectStart);
            }
            if (field == null) {
                throw new JsonReadException("missing \"client_mtime\" for a file entry", jsonLocationExpectObjectStart);
            }
            if (field10 == null) {
                throw new JsonReadException("missing \"rev\" for a file entry", jsonLocationExpectObjectStart);
            }
            jsonLocation = jsonLocationExpectObjectStart;
            file = new File(str3, field6, field8.booleanValue(), unsignedLongField, str4, field9, field, field10, photoInfo3, videoInfo);
        }
        if (!bool.booleanValue()) {
            return new WithChildrenC<>(file, field2, field3);
        }
        if (z) {
            return null;
        }
        throw new JsonReadException("not expecting \"is_deleted\" entry here", jsonLocation);
    }

    private static final class PendingReader<T> extends JsonReader<T> {
        private final T pendingValue;
        private final JsonReader<T> reader;

        public PendingReader(JsonReader<T> jsonReader, T t) {
            this.reader = jsonReader;
            this.pendingValue = t;
        }

        /* JADX INFO: renamed from: mk */
        public static <T> PendingReader<T> m533mk(JsonReader<T> jsonReader, T t) {
            return new PendingReader<>(jsonReader, t);
        }

        @Override // com.dropbox.core.json.JsonReader
        public T read(JsonParser jsonParser) throws JsonReadException, IOException {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                if (!jsonParser.getText().equals("pending")) {
                    throw new JsonReadException("got a string, but the value wasn't \"pending\"", jsonParser.getTokenLocation());
                }
                jsonParser.nextToken();
                return this.pendingValue;
            }
            return this.reader.read(jsonParser);
        }
    }
}

package com.dropbox.core.json;

import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.revenuecat.purchases.common.Constants;
import com.survicate.surveys.TextRecallingManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonWriter<T> {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String[] weekdays = {null, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", null};

    public abstract void write(T t, JsonGenerator jsonGenerator) throws IOException;

    public void writeFields(T t, JsonGenerator jsonGenerator) throws IOException {
    }

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        simpleDateFormat.setTimeZone(UTC);
        return simpleDateFormat.format(date);
    }

    public void write(T t, JsonGenerator jsonGenerator, int i) throws IOException {
        write(t, jsonGenerator);
    }

    public final String writeToString(T t, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            JsonGenerator jsonGeneratorCreateGenerator = JsonReader.jsonFactory.createGenerator(byteArrayOutputStream);
            if (z) {
                jsonGeneratorCreateGenerator = jsonGeneratorCreateGenerator.useDefaultPrettyPrinter();
            }
            try {
                write(t, jsonGeneratorCreateGenerator);
                jsonGeneratorCreateGenerator.flush();
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            } catch (Throwable th) {
                jsonGeneratorCreateGenerator.flush();
                throw th;
            }
        } catch (IOException e) {
            throw LangUtil.mkAssert("Impossible", e);
        }
    }

    public final String writeToString(T t) {
        return writeToString(t, true);
    }

    public final void writeToStream(T t, OutputStream outputStream, boolean z) throws IOException {
        JsonGenerator jsonGeneratorCreateGenerator = JsonReader.jsonFactory.createGenerator(outputStream);
        if (z) {
            jsonGeneratorCreateGenerator = jsonGeneratorCreateGenerator.useDefaultPrettyPrinter();
        }
        try {
            write(t, jsonGeneratorCreateGenerator);
        } finally {
            jsonGeneratorCreateGenerator.flush();
        }
    }

    public final void writeToStream(T t, OutputStream outputStream) throws IOException {
        writeToStream(t, outputStream, true);
    }

    public final void writeToFile(T t, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            writeToStream(t, fileOutputStream, z);
        } finally {
            fileOutputStream.close();
        }
    }

    public final void writeToFile(T t, File file) throws IOException {
        writeToFile((Object) t, file, true);
    }

    public final void writeToFile(T t, String str, boolean z) throws IOException {
        writeToFile(t, new File(str), z);
    }

    public final void writeToFile(T t, String str) throws IOException {
        writeToFile((Object) t, str, true);
    }

    public final void writeDateIso(Date date, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeString(formatDate(date));
    }

    public final void writeDate(Date date, JsonGenerator jsonGenerator) throws IOException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(JsonDateReader.UTC);
        gregorianCalendar.setTime(date);
        String string = Integer.toString(gregorianCalendar.get(1));
        String str = months[gregorianCalendar.get(2)];
        String strZeroPad = zeroPad(Integer.toString(gregorianCalendar.get(5)), 2);
        String strZeroPad2 = zeroPad(Integer.toString(gregorianCalendar.get(11)), 2);
        String strZeroPad3 = zeroPad(Integer.toString(gregorianCalendar.get(12)), 2);
        String strZeroPad4 = zeroPad(Integer.toString(gregorianCalendar.get(13)), 2);
        String str2 = weekdays[gregorianCalendar.get(7)];
        StringBuilder sb = new StringBuilder();
        sb.append(str2).append(TextRecallingManager.ANSWER_SEPARATOR);
        sb.append(strZeroPad).append(" ").append(str).append(" ").append(string).append(" ");
        sb.append(strZeroPad2).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).append(strZeroPad3).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).append(strZeroPad4).append(" +0000");
        jsonGenerator.writeString(sb.toString());
    }

    private static String zeroPad(String str, int i) {
        while (str.length() < i) {
            str = "0" + str;
        }
        return str;
    }
}

package com.pdftron.pdf;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
class ImageCache {

    /* JADX INFO: renamed from: a */
    private final HashMap<Key, List<SoftReference<Bitmap>>> f1572a;

    /* JADX INFO: renamed from: b */
    private boolean f1573b;

    /* synthetic */ ImageCache(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.ImageCache$a */
    static class C6931a {

        /* JADX INFO: renamed from: a */
        private static final ImageCache f1579a = new ImageCache(0);
    }

    /* JADX INFO: renamed from: a */
    public static ImageCache m1160a() {
        return C6931a.f1579a;
    }

    private ImageCache() {
        this.f1572a = new HashMap<>(16);
        this.f1573b = true;
    }

    /* JADX INFO: renamed from: a */
    final Bitmap m1161a(int i, int i2) {
        Bitmap bitmap = null;
        if (!this.f1573b || i <= 0 || i2 <= 0 || this.f1572a.isEmpty()) {
            return null;
        }
        synchronized (this.f1572a) {
            List<SoftReference<Bitmap>> list = this.f1572a.get(new Key(this, i, i2));
            if (list != null && !list.isEmpty()) {
                Iterator<SoftReference<Bitmap>> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 != null && bitmap2.isMutable()) {
                        it.remove();
                        bitmap = bitmap2;
                        break;
                    }
                    it.remove();
                }
                return bitmap;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1162a(Bitmap bitmap) {
        if (!this.f1573b || bitmap == null) {
            return;
        }
        Key key = new Key(this, bitmap.getWidth(), bitmap.getHeight());
        synchronized (this.f1572a) {
            List<SoftReference<Bitmap>> arrayList = this.f1572a.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f1572a.put(key, arrayList);
            }
            arrayList.add(new SoftReference<>(bitmap));
        }
    }

    /* JADX INFO: renamed from: b */
    final void m1164b() {
        synchronized (this.f1572a) {
            this.f1572a.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1163a(boolean z) {
        this.f1573b = z;
    }

    /* JADX INFO: renamed from: c */
    final boolean m1165c() {
        return this.f1573b;
    }

    public class Key {

        /* JADX INFO: renamed from: a */
        private final int f1577a;

        /* JADX INFO: renamed from: b */
        private final int f1578b;

        public Key(ImageCache imageCache, int i, int i2) {
            this.f1577a = i;
            this.f1578b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f1577a == key.f1577a && this.f1578b == key.f1578b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f1577a * 31) + this.f1578b;
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.ImageCache$1 */
    static /* synthetic */ class C69301 {

        /* JADX INFO: renamed from: a */
        Bitmap f1574a = null;

        /* JADX INFO: renamed from: b */
        Rect f1575b = null;

        /* JADX INFO: renamed from: c */
        Rect f1576c = null;

        C69301() {
        }
    }
}

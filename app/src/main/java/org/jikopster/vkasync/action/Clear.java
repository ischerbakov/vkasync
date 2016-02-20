package org.jikopster.vkasync.action;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;

import org.jikopster.vkasync.core.Track;
import org.jikopster.vkasync.misc.Lambda;
import org.jikopster.vkasync.preference.Path;
import org.jikopster.vkasync.worker.Media;

import java.io.File;

public class Clear
{
    public static void clear(Context context, Lambda.Action1<Boolean> listener)
    {
        new AsyncTask<Void, Void, Boolean>() {
            private final String mPath = Path.getCurrent(context, Path.LOCAL);
            private final File mDir = new File(mPath);

            private Uri mUri = MediaStore.Audio.Media.getContentUriForPath(mPath);

            private ContentResolver mCoRe = context.getContentResolver();

            @Override
            protected void onPostExecute(Boolean result) {
                listener.invoke(result);
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                boolean result = delete(mDir);
                mCoRe.delete(mUri, Media.ContentHelper.whereByPath(mPath), null);
                return result;
            }

            private boolean delete(File file) {
                File[] files = file.listFiles();
                if (files != null)
                    for (File f : files) delete(f);
                return file.delete();
            }
        }.execute();
    }
}

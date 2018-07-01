package com.example.administrator.tfimaege.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.io.IOException;

public class BitmapUtils {
    /**
     * 裁剪bitmap
     * @param bitmap
     * @param size
     * @return
     * @throws IOException
     */
    public static Bitmap getScaleBitmap(Bitmap bitmap, int size) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = ((float) size) / width;
        float scaleHeight = ((float) size) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}

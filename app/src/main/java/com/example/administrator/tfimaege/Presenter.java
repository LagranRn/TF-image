package com.example.administrator.tfimaege;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.tfimaege.TensorFlow.Classifier;
import com.example.administrator.tfimaege.TensorFlow.TensorFlowImageClassifier;

import java.util.List;

import static com.example.administrator.tfimaege.TensorFlow.Classifier.*;

public class Presenter {

    private static final String TAG = "Presenter";

    private static final int INPUT_SIZE = 224;
    private static final int IMAGE_MEAN = 117;
    private static final float IMAGE_STD = 1;
    private static final String INPUT_NAME = "input";
    private static final String OUTPUT_NAME = "output";
    private static final String MODEL_FILE = "file:///android_asset/model/tensorflow_inception_graph.pb";
    private static final String LABEL_FILE = "file:///android_asset/model/imagenet_comp_graph_label_strings.txt";

    private MainActivity mActivity;
    private Classifier classifier;


    public Presenter(MainActivity activity) {
        mActivity = activity;
        classifier = TensorFlowImageClassifier.create(mActivity.getAssets(),
                MODEL_FILE, LABEL_FILE, INPUT_SIZE, IMAGE_MEAN, IMAGE_STD, INPUT_NAME, OUTPUT_NAME);

    }

    public void detectImage(final Bitmap croppedBitmap) {
        new detectImageTask().execute(croppedBitmap);
    }

    class detectImageTask extends AsyncTask<Bitmap, Void, String> {


        @Override
        protected String doInBackground(Bitmap... bitmaps) {
            final List<Recognition> results = classifier.recognizeImage(bitmaps[0]);
            String result = "";
            for (Recognition each : results) {
                result += " " + each;
            }
            Log.d(TAG, "detectImage: " + result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            mActivity.showResult(s);
            super.onPostExecute(s);
        }
    }

}

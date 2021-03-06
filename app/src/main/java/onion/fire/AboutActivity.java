package onion.fire;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about);

        ((TextView) findViewById(R.id.text1)).setText(readRawTextFile(R.raw.about));
        ((TextView) findViewById(R.id.text2)).setText(readRawTextFile(R.raw.license_tor));
        ((TextView) findViewById(R.id.text3)).setText(readRawTextFile(R.raw.license_geckoview));
    }

    public String readRawTextFile(int resId) {

        InputStream inputStream = getResources().openRawResource(resId);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            return null;
        }

        return byteArrayOutputStream.toString();

    }

}

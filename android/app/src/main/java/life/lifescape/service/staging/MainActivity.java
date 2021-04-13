package life.lifescape.service.staging;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.lifescape/mea_channel";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        Log.d("","xxxxxxxxx");
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {

                            if(call.method.equals("load_mea_sdk")) {
                                startMeaSDK();
                            }
//                            else if(call.method.equals("register_ca_number")) {
//                                register();
//                            }
                            else {
                                result.error("UNAVAILABLE", null, null);
                            }
                        }
                );
    }

    private void startMeaSDK() {
        Intent intent = new Intent(this, MeaSDK.class);
        startActivityForResult(intent, 120);
    }
}

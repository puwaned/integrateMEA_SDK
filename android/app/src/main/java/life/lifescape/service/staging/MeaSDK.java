package life.lifescape.service.staging;

import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import io.flutter.embedding.android.FlutterActivity;
import com.mea.energysdk.common.Env;
import com.mea.energysdk.common.MEAEnergyTheme;
import com.mea.energysdk.common.MEAEnergyWidgetCallback;
import com.mea.energysdk.service.MEAEnergy;
import com.mea.energysdk.service.common.MEAEnergyCallback;
import com.mea.energysdk.widget.*;

public class MeaSDK extends FlutterActivity {
    MEAEnergyWidget meaWidgets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mea);
        this.meaWidgets  = (MEAEnergyWidget) findViewById(R.id.meaWidget);

        initializeMEA_SDK();
        registerCA();
//        initializeWidget();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initializeWidget() {
        meaWidgets.initCA("011346054", new MEAEnergyWidgetCallback() {
            @Override
            public void onDone() {
                Log.d("on_result_mea_sdk", "pass");
            }

            @Override
            public void onFail(JSONArray jsonArray) {
                Log.d("on_result_mea_sdk", "ErrorrrrrrErrorrrrrrErrorrrrrrErrorrrrrrErrorrrrrrErrorrrrrrErrorrrrrr");
                Log.d("on_result_mea_sdk", jsonArray.toString());
            }
        });
        meaWidgets.setTheme(MEAEnergyTheme.DARK);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void initializeMEA_SDK() {
        MEAEnergy.getInstance().setInitializeApp(this);
        MEAEnergy.getInstance().setAPIKey("hFgFz9rhiysQxKTK3rPvdxUndFVks8vw", "LUSRs5U0XDQRw8YJnBLeVrunTMRZbvbQ");
        MEAEnergy.getInstance().setEnv(Env.STAGING);
    }

    private void registerCA() {
        MEAEnergy.getInstance().registerCA(
                "014280267", // เลขที่แสดงสัญญา (CA)
                "19", // รหัสโครงการ
                "เอ็ม จตุจักร", // ชื่อโครงการภาษาไทย
                "M JATUJAK", // ชื่อโครงการภาษาอังกฤษ
                "แขวงจอมพล เขตจตุจักร", // ที่อยู่โครงการภาษาไทย
                "Jomphol Sub District, Jatujak District", // ที่อยู่โครงการภาษาอังกฤษ
                new MEAEnergyCallback() {
                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        Log.d("on_result_mea_sdk", "Sucesssssssssssssssssssssssssssssssssssssssssssssssssss");
                        Log.d("regis",jsonObject.toString());
                    }

                    @Override
                    public void onFail(JSONArray jsonArray) {
                        Log.d("on_result_mea_sdk", "Errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                        Log.d("regis",jsonArray.toString());
                    }
                });
    }
}


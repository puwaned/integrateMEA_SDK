import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {

    let controller : FlutterViewController = window?.rootViewController as! FlutterViewController
    let meaSDKChannel = FlutterMethodChannel(name: "com.lifescape/mea_channel",
                                              binaryMessenger: controller.binaryMessenger)
    meaSDKChannel.setMethodCallHandler({
        [weak self] (call: FlutterMethodCall, result:FlutterResult) -> Void in
        
        guard call.method == "load_mea_sdk" else {
            result(FlutterMethodNotImplemented)
            return
        }
        self?.startMeaSDK()
      // Note: this method is invoked on the UI thread.
      // Handle battery messages.
    })

    GeneratedPluginRegistrant.register(with: self)
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
    
    private func startMeaSDK() {
        //
    }
}

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = MethodChannel('com.lifescape/mea_channel');

  Future _loadMeaSDK() async {
    try {
      await platform.invokeMethod('load_mea_sdk').then((result) {});
    } on PlatformException catch (e) {
      print(e.message);
    }
  }

  // Future _registerCA() async {
  //   try {
  //     await platform.invokeMethod('register_ca_number').then((result) {
  //       print(result);
  //     });
  //   } on PlatformException catch (e) {
  //     print(e.message);
  //   }
  // }
  //
  // Future _initialMeaSDK() async {
  //   try {
  //     await platform.invokeMethod('init_mea_sdk').then((result) {
  //       print(result);
  //     });
  //   } on PlatformException catch (e) {
  //     print(e.message);
  //   }
  // }

  // @override
  // void initState() {
  //   super.initState();
  //   _initialMeaSDK();
  // }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextButton(onPressed: _loadMeaSDK, child: Text('LOAD MEA_SDK')),
            // Container(
            //   height: 100,
            // ),
            // TextButton(onPressed: _registerCA, child: Text('REGISTER CA'))
          ],
        ),
      ),
    );
  }
}

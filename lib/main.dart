import 'dart:async';

import 'package:flutter/material.dart';
import 'package:home_widget/home_widget.dart';

void main() async {
  runApp(const HomePage());
}

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  double portfolioValue = 1489540.2;
  double investedValue = 1084325.9;
  double dayPNLValue = 3225251.5;
  double dayPNLPercent = 3.49;
  double unrealisedPNLValue = 2154325.9;
  double unrealisedPNLPercent = 47.49;
  double realisedPNLValue = 465765.50;
  double realisedPNLPercent = 47.49;

  @override
  void initState() {
    super.initState();
    Timer.periodic(Duration(milliseconds: 100), (timer) {
      setState(() {
        portfolioValue += 0.1;
        investedValue += 0.1;
        dayPNLValue += 0.1;
        dayPNLPercent += 0.01;
        unrealisedPNLValue += 0.1;
        unrealisedPNLPercent += 0.01;
        realisedPNLValue += 0.1;
        realisedPNLPercent += 0.01;
      });

      updateAndroidWidget();
    });
  }

  void updateAndroidWidget() {
    HomeWidget.saveWidgetData(
        "portfolioValue", portfolioValue.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "investedValue", investedValue.toStringAsFixed(2));
    HomeWidget.saveWidgetData("dayPNLValue", dayPNLValue.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "dayPNLPercent", dayPNLPercent.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "unrealisedPNLValue", unrealisedPNLValue.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "unrealisedPNLPercent", unrealisedPNLPercent.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "realisedPNLValue", realisedPNLValue.toStringAsFixed(2));
    HomeWidget.saveWidgetData(
        "realisedPNLPercent", realisedPNLPercent.toStringAsFixed(2));

    HomeWidget.updateWidget(
      androidName: "PortfolioWidget",
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text("Portfolio Widget")),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: const [
                Text("Updating Android widget in real-time..."),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

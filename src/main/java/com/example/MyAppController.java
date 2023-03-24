package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyAppController {

	@FXML
	private Button calcButton;

	@FXML
	private TextField heightField;

	@FXML
	private Label resultLabel;

	@FXML
	private TextField weightField;

	public void initialize() {
		calcButton.setOnAction(e -> {
			double height = Double.parseDouble(heightField.getText());
			double weight = Double.parseDouble(weightField.getText());
			double bmi = 10000 * weight / Math.pow(height, 2);
			// 小数点以下１桁まで。10でなく10.0で割ること。10で割ると整数になるため。
			double bmiShort = Math.round(bmi * 10)/10.0;
			String bmiStr = String.valueOf(bmiShort);
			
			// 判定
			String judge = "";
			if (bmi < 18.5) judge = "痩せ";
			else if (bmi < 25) judge = "標準体重";
			else judge = "肥満";
			
			resultLabel.setText("BMI = " + bmiStr + "【" + judge + "】");
		});
	}
}

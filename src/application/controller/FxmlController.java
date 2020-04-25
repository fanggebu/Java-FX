package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import application.qq.Send;
import application.util.ReadLoadTxtFileRunnable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FxmlController {

	private Stage primaryStage;

	@FXML
	private Button submit;

	@FXML
	private Button fileControl;

	@FXML
	private TextField sendStr;
	
	@FXML
	private TextField cishu;

	/**
	 * 获取想要一直发送的内容
	 */
	public void sendButton() {

		String str = sendStr.getText(); // 获取文本框输入的内容
		System.out.println(str);
		Send send = new Send();
		int ci = Integer.parseInt(cishu.getText());
		System.out.println(ci);
		send.sendInfinite(str,ci);

	}

	/**
	 * 打开文件选择器，选择TXT文件并进行获取内容
	 */
	public void openFile () {
		
		//文件选择器，并将文件路径打印
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择文件");
		fileChooser.getExtensionFilters().add(
			    new FileChooser.ExtensionFilter("All TXT", "*.txt*"));
		File file = fileChooser.showOpenDialog(primaryStage);
		
		System.out.println(file.getPath());

		ReadLoadTxtFileRunnable RT = new ReadLoadTxtFileRunnable(file.getPath());
		String str = RT.run();
		System.out.println(str);
		Send send = new Send();
		send.sendFileStr(str);
	}

}

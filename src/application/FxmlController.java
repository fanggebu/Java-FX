package application;

import java.io.File;

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

	public void sendButton() {

		String text = sendStr.getText();     // 获取文本框输入的内容
		System.out.println(text);
		
	}
	public void openFile () {
		
		//文件选择器，并将文件路径打印
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择文件");
		File file = fileChooser.showOpenDialog(primaryStage);
		
		System.out.println(file.getPath());

	}

}

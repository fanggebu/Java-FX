package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("QQTimer.fxml"));// 修改了
			// BorderPane root = new BorderPane();
			// 设置Scene的大小(SceneBuilder中点击AnchorPane右边Layout中会显示大小,不一样的可以)
			Scene scene = new Scene(root, 470, 300);// 修改了
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);// 设置不能窗口改变大小
			primaryStage.setTitle("发送QQ消息工具");// 设置标题
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import java.io.File;

import cont.ImageAnimationView;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/cont/Image.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root, 1200, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

//			// 이미지 애니메이션용 클래스 사용
//			ImageAnimationView img = new ImageAnimationView(Duration.millis(1000), new File("nono.png"), 30, 58);
//
//			// 걷는 그래픽 범위 표시
//			img.setAnimationRange(1, img.getMaxIndex());
//
//			// 무한 루프 애니메이션 시작
//			img.setCycleCount(Animation.INDEFINITE);
//			img.play();
//
//			// 이미지가 작으면 확대하자.
//			img.setScaleX(3);
//			img.setScaleY(3);
//
//			// 중앙에 배치하여 표시
//			Bounds b = img.getBoundsInLocal();
//			img.setX(scene.getWidth() / 2 - b.getWidth() / 2);
//			img.setY(scene.getHeight() / 2 - b.getHeight() / 2);
//			root.getChildren().add(img);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

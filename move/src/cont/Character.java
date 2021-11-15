package cont;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character extends Pane {

	// Character Configuration
	ImageView imageView;
	int count = 3;
	int columns = 3;
	int offsetX = 0;
	int offsetY = 0;
	int width = 75;
	int height = 115;

	Rectangle removeRect = null;
	SpriteAnimation animation;

	public Character(ImageView imageView) {
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(200), count, columns, offsetX, offsetY, width,
				height);
		getChildren().addAll(imageView);
	}

}

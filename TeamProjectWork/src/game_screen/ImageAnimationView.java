package game_screen;

import java.io.File;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ImageAnimationView extends ImageView {

	private Rectangle2D[] viewports;
	private Index index = new Index() {
		
		@Override
		public void setValue(Object value) {
			// TODO Auto-generated method stub
			
		}
	};
	private Timeline timeline;
	private Duration dur;

	/**
	 * 지정한 이미지를 가로폭, 세로폭으로 분할하고, 지정 기간에 1 애니메이션을 실행하는 ImageAnimationView 객체를 구축합니다.
	 * 
	 * @param dur
	 * @param img
	 * @param width
	 * @param height
	 */
	public ImageAnimationView(Duration dur, Image img, int width, int height) {

		// 이미지가 옆에 몇 장 있는지, 세로에 몇 장 있는지를 계산합니다.
		int x = (int) img.getWidth() / width;
		int y = (int) img.getHeight() / height;

		// viewport 만들기
		Rectangle2D[] viewports = new Rectangle2D[x * y];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				viewports[i * x + j] = new Rectangle2D(j * width, i * height, width, height);
			}
		}
		this.dur = dur;
		this.viewports = viewports;
		setViewport(viewports[0]);
		setImage(img);
		timeline = new Timeline();
	}

	/**
	 * 지정된 파일이 나타내는 화상을 가로폭, 세로폭으로 분할해, 지정 기간에 1 애니메이션을 실행하는 ImageAnimationView
	 * 오브젝트를 구축합니다.
	 * 
	 * @param dur
	 * @param img
	 * @param width
	 * @param height
	 */
	public ImageAnimationView(Duration dur, File file, int width, int height) {
		this(dur, new Image(file.toURI().toString()), width, height);
	}

	/**
	 * 이미지 번호의 범위를 애니메이션으로 설정합니다.
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	public void setAnimationRange(int startIndex, int endIndex) {
		if (timeline != null)
			timeline.stop();
		index.setValue(startIndex);
		timeline.getKeyFrames().clear();

		// 시작 번호에서 종료 번호까지 애니메이션
		KeyFrame kf = new KeyFrame(dur, new KeyValue(index, endIndex, Interpolator.EASE_BOTH));
		timeline.getKeyFrames().add(kf);
	}

	/**
	 * 모든 이미지를 애니메이션 대상으로 합니다.
	 */
	public void setDefaultAnimationRange() {
		setAnimationRange(0, getMaxIndex());
	}

	/**
	 * 애니메이션을 시작합니다.
	 */
	public void play() {
		timeline.play();
	}

	/**
	 * 애니메이션의 루프 횟수를 지정합니다.
	 * 
	 * @param value
	 */
	public void setCycleCount(int value) {
		timeline.setCycleCount(value);
	}

	/**
	 * 이미지 번호의 최대 값을 가져옵니다.
	 * 
	 * @return
	 */
	public int getMaxIndex() {
		return viewports.length - 1;
	}

	private abstract class Index implements WritableValue {
		private int index = 0;

		@Override
		public Integer getValue() {
			return index;
		}
		public void setValue(Integer index) {
			this.index = index;
			setViewport(viewports[index]);
			
		}
	}
}
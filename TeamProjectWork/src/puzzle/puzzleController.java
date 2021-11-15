package puzzle;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class puzzleController {
	MediaPlayer mp;
	Media m = null;
	@FXML
	public Button hintBtn;
	//힌트사용횟수
	public static int hintUseCnt = 0;
	public void hintLook() {
		try {
			if(hintUseCnt == 0) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/puzzle/hintLayout.fxml"));
				Parent root = (Parent) loader.load();
				Stage stage = new Stage();
				stage.setTitle("힌트보기");
				stage.setScene(new Scene(root));
				stage.show();
				hintUseCnt++;
			} else if(hintUseCnt > 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("사용X");
				alert.setHeaderText("힌트 사용횟수 초과");
				alert.setContentText("힌트를 이미 사용하셨습니다.");
				alert.showAndWait();
			}
		} catch (Exception e) {

		}

	}
	
	
	//퍼즐 맟추기/////////////////////////////////////////////////////////////\
	
	
	//어떤 퍼즐 선택했는지 확인 (기본값 null)
	public String pChoice = "";
	
	//흩어진 퍼즐
	@FXML
	private Button a01;
	@FXML
	private Button a02;
	@FXML
	private Button a03;
	@FXML
	private Button a04;
	@FXML
	private Button a05;
	@FXML
	private Button a06;
	@FXML
	private Button a07;
	@FXML
	private Button a08;
	@FXML
	private Button a09;
	@FXML
	private Button a10;
	@FXML
	private Button a11;
	@FXML
	private Button a12;
	@FXML
	private Button a13;
	@FXML
	private Button a14;
	@FXML
	private Button a15;
	@FXML
	private Button a16;
	@FXML
	private Button a17;
	@FXML
	private Button a18;
	@FXML
	private Button a19;
	@FXML
	private Button a20;
	@FXML
	private Button a21;
	@FXML
	private Button a22;
	@FXML
	private Button a23;
	@FXML
	private Button a24;
	@FXML
	private Button a25;
	
	public void puzzlePiece1() {
		pChoice = "p1";
	}
	
	public void puzzlePiece2() {
		pChoice = "p2";
	}
	
	public void puzzlePiece3() {
		pChoice = "p3";
	}
	
	public void puzzlePiece4() {
		pChoice = "p4";
	}
	
	public void puzzlePiece5() {
		pChoice = "p5";
	}
	
	public void puzzlePiece6() {
		pChoice = "p6";
	}
	
	public void puzzlePiece7() {
		pChoice = "p7";
	}
	
	public void puzzlePiece8() {
		pChoice = "p8";
	}
	
	public void puzzlePiece9() {
		pChoice = "p9";
	}
	
	public void puzzlePiece10() {
		pChoice = "p10";
	}
	
	public void puzzlePiece11() {
		pChoice = "p11";
	}
	
	public void puzzlePiece12() {
		pChoice = "p12";
	}
	
	public void puzzlePiece13() {
		pChoice = "p13";
	}
	
	public void puzzlePiece14() {
		pChoice = "p14";
	}
	
	public void puzzlePiece15() {
		pChoice = "p15";
	}
	
	public void puzzlePiece16() {
		pChoice = "p16";
	}
	
	public void puzzlePiece17() {
		pChoice = "p17";
	}
	
	public void puzzlePiece18() {
		pChoice = "p18";
	}
	
	public void puzzlePiece19() {
		pChoice = "p19";
	}
	
	public void puzzlePiece20() {
		pChoice = "p20";
	}
	
	public void puzzlePiece21() {
		pChoice = "p21";
	}
	
	public void puzzlePiece22() {
		pChoice = "p22";
	}
	
	public void puzzlePiece23() {
		pChoice = "p23";
	}
	
	public void puzzlePiece24() {
		pChoice = "p24";
	}
	
	public void puzzlePiece25() {
		pChoice = "p25";
	}
	
	//액자속 퍼즐
	@FXML
	private ImageView b01;
	@FXML
	private ImageView b02;  
	@FXML
	private ImageView b03;  
	@FXML
	private ImageView b04;  
	@FXML
	private ImageView b05;  
	@FXML
	private ImageView b06;  
	@FXML
	private ImageView b07;  
	@FXML
	private ImageView b08;  
	@FXML
	private ImageView b09;  
	@FXML
	private ImageView b10;  
	@FXML
	private ImageView b11;  
	@FXML
	private ImageView b12;  
	@FXML
	private ImageView b13;  
	@FXML
	private ImageView b14;  
	@FXML
	private ImageView b15;  
	@FXML
	private ImageView b16;  
	@FXML
	private ImageView b17;  
	@FXML
	private ImageView b18;  
	@FXML
	private ImageView b19;  
	@FXML
	private ImageView b20;
	@FXML
	private ImageView b21;
	@FXML
	private ImageView b22;
	@FXML
	private ImageView b23;
	@FXML
	private ImageView b24;
	@FXML
	private ImageView b25;
	
	int count = 0;
	public void addPuzzle1() {
		if(pChoice != "") {
			if(pChoice.equals("p1")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b01.setImage(new Image("/puzzle/piece.jpg"));
				pChoice = "";
				a01.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle2() {
		if(pChoice != "") {
			if(pChoice.equals("p2")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b02.setImage(new Image("/puzzle/piece01.jpg"));
				pChoice = "";
				a02.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle3() {
		if(pChoice != "") {
			if(pChoice.equals("p3")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b03.setImage(new Image("/puzzle/piece02.jpg"));
				pChoice = "";
				a03.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle4() {
		if(pChoice != "") {
			if(pChoice.equals("p4")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b04.setImage(new Image("/puzzle/piece03.jpg"));
				pChoice = "";
				a04.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle5() {
		if(pChoice != "") {
			if(pChoice.equals("p5")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b05.setImage(new Image("/puzzle/piece04.jpg"));
				pChoice = "";
				a05.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle6() {
		if(pChoice != "") {
			if(pChoice.equals("p6")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b06.setImage(new Image("/puzzle/piece05.jpg"));
				pChoice = "";
				a06.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle7() {
		if(pChoice != "") {
			if(pChoice.equals("p7")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b07.setImage(new Image("/puzzle/piece06.jpg"));
				pChoice = "";
				a07.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle8() {
		if(pChoice != "") {
			if(pChoice.equals("p8")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b08.setImage(new Image("/puzzle/piece07.jpg"));
				pChoice = "";
				a08.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle9() {
		if(pChoice != "") {
			if(pChoice.equals("p9")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b09.setImage(new Image("/puzzle/piece08.jpg"));
				pChoice = "";
				a09.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle10() {
		if(pChoice != "") {
			if(pChoice.equals("p10")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b10.setImage(new Image("/puzzle/piece09.jpg"));
				pChoice = "";
				a10.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle11() {
		if(pChoice != "") {
			if(pChoice.equals("p11")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b11.setImage(new Image("/puzzle/piece10.jpg"));
				pChoice = "";
				a11.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle12() {
		if(pChoice != "") {
			if(pChoice.equals("p12")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b12.setImage(new Image("/puzzle/piece11.jpg"));
				pChoice = "";
				a12.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle13() {
		if(pChoice != "") {
			if(pChoice.equals("p13")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b13.setImage(new Image("/puzzle/piece12.jpg"));
				pChoice = "";
				a13.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle14() {
		if(pChoice != "") {
			if(pChoice.equals("p14")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b14.setImage(new Image("/puzzle/piece13.jpg"));
				pChoice = "";
				a14.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle15() {
		if(pChoice != "") {
			if(pChoice.equals("p15")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b15.setImage(new Image("/puzzle/piece14.jpg"));
				pChoice = "";
				a15.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle16() {
		if(pChoice != "") {
			if(pChoice.equals("p16")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b16.setImage(new Image("/puzzle/piece15.jpg"));
				pChoice = "";
				a16.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle17() {
		if(pChoice != "") {
			if(pChoice.equals("p17")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b17.setImage(new Image("/puzzle/piece16.jpg"));
				pChoice = "";
				a17.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle18() {
		if(pChoice != "") {
			if(pChoice.equals("p18")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b18.setImage(new Image("/puzzle/piece17.jpg"));
				pChoice = "";
				a18.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle19() {
		if(pChoice != "") {
			if(pChoice.equals("p19")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b19.setImage(new Image("/puzzle/piece18.jpg"));
				pChoice = "";
				a19.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle20() {
		if(pChoice != "") {
			if(pChoice.equals("p20")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b20.setImage(new Image("/puzzle/piece19.jpg"));
				pChoice = "";
				a20.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle21() {
		if(pChoice != "") {
			if(pChoice.equals("p21")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b21.setImage(new Image("/puzzle/piece20.jpg"));
				pChoice = "";
				a21.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle22() {
		if(pChoice != "") {
			if(pChoice.equals("p22")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b22.setImage(new Image("/puzzle/piece21.jpg"));
				pChoice = "";
				a22.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle23() {
		if(pChoice != "") {
			if(pChoice.equals("p23")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b23.setImage(new Image("/puzzle/piece22.jpg"));
				pChoice = "";
				a23.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle24() {
		if(pChoice != "") {
			if(pChoice.equals("p24")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b24.setImage(new Image("/puzzle/piece23.jpg"));
				pChoice = "";
				a24.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	public void addPuzzle25() {
		if(pChoice != "") {
			if(pChoice.equals("p25")) {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/clickBtn.mp3").toString()));
				mp.play();
				b25.setImage(new Image("/puzzle/piece24.jpg"));
				pChoice = "";
				a25.setVisible(false);
				count++;
				if(count ==25) {
					mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
					mp.play();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("성공");
					alert.setHeaderText("성공");
					alert.setContentText("성공입니다");
					alert.showAndWait();
				}
			} else {
				mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
				mp.play();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
			mp.play();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	

}

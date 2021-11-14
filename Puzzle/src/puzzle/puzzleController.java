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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class puzzleController {

	@FXML
	private Button hintBtn;
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
	
	public void addPuzzle1() {
		if(pChoice != "") {
			if(pChoice.equals("p1")) {
				b01.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275.jpg"));
				pChoice = "";
				a01.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b02.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_01.jpg"));
				pChoice = "";
				a02.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b03.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_02.jpg"));
				pChoice = "";
				a03.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b04.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_03.jpg"));
				pChoice = "";
				a04.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b05.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_04.jpg"));
				pChoice = "";
				a05.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b06.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_05.jpg"));
				pChoice = "";
				a06.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b07.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_06.jpg"));
				pChoice = "";
				a07.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b08.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_07.jpg"));
				pChoice = "";
				a08.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b09.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_08.jpg"));
				pChoice = "";
				a09.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b10.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_09.jpg"));
				pChoice = "";
				a10.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b11.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_10.jpg"));
				pChoice = "";
				a11.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b12.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_11.jpg"));
				pChoice = "";
				a12.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b13.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_12.jpg"));
				pChoice = "";
				a13.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b14.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_13.jpg"));
				pChoice = "";
				a14.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b15.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_14.jpg"));
				pChoice = "";
				a15.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b16.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_15.jpg"));
				pChoice = "";
				a16.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b17.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_16.jpg"));
				pChoice = "";
				a17.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b18.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_17.jpg"));
				pChoice = "";
				a18.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b19.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_18.jpg"));
				pChoice = "";
				a19.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b20.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_19.jpg"));
				pChoice = "";
				a20.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b21.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_20.jpg"));
				pChoice = "";
				a21.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b22.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_21.jpg"));
				pChoice = "";
				a22.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b23.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_22.jpg"));
				pChoice = "";
				a23.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b24.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_23.jpg"));
				pChoice = "";
				a24.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
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
				b25.setImage(new Image("/puzzle/KakaoTalk_20211024_160134275_24.jpg"));
				pChoice = "";
				a25.setVisible(false);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("틀림");
				alert.setHeaderText("알맞는 퍼즐이 아닙니다.");
				alert.setContentText("알맞는 퍼즐을 선택 후 도전하세요.");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("선택X");
			alert.setHeaderText("퍼즐을 선택히세요");
			alert.setContentText("퍼즐을 선택하지 않았습니다.");
			alert.showAndWait();
		}
	}
	
	

}

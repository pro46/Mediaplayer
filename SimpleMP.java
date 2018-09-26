
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;



public class SimpleMP extends Application {
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		// Stage.....
		Parent root =  FXMLLoader.load(getClass().getResource("SimpleMVFxml.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primarystage.setTitle("NewFX");
		primarystage.setScene(scene);
		primarystage.show();
		
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent doubleClicked) {
				if(doubleClicked.getClickCount() == 2) {
					primarystage.setFullScreen(true);
					
				}
				else {
					primarystage.setFullScreen(false);
					}
			}
		});
		
		
		
		
		}
		
	}

	
	


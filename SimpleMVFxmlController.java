import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SimpleMVFxmlController implements Initializable {

	@FXML
	private MediaView MV;
	private MediaPlayer mediaplayer;
	private Media media;
	private Label currentTime;
	private Label lastTime;
	
	@FXML
	private Slider volumeSlider; 
	private Slider slider;
	
	@FXML
	private Button fileOpen;
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		media = new Media("SUIT_PUNJABI.mp4");
		mediaplayer = new MediaPlayer(media);
		MV.setMediaPlayer(mediaplayer);
		mediaplayer.setAutoPlay(true);
		 
		 
		 //Resize  player
		
		DoubleProperty width = MV.fitWidthProperty();
		DoubleProperty height = MV.fitHeightProperty();
		width.bind(Bindings.selectDouble(MV.sceneProperty(),"width"));
		height.bind(Bindings.selectDouble(MV.sceneProperty(),"height"));
		
		// Volume slider
		
		volumeSlider.setValue(mediaplayer.getVolume() * 50);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable arg0) {
				mediaplayer.setVolume(volumeSlider.getValue() / 100);			
				}
			
		});
		

		
	
	
		
	}
	
	public void play(ActionEvent event) {
		
		mediaplayer.play();
	}	
	public void pause(ActionEvent event) {
		mediaplayer.pause();
	}
	public void forward(ActionEvent event) {
		mediaplayer.seek(mediaplayer.getCurrentTime().multiply(1.5));
	}
	public void backward(ActionEvent event) {
		mediaplayer.seek(mediaplayer.getCurrentTime().divide(1.5));
	}
	public void mute(ActionEvent event) {
		if(mediaplayer.isMute()) {
		mediaplayer.setMute(false);
		}else {
			mediaplayer.setMute(true);
		}
	}
	
	
	

	
	
	
}

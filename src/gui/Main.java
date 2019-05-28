package gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Curriculum;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CurriculumView.fxml"));
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("VociView.fxml"));
			
			AnchorPane root = (AnchorPane)loader.load();
			AnchorPane root2 = (AnchorPane)loader2.load();
			
			CurriculumController controller = loader.getController();
			Curriculum model = new Curriculum();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("CurriculumVitae");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Scene scene2 = new Scene(root2);
//			Stage secondaryStage = new Stage();
//			secondaryStage.setTitle("Voci");
//			secondaryStage.setScene(scene2);
			controller.setStage(primaryStage);
			controller.setScene(scene, 0);
			controller.setScene(scene2, 1);
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

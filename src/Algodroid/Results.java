package Algodroid;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class Results
{
    public Results(int score)
    {
        AudioClip gameover = new AudioClip(new File("src\\css\\gameover.mp3").toURI().toString());
        gameover.play();
        //making a new stage to display score
        Stage window = new Stage();
        //setting the modality so that user cannot interact with the background window until this one closes
        window.initModality(Modality.APPLICATION_MODAL);

        //adding an icon for the title bar to the stage
        Image image = new Image("icon.png");
        window.getIcons().add(image);

        //setting title of the window as results
        window.setTitle("Results");

        //setting height and width of the window
        window.setMinWidth(300);
        window.setMinHeight(175);

        //passing the parameter to a local variable
        int holder = score;

        //making a label to display the score on the scene
        String score_string = (" " + holder);
        Label label1 = new Label("You have successfully completed the Level!");
        Label label2 = new Label("With a score of" + score_string);

        //BUTTON
        Button ok = new Button("OK");

        //Closing window on click of button
        ok.setOnAction(e ->
        {
            window.close();

        });
        //setting spacing in the layout of vertical box
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label1,label2,ok);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(ConfirmBox.class.getResource("/css/smallbox.css").toExternalForm());//adding style sheet to the scene
        window.setScene(scene);
        window.showAndWait();
        window.setFullScreenExitHint("");
        window.setFullScreen(true);

    }

}

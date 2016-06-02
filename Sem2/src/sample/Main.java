package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<Rectangle> bonuses = new ArrayList<>();
    public static ArrayList<Rectangle> killers = new ArrayList<>();
    Image image = new Image(getClass().getResourceAsStream("2.png"));
    Image image2 = new Image(getClass().getResourceAsStream("1.png"));
    ImageView imageView = new ImageView(image);
    ImageView imageView2 = new ImageView(image2);
    public Character player = new Character(imageView);
    public Character2 player2 = new Character2(imageView2);
    static Pane root = new Pane();


    public void bonus(){
        int random = (int)Math.floor(Math.random()*75);
        int x = (int)Math.floor(Math.random()*600);
        int y = (int)Math.floor(Math.random()*600);
        if(random == 5){
            Rectangle rect = new Rectangle(20,20,Color.BLUE);
            rect.setX(x);
            rect.setY(y);
            bonuses.add(rect);
            root.getChildren().addAll(rect);;
        }
    }
    public void update() {
        if (isPressed1(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveY(-3);
        } else if (isPressed1(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(3);
        } else if (isPressed1(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(3);
        } else if (isPressed1(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(32);
            player.moveX(-3);
        } else{
            player.animation.stop();
        }

        if (isPressed1(KeyCode.W)) {
            player2.animation2.play();
            player2.animation2.setOffsetY(96);
            player2.moveY(-3);
        } else if (isPressed1(KeyCode.S)) {
            player2.animation2.play();
            player2.animation2.setOffsetY(0);
            player2.moveY(3);
        } else if (isPressed1(KeyCode.D)) {
            player2.animation2.play();
            player2.animation2.setOffsetY(64);
            player2.moveX(3);
        } else if (isPressed1(KeyCode.A)) {
            player2.animation2.play();
            player2.animation2.setOffsetY(32);
            player2.moveX(-3);
        } else{
            player2.animation2.stop();
        }
    }

    public boolean isPressed1(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root.setPrefSize(600,600);
        root.getChildren().addAll(player);
        root.getChildren().addAll(player2);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event-> keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> keys.put(event.getCode(), false));


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                bonus();
            }

        };

        timer.start();
        primaryStage.setTitle("Коснись квадрата и произойдет непоправимое");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

package sample;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character2 extends Pane{

    ImageView imageView2;
    int count2 = 3;
    int columns2 = 3;
    int offsetX2 = 0;
    int offsetY2 = 0;
    int width2 = 32;
    int height2 = 32;
    public int score2 = 0;
    Rectangle removeRect2 = null;
    Rectangle removeKill2 = null;
    SpriteAnimation2 animation2;
    public Character2(ImageView imageView){
        this.imageView2 = imageView;
        this.imageView2.setViewport(new Rectangle2D(offsetX2,offsetY2,width2,height2));
        animation2 = new SpriteAnimation2(imageView,Duration.millis(200),count2,columns2,offsetX2,offsetY2,width2,height2);
        getChildren().addAll(imageView2);
    }
    public void moveX(int x){
        boolean right = x > 0 ? true : false;
        for(int i = 0; i < Math.abs(x); i++) {
            if (right) this.setTranslateX(this.getTranslateX() + 1);
            else this.setTranslateX(this.getTranslateX() - 1);
            isBonuseEat();
        }
    }
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) this.setTranslateY(this.getTranslateY() + 1);
            else this.setTranslateY(this.getTranslateY() - 1);
            isBonuseEat();
        }
    }

    public void isBonuseEat(){
        Main.bonuses.forEach((rect) -> {
            if (this.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                removeRect2 = rect;
                score2++;
                if (score2 >= 50) {
                    System.out.println("Мальчик выполнил план!!!");
                }else System.out.println("Очки мальчика: " + score2);
            }
        });

        Main.bonuses.remove(removeRect2);
        Main.root.getChildren().remove(removeRect2);
    }
}
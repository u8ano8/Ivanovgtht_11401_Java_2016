package sample;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class SpriteAnimation2  extends Transition{
    private final ImageView imageView2;
    private final int count2;
    private final int columns2;
    private int offsetX2;
    private int offsetY2;
    private final int width2;
    private final int height2;

    public SpriteAnimation2(
            ImageView imageView,
            Duration duration,
            int count, int columns,
            int offsetX, int offsetY,
            int width, int height
    ){
        this.imageView2 = imageView;
        this.count2 = count;
        this.columns2 = columns;
        this.offsetX2 = offsetX;
        this.offsetY2 = offsetY;
        this.width2 = width;
        this.height2 = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView2.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

    }
    public void setOffsetX(int x){
        this.offsetX2 = x;
    }
    public void setOffsetY(int y){
        this.offsetY2 = y;
    }
    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(count2*frac), count2-1);
        final int x = (index%columns2)*width2+offsetX2;
        final int y = (index/columns2)*height2+offsetY2;
        imageView2.setViewport(new Rectangle2D(x, y, width2, height2));
    }
}

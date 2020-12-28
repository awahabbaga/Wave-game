import java.awt.Color;
import java.awt.*;
import java.util.Random; 


public class Player extends GameObject{
    Random r = new Random();
    Handler handler;
    public Player(int x,int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;

       // velX = r.nextInt(5) + 1;
        //velY = r.nextInt(5);
    }

    

    public void tick(){
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
        
        collision();
    }

    private void collision(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tmpObject = handler.objects.get(i);

            if (tmpObject.getId() == ID.BasicEnemy || tmpObject.getId() == ID.FastEnemy) {
                
                if (getBounds().intersects(tmpObject.getBounds())) {
                    //Collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}

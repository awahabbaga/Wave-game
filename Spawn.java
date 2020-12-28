import java.util.Random;

public class Spawn {
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
         this.handler = handler;
         this.hud = hud;
        
    }

    public void tick() {
        scoreKeep++;

        if(scoreKeep >= 500){
            scoreKeep = 0;
             hud.level(hud.getLevel() + 1);


            if(hud.getLevel() <=  4) handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            else handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }
 
    }
}

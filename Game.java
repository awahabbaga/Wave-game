import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = -1442798787354930462L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; 
    private Thread thread ;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawn;
    private boolean running = false; 

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

         new Window(WIDTH, HEIGHT, "Wave", this);
         hud = new HUD();
         spawn = new Spawn(handler, hud);
        r = new  Random();
        
        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
 
        //handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2));
        //for(int i = 0; i < 20; i++)
        
    }
	public synchronized void start(){
        thread = new Thread(this);
        thread.start(); 
        running = true;
    }

    public synchronized void stop(){
       try{ 
           thread.join();

           running = false; 
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60   ;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                tick();
                delta--;
            }

            if (running) 
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }

            
        }
         stop(); 
    }


    private void tick() {
        handler.tick();
        hud.tick();
        spawn.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        
        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }
    public static void main(String[] args) {
        new Game();
    }
}
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for Player 1

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
                    tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
                    tempObject.setVelY(5);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(5);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(-5);

            }

            /**
             * if (tempObject.getId() == ID.Player2) { // key events for Player 2
             * 
             * if (key == KeyEvent.VK_UP ) tempObject.setVelY(-5); if (key ==
             * KeyEvent.VK_DOWN) tempObject.setVelY(5); if (key == KeyEvent.VK_RIGHT)
             * tempObject.setVelX(5); if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
             * 
             * }
             */
        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for Player 1

                if (key == KeyEvent.VK_W)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_A)
                    tempObject.setVelX(0);

            }

            /**
             * if (tempObject.getId() == ID.Player2) { // key events for Player 2
             * 
             * if (key == KeyEvent.VK_UP ) tempObject.setVelY(0); if (key ==
             * KeyEvent.VK_DOWN) tempObject.setVelY(0); if (key == KeyEvent.VK_RIGHT)
             * tempObject.setVelX(0); if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
             * 
             * }
             */

        }

    }
}

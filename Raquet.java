public class Raquet {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static final int Y = 330;

    public Raquet(MiniTennis game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xspd;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xspd = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xspd = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xspd = game.speed;
    }
}


// **Bloque 1: Importación de Librerías**

// importamos librerias
import java.awt.*;
import java.awt.event.*;
// para manejar listas
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.*;
import java.net.URI;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// **Bloque 2: Declaración de la clase principal GameOfLife**

// Declaración de la clase principal, que extiende JFrame y
// implementa ActionListener para manejar eventos.
public class GameOfLife extends JFrame implements ActionListener {

  // Constantes para el tamaño de la ventana y tamaño de bloque.
  private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);
  private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(400, 400);
  private static final int BLOCK_SIZE = 10;

  // Elementos de la interfaz de usuario
  private final JMenuBar mb_menu;
  private final JMenu m_file;
  private final JMenu m_game;
  private final JMenu m_help;
  private final JMenuItem mi_file_options;
  private final JMenuItem mi_file_exit;
  private final JMenuItem mi_game_play;
  private final JMenuItem mi_game_autofill;
  private final JMenuItem mi_game_stop;
  private final JMenuItem mi_game_reset;
  private final JMenuItem mi_help_about;
  // Velocidad de los movimientos del juego (por defecto)
  private int i_movesPerSecond = 3;
  // Tablero de juego y hilo para la simulación
  private final GameBoard gb_gameBoard;
  // PARA HACERLO ASINCRONO
  private Thread game;

  public static void main(String[] args) {
    // unir elementos graficos
    JFrame game = new GameOfLife();
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setTitle("Conway's Game of Life");
    ImageIcon img = new ImageIcon("logo.png");
    game.setIconImage(img.getImage());
    game.setSize(DEFAULT_WINDOW_SIZE);
    game.setMinimumSize(MINIMUM_WINDOW_SIZE);
    game.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - game.getWidth()) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - game.getHeight()) / 2);
    game.setVisible(true);

  }

  // **Bloque 3: Constructor de la Clase GameOfLife y Configuración de Menús**

  // Constructor de la clase GameOfLife
  public GameOfLife() {

    // construir nuestros menus
    // Inicialización de elementos de la interfaz de usuario
    mb_menu = new JMenuBar();
    setJMenuBar(mb_menu);
    m_file = new JMenu("File");
    mb_menu.add(m_file);
    m_game = new JMenu("Game");
    mb_menu.add(m_game);
    m_help = new JMenu("Help");
    mb_menu.add(m_help);

    // poner las items de cada menu
    // para File
    mi_file_options = new JMenuItem("Options");
    mi_file_options.addActionListener(this);
    mi_file_exit = new JMenuItem("Exit");
    mi_file_exit.addActionListener(this);
    m_file.add(mi_file_options);
    m_file.add(new JSeparator());
    m_file.add(mi_file_exit);
    // para Game
    mi_game_autofill = new JMenuItem("Autofill");
    mi_game_autofill.addActionListener(this);
    mi_game_play = new JMenuItem("Play");
    mi_game_play.addActionListener(this);
    mi_game_stop = new JMenuItem("Stop");
    mi_game_stop.setEnabled(false);
    mi_game_stop.addActionListener(this);
    mi_game_reset = new JMenuItem("Reset");
    mi_game_reset.addActionListener(this);
    m_game.add(mi_game_autofill);
    m_game.add(new JSeparator());
    m_game.add(mi_game_play);
    m_game.add(mi_game_stop);
    m_game.add(mi_game_reset);
    // Elementos de menú para Help
    mi_help_about = new JMenuItem("About");
    mi_help_about.addActionListener(this);
    m_help.add(mi_help_about);

    // Setup game board
    gb_gameBoard = new GameBoard();
    add(gb_gameBoard);

    // Reproducción de un archivo de sonido (TheMandalorian.wav)
    try {
      Clip sonido = AudioSystem.getClip();
      sonido.open(AudioSystem.getAudioInputStream(new File("TheMandalorian.wav")));
      sonido.start();
    } catch (Exception e) {
      System.out.println("" + e);
    }

  }

// **Bloque 4: Métodos para el control del juego y eventos**

//  Método para controlar si el juego se está ejecutando o deteniendo
  public void setGameBeingPlayed(boolean isBeingPlayed) {
    if (isBeingPlayed) {
      mi_game_play.setEnabled(false);
      mi_game_stop.setEnabled(true);
      game = new Thread(gb_gameBoard);
      game.start();
    } else {
      mi_game_play.setEnabled(true);
      mi_game_stop.setEnabled(false);
      game.interrupt();
    }

  }
// Método para la manipulación de la velocidad del juego y otros elementos
  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource().equals(mi_file_exit)) {
      // Cierra la aplicación si se hace clic en "Exit"
      System.exit(0);
    } else if (ae.getSource().equals(mi_file_options)) {
      // Abre una ventana de opciones para ajustar la velocidad del juego
      final JFrame f_options = new JFrame();
      f_options.setTitle("Options");
      f_options.setSize(300, 100);
      f_options.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f_options.getWidth()) / 2,
          (Toolkit.getDefaultToolkit().getScreenSize().height - f_options.getHeight()) / 2);
      f_options.setResizable(false);
      JPanel p_options = new JPanel();
      p_options.setOpaque(false);
      f_options.add(p_options);
      p_options.add(new JLabel("Number of moves per second:"));
      Integer[] secondOptions = { 1, 2, 3, 4, 5, 10, 15, 20 };
      final JComboBox cb_seconds = new JComboBox(secondOptions);
      p_options.add(cb_seconds);
      cb_seconds.setSelectedItem(i_movesPerSecond);
      cb_seconds.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          i_movesPerSecond = (Integer) cb_seconds.getSelectedItem();
          f_options.dispose();
        }
      });
      f_options.setVisible(true);
    }

    else if (ae.getSource().equals(mi_game_autofill)) {
      // Abre una ventana para elegir el porcentaje de celdas llenas en el tablero
      final JFrame f_autoFill = new JFrame();
      f_autoFill.setTitle("Autofill");
      f_autoFill.setSize(360, 60);
      f_autoFill.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f_autoFill.getWidth()) / 2,
          (Toolkit.getDefaultToolkit().getScreenSize().height - f_autoFill.getHeight()) / 2);
      f_autoFill.setResizable(false);
      JPanel p_autoFill = new JPanel();
      p_autoFill.setOpaque(false);
      f_autoFill.add(p_autoFill);
      p_autoFill.add(new JLabel("What percentage should be filled? "));
      Object[] percentageOptions = { "Select", 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 95 };
      final JComboBox cb_percent = new JComboBox(percentageOptions);
      p_autoFill.add(cb_percent);
      cb_percent.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (cb_percent.getSelectedIndex() > 0) {
            gb_gameBoard.resetBoard();
            gb_gameBoard.randomlyFillBoard((Integer) cb_percent.getSelectedItem());
            f_autoFill.dispose();
          }
        }
      });
      f_autoFill.setVisible(true);
    } else if (ae.getSource().equals(mi_game_reset)) {
      // Resetea el tablero del juego
      gb_gameBoard.resetBoard();
      gb_gameBoard.repaint();

    } else if (ae.getSource().equals(mi_game_play)) {
      // Inicia el juego
      setGameBeingPlayed(true);
    } else if (ae.getSource().equals(mi_game_stop)) {
      // Detiene el juego
      setGameBeingPlayed(false);
    }

    else if (ae.getSource().equals(mi_help_about)) {
      // Abre un enlace web o muestra información sobre el juego
      Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
      try {
        desktop.browse(new URI("https://www.youtube.com/watch?v=OWXD_wJxCKQ"));
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
            "Conway's game of life was a cellular animation devised by the mathematician John Conway", "Source",
            JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }

  // **Bloque 5: Clase Interna GameBoard - Representación del Tablero de Juego**

  // Clase interna GameBoard: representa el tablero de juego y contiene la lógica y el comportamiento del juego
  private class GameBoard extends JPanel implements ComponentListener, MouseListener, MouseMotionListener, Runnable {
    private Dimension d_gameBoardSize = null;
    private final ArrayList<Point> point = new ArrayList<Point>(0);

    // Constructor de GameBoard
    public GameBoard() {
      addComponentListener(this);
      addMouseListener(this);
      addMouseMotionListener(this);
    }

    // Método para resetear el tablero del juego
    public void resetBoard() {
      point.clear();
    }

    // Método para actualizar el tamaño del array en función del tamaño de la ventana
    private void updateArraySize() {
      ArrayList<Point> removeList = new ArrayList<Point>(0);
      for (Point current : point) {
        if ((current.x > d_gameBoardSize.width - 1) || (current.y > d_gameBoardSize.height - 1)) {
          removeList.add(current);
        }
      }
      point.removeAll(removeList);
      repaint();
    }

    // Método para eliminar una celda en las coordenadas (x, y)
    public void removePoint(int x, int y) {
      point.remove(new Point(x, y));
    }

    // metodos de agregacion de mi array list
    // Método para agregar una celda en las coordenadas (x, y)
    public void addPoint(int x, int y) {
      if (!point.contains(new Point(x, y))) {
        point.add(new Point(x, y));
      }
      repaint();
    }

    // Método para agregar una celda en función de la posición del mouse
    public void addPoint(MouseEvent me) {
      int x = me.getPoint().x / BLOCK_SIZE - 1;
      int y = me.getPoint().y / BLOCK_SIZE - 1;
      if ((x >= 0) && (x < d_gameBoardSize.width) && (y >= 0) && (y < d_gameBoardSize.height)) {
        addPoint(x, y);
      }
    }

    // Método para llenar el tablero de juego de manera aleatoria con un cierto porcentaje
    public void randomlyFillBoard(int percent) {
      for (int i = 0; i < d_gameBoardSize.width; i++) {
        for (int j = 0; j < d_gameBoardSize.height; j++) {
          if (Math.random() * 100 < percent) {
            addPoint(i, j);
          }
        }
      }
    }

    // Dibuja el tablero y sus celdas
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // Dibuja las celdas vivas en el tablero
      try {
        for (Point newPoint : point) {
          g.setColor(Color.blue);
          g.fillRect(BLOCK_SIZE + (BLOCK_SIZE * newPoint.x), BLOCK_SIZE + (BLOCK_SIZE * newPoint.y), BLOCK_SIZE,
              BLOCK_SIZE);
        }
      } catch (ConcurrentModificationException cme) {
      }

      // conf nuestro grid
      // Dibuja las líneas de la cuadrícula
      g.setColor(Color.BLACK);
      for (int i = 0; i <= d_gameBoardSize.width; i++) {
        g.drawLine(((i * BLOCK_SIZE) + BLOCK_SIZE), BLOCK_SIZE, (i * BLOCK_SIZE) + BLOCK_SIZE,
            (BLOCK_SIZE * d_gameBoardSize.height));
      }

      for (int i = 0; i <= d_gameBoardSize.height; i++) {
        g.drawLine(BLOCK_SIZE, ((i * BLOCK_SIZE) + BLOCK_SIZE), (BLOCK_SIZE * d_gameBoardSize.width + 1),
            ((i * BLOCK_SIZE) + BLOCK_SIZE));
      }

    }

    // Métodos de la interfaz ComponentListener
    @Override
    public void componentResized(ComponentEvent e) {
      d_gameBoardSize = new Dimension(getWidth() / BLOCK_SIZE - 2, getHeight() / BLOCK_SIZE - 2);
      updateArraySize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      addPoint(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      addPoint(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    // **Bloque 6: Lógica del Juego en la Clase GameBoard**

    // Método run que ejecuta la lógica de la simulación del juego
    @Override
    public void run() {

      // Crear una matriz booleana que representa el estado del juego
      boolean[][] gameBoard = new boolean[d_gameBoardSize.width + 2][d_gameBoardSize.height + 2];
      // Transferir las celdas vivas del ArrayList a la matriz
      for (Point current : point) {
        gameBoard[current.x + 1][current.y + 1] = true;
      }

      // Lista para almacenar las celdas sobrevivientes después de una generación
      ArrayList<Point> survivingCells = new ArrayList<Point>(0);

      // REGLAS DEL JUEGO DE LA VIDA
      for (int i = 1; i < gameBoard.length - 1; i++) {
        for (int j = 1; j < gameBoard[0].length - 1; j++) {
          int surrounding = 0;
          if (gameBoard[i - 1][j - 1]) {
            surrounding++;
          }
          if (gameBoard[i - 1][j]) {
            surrounding++;
          }
          if (gameBoard[i - 1][j + 1]) {
            surrounding++;
          }

          if (gameBoard[i][j - 1]) {
            surrounding++;
          }
          if (gameBoard[i][j + 1]) {
            surrounding++;
          }

          if (gameBoard[i + 1][j - 1]) {
            surrounding++;
          }
          if (gameBoard[i + 1][j]) {
            surrounding++;
          }
          if (gameBoard[i + 1][j + 1]) {
            surrounding++;
          }

          if (gameBoard[i][j]) {
            if ((surrounding == 2) || (surrounding == 3)) {
              survivingCells.add(new Point(i - 1, j - 1));
            }
          } else {
            if (surrounding == 3) {
              survivingCells.add(new Point(i - 1, j - 1));
            }
          }

        }
      }

      // Reiniciar el tablero y actualizar con las celdas sobrevivientes
      resetBoard();
      point.addAll(survivingCells);
      repaint();

      try {
        // Esperar antes de la siguiente generación según la velocidad configurada
        Thread.sleep(1000 / i_movesPerSecond);
        run();
      } catch (InterruptedException e) {
      }

    }

  }

}

package queens;
//Helin Kerpeten S000738
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game {
	static int dimension =8;
	static Scanner scanner=new Scanner(System.in);
	static JFrame frame;
	static JPanel panel;
	static JPanel sidePanel;
	static Game game;
	private static MyButtonListener listener;
	static JButton [][]  square= new JButton[dimension][dimension]; 
	static String lastChoice=null;
	static Solver lastSolver;
	static int index=0;
	static JLabel label;
	static JLabel label2;
	ArrayList<Board> lastSolutions;
	public Game(){
		listener= new MyButtonListener();
		createGUI();
		
	}
	public static void main(String[] args) {
		Game game=new Game();
	}

	public static void createGUI() {
		JFrame frame = new JFrame("Chess Puzzle");
		frame.setSize(1100, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(300, 900));
		sidePanel.setBackground(Color.PINK);
		sidePanel.setLayout(new FlowLayout());
		label=new JLabel();
		label.setPreferredSize(new Dimension(220,50));
		sidePanel.add(label);
		label2=new JLabel();
		label2.setPreferredSize(new Dimension(220,50));
		sidePanel.add(label2);
		createPanel(frame);
		createBoardGUI(panel);
		createButtons(sidePanel);
		label.setOpaque(true);
		label2.setOpaque(true);
		sidePanel.add(label);
		sidePanel.add(label2);

		frame.add(sidePanel,BorderLayout.EAST);
		frame.setVisible(true);
	}
	public static void createPanel(JFrame frame) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(dimension,dimension));
		frame.add(panel ,BorderLayout.WEST);

	}
	public static void createButtons(JPanel sidePanel) {
		JButton queenChoice = new JButton("NQueen Solutions" );
		JButton rooksChoice = new JButton("Rooks Solutions" );
		JButton bishopChoice = new JButton("Bishops Solutions" );
		JButton kingChoice = new JButton("Kings Solutions" );
		JButton next = new JButton("Next" );
		queenChoice.addActionListener(listener);
		rooksChoice.addActionListener(listener);
		bishopChoice.addActionListener(listener);
		kingChoice.addActionListener(listener);
		next.addActionListener(listener);
		queenChoice.setPreferredSize(new Dimension(220,70));
		rooksChoice.setPreferredSize(new Dimension(220,70));
		bishopChoice.setPreferredSize(new Dimension(220,70));
		kingChoice.setPreferredSize(new Dimension(220,70));
		next.setPreferredSize(new Dimension(220,70));
		sidePanel.add(queenChoice);
		sidePanel.add(rooksChoice);
		sidePanel.add(bishopChoice);
		sidePanel.add(kingChoice);
		sidePanel.add(next);
	}

	public static void createBoardGUI(JPanel panel) {
		square= new JButton[dimension][dimension];
		for(int i=0 ;i<dimension;i++){
			for (int j = 0; j <dimension; j++){
				JButton b = new JButton("" );
				b.setPreferredSize(new Dimension(100,100));
				square[i][j]=b;
				if ((i+j)%2 == 0) //switches between black and white squares
					b.setBackground(Color.WHITE);
				else
					b.setBackground(Color.BLACK);

				panel.add(b);

			}
		}
	}

	public static void printSolutions( ArrayList<Board> solutionBoards) {
		panel.removeAll();
		panel.setLayout(new GridLayout(dimension,dimension));
		createBoardGUI(panel);
		solutionBoards.get(index).printBoardWithGUI(square,game);;
	}

	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String text =b.getText();
			if(text.equals("Next")){
				index++;
				if(index>lastSolutions.size())
					index=0;
				printSolutions(lastSolutions) ;
			}else{
				index=0;
				 if(text.equals("Rooks Solutions")) {
					 dimension=8;
					lastSolver=new RooksSolver();
					lastChoice=b.getText();
					lastSolutions=(ArrayList<Board>)lastSolver.getAllSolutionsFor(dimension);
					printSolutions(lastSolutions) ;
				}
				else if(text.equals("Bishops Solutions")) {
					 dimension=8;
					lastSolver=new BishopsSolver();
					lastChoice=b.getText();
					lastSolutions=(ArrayList<Board>)lastSolver.getAllSolutionsFor(dimension);
					printSolutions(lastSolutions) ;
				}else if(text.equals("Kings Solutions")) {
					 dimension=8;
					lastSolver=new KingsSolver();
					JOptionPane.showConfirmDialog(null, "Sorry i couldnt solve kings puzzle.");
				}else if(text.equals("NQueen Solutions")){
					lastSolver=new NQueensSolver();
					String dimensionLine= JOptionPane.showInputDialog("Please enter dimension");
					dimension=Integer.parseInt(dimensionLine);
					lastSolutions=(ArrayList<Board>)lastSolver.getAllSolutionsFor(dimension);
					printSolutions(lastSolutions) ;
				}
					
				index++;
			}
			label.setText("There are "+lastSolutions.size()+
					" solutions. ");
			label2.setText("Showing solution is "+index);
		}

	}
}

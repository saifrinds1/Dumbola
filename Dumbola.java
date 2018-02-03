/* 
 * Author : 
 * Saifudeen Masood  (saifrinds1@gmail.com)
 * Engr. Janzaib Masood  (janzaibaloch786@gmail.com)
 * GitHub : "N/A" 
 */

/*
 * Project libraries
 */
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * Main script of project "Dumbola"
 */
public class Dumbola extends JFrame {

	// RadioButton array that will be shown on the screen
	JRadioButton[][] radioButtons = new JRadioButton[10][10];

	// Initialize Label lblPlayerTurn
	JLabel lblPlayerTurn;

	// Initialize Label lblPlayersReamaining
	JLabel lblPlayersRemaining;

	// ButtonGroup this make only one RadioButton checkable at a time from the
	// "radioButtons"
	ButtonGroup groupRadioButton = new ButtonGroup();

	/*
	 * Array of Player Object it will each individual player information such as
	 * (String playerName, int playerSecretNumber, boolean isEliminated)
	 */
	Player[] player;

	// Initialize boolean gameStatus and set its value to false
	boolean gameStatus = false;

	// Initialize int playerTurn and set its value to 0
	int playerTurn = 0;

	// Initialize int numberOfPlayers and set its value to 0
	int numberOfPlayers = 0;

	// Main method of "Dumbola" Class
	public static void main(String[] args) {
		new Dumbola();
	}

	/*
	 * Method Dumbola Configures the MainWindow and interacts with the players and
	 * more
	 */
	public Dumbola() {
		// Setting MainWindow Size (Width, Height)
		this.setSize(446, 372);

		// Setting MainWindow Title(title)
		this.setTitle("Dumbola");

		// Initialize Toolkit tk
		Toolkit tk = Toolkit.getDefaultToolkit();

		// Initialize dim and set its Dimension to "tk.getScreenSize" which is the
		// "MainScreenResolution"
		Dimension dim = tk.getScreenSize();

		// This is for testing purpose feel free to Check
		/*
		 * System.out.println("Width : " + dim.width + ", Height : " + dim.height);
		 * System.out.println("Window Width : " + this.getWidth() +
		 * ", Window Height : "+ this.getHeight());
		 */

		// Initialize integer xPos and set its value to ((dim.width / 2) -
		// (this.getWidth() / 2))
		int xPos = ((dim.width / 2) - (this.getWidth() / 2));
		// Initialize integer yPos and set its value to ( (dim.height / 2) -
		// (this.getHeight() / 2) )
		int yPos = ((dim.height / 2) - (this.getHeight() / 2));

		/*
		 * In above two lines of code the variable xPos and yPox have been given values
		 * that when you set MainWindow Location to (xPos, yPos) it will be visble at
		 * the center of the MainScreen
		 */

		// setting MainWindow location to (xPos, yPos)
		this.setLocation(xPos, yPos);

		// ########################################## ???????????????
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initializing a MenuBar("A component that is shown on top a ApplicationWindow
		// on which different Menus are shown ") menuBar
		JMenuBar menuBar = new JMenuBar();
		// Setting MainWindow MenuBar to menuBar
		this.setJMenuBar(menuBar);

		// Initialize a Menu mnGame and set its title to ("Game")
		JMenu mnGame = new JMenu("Game");
		// add Menu mnGame to MenuBar menuBar
		menuBar.add(mnGame);

		// Initialize a MenuItem mntmNewGame and set its title to ("New Game")
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		// add MenuItem mntmNewGame to Menu mnGame
		mnGame.add(mntmNewGame);

		// Set MouseListener for MenuItem mntmNewGame
		mntmNewGame.addMouseListener(new MouseListener() {

			/*
			 * When status mouse changes on top MenuItem mntmNewGame one of the below coded
			 * Method is called. But we will on only use the Method "mousePressed".
			 */

			public void mouseClicked(MouseEvent arg0) {

			}

			public void mouseEntered(MouseEvent arg0) {

			}

			public void mouseExited(MouseEvent arg0) {

			}

			// This Method is called when user pressedMouse on top of MenuItem mntmNewGame
			public void mousePressed(MouseEvent e) {

				// If leftMouseButton is pressed
				if (e.getButton() == MouseEvent.BUTTON1) {
					JLabel lblNPlayers = new JLabel("Number of players : ");
					JTextField nPlayers = new JTextField();
					Box box = Box.createHorizontalBox();
					box.add(lblNPlayers);
					box.add(nPlayers);
					int result = JOptionPane.showConfirmDialog(null, box, "New Game", JOptionPane.OK_CANCEL_OPTION);
					System.out.println(nPlayers.getText());

					int numPlayers = 0;
					if (result == 0) {

						numPlayers = Integer.parseInt(nPlayers.getText());

					} else if (!(result == 0)) {

						return;
					}
					// else if ( 2 is greaterThan changeStringToInt(str) and lessThan 100)
					else if (numPlayers < 2 || numPlayers > 100) {
						// Show messageDialog(message = "Invalid input.", title = "Error", icon =
						// errorIcon)
						JOptionPane.showMessageDialog(mntmNewGame, "Invalid input!", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Set Player Array length to StringToInteger(str)
					player = new Player[numPlayers];

					Box bigBox = Box.createVerticalBox();
					Box box2 = Box.createHorizontalBox();
					box.removeAll();
					box.add(new JLabel("Name : "));
					JTextField tempTextField = new JTextField();
					box.add(tempTextField);
					bigBox.add(box);
					box2.add(new JLabel("Secret# : "));
					JPasswordField tempTextField1 = new JPasswordField();
					box2.add(tempTextField1);
					bigBox.add(box2);

					// Repeat player.length number of times
					for (int a = 0; a < player.length; a++) {
						tempTextField.setText("");
						tempTextField1.setText("");
						player[a] = new Player();
						int secretNumber;
						result = JOptionPane.showConfirmDialog(null, bigBox, "Player " + a + " info",
								JOptionPane.OK_CANCEL_OPTION);
						try {
							secretNumber = Integer.parseInt(tempTextField1.getText());
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(mntmNewGame, "Invalid input!", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (tempTextField.getText().length() < 1) {
							// Show messageDialog(message = "Invalid input.", title = "Error", icon =
							// errorIcon)
							JOptionPane.showMessageDialog(mntmNewGame, "Invalid input!", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						if (!(result == 0)) {
							return;
						} else if (secretNumber <= 100 && secretNumber > 0) {

							int tempVariable = 1;
							for (int j = 0; j < a; j++) {

								if (player[j].getPlayerSecretNumber() == secretNumber) {
									tempVariable++;
								}

							}

							if (numPlayers > tempVariable) {
								player[a].setPlayerSecretNumber(secretNumber);
								player[a].setPlayerName(tempTextField.getText());
							} else {
								JOptionPane.showMessageDialog(mntmNewGame, "Duplicate SecretNumbers!", "Draw",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}

						else if (secretNumber > 100 || secretNumber < 1) {

							int dialogReturn = JOptionPane.showConfirmDialog(mntmNewGame,
									"Invalid input!\nDo you want to try again?");
							if (!(dialogReturn == 0))
								return;
							else
								a--;

						}
					}

				}

				for (int k = 0; k < player.length; k++) {
					System.out.println(player[k].toString());
					newGameStarted();
				}
			}

			public void mouseReleased(MouseEvent arg0) {

			}

		});

		// Initialize a MenuItem mntmExit and set its title to ("Exit")
		JMenuItem mntmExit = new JMenuItem("Exit");
		// add MenuItem mntmExit to Menu mnGame
		mnGame.add(mntmExit);

		// SetMouseListener For MenuItem mntmExit
		mntmExit.addMouseListener(new MouseListener() {

			/*
			 * When status mouse changes on top MenuItem mntmExit one of the below coded
			 * Method is called. But we will on only use the Method "mousePressed".
			 */

			public void mouseClicked(MouseEvent arg0) {

			}

			public void mouseEntered(MouseEvent arg0) {

			}

			public void mouseExited(MouseEvent arg0) {

			}

			// This Method is called when user pressedMouse on top of MenuItem mntmExit
			public void mousePressed(MouseEvent e) {
				// If leftMouseButton is pressed
				if (e.getButton() == MouseEvent.BUTTON1) {

					Object[] options = { "Exit", "Cancel" };

					// If confirmDialog returns true
					if (JOptionPane.showOptionDialog(mntmExit,
							"Are you sure you want to exit?\nYour game will be lost.", "Warning",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == 0)
						// Exit Application
						System.exit(0);
				}
			}

			public void mouseReleased(MouseEvent arg0) {

			}

		});

		// Initialize a Menu mnHelp and set its title to "Help"
		JMenu mnHelp = new JMenu("Help");

		// Add Menu mnHelp to MenuBar menuBar
		menuBar.add(mnHelp);

		// Initialize MenuItem mntmRules and set its title to "Rules"
		JMenuItem mntmRules = new JMenuItem("Rules");
		// Add MenuItem mntmRules to Menu mnHelp
		mnHelp.add(mntmRules);

		// Initialize MenuItem mntmWebsite and set its title to "Website"
		JMenuItem mntmWebsite = new JMenuItem("Website");
		// Add MenuItem mntmWebsite to Menu mnHelp
		mnHelp.add(mntmWebsite);

		// Initialize MenuItem mntmGithub and set its title to "GitHub"
		JMenuItem mntmGithub = new JMenuItem("GitHub");
		// Add MenuItem mntmGithub to Menu mnHelp
		mnHelp.add(mntmGithub);

		// Initialize GridBagLayout gridBagLayout
		GridBagLayout gridBagLayout = new GridBagLayout();
		// Computer generated paragraph that sets the layout of GridBagLayout
		// gridBagLayout
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };

		// Sets MainWindow Layout system to GridBagLayout gridBagLayout
		this.getContentPane().setLayout(gridBagLayout);

		// Initialize Label lblEliminateANumber and set its text to "Eliminate a Number"
		JLabel lblEliminateANumber = new JLabel("Eliminate a Number");

		// Computer generated paragraph for layout purpose
		GridBagConstraints gbc_lblEliminateANumber = new GridBagConstraints();
		gbc_lblEliminateANumber.gridwidth = 10;
		gbc_lblEliminateANumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEliminateANumber.gridx = 0;
		gbc_lblEliminateANumber.gridy = 0;
		getContentPane().add(lblEliminateANumber, gbc_lblEliminateANumber);

		// Initialize Box veticalBox
		Box verticalBox = Box.createVerticalBox();

		// Initialize Border openBoder and set it titledBorder("Numbers")
		Border operBorder = BorderFactory.createTitledBorder("Numbers");

		// set Box verticalBox Border to operBorder
		verticalBox.setBorder(operBorder);

		// Computer generated paragraph for layout purpose
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.fill = GridBagConstraints.BOTH;
		gbc_verticalBox.gridheight = 10;
		gbc_verticalBox.gridwidth = 10;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 0;
		gbc_verticalBox.gridy = 1;

		// Initialize a Array of Box horizontalBoxes and set its length to 10
		Box[] horizontalBoxes = new Box[10];

		// Initialize integer c and set its value to 1
		int c = 1;

		// repeat 10 times
		for (int i = 0; i < 10; i++) {

			// set Box horizontalBoxes[i] orientation to horizontal
			horizontalBoxes[i] = Box.createHorizontalBox();

			// repeat 10 times
			for (int ii = 0; ii < 10; ii++) {

				// set RadioButton radioButtons[i][ii] to new RadioButton
				radioButtons[i][ii] = new JRadioButton();
				// add RadioButton radioButons[i][ii] to ButtonGroup groupRadioButton
				groupRadioButton.add(radioButtons[i][ii]);
				// set RadioButton radioButtons[i][ii] text to intToString(c, 2)
				radioButtons[i][ii].setText(intToString(c, 2));
				ListenForRadioButton lForRadioButton = new ListenForRadioButton();
				radioButtons[i][ii].addActionListener(lForRadioButton);////////////////////////////////////////////////////////////////////////

				// and RadioButton radioButtons[i][ii] to Box horizontalBoxes[i]
				horizontalBoxes[i].add(radioButtons[i][ii]);
				// Increase integer c value by one
				c++;
			}
			// add Box horizontalBoxes[i] to Box verticalBox
			verticalBox.add(horizontalBoxes[i]);
		}

		// add Box verticalBox to MainWindow
		this.getContentPane().add(verticalBox, gbc_verticalBox);

		// Initialize Label lblPlayerTurn and set its text to "Player x Turn"
		lblPlayerTurn = new JLabel("Player x Turn");
		// Computer generated paragraph for Layout purpose of Label lblPlayerTurn
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 11;

		// add Label lblPlayerTurn to MainWindow
		this.getContentPane().add(lblPlayerTurn, gbc_lblNewLabel);

		// Initialize Label lblPlayersLeft and set its text to "Players Left"
		lblPlayersRemaining = new JLabel("Players Ramaining.");
		// Computer generated paragraph for Layout purpose of Label lblPlayersLeft
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.gridwidth = 5;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 5;
		gbc_label.gridy = 11;

		// add Label lblPlayersLeft to MainWindow
		this.getContentPane().add(lblPlayersRemaining, gbc_label);

		// Make MainWindow Visible
		this.setVisible(true);

	}

	// sets up a new game.
	protected void newGameStarted() {
		gameStatus = true;
		playerTurn = 0;
		numberOfPlayers = player.length;
		groupRadioButton.clearSelection();

		for (int i = 0; i < 10; i++)
			for (int ii = 0; ii < 10; ii++)
				radioButtons[i][ii].setEnabled(true);

		updateStatus();
	}

	protected int playerRemaining() {
		int j = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (!player[i].isEliminated()) {
				j++;
			}
		}
		lblPlayersRemaining.setText("Players Remaining : " + j);
		return j;
	}

	/*
	 * This method changes integer to String and keeps the length of the string to
	 * what user wishes
	 */
	public static String intToString(int integer, int stringLength) {

		// Initialize String str and set its value (integer+"")
		String str = integer + "";

		// If str length is lessThan stringLength
		if (str.length() < stringLength) {

			// Initialize integer diff and set its value to (stringLength - str.length())
			int diff = stringLength - str.length();

			// repeat integer diff number of times
			for (int i = 0; i < diff; i++) {

				// set String str value to("0"+str)
				str = "0" + str;
			}
		}

		// return String str
		return str;
	}

	private void nextPlayer() {
		for (int i = 0; i < numberOfPlayers; i++) {

			if (playerTurn == numberOfPlayers - 1) {
				playerTurn = 0;
				if (!player[playerTurn].isEliminated())
					break;
			} else {
				playerTurn++;
				if (!player[playerTurn].isEliminated())
					break;
			}

		}
	}

	private void gameOver() {
		player = null;
		numberOfPlayers = 0;
		for (int i = 0; i < 10; i++)
			for (int ii = 0; ii < 10; ii++)
				radioButtons[i][ii].setEnabled(false);
		groupRadioButton.clearSelection();
		gameStatus = false;
		lblPlayerTurn.setText("Player " + "x" + " turn");
		playerRemaining();
	}

	private void updateStatus() {
		lblPlayerTurn.setText("Player " + player[playerTurn].getPlayerName() + " turn");
		playerRemaining();
	}

	private class ListenForRadioButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (gameStatus) {
				String tempString = "";
				for (int i = 0; i < 10; i++) {
					for (int ii = 0; ii < 10; ii++) {

						if (e.getSource() == radioButtons[i][ii]) {
							radioButtons[i][ii].setEnabled(false);
							for (int p = 0; p < numberOfPlayers; p++) {
								if (player[p].getPlayerSecretNumber() == Integer
										.parseInt(radioButtons[i][ii].getText())) {
									tempString = player[p].getPlayerName();
									player[p].setEliminated(true);
									if (player[p] == player[playerTurn]) {
										JOptionPane.showMessageDialog(radioButtons[i][ii],
												"Player " + player[p].getPlayerName() + " is the loser of this game.");
										gameOver();
										return;
									}
									JOptionPane.showMessageDialog(radioButtons[i][ii],
											player[p].getPlayerName() + " eliminated!");
								}
							}
						}

					}
				}
				if (playerRemaining() < 2) {
					for (int i = 0; i < player.length; i++) {
						if (!player[i].isEliminated()) {
							JOptionPane.showMessageDialog(lblPlayerTurn,
									"The loser of the game is Player " + player[i].getPlayerName());
							gameOver();
							return;
						}
					}
				}
				nextPlayer();
				updateStatus();
			}
		}

	}
}
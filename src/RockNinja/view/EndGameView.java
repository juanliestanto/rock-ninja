package RockNinja.view;

import RockNinja.Koneksi;
import RockNinja.latar;
import RockNiinja.controller.GameController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JPanel;

import RockNinja.model.Player;
import RockNinja.Koneksi;
import RockNinja.latar5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class EndGameView extends JPanel {
	private static final long serialVersionUID = 6784705580187233104L;

        private JButton close;
	private Player player;
	private Font mainFont;
	private RenderingHints rh;
        
       
	/**
	 * Sets up the dimensions and rendering options for the panel.
	 * 
	 * @param player
	 *            The player that plays the game.
	 */
	public EndGameView(Player player, JFrame GameController) {
		super();
                JFrame Game = GameController;
		// Set dimensions for the view
                
		Dimension dim = new Dimension(500, 550);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setSize(dim);
		// Load player
		this.player = player;
		// Setup rendering options
		mainFont = new Font("TimesNew", 0, 60);
		rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                 close = new JButton("close");
                 close.setBackground(Color.orange);
                 close.setBounds(350, 450, 100, 50);
                 add(close);
                 close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Koneksi.nambahSkor(latar5.jTextField1.getText(),player.getScore());
                        setVisible(false);
                        Game.dispose();
                        new latar().setVisible(true);
                       
                    }
                });    
	}
	/**
	 * This method is overridden from JPanel, it is used by swing to paint the
	 * view. It renders the player's score and the phrase "Game Over" on screen.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(rh);
		// Fill the screen with gray
		g2.setColor(Color.orange);
		g2.fillRect(0, 0, getWidth(), getHeight());
		// Show Game over and end score in white
		g2.setColor(Color.white);
		g2.setFont(mainFont);
		g.drawString("Game Over", 80, getHeight() / 3);
		g.drawString("Score: " + player.getScore(), 80, (getHeight() / 3) * 2);
	}

    
       
       
    }

package view;

import javax.swing.JTextArea;

import logger.Logger;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.Player;
import model.RowGameModel;


public class RowGameStatusView implements RowGameView {
    public JTextArea playerturn = new JTextArea();

    /**
     * Creates a new RowGameStatusView.
     */
    public RowGameStatusView(JPanel messages) {
        messages.add(playerturn);
        playerturn.setText(Player.PLAYER_1.getLabel() + " to play 'X'");
        Logger.log("updates");
    }

    public void update(RowGameModel gameModel) {
	if (gameModel.getFinalResult() == null) {
	    if(gameModel.getMovesLeft()%2 == 1) {
	        playerturn.setText("'X': " + Player.PLAYER_1.getLabel());
            Logger.log("updates");
	    } else{
		playerturn.setText("'O': " + Player.PLAYER_2.getLabel());
        Logger.log("updates");
	    }
	}
	else {
	    playerturn.setText(gameModel.getFinalResult());
        Logger.log("updates");
	}
    }
}

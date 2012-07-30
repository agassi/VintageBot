package agassi.vintage.controllers;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import agassi.vintage.views.VintagePane;

public final class VintageBot {

	private VintageBot() {
	}

	public static void vintify(Rectangle bounds) {
		final JFrame frame = getMainFrame();
		final JPanel gamePanel = getGamePanel(frame);
		final VintagePane vintagePane = new VintagePane(bounds);

		vintagePane.setBounds(gamePanel.getBounds());
		frame.remove(gamePanel);
		frame.add(vintagePane);
		vintagePane.add(gamePanel);
		frame.validate();
	}

	private static JFrame getMainFrame() {
		Frame[] frames = JFrame.getFrames();
		for (Frame f : frames) {
			if (f.getTitle().contains("RSBot"))
				return (JFrame) f;
		}

		return null;
	}

	private static JPanel getGamePanel(JFrame frame) {
		Component[] components = frame.getContentPane().getComponents();
		for (Component c : components) {
			if (c instanceof JPanel)
				return (JPanel) c;
		}

		return null;
	}

}

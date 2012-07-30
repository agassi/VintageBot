package agassi.vintage;

import java.awt.Rectangle;
import javax.swing.SwingUtilities;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;

import agassi.vintage.controllers.VintageBot;

@Manifest(authors = "Agassi", name = "VintageBot", description = "RSBot is becoming too mainstream")
public class VintageScript extends ActiveScript {

	@Override
	protected void setup() {
		final Rectangle bounds = new Rectangle(Game.getDimensions());

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				VintageBot.vintify(bounds);
			}

		});
	}

}

package agassi.vintage.views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.JPanel;

public class VintagePane extends JPanel {

	private static final long serialVersionUID = 5540746803002312705L;

	private static final ColorConvertOp FILTER = new ColorConvertOp(
			ColorSpace.getInstance(ColorSpace.CS_GRAY), null);

	private BufferedImage image;
	private Rectangle bounds;

	public VintagePane(Rectangle bounds) {
		super(new BorderLayout());
		this.bounds = bounds;
	}

	@Override
	public void paint(Graphics g) {
		BufferedImage img = getImage();
		if (img == null)
			return;

		Graphics graphics = img.createGraphics();
		super.paint(graphics);
		graphics.dispose();
		img = FILTER.filter(img, null);
		g.drawImage(img, 0, 0, null);

		repaint(bounds);
	}

	private BufferedImage getImage() {
		if (image == null && getWidth() > 0 && getHeight() > 0) {
			image = new BufferedImage(getWidth(), getHeight(),
					BufferedImage.TYPE_INT_RGB);
		} else if (image.getWidth() != getWidth()
				|| image.getHeight() != image.getHeight()) {
			image = new BufferedImage(getWidth(), getHeight(),
					BufferedImage.TYPE_INT_RGB);
		}

		return image;
	}
}

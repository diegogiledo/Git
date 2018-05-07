package Control;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//esta clasese encarga de recibir una imagen y reescalarla con el objetivo de adaptarse al Label donde va a ser visible
public class ImageManipulator {

	public void escalarImagen(JLabel label, String ruta) {
		File input = new File(ruta);
		BufferedImage image;
		try {
			image = ImageIO.read(input);

			BufferedImage resized = resize(image, label.getHeight(), label.getWidth());

			label.setIcon(new ImageIcon(resized));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

}
package org.sedorn.screenshotter.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ScreenCaptureRectangle {

	Rectangle captureRect;

    ScreenCaptureRectangle(final BufferedImage screen, final BufferedImage sourceImage) {
        final BufferedImage screenCopy = new BufferedImage(
                (int) (screen.getWidth() / 0.75),
                (int) (screen.getHeight() / 0.75),
                screen.getType());
        final JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
        JScrollPane screenScroll = new JScrollPane(screenLabel);
        
        screenScroll.setPreferredSize(new Dimension(
                (int)(screen.getWidth()/1.755),
                (int)(screen.getHeight()/1.745)));
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(screenScroll, BorderLayout.CENTER);

        final JLabel selectionLabel = new JLabel(
                "Drag a rectangle in the screen shot!");
        panel.add(selectionLabel, BorderLayout.SOUTH);    

        repaint(screen, screenCopy);
        screenLabel.repaint();

        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {

            Point start = new Point();

            @Override
            public void mouseMoved(MouseEvent me) {
                start = me.getPoint();
                repaint(screen, screenCopy);
                selectionLabel.setText("Start Point: " + start);
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                Point end = me.getPoint();
                captureRect = new Rectangle(start,
                        new Dimension(end.x-start.x, end.y-start.y));
                repaint(screen, screenCopy);
                screenLabel.repaint();
                selectionLabel.setText("Rectangle: " + captureRect);
            }
        });
        panel.setToolTipText("Choose the rectangle which should be uploaded");
        
        if(JOptionPane.showConfirmDialog(null, panel) == JOptionPane.YES_OPTION){
            if(captureRect == null){
            	JOptionPane.showMessageDialog(null, "ERROR: Please select a rectangle(Hold down MouseButton)");
            	return;
            }
            System.out.println("Rectangle of interest: " + captureRect);
            
            Rectangle rect = captureRect;
            rect.setSize((int) (rect.getWidth() * 1.33333333),(int) (rect.getHeight() * 1.3333333));
            rect.setLocation((int) (rect.getX() * 1.33333333), (int) (rect.getY() * 1.33333333));
           
            BufferedImage realimage = sourceImage.getSubimage((int) rect.getX(),(int) rect.getY(),(int) rect.getWidth(),(int) rect.getHeight());
            try {
    			System.out.println("Writing file: " + System.currentTimeMillis());
    			ImageIO.write(realimage, "png", new File(System.getProperty("user.dir") + "/screenshot.png"));
    			System.out.println("Finished writing file: " + System.currentTimeMillis());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            new Thread(new Uploader()).start();
        }else{
        	JOptionPane.showMessageDialog(null, "Screenshot aborted");
        }

    }

    public void repaint(BufferedImage orig, BufferedImage copy) {
        Graphics2D g = copy.createGraphics();
        g.drawImage(orig,0,0, null);
        if (captureRect!=null) {
            g.setColor(Color.RED);
            g.draw(captureRect);
            g.setColor(new Color(255,255,255,150));
            g.fill(captureRect);
        }
        g.dispose();
    }

    public static void capture() throws Exception {
        Robot robot = new Robot();
        final Dimension screenSize = Toolkit.getDefaultToolkit().
                getScreenSize();
        final BufferedImage screen = robot.createScreenCapture(
                new Rectangle(screenSize));
        
        //Rescale image
        final BufferedImage scaledScreen = scale(screen, screen.getType(), (int) (screen.getWidth() / 0.75), (int) (screen.getHeight() / 0.75), 0.75, 0.75);
        System.out.println(screen.getWidth() + "x" + screen.getHeight());

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScreenCaptureRectangle(scaledScreen, screen);
            }
        });
    }
    public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }
}

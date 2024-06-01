import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.awt.image.RescaleOp;

public class Main {
    public static void main(String[] args) {

        new ImageViewerGUI2();
    }
}





class ImageViewerGUI2 extends JFrame implements ActionListener {

    JPanel mainPanel, resizePanel, brightnessPanel;

    myButton selectFileButton;
    myButton showImageButton;
    myButton resizeButton;
    myButton grayscaleButton;
    myButton brightnessButton;
    myButton closeButton;
    myButton showResizeButton;
    myButton showBrightnessButton;
    myButton backButton;
    JTextField widthTextField;
    JTextField heightTextField;
    JTextField brightnessTextField;
    String filePath = "/home/IMAGES/image";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);
    BufferedImage originalImage;
    int h = 900;
    int w = 1200;
    float brightenFactor = 1;

    ImageViewerGUI2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 500);
        this.setVisible(true);
        this.setResizable(true);

        mainPanel();
    }

    public void mainPanel() {
        // Create main panel for adding to Frame
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Create Grid panel for adding buttons to it, then add it all to main panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2));

        JLabel mainL = new JLabel("Image Viewer");
        mainPanel.add(mainL);

        selectFileButton = new myButton("Choose Image");
        showImageButton = new myButton("Show Image");
        brightnessButton = new myButton("Brightness");
        grayscaleButton = new myButton("Gray Scale");
        resizeButton = new myButton("Resize");
        closeButton = new myButton("Exit");

        selectFileButton.addActionListener(this);
        showImageButton.addActionListener(this);
        brightnessButton.addActionListener(this);
        grayscaleButton.addActionListener(this);
        resizeButton.addActionListener(this);
        closeButton.addActionListener(this);

        buttonsPanel.setSize(400, 200);

        // Adding all buttons to Grid panel
        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.brightnessButton);
        buttonsPanel.add(this.grayscaleButton);
        buttonsPanel.add(this.resizeButton);
        buttonsPanel.add(this.closeButton);

        // add Grid panel that contains 6 buttons to main panel
        mainPanel.add(buttonsPanel);

        // add main panel to our frame
        this.add(mainPanel);
        this.setVisible(true);
    }

    public void resizePanel() {
        resizePanel = new JPanel();
        resizePanel.setLayout(null);

        JLabel resizeLabel = new JLabel("Resize Section");
        JLabel widthL = new JLabel("Width");
        JLabel heightL = new JLabel("Height");

        widthTextField = new JTextField(5);
        heightTextField = new JTextField(5);

        backButton = new myButton("Back");
        backButton.setBounds(150, 400, 100, 20);
        showResizeButton = new myButton("Result");
        resizePanel.setLayout(new GridLayout(4, 2));

        backButton.addActionListener(this);
        showResizeButton.addActionListener(this);

        //resizePanel.add(resizeLabel);
        //resizePanel.add();
        resizePanel.add(widthL);
        resizePanel.add(widthTextField);
        resizePanel.add(heightL);
        resizePanel.add(heightTextField);
        resizePanel.add(backButton);
        resizePanel.add(showResizeButton);

        this.add(resizePanel);
        this.setVisible(true);
    }

    public void brightnessPanel() {
        brightnessPanel = new JPanel();
        brightnessPanel.setLayout(new GridLayout(2,2));

        backButton = new myButton("Back");
        backButton.setBounds(150, 400, 100, 20);

        showBrightnessButton = new myButton("Result");

        backButton.addActionListener(this);
        showBrightnessButton.addActionListener(this);

        JLabel brightnessL = new JLabel("Enter f (must be between 0 and 1)");
        brightnessTextField = new JTextField(5);
        brightnessTextField.setBounds(150, 400, 100, 20);
        //showBrightnessButton.setLayout(150, 400, 100, 20);
        brightnessPanel.add(brightnessL);
        brightnessPanel.add(brightnessTextField);
        brightnessPanel.add(backButton);
        brightnessPanel.add(showBrightnessButton);
        remove(mainPanel);
        add(brightnessPanel);
        this.revalidate();
        this.repaint();
        //this.setVisible(true);
    }

    public void chooseFileImage() {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                originalImage = ImageIO.read(file);
                JOptionPane.showMessageDialog(null, "Image Loaded Successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Failed to load image.");
                e.printStackTrace();
            }
        }
    }

    public void showOriginalImage() {
        if (originalImage == null) {
            JOptionPane.showMessageDialog(null, "No image loaded.");
            return;
        }
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(originalImage, 0, 0, this);
            }
        };

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    public void grayScaleImage() {
        if (originalImage == null) {
            JOptionPane.showMessageDialog(null, "No image loaded.");
            return;
        }
        BufferedImage grayImage = new BufferedImage(
                originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        ColorConvertOp op = new ColorConvertOp(
                ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(originalImage, grayImage);

        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(grayImage, 0, 0, this);
            }
        };

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Gray Scale Image");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    public void showResizeImage(int w, int h) {
        if (originalImage == null) {
            JOptionPane.showMessageDialog(null, "No image loaded.");
            return;
        }
        Image resizedImage = originalImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        BufferedImage bufferedResizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedResizedImage.createGraphics();
        g2d.drawImage(resizedImage, 0, 0, null);
        g2d.dispose();

        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bufferedResizedImage, 0, 0, this);
            }
        };

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Resized Image");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    public void showBrightnessImage(float f) {
        if (originalImage == null) {
            JOptionPane.showMessageDialog(null, "No image loaded.");
            return;
        }
        RescaleOp rescaleOp = new RescaleOp(f, 0, null);
        BufferedImage brightenedImage = rescaleOp.filter(originalImage, null);

        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(brightenedImage, 0, 0, this);
            }
        };

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Brightened Image");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resizeButton) {
            resizePanel();
            remove(mainPanel);
            add(resizePanel);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == showImageButton) {
            showOriginalImage();
        } else if (e.getSource() == grayscaleButton) {
            grayScaleImage();
        } else if (e.getSource() == showResizeButton) {
            h = Integer.parseInt(heightTextField.getText());
            w = Integer.parseInt(widthTextField.getText());
            showResizeImage(w, h);
        } else if (e.getSource() == brightnessButton) {
            brightnessPanel();
            
        } else if (e.getSource() == showBrightnessButton) {
            brightenFactor = Float.parseFloat(brightnessTextField.getText());
            showBrightnessImage(brightenFactor);
        } else if (e.getSource() == selectFileButton) {
            chooseFileImage();
        } else if (e.getSource() == closeButton) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource() == backButton) {
            this.getContentPane().removeAll();
            this.mainPanel();
            this.revalidate();
            this.repaint();
        }
    }

    public static void main(String[] args) {
        new ImageViewerGUI();
    }
}

class myButton extends JButton {
    myButton(String Text) {
        this.setText(Text);
        this.setForeground(new Color(49, 48, 77));
        this.setBackground(new Color(182, 187, 196));
        this.setFont(new Font("Arial-PLAIN-11", Font.BOLD, 14));
    }
}

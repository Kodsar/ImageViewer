# ImageViewerGUI

`ImageViewerGUI` is a Java-based graphical user interface (GUI) application that allows users to select, view, resize, convert to grayscale, and adjust the brightness of images. 

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- awt library
- io library
- javax library
- swing library

## Usage and Features

1. **Select an Image:**
   - Click the "Choose Image" button to open a file chooser dialog.
   - Select an image file from your file system.

2. **Show the Image:**
   - Click the "Show Image" button to display the chosen image.

3. **Resize the Image:**
   - Click the "Resize" button to open the resize panel.
   - Enter the desired width and height.
   - Click "Result" to display the resized image.

4. **Convert to Grayscale:**
   - Click the "Gray Scale" button to display the grayscale version of the image.

5. **Adjust Brightness:**
   - Click the "Brightness" button to open the brightness panel.
   - Enter a brightness factor (must be between 0 and 1).
   - Click "Result" to display the brightness-adjusted image.

6. **Navigate:**
   - Use the "Back" button to return to the main menu from any panel.

7. **Exit:**
   - Click the "Exit" button to close the application.

## Screenshots

Here are some screenshots of the application:

### Main Menu
![Main Menu](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.mainPanel.png?raw=true)
### Image Choosing Panel
![chooseImagePanel](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.1.chooseImagePanel.png?raw=true)
### Image Display
![Image Display](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.2.showImagePanel.png?raw=true)
### Brightness Panel
![brightnessPanel](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.3.brightnessPanel.png?raw=true)
### Brightness Adjusted Image
![Brightness Adjusted Image](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.3.1.brightnessChangedImage.png?raw=true)
### Grayscale Image
![Grayscale Image](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.4.grayScaleShowPanel.png?raw=true)
### Resizing Panel
![ResizePanel](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.5.resizePanel.png?raw=true)
### Resized Image
![Resized Image](https://github.com/Kosar-Gari/ImageViewer/blob/main/ImageViewerPanels/1.5.1.resizedImagePanel.png?raw=true)
## Code Structure

- **ImageViewerGUI.java:** The main GUI application file.
- **myButton.java:** Custom button class used in the GUI.

## Methods

### `ImageViewerGUI` Class

- **mainPanel():** Initializes the main panel with buttons for various functionalities.
- **resizePanel():** Initializes the panel for resizing the image.
- **brightnessPanel():** Initializes the panel for adjusting the image brightness.
- **chooseFileImage():** Allows the user to choose an image file.
- **showOriginalImage():** Displays the chosen image.
- **grayScaleImage():** Converts the chosen image to grayscale and displays it.
- **showResizeImage(int w, int h):** Resizes the chosen image and displays it.
- **showBrightnessImage(float f):** Adjusts the brightness of the chosen image and displays it.
- **actionPerformed(ActionEvent e):** Handles button click events.

### `myButton` Class

- **myButton(String Text):** Custom JButton class with predefined styles.

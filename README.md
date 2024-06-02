# ImageViewerGUI

`ImageViewerGUI` is a Java-based graphical user interface (GUI) application that allows users to select, view, resize, convert to grayscale, and adjust the brightness of images. 

## Features

- **Select Image:** Choose an image file from your file system.
- **Show Image:** Display the selected image.
- **Resize Image:** Resize the image to specified dimensions.
- **Grayscale Image:** Convert the image to grayscale.
- **Adjust Brightness:** Change the brightness of the image.
- **Navigate:** Switch between the main menu and different functionalities.
- **Exit:** Close the application.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- An IDE or text editor to view and edit the code (optional).
- jsoup library.

## Usage

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
![Main Menu](https://www.dropbox.com/scl/fi/xiw3rw243y4z9mj5pvqjz/1.mainPanel.png?rlkey=twlrl9i5uomfdye7sif0wnelj&st=fmf6rgzg&dl=0)
### Image Choosing Panel
![chooseImagePanel](https://www.dropbox.com/scl/fi/48gskyb0enl2te5ij59do/1.1.chooseImagePanel.png?rlkey=5lbulmrylrj31foo7se74zb3z&st=5ucolang&dl=0)

### Image Display
![Image Display](https://www.dropbox.com/scl/fi/lcbpp5sh1ua1u8rfsfdyd/1.2.showImagePanel.png?rlkey=57dop7rz29wr248nq1xodj772&st=4v5j58t7&dl=0)

### Brightness Panel
![brightnessPanel](https://www.dropbox.com/scl/fi/pu1a12jf7qthzkfqzk2t3/1.3.brightnessPanel.png?rlkey=lss2gmvk0n9nogjw1kjzh1a7s&st=3yvwgaim&dl=0)

### Brightness Adjusted Image
![Brightness Adjusted Image](https://www.dropbox.com/scl/fi/k645ixzaasbi6vhfhzmsn/1.3.1.brightnessChangedImage.png?rlkey=p78ztuh7af8mccd1rouw0kdeb&st=iyhuvmjx&dl=0)

### Grayscale Image
![Grayscale Image](https://www.dropbox.com/scl/fi/z5v4fprns80891oacft1w/1.4.grayScaleShowPanel.png?rlkey=zcsh3raz05i9w0140vs66cso6&st=vq4rfc7c&dl=0)

### Resizing Panel
![ResizePanel](https://www.dropbox.com/scl/fi/9agv65hvxn4rd3xk5ww8a/1.5.resizePanel.png?rlkey=27oi3afjpt1k3g6fs4ow9eflk&st=hmm030vj&dl=0)

### Resized Image
![Resized Image](https://www.dropbox.com/scl/fi/lds4ak4kbpkbaj44k7ey5/1.5.1.resizedImagePanel.png?rlkey=w882bmmkrvk1yjgrpwfpk2d7j&st=mfbn393d&dl=0)

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

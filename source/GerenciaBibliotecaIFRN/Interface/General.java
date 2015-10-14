package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Main window of the program
 * 
 * @author Danielson Silva (danielson_fx@yahoo.com.br)
 * @version 1.0
 */
public class General extends JFrame
{
    // Numbers variables
    private int width;
    private int height;
    private double sizeRate;
    // Components variables
    private JButton btnRegisterUse;
    private JButton btnInsertUser;
    private JButton btnRemoveUse;
    private JButton btnReport;
    /**
     * Constructor for the General Class
     * 
     * @param messages Variable for intercionalization of the program
     */
    public General(ResourceBundle messages)
    {
        // inicialize variables
        String title = messages.getString("title");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        sizeRate = 0.7;
        width  = (int) (Math.round(dim.width*sizeRate));
        height = (int) (Math.round(dim.height*sizeRate));

        // Setting up the icon
        URL url = this.getClass().getResource("/./utils/icon.png");    
        Image icon = Toolkit.getDefaultToolkit().getImage(url);    
        this.setIconImage(icon);        
        
        // Close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Inicialize the window with 80% of the screen resolution
        this.setSize(width, height);
        // Title of the window
        this.setTitle(title);
        // Border Layout for the components
        this.setLayout(new GridBagLayout());
        // Inicialize the window in the center of the monitor
        this.setLocationRelativeTo(null);  
        // Add the menu bar
        addMenuBarToPane(this,messages);
        // Add the tabbed pane
        addTabbedPane(this, messages);
        // Add the components of the window
        addComponentsToPane(this.getContentPane(),messages);
        // Popup the main window
        this.setVisible(true);
    }

    /**
     * Add the components to the container of this Class
     * 
     * @param pane Container that will receive the components
     * @param messages Variable for internationalization
     */
    private void addComponentsToPane(Container pane, ResourceBundle messages)
    {
        //Setting the names of the buttons
        String strRegisterUse = messages.getString("btnRegisterUse");
        String strInsertUser = messages.getString("btnInsertUser");
        String strRemoveUse = messages.getString("btnRemoveUse");
        String strReport = messages.getString("btnReport");
        
        //Setting up the pane
        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GridBagConstraints gbc = new GridBagConstraints();
        btnRegisterUse = new JButton(strRegisterUse);
        btnInsertUser = new JButton(strInsertUser);
        btnRemoveUse = new JButton(strRemoveUse);
        btnReport = new JButton(strReport);
        // Adding the buttons
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pane.add(btnRegisterUse, gbc);
        gbc.gridy = 1;
        pane.add(btnInsertUser, gbc);
        gbc.gridy = 2;
        pane.add(btnRemoveUse, gbc);
        gbc.gridy = 3;
        pane.add(btnReport, gbc);
    }
    /**
     * Add a menu bar to the program
     * 
     * @param pane Container that will receive the components
     * @param messages Variable for internationalization
     */    
    private void addMenuBarToPane(JFrame frame, ResourceBundle messages)
    {
        // Setting up the menu bar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        // Setting the menu categories
        JMenu fileMenu = new JMenu(messages.getString("MenuFile"));
        JMenu helpMenu = new JMenu(messages.getString("MenuHelp"));
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        // Setting the menu items
        JMenuItem exitAction = new JMenuItem(messages.getString("MenuItemExit"));
        JMenuItem aboutAction = new JMenuItem(messages.getString("MenuItemAbout"));
        // Setting up the adding
        fileMenu.add(exitAction);
        helpMenu.add(aboutAction);
    }
    /**
     * Add the tabbed pane to the window
     * 
     * @param pane Container that will receive the components
     * @param messages Variable for internationalization
     */    
    private void addTabbedPane(Container pane, ResourceBundle messages)
    {
        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridheight = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JComponent panel1 = makeTextPanel("Panel #1");
        ImageIcon icon = createImageIcon("images/middle.gif");
        tabbedPane.addTab("Tab 1", icon, new JTable(),"Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", icon, panel2,"Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3,"Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", icon, panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        pane.add(tabbedPane, gbc);
    }
    /**
     * Add a TextPanel for a TabbedPane
     * 
     * @param text String that will appear in the panel
     */  
    private JComponent makeTextPanel(String text) 
    {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }    
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

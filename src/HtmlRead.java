import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.ReadWriteLock;

public class HtmlRead implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea KeyWord; //typing area
    private JTextArea URL; //typing area
    private JTextArea Results;
    private JButton Search;
    private JPanel Top;
    private JPanel Bottom;
    private int WIDTH=800;
    private int HEIGHT=700;
    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        prepareGUI();
        showEventDemo();

    }

        private void prepareGUI() {
            mainFrame = new JFrame("Java SWING Examples");
            mainFrame.setSize(800, 700);
            mainFrame.setLayout(new GridLayout(2,1));

            //menu at top
            mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            });

            mainFrame.setVisible(true);
        }

        private void showEventDemo() {

            JButton Search = new JButton("Search");
            KeyWord = new JTextArea("KeyWord:");
            URL = new JTextArea("URL:");
            Results = new JTextArea("Results:");
            JScrollPane scrollpane = new JScrollPane(Results);

            Top = new JPanel();
            Top.setLayout(new GridLayout(1,3));
            Bottom = new JPanel();
            Bottom.setLayout(new GridLayout(1,1));
            Search.setActionCommand("Search");


               Search.addActionListener(new ButtonClickListener());
            //    Button2.addActionListener(new ButtonClickListener());
            //    Button3.addActionListener(new ButtonClickListener())
            //  Button4.addActionListener(new ButtonClickListener());
            //Button5.addActionListener(new ButtonClickListener());
            Top.add(KeyWord);
            Top.add(URL);
            Top.add(Search);
            Bottom.add(scrollpane);
            mainFrame.add(Top);

            mainFrame.add(Bottom);
            mainFrame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cut)
                URL.cut();
            KeyWord.cut();

            if (e.getSource() == paste)
                URL.paste();
            KeyWord.paste();

            if (e.getSource() == copy)
                URL.copy();
            KeyWord.copy();

            if (e.getSource() == selectAll)
                URL.selectAll();
            KeyWord.selectAll();

        }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Search")) {
                try {
                    System.out.println();
                    System.out.print("hello \n");
                    URL url = new URL(URL.getText());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openStream())
                    );
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("href=")) {
                            line.indexOf("href=");
                            int abcd = line.indexOf("href=");

                            String pqrs = line.substring(abcd + 6);
//                System.out.println("og"+pqrs);
                            pqrs.indexOf("\"");
                            int end = pqrs.indexOf("\"");
                            pqrs.indexOf("'");
                            int end1 = pqrs.indexOf("'");
//               System.out.println(end);
//         System.out.print(end1);
                            if (end1 < 0) {
                                String link = pqrs.substring(0, end);
                                if(link.contains(KeyWord.getText())){
                                    System.out.println(link);
                                    Results.append(link+ "\n");
                                }
                            } else if (end < 0) {
                                String link = pqrs.substring(0, end1);
                                if(link.contains(KeyWord.getText())){
                                    System.out.println(link);
                                    Results.append(link+ "\n");
                                }

                            } else if (end < end1) {
                                String link = pqrs.substring(0, end);
                                if(link.contains(KeyWord.getText())){
                                    System.out.println(link);
                                    Results.append(link + "\n");
                                }

                            } else {
                                String link = pqrs.substring(0, end1);
                                if(link.contains(KeyWord.getText())){
                                    System.out.println(link);
                                    Results.append(link + "\n");
                                }

                            }
                            //   System.out.println(pqrs.substring(0,end));
                        }
                    }
                    reader.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }



    }






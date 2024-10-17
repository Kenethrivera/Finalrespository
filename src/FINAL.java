//layeredpane
//exception
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FINAL {
    
    public static JFrame frame1;
    public static JLabel username, password;
    public static String excep, excep1;
    
    public static void main(String[] args) {
        
        frame1 = new JFrame("WELCOME");
        frame1.setSize(500, 500);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setLayout(new BorderLayout());
        frame1.setResizable(false);

        JLabel label1 = new JLabel("WELCOME!!");
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setBounds(0,170,frame1.getWidth(), 50);
        
        ImageIcon bg = new ImageIcon("welcome.jpg");
        Image image  = bg.getImage();
        Image image1 = image.getScaledInstance(frame1.getHeight(), frame1.getWidth(), Image.SCALE_REPLICATE);
        bg = new ImageIcon(image1);
        
        JLabel label2 = new JLabel();
        label2.setIcon(bg);
        label2.setBounds(0, 0, frame1.getHeight(), frame1.getWidth());
        
        JButton button1 = new JButton("Sign in ");
        button1.setBounds(190, 250, 130, 30);
        button1.setFocusable(false);
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        button1.addActionListener((ActionEvent e)->{
            login();
        });
        
        JLayeredPane layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(500,500));
        layer.add(button1, Integer.valueOf(1));
        layer.add(label1, Integer.valueOf(1));
        layer.add(label2, Integer.valueOf(0));
        
        frame1.add(layer);
        frame1.setVisible(true);
     
       
        
    } public static void login(){
        
        
        JFrame loginframe = new JFrame("SIGN UP");
        loginframe.setSize(500, 500);
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setLocationRelativeTo(null);
        loginframe.setResizable(false);
        
        JPanel bg = new JPanel();
        bg.setBackground(new Color(0,204,153));
        bg.setLayout(null);
        loginframe.add(bg);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(72, 40, 350, 370);
        panel1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 4));
        panel1.setBackground(Color.WHITE);
        bg.add(panel1);
       
        JLabel text = new JLabel("SIGN IN WITH");
        text.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
        text.setForeground(Color.BLACK);
        text.setBounds(120, 40, 150, 30);
        panel1.add(text);
        
        
        ImageIcon fbicon = new ImageIcon("fb.jpg");
        Image icon1 = fbicon.getImage();
        Image resizefb = icon1.getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        fbicon = new ImageIcon(resizefb);
        
        JButton fbbutton = new JButton(fbicon);
        fbbutton.setBounds(50,80,120,30);
        fbbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fbbutton.setContentAreaFilled(false);
        fbbutton.addActionListener((ActionEvent e)->{
           new fbframe();
        });
        
        
        ImageIcon googleicon = new ImageIcon("google.jpg");
        Image icon2 = googleicon.getImage();
        Image resizedgoogle = icon2.getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        googleicon = new ImageIcon(resizedgoogle);
        
        JButton googlebutton = new JButton(googleicon);
        googlebutton.setBounds(180, 80, 120, 30);
        googlebutton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        googlebutton.setContentAreaFilled(false);
        googlebutton.addActionListener((ActionEvent e)->{
            new googleframe();
        });
        
        username = new JLabel("Username: ");
        username.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        username.setForeground(Color.BLACK);
        username.setBounds(50, 140, 100, 30);
        
        JTextField usertf = new JTextField();
        usertf.setBounds(50, 170, 270, 30);
        
        password = new JLabel("Password: ");
        password.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        password.setForeground(Color.BLACK);
        password.setBounds(50, 210, 100, 30);
        
        JTextField passtf = new JTextField();
        passtf.setBounds(50, 240, 270, 30);
        
        JLabel errormess = new JLabel("");
        errormess.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        errormess.setForeground(Color.red);
        errormess.setBounds(50,270,270,30);
        panel1.add(errormess);
        
        JButton signinb = new JButton("SIGN IN");   
        signinb.setBounds(135, 300, 90, 30);
        signinb.setFocusable(false); 
        signinb.setContentAreaFilled(false);
        signinb.addActionListener((ActionEvent e)->{
            userexcep(usertf, passtf, errormess);
        });
        
        panel1.add(signinb);
        panel1.add(passtf);
        panel1.add(password);
        panel1.add(usertf);
        panel1.add(fbbutton);
        panel1.add(googlebutton);
        panel1.add(username);
        loginframe.setVisible(true);  
        
    } public static void userexcep(JTextField usertf, JTextField passtf, JLabel errormess){
        String userinput = usertf.getText();
        String passinput = passtf.getText();
        
        if(userinput.isEmpty() || passinput.isEmpty()){
            //JOptionPane.showMessageDialog(null, "PLEASE FILL THE USERNAME AND PASSWORD", "ERROR",JOptionPane.ERROR_MESSAGE);
            errormess.setText("USERNAME AND PASSWORD IS EMPTY");
        } else{

            frame1.dispose();
            JOptionPane.showMessageDialog(null, "LOGIN SUCCESFULLY");
            new succcess();
         
        }
        try(PrintWriter info = new PrintWriter(new FileWriter("GUI DATA.txt", true))){
            info.write("Username: "+userinput+ "\n");
            info.write("Password: "+passinput+ "\n");
            info.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "FILE NOT FOUND", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
}
//important imports + packages
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        //making a new scanner object
        Scanner scan = new Scanner(System.in);
        
        //asking user for art title
        System.out.println("What would you like your artwork title to be?");
        String title = scan.nextLine();
        //asking for circle radius
        System.out.println("What radius would you want for your circles? (Decimals allowed)");
        double radius = scan.nextDouble();
        //asking user the amount of variance they want (how much smaller/bigger they want their circles to be than the radius)
        System.out.println("How much variance from your radius would you like for your cicles? (Decimals allowed)");
        double variance = scan.nextDouble();
        //asking how many circles
        System.out.println("How many circles would you like?");
        int circles = scan.nextInt();
        
        //defining new jframe and setting parameters for it
        JFrame f= new JFrame(title);
        f.setSize(800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //defining new jlabel title and setting it to the center
        JLabel title2 = new JLabel(title, SwingConstants.CENTER);
        
        ///setting title text color and attributes such as font
        title2.setForeground(Color.BLACK);
        title2.setFont(new Font("Arial", Font.BOLD, 34));
        
        //setting up new jpanel
        JPanel p = new JPanel() {

            public void paint(Graphics g) {
                //using built in java swing method paint to handle painting
                super.paint(g);
                
                //black background for the artwork
                g.setColor(Color.BLACK);
                g.fillRect(0,0,getWidth(), getHeight());
                
                //printing all circles to screen
                for(int i = 0; i < circles; i++) {
                    //getting circle radius
                    double circ_rad = (radius-variance) + Math.random() * (variance*2);
                    
                    //getting circle coordinates
                    double x = Math.random() * (getWidth() - 1) + 1;
                    double y = Math.random() * (getWidth() - 1) + 1;
                    
                    //random color for circle
                    g.setColor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
                    
                    //placing the oval with the coordinates and radius
                    g.fillOval((int) x, (int) y, (int) (circ_rad * 2), (int) (circ_rad * 2));
                }
            }
        };
        
        //formatting the title to the top and displaying frame
        f.setLayout(new BorderLayout());
        f.add(title2, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
}
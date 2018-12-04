package myUber;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import myUberOthers.GPS;
import myUberRide.Ride;


public class Main{
               private static JFrame fenetre = new JFrame();
               private static JPanel container = new JPanel();
               private static JPanel bigcontainer = new JPanel();
               private static JPanel testscenariopanel =new JPanel();
               private static JButton testscenario = new JButton("testscenario");
               private static JTextField jtf = new JTextField("");
               private static JTextPane textup= new JTextPane();
               private static JTextPane textdown= new JTextPane();
               private static Boolean systemcreated= false;
               
               private static MyUber myUber= null;

               
               public static JFrame getFenetre() {
                              return fenetre;
               }

               public static void setFenetre(JFrame fenetre) {
                              Main.fenetre = fenetre;
               }

               public static JPanel getContainer() {
                              return container;
               }

               public static void setContainer(JPanel container) {
                              Main.container = container;
               }

               public static JTextField getJtf() {
                              return jtf;
               }

               public static void setJtf(JTextField jtf) {
                              Main.jtf = jtf;
               }

               public static JTextPane getTextup() {
                              return textup;
               }

               public static void setTextup(JTextPane textup) {
                              Main.textup = textup;
               }

               public static JTextPane getTextdown() {
                              return textdown;
               }

               public static void setTextdown(JTextPane textdown) {
                              Main.textdown = textdown;
               }

               public static Boolean getSystemcreated() {
                              return systemcreated;
               }

               public static void setSystemcreated(Boolean systemcreated) {
                              Main.systemcreated = systemcreated;
               }

              

               public static MyUber getMyUber() {
				return myUber;
			}

			public static void setMyUber(MyUber myUber) {
				Main.myUber = myUber;
			}

			

           public static void main(String[] args) {
                              Main tkt= new Main();
                              tkt.window();
                    }
               
          public Main() {                 
                          }
               
          public void window(){
                              //Sets the windows title
                              fenetre.setTitle("MyUber CLUI");
                              //Sets the size
                              fenetre.setSize(800, 800);
                              //Puts the window in the center
                              fenetre.setLocationRelativeTo(null);
                              //sets the default close operation
                              fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
                              
                              container.setLayout(new BorderLayout());
                              Font police = new Font("Arial", Font.BOLD, 14);
                              jtf.setFont(police);
                              jtf.setPreferredSize(new Dimension(50, 30));
                              jtf.setForeground(Color.BLUE);
                              jtf.addKeyListener(new ClavierListener());
                              
                              testscenario.setPreferredSize(new Dimension(200,50));

                              testscenariopanel.setLayout(new GridLayout(11,1));
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(testscenario);
                              
                              bigcontainer.setSize(800,30);
                              bigcontainer.setLayout(new GridLayout(1,4));
                              bigcontainer.add(jtf);
                              bigcontainer.add(new JPanel());
                              bigcontainer.add(testscenariopanel);
                              bigcontainer.add(new JPanel());
                              
                              container.add(textup,BorderLayout.NORTH);
                              container.add(bigcontainer, BorderLayout.CENTER);
                              container.add(textdown,BorderLayout.SOUTH);
                              
                              testscenario.addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e) {
                                                           //creation of a system
                                                           myUber= new MyUber(50,50);
                                                           
                                                           // initiation
                                                           
                                                           myUber.initiation();
                                                           
                                                           // ten clients request a ride
                                                           // one of them is chosen from command line, the others are random 
                                                           
                                                           for(int i = 0; i < 9; i++) {
                                                        	   myUber.customerList.get(i).requestRandomRide(myUber);
                                                           }
                                                           
                                                           myUber.customerList.get(10).requestRide(2, new GPS(), myUber);
                                                           
                                                           // the rides are allocated to the drivers 
                                                           
                                                           int counter = 1;
                                                   		   for (Ride ride: myUber.requestedRides) {
                                                   		         ride.setRideID(counter);
                                                   			     ride.start();
                                                   			     counter++;
                                
                                                   		}

                                                          
                                                           
                                                        textdown.setText(myUber.toString()
                                                                                         + "\n Ten clients request a Ride"
                                                                                         );
                                            }
                                            
                                            
                              });
                              
                              
                              fenetre.setContentPane(container);
                              fenetre.setVisible(true);
                                                           
               }
               
               public void newcommandline() {
                              String command= jtf.getText();
                              String[] commandsplitted= command.split(" ") ;
                              System.out.println(commandsplitted[0].equals("setup"));
                              System.out.println(commandsplitted[0].equals("help"));
                              System.out.println(systemcreated);
                              String success = "Task completed. System is ready.";
                              if (!(commandsplitted[0].equals("setup")||commandsplitted[0].equals("help")||systemcreated)) {
                                            textdown.setText("The system has not been created, use the setup or the help method first");
                              }else {
                                            if (commandsplitted[0].equals("setup")) {
                                                           if (commandsplitted.length != 3) {
                                                                          textdown.setText("The setup method requires 2 arguments: the number of stations (int) and the total number of slots(int)");
                                                           }else {
                                                                          try {
                                                                          int n1= Integer.parseInt(commandsplitted[1]);
                                                                          int n2= Integer.parseInt(commandsplitted[2]);
                                                                          myUber= new MyUber(n1,n2);
                                                                          textdown.setText(myUber.toString());
                                                                          systemcreated=true;
                                                                          }catch(NumberFormatException e) {
                                                                                         textdown.setText("The setup method requires 2 arguments: the number of customers (int) and the  number of dri(int)");
                                                                          }
                                                           }
                                            }
                                            
                                            
                                            
                                            else if (commandsplitted[0].equals("help")) {
                                                           textup.setText("List of the available methods: \n"
                                                                                         + "\n The setup method requires 2 arguments: the number of customers (int) and the total number of drivers(int)"
                                                                                         );
                                            }
                                            else{
                                                           textdown.setText("The method you asked for doesn't exist");
                                            }
                              }
                              textup.setText(textup.getText()+"\n"+command);
                              jtf.setText("");
                              
               }
               

               
               class ClavierListener implements KeyListener{

                   public void keyPressed(KeyEvent event) { 
                              if (event.getKeyCode()==10) {
                                            newcommandline();
                              }
                   }

                   public void keyReleased(KeyEvent event) {

                   }

                              public void keyTyped(KeyEvent arg0) {
                                            // TODO Auto-generated method stub
                                            
                              }
               }
}



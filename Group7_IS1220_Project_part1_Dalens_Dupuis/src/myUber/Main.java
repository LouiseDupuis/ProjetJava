package myUber;

import myUberRide.*;
import myUberOthers.*;
import myUberCar.*;
import myUberPeople.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import myUberOthers.GPS;
import myUberPeople.Customer;
import myUberRide.Ride;


public class Main{
               private static JFrame fenetre = new JFrame();
               private static JPanel container = new JPanel();
               private static JPanel bigcontainer = new JPanel();
               private static JPanel testscenariopanel =new JPanel();
               private static JButton testscenario = new JButton("testscenario");
               private static JTextField jtf = new JTextField("");
               private static JPanel haut = new JPanel();
               private static JTextPane textup= new JTextPane();
               private static JTextPane textdown= new JTextPane();
               private static Boolean systemcreated= false;
               
               private static MyUber myUber= null;
               public static Map<Integer, UndefinedRide> waitingChoiceRide = new HashMap();

               
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
                              fenetre.setSize(600, 600);
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
                              
                              testscenario.setPreferredSize(new Dimension(100,50));

                              testscenariopanel.setLayout(new GridLayout(11,1));
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(new JPanel());
                              testscenariopanel.add(testscenario);
                              
                              bigcontainer.setSize(500,30);
                              bigcontainer.setLayout(new GridLayout(1,4));
                              bigcontainer.add(jtf);
                              bigcontainer.add(testscenariopanel);
                              bigcontainer.add(haut);
                              
                              container.add(textup,BorderLayout.NORTH);
                              container.add(bigcontainer, BorderLayout.CENTER);
                              container.add(textdown,BorderLayout.SOUTH);
                              
                              /*JLabel label = new JLabel("<html><body>Bienvenue dans l'interface utilisateur de myUber <br />"
                              		+ "Pour utiliser l'application, vous pouvez : "
                              		+ "<ul>\r\n" + 
                              		"  <li>Utiliser le bouton TestScenario qui démarre un scénario d'utilisation de myUber" + 
                              		"  <li>Définir vous même les évenements grâce aux méthodes de la command line ( à gauche)</li>\r\n" + 
                              		"</ul>"
                              		+ "</body></html>");
                              
                              Font police2 = new Font("Arial", Font.BOLD, 11);
                              label.setFont(police2);
                              haut.add(label);
                              */
                              textup.setText("Bienvenue dans l'interface utilisateur de myUber "
                              		+ " \n Pour utiliser l'application, vous pouvez : "
                              		+ " \n" + 
                              		"  \n - Utiliser le bouton TestScenario qui démarre un scénario d'utilisation de myUber" + 
                              		"  \n  - Définir vous même les évenements grâce aux méthodes de la command line ( à gauche)\r\n"
                              		+ "\n Pour connaître l'ensemble des méthodes utilisables, entrez help "
                              		);
                              
                              testscenario.addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e) {
                                                           //creation of a system
                                                           myUber= new MyUber(50,50);
                                                           
                                                           textdown.setText(myUber.toString());
                                                           
                                                           // initiation
                                                           
                                                           myUber.initiation();
                                                           

                                                           
                                                           // ten clients request a ride
                                                           
                                                           textdown.setText(myUber.toString() +
                                                        		              " \n Ten clients request a Ride ");
                                                           // one of them is chosen from command line, the others are random 
                                                           
                                                           for(int i = 0; i < 9; i++) {
                                                        	   myUber.customerList.get(i).requestRandomRide(myUber);
                                                           }
                                                           

                                                           
                                                           // the rides are allocated to the drivers 
                                                           
                                                           int counter = 1;
                                                   		   for (Ride ride: myUber.requestedRides) {
                                                   		         ride.setRideID(counter);
                                                   			     ride.start();
                                                   			  textdown.setText(myUber.toString() +
                                                		              " \n Ten clients request a Ride "+
                                                   					  "\n The ride" + counter +" has started ");
                                                   			     counter++;
                                                   			     // à changer : afficher les messages du client 
                                
                                                   		}

                                                          
                                                           
                                                       // textdown.setText(myUber.toString()
                                                                                         //+ "blabla"
                                                                                        // );
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
                                                                          myUber.initiation();
                                                                          textdown.setText(myUber.toString());
                                                                          systemcreated=true;
                                                                          }catch(NumberFormatException e) {
                                                                                         textdown.setText("The setup method requires 2 arguments: the number of customers (int) and the  number of dri(int)");
                                                                          }
                                                           }
                                            }
                                            
                                            else if (commandsplitted[0].equals("addCustomer")) {
                                                if (commandsplitted.length != 4) {
                                                               textdown.setText("The addUser method requires 3 arguments: the name of the customer (String), the surname of the customer (String) and credit card number (int - 16 digits)");
                                                }else {
                                                               String name= commandsplitted[1];
                                                               String surname= commandsplitted[2];
                                                               int credit = 0;
                                                               try {
                                                               credit = Integer.valueOf(commandsplitted[3]);
                                                               } catch (Exception e) {
                                                            	   textdown.setText("Please enter a valid integer");
                                                               };
                                                               Customer customer = new Customer(name,surname, credit);
                                                               this.myUber.addCustomer(customer);
                                                               textdown.setText("Customer "+ customer.getName() + " " + customer.getSurname()+ " has succesfully been added. Id = " + customer.getCustomerID());
                                                               
                                                               
                                                               
                                                }
                                                
                                 }         else if (commandsplitted[0].equals("requestRide")) {
                                                   if (commandsplitted.length != 5) {
                                         textdown.setText("The requestRide method requires 4 arguments: the id of the customer (int), the number of passengers (between 1 and 6), the longitude and the latitude of the destination (between -50 and 50)");
                          }else {
                        	  int id = -1;
                              int nb = -1;
                              int longitude =-1;
                              int latitude = -1;
                              Map<String,Double> priceList = new HashMap<>();
                                         try {
                                        	  id = Integer.valueOf(commandsplitted[1]);
                                              nb = Integer.valueOf(commandsplitted[2]);
                                              longitude = Integer.valueOf(commandsplitted[3]);
                                              latitude = Integer.valueOf(commandsplitted[4]);
                                         } catch (Exception e) {
                                      	   textdown.setText("Please enter valid numbers");
                                         };
                                         try {
                                        	 priceList = myUber.customerList.get(id -1).requestRide(nb, new GPS(longitude, latitude),this.myUber);
                                         }catch(ArrayIndexOutOfBoundsException e) {
                                        	 textdown.setText("No customer with such id");
                                         }
                                         textdown.setText("This is the list of rides that we propose + priceList"
                                         		);
                                         
                                         //creation of a new generic ride to stock the info while the customer chooses
                                       
                                         UndefinedRide ride = new UndefinedRide(myUber.customerList.get(id - 1).getGPS(), new GPS(longitude, latitude),nb, priceList);
                                         ride.myUber = myUber;
                                         ride.customer = myUber.customerList.get(id - 1);
                                         
                                         this.waitingChoiceRide.put(id,ride);
                                         
                                        
                                 	    
                                        		 
                                        	
                                         
                                         
                                         
                                         
                                         
                                         
                          }
                          
           }               else if (commandsplitted [0].equals("choose") ) {
        	   if (commandsplitted.length != 2) {
        		   textdown.setText("The method choose takes one argument : UberX, UberVan, UberBlack or UberPool");
        	   }else if (waitingChoiceRide.isEmpty()) {
        		   textdown.setText("Please request a ride first");
        	   }else {
        	   
               String type = commandsplitted[1];
               int id = Integer.parseInt(commandsplitted[2]);
                
               // définir le traffic
               
               RideFactory factory = new RideFactory();
               Ride ride = factory.createRide(type, this.waitingChoiceRide.get(id ).getStart(), this.waitingChoiceRide.get(id ).getEnd(),this.waitingChoiceRide.get(id ).getNbPassengers());
               
       		   ride.price = this.waitingChoiceRide.get(id).priceList.get(type);
       		   
       		   
       	       ride.myUber = myUber;
       		
       	    myUber.requestedRides.add(ride) ; 
       	    waitingChoiceRide.remove(ride);
       	   textdown.setText("The ride has been successfully requested"
              		+ ride);
        	   }
           }

                                            
                                            
                                            
                                            else if (commandsplitted[0].equals("help")) {
                                                           textup.setText("List of the available methods: \n"
                                                                                         + "\n The setup method requires 2 arguments: the number of customers (int) and the total number of drivers(int)"
                                                                                         + "\n The addUser method requires 3 arguments: the name of the customer (String), the surname of the customer (String) and credit card number (int - 16 digits)"
                                                                                         + "The requestRide method requires 4 arguments: the id of the customer (int), the number of passengers (between 1 and 6), the longitude of the destination (between 2.22 and 2.44), the latitude (48.8 - 48.9)"
                                                                                          + "The method choose takes one argument : UberX, UberVan, UberBlack or UberPool");
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



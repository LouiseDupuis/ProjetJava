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
                                                           
                                                           myUber.initiation(20,20,10);
                                                           

                                                           
                                                           // ten clients request a ride
                                                           
                                                           textdown.setText(myUber.toString() +
                                                        		              " \n Ten clients request a Ride ");
                                                           // one of them is chosen from command line, the others are random 
                                                           
                                                           for(int i = 0; i < 9; i++) {
                                                        	   myUber.customerList.get(i).requestRandomRide(myUber, -1);
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
                                                           if (commandsplitted.length != 5) {
                                                                          textdown.setText("The setup method requires 4 arguments: the numbers of standard, berline and van cars (int) and the number of customers (int)");
                                                           }else {
                                                                          try {
                                                                          int n1= Integer.parseInt(commandsplitted[4]);
                                                                          
                                                                          int nbStandard = Integer.parseInt(commandsplitted[1]);
                                                                          int nbBerline = Integer.parseInt(commandsplitted[2]);
                                                                          int nbVan = Integer.parseInt(commandsplitted[3]);
                                                                          int n2= nbStandard + nbBerline + nbVan;
                                                                          myUber= new MyUber(n1,n2);
                                                                          myUber.initiation(nbStandard, nbBerline, nbVan);
                                                                          textdown.setText(myUber.toString());
                                                                          systemcreated=true;
                                                                          }catch(NumberFormatException e) {
                                                                                         textdown.setText("The setup method requires 4 arguments: the numbers of standard, berline and van cars (int) and the number of customers (int)");
                                                                          }
                                                           }
                                            }
                                            
                                            else if (commandsplitted[0].equals("addCustomer")) {
                                                if (commandsplitted.length != 3) {
                                                               textdown.setText("The addCustomer method requires 2 arguments: the name of the customer (String) and the surname of the customer (String)");
                                                }else {
                                                               String name= commandsplitted[1];
                                                               String surname= commandsplitted[2];
                                                               
                                                               Customer customer = new Customer(name,surname);
                                                               this.myUber.addCustomer(customer);
                                                               textdown.setText("Customer "+ customer.getName() + " " + customer.getSurname()+ " has succesfully been added. Id = " + customer.getCustomerID()
                                                               +"\n " + myUber.customerList.toString());
                                                               
                                                               
                                                               
                                                }
                                            } 
                                                
                                                
                                                else if (commandsplitted[0].equals("addCarDriver")) {
                                                    if (commandsplitted.length != 4) {
                                                                   textdown.setText("The addCarDriver method requires 3 arguments: the name of the driver (String) , the surname of the driver (String) and the type of his car (String)");
                                                    }else {
                                                                   String name= commandsplitted[1];
                                                                   String surname= commandsplitted[2];
                                                                   String type = commandsplitted[3];
                                                                   
                                                                   CarFactory cf = new CarFactory();
                                                                   Car car = cf.createCar(type);
                                                                   
                                                                   Driver driver = new Driver(name, surname, car);
                                                                   car.setDriver(driver);
                                                                   myUber.driverList.add(driver);
                                                                   myUber.carList.add(car);
                                                                   myUber.nbdrivers++;
                                                                   myUber.nbcars++;
                                                                   textdown.setText(myUber.driverList.toString() + "\n" + myUber.carList.toString());
                                                                   
                                                                   
                                                                   
                                                    }
                                                }
                                                    
                                                    else if (commandsplitted[0].equals("addDriver")) {
                                                        if (commandsplitted.length != 4) {
                                                                       textdown.setText("The addDriver method requires 3 arguments: the name of the driver (String) , the surname of the driver (String) and the id of his car (int)");
                                                        }else {
                                                                       String name= commandsplitted[1];
                                                                       String surname= commandsplitted[2];
                                                                       String id = commandsplitted[3];
                                                                       
                                                                      
                                                                       Driver driver = new Driver(name, surname, myUber.findCarByID(id));
                                                                       myUber.findCarByID(id).setDriver(driver);
                                                                       myUber.driverList.add(driver);
                                  
                                                                       myUber.nbdrivers++;
                                                                       
                                                                       textdown.setText(myUber.driverList.toString() + "\n" + myUber.carList.toString());
                                                                       
                                                                       
                                                                       
                                                        }
                                                    }
                                                        
                                                        
                                                        
                                                        
                                                        else if (commandsplitted[0].equals("setDriverStatus")) {
                                                            if (commandsplitted.length != 4) {
                                                                           textdown.setText("The setDriverStatus method requires 3 arguments: the name of the driver (String) , the surname of the driver (String) and the status (offduty, onduty or offline");
                                                            }else {
                                                                           String name= commandsplitted[1];
                                                                           String surname= commandsplitted[2];
                                                                           String status = commandsplitted[3];
                                                                           
                                                                           
                                                                           if (status.equals("offduty")) {
                                                                           myUber.findDriverByName(name, surname).setState(DriverState.OFFDUTY);
                                                                           }
                                                                           
                                                                           else if (status.equals("offline")) {
                                                                               myUber.findDriverByName(name, surname).setState(DriverState.OFFLINE);
                                                                               }
                                                                               
                                                                           else if (status.equals("onduty")) {
                                                                               myUber.findDriverByName(name, surname).setState(DriverState.ONDUTY);
                                                                               }
                                                                           else {
                                                                        	   textdown.setText("Please enter a valid status : offduty, onduty or offline");
                                                                           }
                                                                           textdown.setText(myUber.driverList.toString());
                                                                           
                                                                           
                                                                           
                                                            }
                                                        }
                                                            
                                                            
                                                            else if (commandsplitted[0].equals("moveCar")) {
                                                                if (commandsplitted.length != 4) {
                                                                               textdown.setText("The moveCar method requires 3 arguments: the id of the car (String) and the longitude and latitude of the GPS ");
                                                                }else {
                                                                               String id = commandsplitted[1];
                                                                               int x = Integer.parseInt(commandsplitted[2]);
                                                                               int y = Integer.parseInt(commandsplitted[3]);
                                                                               
                                                                               myUber.findCarByID(id).setGPS(new GPS(x,y));
                                                                               
                                                                               textdown.setText( myUber.carList.toString());
                                                                               
                                                                               
                                                                               
                                                                }
                                                            }
                                                                
                                                                
                                                                else if (commandsplitted[0].equals("moveCustomer")) {
                                                                    if (commandsplitted.length != 4) {
                                                                                   textdown.setText("The moveCustomer method requires 3 arguments: the id of the customer (int) and the longitude and latitude of the GPS ");
                                                                    }else {
                                                                                   int id = Integer.parseInt(commandsplitted[1]);
                                                                                   int x = Integer.parseInt(commandsplitted[2]);
                                                                                   int y = Integer.parseInt(commandsplitted[3]);
                                                                                   
                                                                                   myUber.findCustomerByID(id).setGPS(new GPS(x,y));
                                                                                   
                                                                                   textdown.setText( myUber.customerList.toString());
                                                                                   
                                                                                   
                                                                                   
                                                                    }
                                                                }
                                                                  
                                                                    else if (commandsplitted[0].equals("display")) {
                                                                    	
                                                                    textdown.setText(myUber.toString()
                                                                    		+ "\n" + myUber.customerList.toString()
                                                                    		+ "\n" + myUber.carList.toString()
                                                                    		+ "\n" + myUber.driverList.toString());
                                                            }
                                                        
                                                        
                                                                
                                                
                        else if (commandsplitted[0].equals("ask4price")) {
                                                   if (commandsplitted.length != 5) {
                                         textdown.setText("The requestRide method requires 4 arguments: the id of the customer (int), the longitude of the destination (between 2.22 and 2.44), the latitude (48.8 - 48.9) and the time (int)");
                                }else {
                        	  int id = -1;
                              int time = -1;
                              int longitude =-1;
                              int latitude = -1;
                              
                              Map<String,Double> priceList = new HashMap<>();
                                         try {
                                        	  id = Integer.valueOf(commandsplitted[1]);
                                              time = Integer.valueOf(commandsplitted[4]);
                                              longitude = Integer.valueOf(commandsplitted[2]);
                                              latitude = Integer.valueOf(commandsplitted[3]);
                                         } catch (Exception e) {
                                      	   textdown.setText("Please enter valid numbers");
                                         };
                                         
                                         
                                         
                                         
                                         try {
                                        	 System.out.println(myUber.customerList.get(id -1));
                                        	 
                                        	 priceList = myUber.customerList.get(id -1).requestRide(1, new GPS(longitude, latitude), this.myUber, time);
                                        	 System.out.println(priceList);
                                         }catch(ArrayIndexOutOfBoundsException e) {
                                        	 textdown.setText("No customer with such id");
                                         }
                                         textdown.setText("This is the list of rides that we propose" + priceList
                                         		);
                                         
                                         //creation of a new generic ride to stock the info while the customer chooses
                                       
                                         UndefinedRide ride = new UndefinedRide(myUber.customerList.get(id - 1).getGPS(), new GPS(longitude, latitude),1, priceList);
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
               Ride ride = factory.createRide(type, waitingChoiceRide.get(id ).getStart(), waitingChoiceRide.get(id ).getEnd(),waitingChoiceRide.get(id ).getNbPassengers());
               
       		   ride.price = waitingChoiceRide.get(id).priceList.get(type);
       		   
       		   
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


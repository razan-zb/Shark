

package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import javax.swing.JOptionPane;
import Model.Game;
import Model.Player;
import Model.Question;
import View.RootLayout;

public class Main implements Serializable {
	
	static Game game = null;
	public static TheGame system;
	
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME"); 
		
		 try {
	        	
	            system = loadDB();
	            system.LoadQuestions();
	    		for(Question q:system.getQuestionList().values())
	    			System.out.println(q);
	    		System.out.println(system.getQuestionList().size());
	            if (system == null) {
	                saveDB();
	            }else {
	                TheGame.updateCurrentInstance(system);
	            }
	        } catch (Exception e) {
	            
	        }

	        
	        try {
	        	
	            RootLayout lo = new RootLayout();
	            lo.setVisible(true);
	            
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "not");
	        }
	        
	    }

	    /**
	     * to load the hospital from TheGame.ser field
	     * @return TheGame obj
	     */
	    public static TheGame loadDB() {
	        
	        String fileName = "TheGame.ser";
	        TheGame cont =null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        
	        try {
	        	
	      
	            
	            fis = new FileInputStream(fileName);
	            in = new ObjectInputStream(fis);
	            cont = (TheGame)in.readObject();
	            
	   
	    		
	            in.close();
	            fis.close();
	            JOptionPane.showMessageDialog(null, " loaded successfully", "Loading DataBase", JOptionPane.INFORMATION_MESSAGE);
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "DataB"
	            		+ "ase wasn't found.", " DataBase is Missing", JOptionPane.ERROR_MESSAGE);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error in Reading DataBase", "Read DataBase Error", JOptionPane.INFORMATION_MESSAGE);
	        } catch (ClassNotFoundException c) {
	            c.printStackTrace();
	        } finally {
	        	
	            return cont;
	        }
	    }
	    
	    
	    /**
	     * saveDB to save all new data in the hospital to Hospital.ser field
	     * @throws IOException
	     */
	   
	    public static void saveDB() throws IOException {
	        
	        String fileName = "TheGame.ser";
	        TheGame db = TheGame.getInstance();
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        
	        try {
	      
	        	
	            fos = new FileOutputStream(fileName);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(db);
	            out.close();
	            fos.close();
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, "Saving  failed", "Save Error", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Saving  failed", "Save Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }  
		
}


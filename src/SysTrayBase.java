import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.datatransfer.*;
import java.awt.Toolkit;


public class SysTrayBase {

	SysTrayBase()
	{
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
		
		GeraCPF cpf= new GeraCPF(); 
		GeraRUT rut = new GeraRUT();
		listaCartoes lista = new listaCartoes();
		final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("images/bulb.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
       
        // Create a pop-up menu components
        MenuItem geraCPF = new MenuItem("Gerar CPF");
        MenuItem geraRUT= new MenuItem("Gerar RUT");
        MenuItem sair= new MenuItem("Sair");
//        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
//        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
          Menu menuCartaoBrasil = new Menu("Cartão Brasil");
          Menu menuCartaoArgentina = new Menu("Cartão Argentina");
          Menu menuCartaoChile = new Menu("Cartão Chile");
//        MenuItem errorItem = new MenuItem("Error");
//        MenuItem warningItem = new MenuItem("Warning");
          MenuItem brasilMaster = new MenuItem("MasterCard");
          MenuItem brasilVisa = new MenuItem("VISA");
          MenuItem brasilAmex = new MenuItem("AMEX");
          MenuItem chileMaster = new MenuItem("MasterCard");
          MenuItem chileVisa = new MenuItem("VISA");
          MenuItem chileAmex = new MenuItem("AMEX");
          MenuItem chileDiners = new MenuItem("Diners");
          MenuItem argentinaMaster = new MenuItem("MasterCard");
          MenuItem argentinaVisa = new MenuItem("VISA");
          MenuItem argentinaAmex = new MenuItem("AMEX");
          MenuItem argentinaDiners = new MenuItem("Diners");

//        MenuItem noneItem = new MenuItem("None");
//        MenuItem exitItem = new MenuItem("Exit");
       
        //Add components to pop-up menu
          popup.add(menuCartaoBrasil);
          popup.add(menuCartaoChile);
          popup.add(menuCartaoArgentina);
          popup.add(geraCPF);
          popup.add(geraRUT);
          popup.add(sair);
//        popup.addSeparator();
//        popup.add(cb1);
//        popup.add(cb2);
//        popup.addSeparator();
          
menuCartaoBrasil.add(brasilMaster);
menuCartaoBrasil.add(brasilVisa);
menuCartaoBrasil.add(brasilAmex);
menuCartaoChile.add(chileMaster);
menuCartaoChile.add(chileVisa);
menuCartaoChile.add(chileAmex);
menuCartaoChile.add(chileDiners);
menuCartaoArgentina.add(argentinaMaster);
menuCartaoArgentina.add(argentinaVisa);
menuCartaoArgentina.add(argentinaAmex);
menuCartaoArgentina.add(argentinaDiners);
//        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
		
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("CPF Rapido");
//            	System.out.println("  "+cpf.gerarCPF());
            	StringSelection stringSelection = new StringSelection(cpf.gerarCPF());
            	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clpbrd.setContents(stringSelection, null);
            	trayIcon.displayMessage("CPF Gerado!", "Copiado para área de transferência.", TrayIcon.MessageType.INFO);
            	
            	}
        });
        geraCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	System.out.println("GerandoCPF");
            	//System.out.println("  "+cpf.gerarCPF());
            	StringSelection stringSelection = new StringSelection(cpf.gerarCPF());
            	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clpbrd.setContents(stringSelection, null);
            	trayIcon.displayMessage("CPF Gerado!", "Copiado para área de transferência.", TrayIcon.MessageType.INFO);
            }
        });
        geraRUT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	System.out.println("GerandoRUT");
            	//System.out.println("   "+rut.generateRUT());
            	StringSelection stringSelection = new StringSelection(rut.generateRUT());
            	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clpbrd.setContents(stringSelection, null);
            	trayIcon.displayMessage("RUT Gerado!", "Copiado para área de transferência.", TrayIcon.MessageType.INFO);
            }
        });
	
        brasilVisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	System.out.println("brasilVisa");
            	StringSelection stringSelection = new StringSelection("4235647728025682");
            	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clpbrd.setContents(stringSelection, null);
            	trayIcon.displayMessage("Visa Brasil", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
            }
        });
        brasilMaster.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("brasilMaster");
                        StringSelection stringSelection = new StringSelection("5031433215406351");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Master Brasil", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });
        brasilAmex.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("brasilAmex");
                        StringSelection stringSelection = new StringSelection("375365153556885");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("AMEX Brasil", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });

        chileVisa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("chileVisa");
                        StringSelection stringSelection = new StringSelection("4168818844447115");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Visa Chile", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });
        chileMaster.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("chileMaster");
                        StringSelection stringSelection = new StringSelection("5416752602582580");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Master Chile", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });		
        chileAmex.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("chileAmex");
                        StringSelection stringSelection = new StringSelection("375778174461804");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Master Chile", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });
        chileDiners.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("chileDiners");
                        StringSelection stringSelection = new StringSelection(lista.retornaDiners());
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Diners Chile", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });

        argentinaVisa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("argentinaVisa");
                        StringSelection stringSelection = new StringSelection("4509953566233704");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Visa Argentina", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });		
        argentinaMaster.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("argentinaMaster");
                        StringSelection stringSelection = new StringSelection("5031755734530604");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Master Argentina", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });		
        argentinaAmex.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("argentinaAmex");
                        StringSelection stringSelection = new StringSelection("371180303257522");
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("AMEX Argentina", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });
        argentinaDiners.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    { 
                        System.out.println("argentinaDiners");
                        StringSelection stringSelection = new StringSelection(lista.retornaDiners());
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        trayIcon.displayMessage("Diners Argentina", "Copiado para a área de transferência.", TrayIcon.MessageType.INFO);
                    }
                });
        
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            System.exit(0);
            	
            }
        }
        
        
        );
        
        
	}
	 private static Image createImage(String path, String description) {
	        URL imageURL = SysTrayBase.class.getResource(path);
	        
	        if (imageURL == null) {
	            System.err.println("Resource not found: " + path);
	            JOptionPane.showMessageDialog(null,"Imagem nao encontrada");
	            return null;
	        } else {
	            return (new ImageIcon(imageURL, description)).getImage();
	        }
	    }
	
	
}


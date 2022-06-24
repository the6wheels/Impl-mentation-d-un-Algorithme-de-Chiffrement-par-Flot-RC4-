package TP3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class RC4algo {

	private JFrame frmCryptoTp;
	private JTextField text1;
	private JLabel result2;
	private JTextField text2;
    static short[] S;
    static short[] T;
    static byte[] enText;
    static byte[] deText;
    private JTextField result;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RC4algo window = new RC4algo();
					window.frmCryptoTp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});

	}


	public RC4algo() {
		initialize();
	}


	private void initialize() {

		 
		frmCryptoTp = new JFrame();
		frmCryptoTp.setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		frmCryptoTp.setForeground(UIManager.getColor("EditorPane.background"));
		frmCryptoTp.getContentPane().setBackground(UIManager.getColor("Label.foreground"));
		frmCryptoTp.setTitle("Crypto TP_03");
		frmCryptoTp.setBounds(100, 100, 462, 440);
		frmCryptoTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCryptoTp.getContentPane().setLayout(null);
		
		text1 = new JTextField();
		text1.setBackground(UIManager.getColor("Label.disabledForeground"));
		text1.setFont(new Font("Dialog", Font.PLAIN, 18));
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setForeground(new Color(176, 224, 230));
		text1.setBounds(45, 42, 369, 44);
		frmCryptoTp.getContentPane().add(text1);
		text1.setColumns(10);
		
		JLabel lblCreatedBy = new JLabel("Created By : Hadjazi + Amour");
		lblCreatedBy.setForeground(UIManager.getColor("EditorPane.background"));
		lblCreatedBy.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCreatedBy.setBounds(239, 348, 229, 38);
		frmCryptoTp.getContentPane().add(lblCreatedBy);
		
		JLabel lblGroupRssi = new JLabel("Group : RSSI - 01");
		lblGroupRssi.setForeground(UIManager.getColor("EditorPane.background"));
		lblGroupRssi.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblGroupRssi.setBounds(239, 371, 175, 38);
		frmCryptoTp.getContentPane().add(lblGroupRssi);
		
	    result2 = new JLabel("");
	    result2.setForeground(new Color(218, 112, 214));
	    result2.setHorizontalAlignment(SwingConstants.CENTER);
	    result2.setFont(new Font("Ubuntu Light", Font.BOLD | Font.ITALIC, 18));
		result2.setBounds(55, 290, 359, 55);
		frmCryptoTp.getContentPane().add(result2);
		
		JLabel lblInsetYourText = new JLabel("Inset your text");
		lblInsetYourText.setForeground(UIManager.getColor("EditorPane.background"));
		lblInsetYourText.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblInsetYourText.setBounds(51, 15, 120, 15);
		frmCryptoTp.getContentPane().add(lblInsetYourText);
		
		JLabel lblInsertKey = new JLabel("Insert KEY");
		lblInsertKey.setForeground(UIManager.getColor("EditorPane.background"));
		lblInsertKey.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblInsertKey.setBounds(55, 111, 103, 15);
		frmCryptoTp.getContentPane().add(lblInsertKey);
		
		text2 = new JTextField();
		text2.setBackground(UIManager.getColor("Menu.disabledForeground"));
		text2.setFont(new Font("Dialog", Font.PLAIN, 18));
		text2.setForeground(new Color(176, 224, 230));
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setColumns(10);
		text2.setBounds(176, 92, 238, 44);
		frmCryptoTp.getContentPane().add(text2);
		
		JRadioButton bit1 = new JRadioButton("128 bit");
		bit1.setBackground(UIManager.getColor("Label.foreground"));
		bit1.setForeground(Color.LIGHT_GRAY);
		bit1.setBounds(302, 216, 112, 23);
		frmCryptoTp.getContentPane().add(bit1);
		
		JRadioButton bit2 = new JRadioButton("256 bit");
		bit2.setBackground(UIManager.getColor("Label.foreground"));
		bit2.setForeground(Color.LIGHT_GRAY);
		bit2.setBounds(302, 252, 112, 23);
		frmCryptoTp.getContentPane().add(bit2);
		
		
		result = new JTextField();
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setForeground(new Color(176, 224, 230));
		result.setFont(new Font("Dialog", Font.PLAIN, 18));
		result.setColumns(10);
		result.setBackground(UIManager.getColor("Button.disabledText"));
		result.setBounds(45, 148, 369, 44);
		frmCryptoTp.getContentPane().add(result);
		
		
		
		ButtonGroup gpp = new ButtonGroup();
		gpp.add(bit1);
		gpp.add(bit2);
		
		JButton btnCE = new JButton("RC4 Encryption");
		btnCE.setBackground(SystemColor.desktop);
		btnCE.setForeground(new Color(230, 230, 250));
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
				
					

			            byte[] key = text2.getText().getBytes();
			            
						if (bit1.isSelected()) {
							RC4v128 rc = new RC4v128(new String(key));
				            String plainText = text1.getText();
				            enText = rc.encrypt(plainText.getBytes());
				            String encrypted = new String(enText, "UTF-8");
				            System.out.println("Encrypter is " + encrypted);
							result.setText(encrypted);
							result2.setForeground(Color.green);
							result2.setText("Successfully Encrypted with RC4");
							
						}else if (bit2.isSelected())
						{
							RC4v256 rc = new RC4v256(new String(key));
				            String plainText = text1.getText();
				            enText = rc.encrypt(plainText.getBytes());
				            String encrypted = new String(enText, "UTF-8");
				            System.out.println("Encrypter is " + encrypted);
							result.setText(encrypted);
							result2.setForeground(Color.green);
							result2.setText("Successfully Encrypted with RC4");
						}
						
			            


			     
					
}
				catch (Exception ex){
					result2.setText(ex.toString());
				}
			}
		});
		btnCE.setBounds(45, 216, 175, 25);
		frmCryptoTp.getContentPane().add(btnCE);
		
		JButton btnCD = new JButton("RC4 Decryption");
		btnCD.setBackground(SystemColor.desktop);
		btnCD.setForeground(new Color(230, 230, 250));
		btnCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {				

				            byte[] key = text2.getText().getBytes();
				            
							if (bit1.isSelected()) {
								RC4v128 rc = new RC4v128(new String(key));
					            deText = rc.decrypt(enText);
					            String Decrypted = new String(deText, "UTF-8");
					            System.out.println("Decrypted is " + Decrypted);				            
								text1.setText(Decrypted);
								result2.setForeground(Color.red);
								result2.setText("Successfully Decrypted with RC4");
							}else if (bit2.isSelected())
							{
								RC4v256 rc = new RC4v256(new String(key));
					            deText = rc.decrypt(enText);
					            String Decrypted = new String(deText, "UTF-8");
					            System.out.println("Decrypted is " + Decrypted);				            
								text1.setText(Decrypted);
								result2.setForeground(Color.red);
								result2.setText("Successfully Decrypted with RC4");
							}
				     
						
	}
				catch (Exception ex){
					result2.setText(ex.toString());
				}
			}
		});
		btnCD.setBounds(45, 253, 175, 25);
		frmCryptoTp.getContentPane().add(btnCD);
		

		
		
		
	}
	
// RC4 algo encryption and decryption
	
	public class RC4v256 {


	    public RC4v256(String keyString) {

	        if (keyString.length() < 1 && keyString.length() > 256) {
	            throw new IllegalArgumentException("Key lenght should be in between 1 and 256");
	        }

	        byte[] tempKey = keyString.getBytes();
	        short[] key = new short[tempKey.length];
	        int keyLength = tempKey.length;

	        for (int i = 0; i < keyLength; i++) {
	            key[i] = (short) ((short) tempKey[i] & 0xff);
	        }
	        ksa(key);

	    }


	    public void ksa(short[] key) {
	        short temp;
	        S = new short[256];
	        T = new short[256];

	        for (int i = 0; i < 256; i++) {
	            S[i] = (short) i;
	        }

	        int j = 0;
	        for (int i = 0; i < 256; i++) {
	            j = (j + S[i] + key[i % key.length]) % 256;

	            temp = S[i];
	            S[i] = S[j];
	            S[j] = temp;
	        }
	        System.arraycopy(S, 0, T, 0, S.length);
	    }

	    public byte[] genPad(int length) {
	        System.arraycopy(S, 0, T, 0, S.length);
	        int i = 0, j = 0;
	        short temp;
	        byte[] tempPpad = new byte[length];
	        for (int k = 0; k < length; k++) {
	            i = (i + 1) % 256;
	            j = (j + T[i]) % 256;

	            temp = T[i];
	            T[i] = T[j];
	            T[j] = temp;

	            tempPpad[k] = (byte) (T[(T[i] + T[j]) % 256]);
	        }
	        return tempPpad;
	    }

	    public byte[] encrypt(byte[] plain) {
	        byte[] pad = genPad(plain.length);
	        byte[] encrypt = new byte[plain.length];
	        for (int i = 0; i < plain.length; i++) {
	            encrypt[i] = (byte) (plain[i] ^ pad[i]);
	        }
	        return encrypt;
	    }

	    public byte[] decrypt(byte[] cipher) {
	        byte[] plain = encrypt(cipher);
	        return plain;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	public class RC4v128 {



	    public RC4v128(String keyString) {

	        if (keyString.length() < 1 && keyString.length() > 128) {
	            throw new IllegalArgumentException("Key lenght should be in between 1 and 128");
	        }

	        byte[] tempKey = keyString.getBytes();
	        short[] key = new short[tempKey.length];
	        int keyLength = tempKey.length;

	        for (int i = 0; i < keyLength; i++) {
	            key[i] = (short) ((short) tempKey[i] & 0xff);
	        }
	        ksa(key);

	    }


	    public void ksa(short[] key) {
	        short temp;
	        S = new short[128];
	        T = new short[128];

	        for (int i = 0; i < 128; i++) {
	            S[i] = (short) i;
	        }

	        int j = 0;
	        for (int i = 0; i < 128; i++) {
	            j = (j + S[i] + key[i % key.length]) % 128;

	            temp = S[i];
	            S[i] = S[j];
	            S[j] = temp;
	        }
	        System.arraycopy(S, 0, T, 0, S.length);
	    }

	    public byte[] genPad(int length) {
	        System.arraycopy(S, 0, T, 0, S.length);
	        int i = 0, j = 0;
	        short temp;
	        byte[] tempPpad = new byte[length];
	        for (int k = 0; k < length; k++) {
	            i = (i + 1) % 128;
	            j = (j + T[i]) % 128;

	            temp = T[i];
	            T[i] = T[j];
	            T[j] = temp;

	            tempPpad[k] = (byte) (T[(T[i] + T[j]) % 128]);
	        }
	        return tempPpad;
	    }

	    public byte[] encrypt(byte[] plain) {
	        byte[] pad = genPad(plain.length);
	        byte[] encrypt = new byte[plain.length];
	        for (int i = 0; i < plain.length; i++) {
	            encrypt[i] = (byte) (plain[i] ^ pad[i]);
	        }
	        return encrypt;
	    }

	    public byte[] decrypt(byte[] cipher) {
	        byte[] plain = encrypt(cipher);
	        return plain;
	    }
	}
}

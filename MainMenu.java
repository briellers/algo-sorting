import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class MainMenu extends javax.swing.JFrame {

	private javax.swing.JPanel contentPane;
	private javax.swing.JButton btnAdd;
	private JButton btnAdd_1;
	private javax.swing.JButton btnDelete;
	private JButton btnDelete_1;
	private javax.swing.JButton btnClear;
	private JButton btnClear_1;
	private javax.swing.JTextField inputTextField;
	private javax.swing.JLabel lblInputList;
	private javax.swing.JLabel lblInputNumber;
	private javax.swing.JButton btnSelectionSort;
	private JButton btnSelectionSort_1;
	private javax.swing.JButton btnBubbleSort;
	private JButton btnBubbleSort_1;
	private JTextArea inputList;
	private JTextArea sortedList;
    private JTextArea processList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() {	
		setTitle("Sorting Algorithms");
		initComponents();
		disableKeyCharacters();
	}
	
	private void disableKeyCharacters() 
	{
		
	        inputTextField.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                if ((((e.getKeyChar() < '0') || (e.getKeyChar() > '9')) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE))) {
	                    e.consume();
	                }
	            }
	        });
	    }
		
	private int[] inputs;
    private ArrayList <Integer> list = new ArrayList<>();
    private int num;
    
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 216, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAdd = new JButton();
		btnDelete = new JButton();
		btnClear = new JButton();
		btnSelectionSort= new JButton();
		btnBubbleSort = new JButton();
		
		
		btnAdd_1 = new JButton("ADD");
		btnAdd_1.setForeground(new Color(255, 255, 255));
		btnAdd_1.setBackground(new Color(224, 199, 192));
		btnAdd_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnAdd_1.setBounds(10, 63, 105, 38);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputTextField.getText().isEmpty()) {	
					JOptionPane.showMessageDialog(null, "You must enter a number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					num = Integer.parseInt(inputTextField.getText());
					list.add(num);
					inputTextField.setText("");
					System.out.println(list);
					inputList.append("[" + num + "]" + " , ");
				}
			
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdd_1);
		
		btnDelete_1 = new JButton("DELETE");
		btnDelete_1.setForeground(new Color(255, 255, 255));
		btnDelete_1.setBackground(new Color(224, 199, 192));
		btnDelete_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnDelete_1.setBounds(10, 112, 105, 38);
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputs = new int[list.size()];
				 if(list.isEmpty())
				 {
		                JOptionPane.showMessageDialog(null, "List is empty", "Error", JOptionPane.ERROR_MESSAGE);
		         } else {
		                list.remove(list.size() - 1);
		                System.out.println(list);
		                inputList.setText("");

		                for(int i = 0; i < list.size(); i++){
		                    inputs[i] = list.get(i);
		                }

		                for(int i = 0; i < list.size(); i++) {
		                    inputList.append("[" + inputs[i] + "]" + " , ");
		                }
		         }
			}
		});
		contentPane.add(btnDelete_1);
		
		btnClear_1 = new JButton("CLEAR");
		btnClear_1.setForeground(new Color(255, 255, 255));
		btnClear_1.setBackground(new Color(224, 199, 192));
		btnClear_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnClear_1.setBounds(10, 161, 105, 38);
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(inputList.getText().equals("")){
		                JOptionPane.showMessageDialog(null, "List already empty", "Warning", JOptionPane.ERROR_MESSAGE);
		            } else {
		            	list.clear();
		            	inputList.setText("");
		            	System.out.println(list);
		            }
				
			}
		});
		contentPane.add(btnClear_1);
		
		inputTextField = new JTextField();
		inputTextField.setForeground(new Color(255, 255, 255));
		inputTextField.setBackground(new Color(130, 181, 202));
		inputTextField.setBounds(125, 30, 295, 30);
		contentPane.add(inputTextField);
		inputTextField.setColumns(10);
		
		lblInputList = new JLabel("YOUR VALUES");
		lblInputList.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputList.setBounds(125, 71, 295, 16);
		contentPane.add(lblInputList);
		
		lblInputNumber = new JLabel("ENTER A NUMBER");
		lblInputNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputNumber.setBounds(125, 10, 295, 16);
		contentPane.add(lblInputNumber);
		
		btnSelectionSort_1 = new JButton("SELECTION SORT");
		btnSelectionSort_1.setBackground(new Color(245, 220, 213));
		btnSelectionSort_1.setForeground(new Color(112, 128, 144));
		btnSelectionSort_1.setBounds(125, 161, 140, 38);
		btnSelectionSort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnSelectionSort_1);
		
		btnBubbleSort_1 = new JButton("BUBBLE SORT");
		btnBubbleSort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll1();
                bubbleSort();
                
			}
		});
		btnBubbleSort_1.setBackground(new Color(245, 220, 213));
		btnBubbleSort_1.setForeground(new Color(112, 128, 144));
		btnBubbleSort_1.setBounds(280, 161, 140, 38);
		contentPane.add(btnBubbleSort_1);
		
		JLabel lblSorting = new JLabel("SORTING");
		lblSorting.setForeground(new Color(255, 255, 255));
		lblSorting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorting.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblSorting.setBounds(10, 16, 105, 16);
		contentPane.add(lblSorting);
		
		JLabel lblAlgorithms = new JLabel("ALGORITHMS");
		lblAlgorithms.setForeground(new Color(255, 255, 255));
		lblAlgorithms.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgorithms.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblAlgorithms.setBounds(10, 34, 105, 16);
		contentPane.add(lblAlgorithms);
		inputList = new JTextArea();
		inputList.setForeground(new Color(255, 255, 255));
		inputList.setBackground(new Color(96, 145, 150));
		inputList.setEditable(false);
		inputList.setBounds(125, 91, 295, 59);
		contentPane.add(inputList);
		
		JLabel lblProcess = new JLabel("SORTING PROCESS");
		lblProcess.setHorizontalAlignment(SwingConstants.LEFT);
		lblProcess.setBounds(10, 206, 118, 16);
		contentPane.add(lblProcess);
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnAscending.setBackground(new Color(178, 216, 235));
		rdbtnAscending.setBounds(234, 206, 92, 16);
		contentPane.add(rdbtnAscending);
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnDescending.setBackground(new Color(178, 216, 235));
		rdbtnDescending.setBounds(328, 206, 92, 16);
		contentPane.add(rdbtnDescending);
		
		JTextArea processList = new JTextArea();
		processList.setFont(new Font("Monospaced", Font.PLAIN, 12));
		processList.setEditable(false);
		btnClear_1.setBackground(new Color(224, 199, 192));
		processList.setBounds(10, 228, 410, 112);
		contentPane.add(processList);
		
		JLabel lblSortedValues = new JLabel("SORTED VALUES");
		lblSortedValues.setHorizontalAlignment(SwingConstants.LEFT);
		lblSortedValues.setBounds(10, 347, 118, 16);
		contentPane.add(lblSortedValues);
		
		JTextArea sortedList = new JTextArea();
		sortedList.setFont(new Font("Monospaced", Font.PLAIN, 12));
		sortedList.setEditable(false);
		sortedList.setBackground(new Color(96, 145, 150));
		sortedList.setBounds(10, 369, 410, 51);
		contentPane.add(sortedList);
		
	}
	
}

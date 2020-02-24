import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class MainMenu extends JFrame {
	
	private boolean isDoingBubbleSort = false;
	private boolean isDoingSelectionSort = false;
	private boolean hasSorted = false;
	private static JPanel contentPane;
	private static JButton addButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JTextField inputTextField;
	private JLabel lblInputList;
	private JLabel lblInputNumber;
	private JButton selectBtn;
	private JButton bubbleBtn;
	private JTextArea inputList;
	private JRadioButton ascend;
	private JRadioButton descend;
    
    private int[] inputs;
    private static ArrayList <Integer> list = new ArrayList<>();
    private int num;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextArea processList;
    private JScrollPane sortedScroll;
    private JTextArea sortedList;
    private JTextArea sortInfo;
	
	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
	}

	public MainMenu() {	
		setTitle("Sorting Algorithms");
		initComponents();
		actionButtons();
		disableKeyCharacters();
	}
	
	private void disableKeyCharacters() {		
	        inputTextField.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	            	if (e.getKeyCode()==KeyEvent.VK_ENTER){
		                if ((((e.getKeyChar() < '0') || (e.getKeyChar() > '9')) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE))) {
		                    e.consume();
		                }
	            	}
	            }
	        });
	    }
		
    
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 216, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		addButton = new JButton("ADD");
		deleteButton = new JButton("DELETE");
		clearButton = new JButton("CLEAR");
		bubbleBtn = new JButton("BUBBLE SORT");
		inputTextField = new JTextField();
		inputList = new JTextArea();
		selectBtn = new JButton("SELECTION SORT");
		
		JLabel lblSorting = new JLabel("SORTING");
		JLabel lblAlgorithms = new JLabel("ALGORITHMS");
		JLabel lblProcess = new JLabel("SORTING PROCESS");
		JLabel lblSortedValues = new JLabel("SORTED VALUES");
		
		ascend = new JRadioButton("Ascending");
		ascend.setSelected(true);
		buttonGroup.add(ascend);
		descend = new JRadioButton("Descending");
		buttonGroup.add(descend);
		
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBackground(new Color(224, 199, 192));
		addButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		addButton.setBounds(10, 63, 105, 38);
		
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setBackground(new Color(224, 199, 192));
		deleteButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		deleteButton.setBounds(10, 112, 105, 38);
		
		clearButton.setForeground(new Color(255, 255, 255));
		clearButton.setBackground(new Color(224, 199, 192));
		clearButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		clearButton.setBounds(10, 161, 105, 38);
		
		descend.setHorizontalAlignment(SwingConstants.RIGHT);
		descend.setBackground(new Color(178, 216, 235));
		descend.setBounds(328, 206, 92, 16);
		
		lblSortedValues.setHorizontalAlignment(SwingConstants.LEFT);
		lblSortedValues.setBounds(10, 347, 118, 16);
		
		inputTextField.setForeground(new Color(255, 255, 255));
		inputTextField.setBackground(new Color(130, 181, 202));
		inputTextField.setBounds(125, 30, 295, 30);
		inputTextField.setColumns(10);
		
		lblInputList = new JLabel("YOUR VALUES");
		lblInputList.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputList.setBounds(125, 71, 295, 16);
		
		lblInputNumber = new JLabel("ENTER A NUMBER");
		lblInputNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputNumber.setBounds(125, 10, 295, 16);
		
		lblSorting.setForeground(new Color(255, 255, 255));
		lblSorting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorting.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblSorting.setBounds(10, 16, 105, 16);
		
		lblProcess.setHorizontalAlignment(SwingConstants.LEFT);
		lblProcess.setBounds(10, 206, 118, 16);
		
		bubbleBtn.setBackground(new Color(245, 220, 213));
		bubbleBtn.setForeground(new Color(112, 128, 144));
		bubbleBtn.setBounds(280, 161, 140, 38);
		
		selectBtn.setBackground(new Color(245, 220, 213));
		selectBtn.setForeground(new Color(112, 128, 144));
		selectBtn.setBounds(125, 161, 140, 38);
		
		inputList.setForeground(new Color(255, 255, 255));
		inputList.setBackground(new Color(96, 145, 150));
		inputList.setEditable(false);
		inputList.setBounds(125, 91, 295, 59);
		
		ascend.setHorizontalAlignment(SwingConstants.RIGHT);
		ascend.setBackground(new Color(178, 216, 235));
		ascend.setBounds(234, 206, 92, 16);
		
		lblAlgorithms.setForeground(new Color(255, 255, 255));
		lblAlgorithms.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgorithms.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblAlgorithms.setBounds(10, 34, 105, 16);
		
		contentPane.setLayout(null);
		contentPane.add(addButton);		
		contentPane.add(deleteButton);
		contentPane.add(clearButton);				
		contentPane.add(descend);				
		contentPane.add(inputTextField);				
		contentPane.add(lblInputList);				
		contentPane.add(lblInputNumber);				
		contentPane.add(selectBtn);				
		contentPane.add(bubbleBtn);		
		contentPane.add(lblSorting);		
		contentPane.add(lblAlgorithms);		
		contentPane.add(inputList);		
		contentPane.add(lblProcess);		
		contentPane.add(ascend);
		contentPane.add(lblSortedValues);
		
		JScrollPane sortingScroll = new JScrollPane();
		sortingScroll.setBounds(10, 228, 410, 108);
		contentPane.add(sortingScroll);
		
		processList = new JTextArea();
		processList.setEditable(false);
		sortingScroll.setViewportView(processList);
		
		sortedScroll = new JScrollPane();
		sortedScroll.setBounds(10, 366, 240, 54);
		contentPane.add(sortedScroll);
		
		sortedList = new JTextArea();
		sortedList.setEditable(false);
		sortedList.setForeground(Color.WHITE);
		sortedList.setBackground(new Color(96, 145, 150));
		sortedScroll.setViewportView(sortedList);
		
		JLabel lblSortInformation = new JLabel("SORT INFORMATION");
		lblSortInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblSortInformation.setBounds(262, 347, 118, 16);
		contentPane.add(lblSortInformation);
		
		JScrollPane sortScroll = new JScrollPane();
		sortScroll.setBounds(262, 366, 158, 54);
		contentPane.add(sortScroll);
		
		sortInfo = new JTextArea();
		sortInfo.setEditable(false);
		sortScroll.setViewportView(sortInfo);
	}
	
	private void actionButtons(){
		addButton.addActionListener(new ActionListener() {
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
		
		deleteButton.addActionListener(new ActionListener() {
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
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(inputList.getText().equals("")){
		                JOptionPane.showMessageDialog(null, "List already empty", "Warning", JOptionPane.ERROR_MESSAGE);
		            } else {
		            	list.clear();
		            	inputList.setText("");
		            	sortedList.setText("");
		            	processList.setText("");
		            	sortInfo.setText("");
		            	System.out.println(list);
		            }
				
			}
		});

		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isDoingSelectionSort = true;
				hasSorted = true;
				processList.repaint();
				System.out.print(list.size());
	            inputs = new int[list.size()];
	            
	            for(Integer x : list){
	                System.out.println(x + " ");
	            }
	            
	            if(list.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "You must enter a number", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	                for (int i = 0; i < list.size(); i++) {
	                    inputs[i] = list.get(i);
	                }
	            }
				
				if (ascend.isSelected()) {
					removeAll1();
					selectionSort();
				}
				
				else if (descend.isSelected()) {
					removeAll1();	
					descendSelectionSort();
				}	
			}
		});
		
		ascend.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (isDoingBubbleSort = false && hasSorted) { // bubble sort	
					removeAll1();
					bubbleSort();
				} else if (isDoingSelectionSort = true && hasSorted) { // selection sort
					removeAll1();
					selectionSort();
				}
			}
		});
		
		descend.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (isDoingBubbleSort = true && hasSorted) { // bubble sort	
					removeAll1();
					descendBubbleSort();
				} else if (isDoingSelectionSort = false && hasSorted) { // selection sort
					removeAll1();
					descendSelectionSort();
				}
			}
		});
		
		bubbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isDoingBubbleSort = true;
				hasSorted = true;
				processList.repaint();
				System.out.print(list.size());
	            inputs = new int[list.size()];
	            
	            for(Integer x : list){
	                System.out.println(x + " ");
	            }
	            
	            if(list.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "You must enter a number", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	                for (int i = 0; i < list.size(); i++) {
	                    inputs[i] = list.get(i);
	                }
	            }

	            
				if (ascend.isSelected()) {
					removeAll1();
					bubbleSort();
				}
				
				else if (descend.isSelected()) {
					removeAll1();
					descendBubbleSort();				
				}
			}
		});
	}
	
	private void removeAll1(){
        sortedList.setText("");
        processList.setText("");
        sortInfo.setText("");
    }	
	
	private void bubbleSort(){
		removeAll1();
		
		processList.append("Bubble Sort - Ascending\n\n");
		
        int[] bubbleArr = new int[list.size()];
        int swaps = 0, comparisons = 0, passes = 0;
        System.arraycopy(inputs, 0, bubbleArr, 0, inputs.length);

        for(int i = 0; i < bubbleArr.length - 1; i++) {
            if(i == 0)
                processList.append("Pass #" + (i+1) + ": ");
            else
                processList.append("\nPass #" + (i+1) + ": ");
            
            for(int j = 0; j < bubbleArr.length - i - 1; j++) {
            	comparisons++;
                if (bubbleArr[j] > bubbleArr[j + 1]) {
                	swaps++;
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j + 1];
                    bubbleArr[j + 1] = temp;
                }
            }

            for (int value : bubbleArr) {
                processList.append(value + " ");
            }

            boolean isArranged = true;

            for(int z = 0; z < bubbleArr.length; z++) {
                if(z+1 < bubbleArr.length) {
                    if(bubbleArr[z] > bubbleArr[z+1]) {
                        isArranged = false;
                        break;
                    }
                }
            }
            
            if(isArranged){
            	passes = i;
                break;
            }
        }
        
        for (int input : bubbleArr) {
            sortedList.append(input + " ");
        }
        
        sortInfo.append("Passes: " + (passes+1));
        sortInfo.append("\nSwaps: " + swaps);
        sortInfo.append("\nComparisons: " + comparisons);
    }
	
	private void descendBubbleSort() {
		removeAll1();
		
		processList.append("Bubble Sort - Descending\n\n");

        int[] descBubbleSort = new int[list.size()];
        int swaps = 0, comparisons = 0, passes = 0;
        System.arraycopy(inputs, 0, descBubbleSort, 0, inputs.length);

        for(int i = 0; i < descBubbleSort.length - 1; i++){
        	if(i == 0)
                processList.append("Pass #" + (i+1) + ": ");
            else
                processList.append("\nPass #" + (i+1) + ": ");

            for(int j = 0; j < descBubbleSort.length - i - 1; j++) {
            	comparisons++;
                if (descBubbleSort[j] < descBubbleSort[j + 1]) {
                	swaps++;
                    int temp = descBubbleSort[j];
                    descBubbleSort[j] = descBubbleSort[j + 1];
                    descBubbleSort[j + 1] = temp;
                }
            }

            for (int value : descBubbleSort) {
                processList.append(value + " ");
            }

            boolean isArranged = true;

            for(int z = 0; z < descBubbleSort.length; z++) {
                if(z+1 < descBubbleSort.length){
                    if(descBubbleSort[z] < descBubbleSort[z+1]) {
                        isArranged = false;
                        break;
                    }
                }
            }
            if(isArranged){
            	passes = i;
                break;
            }
        }
        for (int input : descBubbleSort) {
        	sortedList.append(input + " ");
        }
        
        sortInfo.append("Passes: " + (passes+1));
        sortInfo.append("\nSwaps: " + swaps);
        sortInfo.append("\nComparisons: " + comparisons);
	}
	
	private void selectionSort() {
		removeAll1();
		
		processList.append("Selection Sort - Ascending\n\n");
		
		int[] selectionArr = new int[list.size()];
		int swaps = 0, comparisons = 0, passes = 0;
        System.arraycopy(inputs,0, selectionArr, 0, inputs.length);

        for(int i = 0; i < selectionArr.length - 1; i++){
        	if(i == 0)
                processList.append("Pass #" + (i+1) + ": ");
            else
                processList.append("\nPass #" + (i+1) + ": ");

            int min_index = i;

            for(int j = i + 1; j < selectionArr.length; j++) {
            	comparisons++;
                if (selectionArr[j] < selectionArr[min_index]) {
                	swaps++;
                    min_index = j;
                }
            }

            int temp = selectionArr[min_index];
            selectionArr[min_index] = selectionArr[i];
            selectionArr[i] = temp;

            for (int value : selectionArr) {
                processList.append(value + " ");
            }

            boolean isArrange = true;

            for(int z = 0; z < selectionArr.length; z++) {
                if(z+1 < selectionArr.length){
                    if(selectionArr[z] < selectionArr[z+1]) {
                        isArrange = false;
                        break;
                    }
                }
            }

            if(isArrange){
            	break;
            }
            
            passes = i;

        }

        for(int input : selectionArr){
        	sortedList.append(input + " ");
        }
        
        sortInfo.append("Passes: " + (passes+1));
        sortInfo.append("\nSwaps: " + swaps);
        sortInfo.append("\nComparisons: " + comparisons);
	}
	
	private void descendSelectionSort() {
		removeAll1();

		processList.append("Selection Sort - Descending\n\n");
        int[] selectionArr = new int[list.size()];
        int swaps = 0, comparisons = 0, passes = 0;
        System.arraycopy(inputs,0, selectionArr, 0, inputs.length);

        for(int i = 0; i < selectionArr.length - 1; i++) {
        	if(i == 0)
                processList.append("Pass #" + (i+1) + ": ");
            else
                processList.append("\nPass #" + (i+1) + ": ");

            int max_index = i;

            for(int j = i + 1; j < selectionArr.length; j++) {
            	comparisons++;
                if (selectionArr[j] > selectionArr[max_index]) {
                	swaps++;
                    max_index = j;
                }
            }

            int temp = selectionArr[max_index];
            selectionArr[max_index] = selectionArr[i];
            selectionArr[i] = temp;

            for (int value : selectionArr) {
                processList.append(value + " ");
            }

            boolean isArrange = true;

            for(int z = 0; z < selectionArr.length; z++) {
                if(z + 1 < selectionArr.length){
                    if(selectionArr[z] > selectionArr[z+1]) {
                        isArrange = false;
                        break;
                    }
                }
            }

            if(isArrange){
                break;
            }
            
            passes = i;

        }

        for(int input : selectionArr){
        	sortedList.append(input + " ");
        }
        
        sortInfo.append("Passes: " + (passes+1));
        sortInfo.append("\nSwaps: " + swaps);
        sortInfo.append("\nComparisons: " + comparisons);
	}
}
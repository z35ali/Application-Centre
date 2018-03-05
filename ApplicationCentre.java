	import java.awt.*;
	import java.awt.event.*;
	
	import javax.swing.*;
	
	class Student{
		private String studentName;
		private	int average;
		private String uni1;
		private String uni2;
		private String uni3;
		private boolean admitted1=false;
		private boolean admitted2=false;
		private boolean admitted3=false;
		
		public Student(String sName, int mark, String university1, String university2, String university3, boolean a1, boolean a2, boolean a3) {
			studentName=sName;
			average=mark;
			uni1=university1;
			uni2=university2;
			uni3=university3;
			admitted1=a1;
			admitted2=a2;
			admitted3=a3;
			
		}
		
		public String getSName(){
			return studentName;
		}
		public void setSName(String s){
			 studentName=s;
		}
		
		
		public int getAverage() {
			return average;
		}
		public String getAmittted1() {
			if (admitted1) {
				return ("admitted");
			}else {
				return ("rejected");
			}
		}
		public String getAmittted2() {
			if (admitted2) {
				return ("admitted");
			}else {
				return ("rejected");
			}
		}
		public String getAmittted3() {
			if (admitted3) {
				return ("admitted");
			}else {
				return ("rejected");
			}
		}
		public void setAdmitted1(boolean admit1) {
			admitted1=admit1;
		}
		public void setAdmitted2(boolean admit2) {
			admitted2=admit2;
		}
		public void setAdmitted3(boolean admit3) {
			admitted3=admit3;
		}
		public String toString() {
			return (studentName+", "+"average="+average+", "+uni1+"-"+admitted1+", "+uni2+"-"+admitted2+", "+uni3+"-"+admitted3);
		}
	}
	public class ApplicationCentre extends JApplet{
		boolean result=false;
		private boolean c1,c2,c3;
		private JTextArea textarea, searchArea;
		private JButton inputButton,displayButton,submitButton,searchButton,submitButtonsearch;
		private JPanel input,buttons,texts, displayallp, search;
		private JLabel namel, averagel, unil,uni2l,uni3l,searchl;
		private JTextField namef, averagef,hsf,searchf;
		private JList choices;
		private int count=4;
		private Student stdInfo [] = new Student [100];
		String [] uni10= {"Toronto","York","Western","Brock","Guelph", "Waterloo", "McGill", "Concordia", "Laval", "MacMaster"};
		
	    
	
		public void init() {
			setSize(700,500);
				 c1= CheckAdmit("Toronto", 75);
				 c2=   CheckAdmit("MacMaster", 75);
				c3=    CheckAdmit("Waterloo", 75);
			Student newStudent=new Student ("Jason",75,"Toronto", "MacMaster", "Waterloo",c1,c2,c3);
		    stdInfo [0]=newStudent;
		    
		    
		    c1= CheckAdmit("Western", 80);
		 	 c2=   CheckAdmit("Laval", 80);
		 	c3=    CheckAdmit("Brock", 80);
		 newStudent=new Student ("Andrew",80,"Western", "Laval", "Brock",c1,c2,c3);
		 stdInfo [1]=newStudent;
		 
		  c1= CheckAdmit("MacMaster", 100);
			 c2=   CheckAdmit("McGill", 100);
			c3=    CheckAdmit("Toronto", 100);
		newStudent=new Student ("Zafar",100,"MacMaster", "McGill", "Toronto",c1,c2,c3);
		stdInfo [2]=newStudent;
		
		    c1= CheckAdmit("Concordia", 90);
			 c2=   CheckAdmit("McGill", 90);
			c3=    CheckAdmit("York", 90);
		newStudent=new Student ("Donall",90,"Concordia", "McGill", "York",c1,c2,c3);
	   stdInfo [3]=newStudent;
	   
	   	c1=false;
	   	c2=false;
	   	c3=false;
	   
			
			Container container=getContentPane();
			
			buttons= new JPanel (new GridLayout (3,1,10,10)); 
			input=new JPanel(new GridLayout (1,10,5,5)); 
			displayallp= new JPanel(new GridLayout (1,10,5,5)); 
			search=new JPanel(new GridLayout (2,5,5,5)); 
			
			inputButton=new JButton ("Input");
			buttons.add(inputButton);
		
			
			displayButton=new JButton ("Display All");
			buttons.add(displayButton);
			
			
			searchButton=new JButton("Search");
			buttons.add(searchButton);
			container.add(buttons,BorderLayout.WEST);
			
			container.add(input,BorderLayout.CENTER);
			container.add(displayallp,BorderLayout.EAST);
			
			
			texts = new JPanel (new GridLayout(10,1));
			
			unil=new JLabel ("Enter you Information");
			texts.add(unil);
			namel=new JLabel ("Last Name");
			namef=new JTextField();
			texts.add(namel);
			texts.add(namef);
			
			averagel=new JLabel("Average");
			averagef=new JTextField();
			texts.add(averagel);
			texts.add(averagef);
			
			uni2l=new JLabel ("                 Choose your University");
			texts.add(uni2l);
			uni3l=new JLabel ("       By Holding CTRL On the right   ");
			texts.add(uni3l);
			
			submitButton= new JButton ("Submit");
			texts.add(submitButton);
			
			textarea= new JTextArea(20, 20);
			textarea.setFont(new Font("Serif", Font.ITALIC, 12));
			displayallp.add(textarea);
			
			
			searchl=new JLabel("Search");
			searchf=new JTextField();
			search.add(searchl);
			search.add(searchf);
			submitButtonsearch= new JButton ("Submit");
			search.add(submitButtonsearch);
			searchArea= new JTextArea(20, 20);
			searchArea.setFont(new Font("Arial", Font.BOLD, 14));
			searchArea.setLineWrap(true);
			searchArea.setWrapStyleWord(true);
			search.add(searchArea);
		
			
			
			
			
		choices=new JList(uni10);
		input.add(texts);
		input.add(choices);
	
		input.setVisible(false);
		displayallp.setVisible(false);
		search.setVisible(false);
		buttons.setVisible(true);
		
		searchButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  container.remove(input);
				  container.remove(displayallp);
				  container.add(search);
				  search.setVisible(true);
				  input.setVisible(false);
				  displayallp.setVisible(false);
					
			  } 
			} );
		submitButtonsearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				result=false;
				System.out.println(count);
				  for (int i=0; i<count;i++) {
				  if (searchf.getText().equals(stdInfo[i].getSName())) {
					  result=true;
					  searchArea.setText(stdInfo[i].toString());  
				  }
					  
				  }
				  if (!result) {
					  searchArea.setText("STUDENT NOT FOUND");  
				  }
				
				  
			  } 
			} );
		inputButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  container.remove(search);
				  container.add(input);
				  input.setVisible(true);
				  
				  displayallp.setVisible(false);
					
			  } 
			} );
		displayButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  container.remove(search);
				  container.remove(input);
				  container.add(displayallp);
				  input.setVisible(false);
				  displayallp.setVisible(true);
				  String displayallStudents="";
				  Student temp;
			          		
	          	
				  for (int t = 0; t < stdInfo.length-1; t++) {
			            for (int i= 0; i < stdInfo.length - t -1; i++) {
			            	
			            	if (stdInfo[i+1]!=null) {
			                if((stdInfo[i+1].getSName()).compareToIgnoreCase((stdInfo[i].getSName()))<0) {
			                    temp= stdInfo[i];
			                    stdInfo[i] = stdInfo[i + 1];
			                    stdInfo[i + 1] = temp;
			            }
			            }
			            }
			        }
				  for (int i=0;i<count;i++) {
					  displayallStudents+=stdInfo[i].toString()+"\n";
					}
				  textarea.setText(displayallStudents);
			  } 
			} );
		submitButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  
				   Object [] unisListSelected = choices.getSelectedValues();
				     String [] selectedUnis = new String[unisListSelected.length];
				     for (int i=0;i<selectedUnis.length; i++ ){
				      selectedUnis[i] = (String) unisListSelected[i];
				      
				     }
				   
				     String trimAverage=(averagef.getText().trim());
				    
				    	 c1= CheckAdmit(selectedUnis[0], Integer.parseInt(trimAverage));
						 c2=    CheckAdmit(selectedUnis[1], Integer.parseInt(trimAverage));
						  c3=   CheckAdmit(selectedUnis[2], Integer.parseInt(trimAverage));
						  
				     Student newStudent=new Student (namef.getText().trim(),Integer.parseInt(trimAverage),selectedUnis[0],selectedUnis[1], selectedUnis[2],c1,c2,c3);
				   
				  stdInfo [count]=newStudent;
				  count++;
				  namef.setText(" ");
				  averagef.setText(" ");
				  choices .clearSelection();
				     
				  JOptionPane.showMessageDialog(container, "Student "+count+" out of 100"); 
			  } 
			} );
		
		
			  
			
		}
	public boolean CheckAdmit(String u, int average) {
			if(average>100) {
				average=100;
			}
		if ((u.equals("Toronto")&&average>=90)){
			return true;
		}else if ((u.equals("York")&&average>=84)){
			return true;
		}else if ((u.equals("Brock")&&average>=75)){
			return true;
		}else if ((u.equals("Guelph")&&average>=76)){
			return true;
		}
			else if ((u.equals("Waterloo")&&average>=88)){
				return true;
			}
			else if ((u.equals("McGill")&&average>=90)){
				return true;
			}
			else if ((u.equals("Concordia")&&average>=76)){
				return true;
			}
			else if ((u.equals("Laval")&&average>=78)){
				return true;
			}
			else if ((u.equals("MacMaster")&&average>=82)){
				return true;
			}
			else if ((u.equals("Western")&&average>=80)){
				return true;
			}
			else {
				return false;
			}
			
	}
		}
	
	

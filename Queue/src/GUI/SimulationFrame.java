package GUI;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimulationFrame extends JFrame {


    private JLabel currentTimeLabel;
    private JTextArea currentTimeField;

    private JLabel timeLabel;
    private JLabel timeLabelMin;
    private JLabel timeLabelMax;
    private JTextField timeMinField;
    private JTextField timeMaxField;
    private JLabel clientsLabel;

    private JLabel serviceLabel;
    private JLabel serviceLabelMin;
    private JLabel serviceLabelMax;
    private JTextField serviceMinField;
    private JTextField serviceMaxField;
    private JTextField clientsField;

    private JLabel nbQueues;
    private JTextField nbQueuesField;

    private JLabel simulation;
    private JTextField simulationField;

    private JLabel extraInterval;
    private JLabel extraIntervalMin;
    private JLabel extraIntervalMax;
    private JTextField extraIntervalMinField;
    private JTextField extraIntervalMaxField;

    private JButton startButton;

    private JTextArea logsField;
    private JLabel logsLabel;
    private JScrollPane logScrollPane;

    private JTextArea minimumOutputField;
    private JLabel minimumOutputLabel;
    private JScrollPane minimumOutputScrollPane;

    private JLabel q1Label;
    private JLabel q2Label;
    private JLabel q3Label;
    private JLabel q4Label;
    private JLabel q5Label;
    private JLabel q6Label;
    private JLabel q7Label;
    private JLabel q8Label;
    private JLabel q9Label;
    private JLabel q10Label;
    private JLabel q11Label;
    private JLabel q12Label;
    private JLabel q13Label;
    private JLabel q14Label;
    private JLabel q15Label;
    private JLabel q16Label;
    private JLabel q17Label;
    private JLabel q18Label;
    private JLabel q19Label;
    private JLabel q20Label;



    private JTextArea q1Field;
    private JTextArea q2Field;
    private JTextArea q3Field;
    private JTextArea q4Field;
    private JTextArea q5Field;
    private JTextArea q6Field;
    private JTextArea q7Field;
    private JTextArea q8Field;
    private JTextArea q9Field;
    private JTextArea q10Field;
    private JTextArea q11Field;
    private JTextArea q12Field;
    private JTextArea q13Field;
    private JTextArea q14Field;
    private JTextArea q15Field;
    private JTextArea q16Field;
    private JTextArea q17Field;
    private JTextArea q18Field;
    private JTextArea q19Field;
    private JTextArea q20Field;

    public SimulationFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 1500, 800);
        this.getContentPane().setLayout(null);

        // use a bigger font
        Font biggerFont = new Font("Times New Roman", Font.PLAIN, 18);
        Font hugeFont = new Font("Times New Roman",Font.PLAIN,32);

        timeLabel = new JLabel("Arrival times : ");
        timeLabel.setFont(biggerFont);
        timeLabel.setBounds(50, 50, 300, 30);
        getContentPane().add(timeLabel);

        timeLabelMin = new JLabel("min : ");
        timeLabelMin.setFont(biggerFont);
        timeLabelMin.setBounds(180, 50, 50, 30);
        getContentPane().add(timeLabelMin);

        timeMinField = new JTextField();
        timeMinField.setBounds(220, 50, 30, 30);
        getContentPane().add(timeMinField);

        timeLabelMax = new JLabel("max : ");
        timeLabelMax.setFont(biggerFont);
        timeLabelMax.setBounds(260, 50, 50, 30);
        getContentPane().add(timeLabelMax);

        timeMaxField = new JTextField();
        timeMaxField.setBounds(310, 50, 30, 30);
        getContentPane().add(timeMaxField);

        serviceLabel = new JLabel("Service duration. ");
        serviceLabel.setFont(biggerFont);
        serviceLabel.setBounds(50, 80, 150, 30);
        getContentPane().add(serviceLabel);

        serviceLabelMin = new JLabel("min : ");
        serviceLabelMin.setFont(biggerFont);
        serviceLabelMin.setBounds(180, 80, 50, 30);
        getContentPane().add(serviceLabelMin);

        serviceMinField = new JTextField();
        serviceMinField.setBounds(220, 80, 30, 30);
        getContentPane().add(serviceMinField);

        serviceLabelMax = new JLabel("max : ");
        serviceLabelMax.setFont(biggerFont);
        serviceLabelMax.setBounds(260, 80, 50, 30);
        getContentPane().add(serviceLabelMax);

        serviceMaxField = new JTextField();
        serviceMaxField.setBounds(310, 80, 30, 30);
        getContentPane().add(serviceMaxField);

        nbQueues = new JLabel("Number of queues (max 20) :");
        nbQueues.setFont(biggerFont);
        nbQueues.setBounds(50, 110, 300, 30);
        getContentPane().add(nbQueues);

        nbQueuesField = new JTextField();
        nbQueuesField.setBounds(310, 110, 50, 30);
        getContentPane().add(nbQueuesField);

        simulation = new JLabel("Simulation interval : ");
        simulation.setFont(biggerFont);
        simulation.setBounds(50, 140, 200, 30);
        getContentPane().add(simulation);

        simulationField = new JTextField();
        simulationField.setBounds(200, 140, 30, 30);
        getContentPane().add(simulationField);

        clientsLabel = new JLabel("Number of clients:");
        clientsLabel.setBounds(50, 20, 150, 30);
        clientsLabel.setFont(biggerFont);
        getContentPane().add(clientsLabel);

        clientsField = new JTextField();
        clientsField.setBounds(200, 20, 100, 30);
        getContentPane().add(clientsField);

        /// BUTTONS
        /// ---------------------------------------------------------------------------------

        startButton = new JButton("Start Simulation");
        startButton.setBounds(50, 200, 150, 50);
        getContentPane().add(startButton);

        // ------------------------------------------------------------------------------------------

        /// LOGS
        /// ---------------------------------------------------------------------------------------------
        logScrollPane = new JScrollPane();
        logScrollPane.setBounds(600, 20, 250, 300); // updated x-coordinate to 1070
        logsField = new JTextArea();
        logsField.setEditable(false);
        logScrollPane.setViewportView(logsField);
        getContentPane().add(logScrollPane);

        logsField.setText("");

        logsLabel = new JLabel("Logs : ");
        logsLabel.setBounds(600, 0, 100, 30); // updated x-coordinate to 1070
        getContentPane().add(logsLabel);


        // ----------------------------------------------------------------------------------------------------


        /// QUEUE ZONE
        /// ------------------------------------------------------------------------------------

        q1Label = new JLabel("Q1");
        q1Label.setBounds(10, 300, 43, 30);
        getContentPane().add(q1Label);

        q1Field = new JTextArea();
        q1Field.setEditable(false);
        q1Field.setBounds(10, 350, 43, 300);
        q1Field.setFont(hugeFont);
        getContentPane().add(q1Field);

        q2Label = new JLabel("Q2");
        q2Label.setBounds(60, 300, 43, 30);
        getContentPane().add(q2Label);

        q2Field = new JTextArea();
        q2Field.setEditable(false);
        q2Field.setBounds(60, 350, 43, 300);
        q2Field.setFont(hugeFont);
        getContentPane().add(q2Field);

        q3Label = new JLabel("Q3");
        q3Label.setBounds(110, 300, 43, 30);
        getContentPane().add(q3Label);

        q3Field = new JTextArea();
        q3Field.setEditable(false);
        q3Field.setBounds(110, 350, 43, 300);
        q3Field.setFont(hugeFont);
        getContentPane().add(q3Field);

        q4Label = new JLabel("Q4");
        q4Label.setBounds(160, 300, 43, 30);
        getContentPane().add(q4Label);

        q4Field = new JTextArea();
        q4Field.setEditable(false);
        q4Field.setBounds(160, 350, 43, 300);
        q4Field.setFont(hugeFont);
        getContentPane().add(q4Field);

        q5Label = new JLabel("Q5");
        q5Label.setBounds(210, 300, 43, 30);
        getContentPane().add(q5Label);

        q5Field = new JTextArea();
        q5Field.setEditable(false);
        q5Field.setBounds(210, 350, 43, 300);
        q5Field.setFont(hugeFont);
        getContentPane().add(q5Field);

        q6Label = new JLabel("Q6");
        q6Label.setBounds(260, 300, 43, 30);
        getContentPane().add(q6Label);

        q6Field = new JTextArea();
        q6Field.setEditable(false);
        q6Field.setBounds(260, 350, 43, 300);
        q6Field.setFont(hugeFont);
        getContentPane().add(q6Field);

        q7Label = new JLabel("Q7");
        q7Label.setBounds(310, 300, 43, 30);
        getContentPane().add(q7Label);

        q7Field = new JTextArea();
        q7Field.setEditable(false);
        q7Field.setBounds(310, 350, 43, 300);
        q7Field.setFont(hugeFont);
        getContentPane().add(q7Field);

        q8Label = new JLabel("Q8");
        q8Label.setBounds(360, 300, 43, 30);
        getContentPane().add(q8Label);

        q8Field = new JTextArea();
        q8Field.setEditable(false);
        q8Field.setBounds(360, 350, 43, 300);
        q8Field.setFont(hugeFont);
        getContentPane().add(q8Field);

        q9Label = new JLabel("Q9");
        q9Label.setBounds(410, 300, 43, 30);
        getContentPane().add(q9Label);

        q9Field = new JTextArea();
        q9Field.setEditable(false);
        q9Field.setBounds(410, 350, 43, 300);
        q9Field.setFont(hugeFont);
        getContentPane().add(q9Field);

        q10Label = new JLabel("Q10");
        q10Label.setBounds(460, 300, 43, 30);
        getContentPane().add(q10Label);

        q10Field = new JTextArea();
        q10Field.setEditable(false);
        q10Field.setBounds(460, 350, 43, 300);
        q10Field.setFont(hugeFont);
        getContentPane().add(q10Field);

        q11Label = new JLabel("Q11");
        q11Label.setBounds(510, 300, 43, 30);
        getContentPane().add(q11Label);

        q11Field = new JTextArea();
        q11Field.setEditable(false);
        q11Field.setBounds(510, 350, 43, 300);
        q11Field.setFont(hugeFont);
        getContentPane().add(q11Field);

        q12Label = new JLabel("Q12");
        q12Label.setBounds(560, 300, 43, 30);
        getContentPane().add(q12Label);

        q12Field = new JTextArea();
        q12Field.setEditable(false);
        q12Field.setBounds(560, 350, 43, 300);
        q12Field.setFont(hugeFont);
        getContentPane().add(q12Field);

        q13Label = new JLabel("Q13");
        q13Label.setBounds(610, 300, 43, 30);
        getContentPane().add(q13Label);

        q13Field = new JTextArea();
        q13Field.setEditable(false);
        q13Field.setBounds(610, 350, 43, 300);
        q13Field.setFont(hugeFont);
        getContentPane().add(q13Field);

        q14Label = new JLabel("Q14");
        q14Label.setBounds(660, 300, 43, 30);
        getContentPane().add(q14Label);

        q14Field = new JTextArea();
        q14Field.setEditable(false);
        q14Field.setBounds(660, 350, 43, 300);
        q14Field.setFont(hugeFont);
        getContentPane().add(q14Field);

        q15Label = new JLabel("Q15");
        q15Label.setBounds(710, 300, 43, 30);
        getContentPane().add(q15Label);

        q15Field = new JTextArea();
        q15Field.setEditable(false);
        q15Field.setBounds(710, 350, 43, 300);
        q15Field.setFont(hugeFont);
        getContentPane().add(q15Field);

        q16Label = new JLabel("Q16");
        q16Label.setBounds(760, 300, 43, 30);
        getContentPane().add(q16Label);

        q16Field = new JTextArea();
        q16Field.setEditable(false);
        q16Field.setBounds(760, 350, 43, 300);
        q16Field.setFont(hugeFont);
        getContentPane().add(q16Field);

        q17Label = new JLabel("Q17");
        q17Label.setBounds(810, 300, 43, 30);
        getContentPane().add(q17Label);

        q17Field = new JTextArea();
        q17Field.setEditable(false);
        q17Field.setBounds(810, 350, 43, 300);
        q17Field.setFont(hugeFont);
        getContentPane().add(q17Field);

        q18Label = new JLabel("Q18");
        q18Label.setBounds(860, 300, 43, 30);
        getContentPane().add(q18Label);

        q18Field = new JTextArea();
        q18Field.setEditable(false);
        q18Field.setBounds(860, 350, 43, 300);
        q18Field.setFont(hugeFont);
        getContentPane().add(q18Field);
        q19Label = new JLabel("Q19");
        q19Label.setBounds(910, 300, 43, 30);
        getContentPane().add(q19Label);

        q19Field = new JTextArea();
        q19Field.setEditable(false);
        q19Field.setBounds(910, 350, 43, 300);
        q19Field.setFont(hugeFont);
        getContentPane().add(q19Field);

        q20Label = new JLabel("Q20");
        q20Label.setBounds(960, 300, 43, 30);
        getContentPane().add(q20Label);

        q20Field = new JTextArea();
        q20Field.setEditable(false);
        q20Field.setBounds(960, 350, 43, 300);
        q20Field.setFont(hugeFont);
        getContentPane().add(q20Field);


        // -------------------------------------------------------------------------------------------------

        /// CURRENT TIME

        currentTimeLabel = new JLabel("Current time:");
        currentTimeLabel.setFont(hugeFont);
        currentTimeLabel.setBounds(1050, 400, 200, 30);
        getContentPane().add(currentTimeLabel);

        currentTimeField = new JTextArea();
        currentTimeField.setEditable(false);
        currentTimeField.setFont(hugeFont);
        currentTimeField.setBounds(currentTimeLabel.getX() + currentTimeLabel.getWidth(), 400, 100, 50);
        getContentPane().add(currentTimeField);



    }

    public void updateQueue(int queueNumber, int numberOfClients) {
        JTextArea queueField = null;
        switch(queueNumber) {
            case 1:
                queueField = q1Field;
                break;
            case 2:
                queueField = q2Field;
                break;
            case 3:
                queueField = q3Field;
                break;
            case 4:
                queueField = q4Field;
                break;
            case 5:
                queueField = q5Field;
                break;
            case 6:
                queueField = q6Field;
                break;
            case 7:
                queueField = q7Field;
                break;
            case 8:
                queueField = q8Field;
                break;
            case 9:
                queueField = q9Field;
                break;
            case 10:
                queueField = q10Field;
                break;
            case 11:
                queueField = q11Field;
                break;
            case 12:
                queueField = q12Field;
                break;
            case 13:
                queueField = q13Field;
                break;
            case 14:
                queueField = q14Field;
                break;
            case 15:
                queueField = q15Field;
                break;
            case 16:
                queueField = q16Field;
                break;
            case 17:
                queueField = q17Field;
                break;
            case 18:
                queueField = q18Field;
                break;
            case 19:
                queueField = q19Field;
                break;
            case 20:
                queueField = q20Field;
                break;
            default:
                System.err.println("Invalid queue number: " + queueNumber);
                return;
        }

        queueField.setText("");
        for (int i = 0; i < numberOfClients; i++) {
            queueField.append("☺\n");
        }
    }

    public void updateLogs(String updateText) {

        logsField.append(updateText + "\n");
        JScrollBar myScrollBar=logScrollPane.getVerticalScrollBar();
        myScrollBar.setValue(myScrollBar.getMaximum());
    }


    public void updateCurrentTime(String updateText)
    {
        currentTimeField.setText(updateText);
    }

    public String getTimeMin()
    {
        return timeMinField.getText();
    }

    public String getTimeMax()
    {
        return timeMaxField.getText();
    }

    public String getServiceTimeMin()
    {
        return serviceMinField.getText();
    }

    public String getServiceTimeMax()
    {
        return serviceMaxField.getText();
    }

    public String getNumberOfQueues()
    {
        return nbQueuesField.getText();
    }

    public String getSimulationTime()
    {
        return simulationField.getText();
    }

    public String getNumberOfClients() {
        return clientsField.getText().trim();
    }

    public void addStartButtonActionListener(final ActionListener actionListener)
    {
        startButton.addActionListener(actionListener);
    }
}

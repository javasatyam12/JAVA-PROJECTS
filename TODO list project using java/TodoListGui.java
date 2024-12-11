//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TodoListGui extends JFrame implements ActionListener {
//        //Task Panel will act as the container for the taskcomponent Panel
//
//        private JPanel taskPanel , taskComponentPanel;
//        public TodoListGui() {
//            super("To Do List Application");
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setPreferredSize(commonConstants.GUI_SIZE);
//            pack();
//            setLocationRelativeTo(null);
//            setResizable(false);
//            setLayout(null);
//
//            addGuiComponent();
//
//        }
//
//        private void addGuiComponent(){
//            JLabel bannerLabel =  new JLabel("TO DO LIST");
//            bannerLabel.setBounds(220,
//                    15,
//                    commonConstants.BANNER_SIZE.width,
//                    commonConstants.BANNER_SIZE.height
//            );
//
//            //Task Panel
//            taskPanel = new JPanel();
//
//            //Task Component
//            taskComponentPanel = new JPanel();
//            taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
//            taskPanel.add(taskComponentPanel);
//
//            //Add Scrolling to the  Panel
//            JScrollPane scrollPane = new JScrollPane(taskPanel);
//            scrollPane.setBounds(8,70,commonConstants.TASKPANEL_SIZE.width, commonConstants.TASKPANEL_SIZE.height);
//            scrollPane.setMaximumSize(commonConstants.TASKPANEL_SIZE);
//            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//            //ADD TASK  BUTTON
//            JButton addTaskButton = new JButton("Add Task");
//            addTaskButton.setBounds(-5,commonConstants.GUI_SIZE.height-88,
//                    commonConstants.ADDTASK_BUTTON_SIZE.width, commonConstants.ADDTASK_BUTTON_SIZE.height);
//            addTaskButton.addActionListener(this);
//
//            // ADD TO FRAME
//            this.getContentPane().add(bannerLabel);
//            this.getContentPane().add(scrollPane);
//            this.getContentPane().add(addTaskButton);
//
//        }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//       String command = e.getActionCommand();
//       if(command.equalsIgnoreCase("Add Task ")){
//           //Create a Task Components
//           TaskComponent taskComponents = new TaskComponent(taskComponentPanel);
//           taskComponents.add(taskComponentPanel);
//
//           //make the task field request focus after creation
//           taskComponents.getTaskField().requestFocus();
//           repaint();
//           revalidate();
//        }
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListGui extends JFrame implements ActionListener {
    private JPanel taskPanel, taskComponentPanel;

    public TodoListGui() {
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(commonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponent();
    }

    private void addGuiComponent() {
        JLabel bannerLabel = new JLabel("TO DO LIST");
        bannerLabel.setFont(new Font("AvantGrade", Font.BOLD,36));
        bannerLabel.setBounds(170, 15, commonConstants.BANNER_SIZE.width, commonConstants.BANNER_SIZE.height);

        // Task Panel
        taskPanel = new JPanel();

        // Task Component Panel with BoxLayout
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        // Add Scrolling to the Panel
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, commonConstants.TASKPANEL_SIZE.width, commonConstants.TASKPANEL_SIZE.height);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(commonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //changing the speed of the scroll bar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.getUnitIncrement(20);

        // ADD TASK BUTTON
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setActionCommand("Add Task");  // Explicitly set action command
        addTaskButton.setBounds(-5, commonConstants.GUI_SIZE.height - 88,
                commonConstants.ADDTASK_BUTTON_SIZE.width, commonConstants.ADDTASK_BUTTON_SIZE.height);
        addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addTaskButton.addActionListener(this);

        // ADD TO FRAME
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task")) {
            // Create a Task Component
            TaskComponent taskComponents = new TaskComponent(taskComponentPanel);

            //Make the previous task appear disable
            if(taskComponentPanel.getComponentCount()>1){
                TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(
                        taskComponentPanel.getComponentCount()-2);
                previousTask.getTaskField().setBackground(null);

            }

            // Add Task Component to taskComponentPanel
            taskComponentPanel.add(taskComponents);

            // Make the task field request focus after creation
            taskComponents.getTaskField().requestFocus();

            // Revalidate and repaint the taskComponentPanel to reflect the new task
            taskComponentPanel.revalidate();
            taskComponentPanel.repaint();
        }
    }
}

